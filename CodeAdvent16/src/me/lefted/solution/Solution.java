package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
	List<String> lines = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	int found = getCountInvalidTickets(lines, getRules(lines));
	System.out.println(String.format("found %s", found));
    }

    public static List<int[]> getRules(List<String> input) {
	List<int[]> result = new ArrayList<>();

	for (String line : input) {
	    if (line.isEmpty())
		break;
	    final List<Integer> numList = new ArrayList<>();
	    Stream.of(line.split(": ")[1].split(" or ")).forEach(e -> numList.addAll(Arrays.asList(e.split("-")).stream().map(Integer::parseInt).collect(
		Collectors.toList())));
	    result.add(numList.stream().mapToInt(Integer::valueOf).toArray());
	}

	return result;
    }

    public static int getCountInvalidTickets(List<String> input, List<int[]> rules) {
	int count = 0;
	int flag = 0;

	for (String line : input) {
	    if (line.isEmpty()) {
		flag++;
		continue;
	    }
	    if (flag != 2 || line.contains("tickets")) {
		continue;
	    }

	    count += Stream.of(line.split(",")).filter(numStr -> !isValidNum(Integer.parseInt(numStr), rules)).mapToInt(Integer::parseInt).sum();
	}
	return count;
    }

    // if num matches any rule
    public static boolean isValidNum(int num, List<int[]> rules) {

	for (int[] categories : rules) {
	    if (categories[0] <= num && num <= categories[1])
		return true;
	    if (categories[2] <= num && num <= categories[3])
		return true;
	}
	return false;
    }
}
