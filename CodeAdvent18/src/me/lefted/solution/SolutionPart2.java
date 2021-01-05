package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.function.LongBinaryOperator;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	long found = calcSum(input);
	System.out.println(String.format("found %s", found));
    }

    public static long calcSum(List<String> input) {
	return input.stream().mapToLong(line -> calcResult(line)).sum();
    }

    public static long calcResult(String line) {
	List<String> elements = Arrays.asList(line.split(" "));
	Stack<List<Long>> mulStack = new Stack<>();
	Stack<Long> valueStack = new Stack<>();
	Stack<LongBinaryOperator> opStack = new Stack<>();

	// default values
	valueStack.push(0L);
	opStack.push((x, y) -> x + y);
	mulStack.push(new ArrayList<>());

	for (int index = 0; index < elements.size(); index++) {
	    String element = elements.get(index);

	    if (element.contains("(")) {
		int numBrackets = (int) element.chars().filter(ch -> ch == '(').count();

		// push value-, op- and mulstack
		for (int j = 0; j < numBrackets; j++) {
		    valueStack.push(0L);
		    opStack.push((x, y) -> x + y);
		    mulStack.push(new ArrayList<>());
		}

		// remove all (
		String withoutBrackets = element.replace("(", "");
		Long elementNum = Long.parseLong(withoutBrackets);

		// perform calculation and set it on top of the valuestack
		valueStack.setElementAt(opStack.peek().applyAsLong(elementNum, valueStack.peek()), valueStack.size() - 1);
	    } else if (element.contains(")")) {
		// change operator back to + since bracket is closing
		opStack.setElementAt((x, y) -> x + y, opStack.size() - 1);
		// remove all )
		String withoutBrackets = element.replace(")", "");
		long elementNum = Long.parseLong(withoutBrackets);

		// perform calculation
		valueStack.setElementAt(opStack.peek().applyAsLong(elementNum, valueStack.peek()), valueStack.size() - 1);
		int numBrackets = (int) element.chars().filter(ch -> ch == ')').count();
		// pop value-, op- and mulstack
		for (int j = 0; j < numBrackets; j++) {
		    // pop opstack, its value is not needed
		    opStack.pop();

		    // multiply mulStack with itself and valueStack
		    List<Long> mularray = mulStack.pop();
		    long valueFromValueStack = valueStack.pop();
		    long bracketResult;

		    try {
			long mulResult = mularray.stream().mapToLong(Long::longValue).reduce((x, y) -> x * y).getAsLong();
			if (valueFromValueStack == 0L) {
			    bracketResult = mulResult;
			} else {
			    bracketResult = valueFromValueStack * mulResult;
			}
		    } catch (NoSuchElementException e) {
			// either mulResult or valueFromValueStack is always defined
			bracketResult = valueFromValueStack;
		    }
		    // combine values when popping
		    // alway + because if it is * the value would be 0 and therefore bracketResult should just become the top value of the valuestack
		    valueStack.setElementAt(bracketResult + valueStack.peek(), valueStack.size() - 1);
		}
	    } else {
		// check for op codes
		switch (element) {
		case "+":
		    // set operator to +
		    opStack.setElementAt((x, y) -> x + y, opStack.size() - 1);
		    break;
		case "*":
		    // set operator to *
		    opStack.setElementAt((x, y) -> x * y, opStack.size() - 1);
		    // put value from valuestack in mularray
		    mulStack.peek().add(valueStack.peek());
		    // reset value of valuestack to 0
		    valueStack.setElementAt(0L, valueStack.size() - 1);
		    break;
		default:
		    // change operator back to + since no paranthesis opened
		    opStack.setElementAt((x, y) -> x + y, opStack.size() - 1);
		    long elementNum = Long.parseLong(element);

		    // perform calculation
		    long result = opStack.peek().applyAsLong(elementNum, valueStack.peek());
		    valueStack.setElementAt(opStack.peek().applyAsLong(elementNum, valueStack.peek()), valueStack.size() - 1);
		    break;
		}
	    }
	}

	// multiply mulstack with itself and valuestack
	List<Long> mularray = mulStack.pop();
	long valueFromValueStack = valueStack.pop();
	long result;

	try {
	    long mulResult = mularray.stream().mapToLong(Long::longValue).reduce((x, y) -> x * y).getAsLong();
	    if (valueFromValueStack == 0L) {
		result = mulResult;
	    } else {
		result = valueFromValueStack * mulResult;
	    }
	} catch (NoSuchElementException e) {
	    // either mulResult or valueFromValueStack is always defined
	    result = valueFromValueStack;
	}
	return result;
    }
}