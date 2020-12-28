package me.lefted.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException {
	String input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt")).get(0);
	int found = 0;
	found = playGame(input);
	System.out.println(String.format("found %s", found));
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static int playGame(String input) {

	List<Integer> nums = Arrays.asList(input.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
	Map<Integer, List<Integer>> memory = new HashMap<>();

	// 0,6,3 were not spoken before so just use its original timestamp -> age would be 0
	memory.putAll(IntStream.range(0, nums.size()).boxed().collect(Collectors.toMap(i -> nums.get(i), i -> new ArrayList<>(Arrays.asList(i + 1, i + 1)))));

	int result = -1;
	int prevNumber = nums.get(nums.size() - 1);
	for (int currTimestamp = memory.size() + 1; currTimestamp < 30000001; currTimestamp++) {
	    result = step(currTimestamp, prevNumber, memory);
	    prevNumber = result;
	}

	return result;
    }

    public static int step(int currTimestamp, int prevNumber, Map<Integer, List<Integer>> memory) {
	int age = 0;
	if (memory.containsKey(prevNumber)) {
	    age = memory.get(prevNumber).get(1) - memory.get(prevNumber).get(0);

	    if (memory.containsKey(age)) {
		memory.get(age).set(0, memory.get(age).get(1));
		memory.get(age).set(1, currTimestamp);
	    } else {
		memory.put(age, new ArrayList<>(Arrays.asList(currTimestamp, currTimestamp)));
	    }
	} else {
	    System.err.println("Memory map does not contain previous number");
	    System.exit(1);
	}
	return age;
    }
}
