package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
	String test = "35\r\n" + "20\r\n" + "15\r\n" + "25\r\n" + "47\r\n" + "40\r\n" + "62\r\n" + "55\r\n" + "65\r\n" + "95\r\n" + "102\r\n" + "117\r\n"
	    + "150\r\n" + "182\r\n" + "127\r\n" + "219\r\n" + "299\r\n" + "277\r\n" + "309\r\n" + "576";
	List<String> numbersList = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	
	long found = 0;
	found = findNumber(numbersList.stream().map(str -> Long.parseLong(str)).collect(Collectors.toList()),  25);
	
	System.out.println(String.format("Found %s", found));
    }

    public static long findNumber(List<Long> input, int preambleSize) {

	for (int i = preambleSize; i < input.size(); ++i) {
	    List<Long> testInput = input.subList(i - preambleSize, i);
	    long numberToTest = input.get(i);
	    if (!isValid(testInput, numberToTest))
		return numberToTest;
	}

	return 0;
    }

    public static boolean isValid(List<Long> input, long numberToTest) {

	for (long i : input) {
	    for (long j : input) {

		if (i != j) {
		    if (i + j == numberToTest)
			return true;
		}
	    }
	}
	return false;
    }
}