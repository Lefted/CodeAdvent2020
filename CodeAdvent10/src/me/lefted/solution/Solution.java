package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
	List<String> numbersList = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));

	long found = 0;
	found = calculateResult(numbersList.stream().map(Long::parseLong).collect(Collectors.toList()));

	System.out.println(String.format("Found %s", found));
    }

    public static int calculateResult(List<Long> input) {
	input.add(0L);
	List<Long> sortedList = input.stream().sorted(Comparator.comparingLong(Long::longValue)).collect(Collectors.toList());
	sortedList.add(sortedList.stream().mapToLong(Long::longValue).max().getAsLong() + 3L);
	int numberOfDiff3s = 0;
	int numberOfDiff1s = 0;

	for (int i = 1; i < sortedList.size(); ++i) {
	    long difference = sortedList.get(i) - sortedList.get(i - 1);

	    if (difference == 3) {
		numberOfDiff3s++;
	    } else if (difference == 1) {
		numberOfDiff1s++;
	    }
	}

	return numberOfDiff1s * numberOfDiff3s;
    }
}