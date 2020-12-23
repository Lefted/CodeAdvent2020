package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
	String input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt")).get(0);
	int found = 0;
	found = playGame(input);
	System.out.println(String.format("found %s", found));
    }

    public static int playGame(String input) {
	List<Integer> nums = Arrays.asList(input.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());

	for (int i = nums.size(); i < 2020; i++) {
	    int prevNum = nums.get(i - 1);
	    final List<Integer> prevPart = nums.subList(0, i - 1);
	    if (prevPart.contains(prevNum)) {
		for (int j = prevPart.size() - 1; j >= 0; j--) {
		    if (prevPart.get(j) == prevNum) {
			int age = i - j - 1;
			nums.add(age);
			break;
		    }
		}
	    } else {
		nums.add(0);
	    }
	}
	return nums.get(nums.size()-1);
    }
}
