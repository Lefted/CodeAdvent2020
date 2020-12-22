package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
	List<String> lines = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	int found = 0;
	found = calcResult(lines);
	System.out.println(String.format("found %s", found));
    }

    public static int calcResult(List<String> lines) {
	int startTime = Integer.parseInt(lines.get(0));
	List<Integer> busIds = parseTime(lines.get(1));

	int minWaitTimeIndex = 0;
	int minWaitTime = Integer.MAX_VALUE;
	for (int i = 0; i < busIds.size(); ++i) {
	    int currentWaitTime = calcWaitTime(startTime, busIds.get(i));
	    if (currentWaitTime < minWaitTime) {
		minWaitTimeIndex = i;
		minWaitTime = currentWaitTime;
	    }
	}
	return minWaitTime * busIds.get(minWaitTimeIndex);
    }

    public static int calcWaitTime(int startTime, int busId) {
	return (((startTime / busId) + 1) * busId) - startTime;
    }

    public static List<Integer> parseTime(String line) {
	return Stream.of(line.split(",")).filter(new Predicate<String>() {
	    @Override
	    public boolean test(String t) {
		try {
		    Integer.parseInt(t);
		    return true;
		} catch (Exception e) {
		    return false;
		}
	    }
	}).mapToInt(Integer::parseInt).sorted().boxed().collect(Collectors.toList());
    }
}
