package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import me.lefted.functions.Operator;

public class Solution {

    public static void main(String[] args) throws IOException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	long found = calcSum(input);
	System.out.println(String.format("found %s", found));
    }

    public static long calcSum(List<String> input) {
	return input.stream().mapToLong(line -> calcResult(line)).sum();
    }

    public static long calcResult(String line) {
	List<String> args = Arrays.asList(line.split(" "));
	Stack<Long> valueStack = new Stack<>();
	Stack<Operator> opStack = new Stack<>();

	valueStack.push(0L);
	opStack.push((x, y) -> x + y);

	for (int index = 0; index < args.size(); index++) {
	    String element = args.get(index);

	    if (element.contains("(")) {
		int numBrackets = (int) element.chars().filter(ch -> ch == '(').count();

		// push value and op stack
		for (int j = 0; j < numBrackets; j++) {
		    valueStack.push(0L);
		    opStack.push((x, y) -> x + y);
		}

		// remove (
		String withoutBrackets = element.replace("(", "");
		Long elementNum = Long.parseLong(withoutBrackets);

		// perform calculation
		valueStack.setElementAt(opStack.peek().getResult(elementNum, valueStack.peek()), valueStack.size() - 1);
	    } else if (element.contains(")")) {
		// remove )
		String withoutBrackets = element.replace(")", "");
		long elementNum = Long.parseLong(withoutBrackets);

		// perform calculation
		valueStack.setElementAt(opStack.peek().getResult(elementNum, valueStack.peek()), valueStack.size() - 1);

		int numBrackets = (int) element.chars().filter(ch -> ch == ')').count();

		// pop value and op stack
		for (int j = 0; j < numBrackets; j++) {
		    long topValue = valueStack.pop();
		    opStack.pop();
		    // combine values when popping
		    valueStack.setElementAt(opStack.peek().getResult(topValue, valueStack.peek()), valueStack.size() - 1);
		}

	    } else {
		// check of op codes
		switch (element) {
		case "+":
		    opStack.setElementAt((x, y) -> x + y, opStack.size() - 1);
		    break;
		case "*":
		    opStack.setElementAt((x, y) -> x * y, opStack.size() - 1);
		    break;
		default:
		    long elementNum = Long.parseLong(element);
		    // perform caluclation
		    valueStack.setElementAt(opStack.peek().getResult(elementNum, valueStack.peek()), valueStack.size() - 1);
		    break;
		}
	    }
	}
	return valueStack.peek();
    }
}
