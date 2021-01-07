package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.florianingerl.util.regex.Pattern;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	Map<Integer, String> rules = parseRules(input);
	StringBuilder ruleRegEx = getRegEx(0, rules, new HashMap<>());

	// add anchors to regex
	ruleRegEx.insert(0, "^");
	ruleRegEx.append("$");

	System.out.println(String.format("regEx %s", ruleRegEx.toString()));

	int found = countMatchingMessages(input, ruleRegEx.toString());
	System.out.println(String.format("found %s", found));
    }

    public static Map<Integer, String> parseRules(List<String> input) {
	Map<Integer, String> result = new HashMap<>();

	for (String line : input) {
	    if (line.isEmpty())
		break;
	    String[] split = line.split(": ");
	    int ruleNumber = Integer.parseInt(split[0]);
	    String rule = split[1];
	    result.put(ruleNumber, rule);
	}
	return result;
    }

    public static StringBuilder getRegEx(Integer ruleNumber, Map<Integer, String> rules, Map<Integer, StringBuilder> memory) {
	// if memory contains it return the value in memory
	if (memory.containsKey(ruleNumber))
	    return memory.get(ruleNumber);

	StringBuilder regEx = new StringBuilder();
	String ruleText = rules.get(ruleNumber);
	String[] elements = ruleText.split(" ");
	// rule 8 and 11 are specially handled
	if (ruleNumber != 8 && ruleNumber != 11) {
	    for (String element : elements) {
		if (element.contains("\"")) {
		    char ch = element.charAt(1);
		    regEx.append(ch);
		} else if (element.equalsIgnoreCase("|")) {
		    regEx.append("|");
		} else {
		    int elementRuleNum = Integer.parseInt(element);
		    StringBuilder elementRegEx = getRegEx(elementRuleNum, rules, memory);
		    regEx.append(elementRegEx);
		}
	    }
	}
	if (ruleNumber == 8) {
	    StringBuilder regExRule42 = getRegEx(42, rules, memory);
	    regEx.append("(");
	    regEx.append(regExRule42);
	    regEx.append(")");
	    regEx.append("+");
	}
	if (ruleNumber == 11) {
	    StringBuilder regExRule42 = getRegEx(42, rules, memory);
	    StringBuilder regExRule31 = getRegEx(31, rules, memory);

	    // this makes use of recursive regex, which is not supported in the default java.util.regex
	    // see https://github.com/florianingerl/com.florianingerl.util.regex
	    regEx.append("(");
	    regEx.append("?<name>");
	    regEx.append(regExRule42);
	    regEx.append("(?'name')?");
	    regEx.append(regExRule31);
	    regEx.append(")");
	}

	if (!ruleText.contains("\"")) {
	    regEx.insert(0, "(");
	    regEx.append(")");
	}

	// add result to memory
	memory.put(ruleNumber, regEx);

	return regEx;
    }

    public static int countMatchingMessages(List<String> input, String regEx) {
	int result = 0;
	boolean isMessageSection = false;

	for (String line : input) {
	    if (line.isEmpty()) {
		isMessageSection = true;
		continue;
	    }
	    if (!isMessageSection)
		continue;

	    if (Pattern.matches(regEx, line)) {
		result++;
	    }
	}
	return result;
    }
}