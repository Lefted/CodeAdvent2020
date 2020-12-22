package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	long found = 0;
	found = calcResult(input);
	System.out.println(String.format("found %s", found));
    }

    public static long calcResult(List<String> input) {
	String mask = "";
	Map<Integer, Long> memory = new HashMap<>();
	for (String line : input) {
	    if (line.startsWith("mask")) {
		mask = line.split(" ")[2];
		continue;
	    }
	    int adress = Integer.parseInt(line.replace(']', '[').replace('[', 'P').split("P")[1]);
	    String fullValue = "";

	    final String value = Integer.toBinaryString(Integer.parseInt(line.split(" ")[2]));
	    for (int i = 0; i < 36 - value.length(); ++i) {
		fullValue = fullValue.concat("0");
	    }
	    fullValue = fullValue.concat(value);

	    char[] maskArray = mask.toCharArray();
	    char[] valueArray = fullValue.toCharArray();
	    for (int i = 0; i < maskArray.length; ++i) {
		if (maskArray[i] != 'X')
		    valueArray[i] = maskArray[i];
	    }
	    memory.put(adress, Long.parseUnsignedLong(new String(valueArray), 2)); 
	}
	return memory.values().stream().mapToLong(Long::longValue).sum();
    }
}
