package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	LinkedHashMap<String, int[]> rules = getRules(input);
	List<String> validTickets = getValidTickets(input, rules);

	Map<Integer, String> resultingColumnRuleNameMap = getColumnRuleNameMap(rules, validTickets);

	String myTicket = getMyTicketFromInput(input);
	long found = calcSolution(resultingColumnRuleNameMap, myTicket);
	System.out.println(String.format("found %s", found));
    }

    public static long calcSolution(Map<Integer, String> columnRuleNameMap, String myTicket) {
	long result = 0;
	int[] myTicketValues = Stream.of(myTicket.split(",")).mapToInt(Integer::parseInt).toArray();

	for (int column : columnRuleNameMap.keySet()) {
	    String ruleName = columnRuleNameMap.get(column);
	    // if the rule starts with departure
	    if (ruleName.startsWith("departure")) {
		// multiply the value in the result
		int value = myTicketValues[column];
		result = result == 0 ? value : (result * value);
	    }
	}
	return result;
    }

    public static String getMyTicketFromInput(List<String> input) {
	int count = 0;
	for (String line : input) {
	    if (line.isEmpty()) {
		count++;
		continue;
	    }
	    if (count != 1) {
		continue;
	    }
	    if (!line.contains("your ticket:")) {
		return line;
	    }
	}
	return null;
    }

    public static Map<Integer, String> getColumnRuleNameMap(LinkedHashMap<String, int[]> rules, List<String> validTicketLines) {
	Map<Integer, String> columnRuleNameMap = new HashMap<>();
	// number of columns should be 20
	int numColumns = validTicketLines.get(0).split(",").length;

	Map<Integer, List<String>> columnMatchingRules = new LinkedHashMap<>();
	// find which columns match which rules
	{
	    for (int column = 0; column < numColumns; column++) {
		ruleLoop: for (int ruleIndex = 0; ruleIndex < rules.size(); ruleIndex++) {
		    String ruleName = (String) rules.keySet().toArray()[ruleIndex];
		    int[] rule = rules.get(ruleName);

		    // check if the current columns matches the rule
		    for (int row = 0; row < validTicketLines.size(); row++) {
			int numToBeChecked = Integer.parseInt(validTicketLines.get(row).split(",")[column]);
			// System.out.println(String.format("checking number %s in column %s for rule %s", numToBeChecked, column, ruleName));

			if (!isValidForRule(numToBeChecked, rule)) {
			    continue ruleLoop;
			}
		    }

		    // all columns are valid for the rule
		    if (columnMatchingRules.containsKey(column)) {
			columnMatchingRules.get(column).add(ruleName);
		    } else {
			columnMatchingRules.put(column, new ArrayList<>(Arrays.asList(ruleName)));
		    }
		}
	    }
	}

	int countMatchingRules = columnMatchingRules.values().stream().mapToInt(list -> list.size()).sum();

	int remainingPossibilities = countMatchingRules;
	// bruteforce a combination of rules so that all 20 rulse are applied to one column
	while (remainingPossibilities != 0) {

	    for (int column : columnMatchingRules.keySet()) {
		// if the column matches only 1 rule
		if (columnMatchingRules.get(column).size() == 1) {
		    String ruleName = columnMatchingRules.get(column).get(0);
		    // assign the rule to the column
		    columnRuleNameMap.put(column, ruleName);
		    // remove rule entirely from temp map
		    columnMatchingRules.values().forEach(list -> list.remove(ruleName));
		    // update remaining possibilities
		    remainingPossibilities = columnMatchingRules.values().stream().mapToInt(list -> list.size()).sum();
		}
	    }
	}
	return columnRuleNameMap;
    }

    public static LinkedHashMap<String, int[]> getRules(List<String> input) {
	LinkedHashMap<String, int[]> result = new LinkedHashMap<>();

	for (String line : input) {
	    if (line.isEmpty())
		break;

	    List<Integer> numList = new ArrayList<>();
	    // put all numbers in the temporary numList
	    Stream.of(line.split(": ")[1].split(" or ")).forEach(e -> numList.addAll(Arrays.asList(e.split("-")).stream().map(Integer::parseInt).collect(
		Collectors.toList())));
	    String ruleName = line.split(": ")[0];
	    result.put(ruleName, numList.stream().mapToInt(Integer::valueOf).toArray());
	}

	return result;
    }

    public static List<String> getValidTickets(List<String> input, Map<String, int[]> rules) {
	List<String> validTickets = new ArrayList<>();
	int count = 0;
	int flag = 0;

	lines: for (int index = 0; index < input.size(); index++) {
	    String line = input.get(index);
	    if (line.contains("your ticket"))
		validTickets.add(input.get(index + 1));
	    if (line.isEmpty()) {
		flag++;
		continue;
	    }
	    if (flag != 2 || line.contains("tickets")) {
		continue;
	    }

	    final String[] split = line.split(",");
	    for (String num : split) {
		if (!isValidNum(Integer.parseInt(num), rules))
		    continue lines;
	    }
	    validTickets.add(line);
	}

	return validTickets;
    }

    public static boolean isValidForRule(int num, int[] rule) {
	if (rule[0] <= num && num <= rule[1])
	    return true;
	if (rule[2] <= num && num <= rule[3])
	    return true;
	return false;
    }

    // if num matches any rule
    public static boolean isValidNum(int num, Map<String, int[]> rule) {
	for (int[] categories : rule.values()) {
	    if (categories[0] <= num && num <= categories[1])
		return true;
	    if (categories[2] <= num && num <= categories[3])
		return true;
	}
	return false;
    }
}
