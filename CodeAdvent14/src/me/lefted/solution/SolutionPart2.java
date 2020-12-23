package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	long found = 0;
	found = calcMemorySum(input);
	System.out.println(String.format("found %s", found));
    }

    public static long calcMemorySum(List<String> lines) {
	String mask = null;
	StringBuffer currentAdress = null;
	Map<Long, Long> memory = new HashMap<>();

	for (String line : lines) {
	    // assign mask
	    if (line.startsWith("mask")) {
		mask = line.split(" ")[2];
		continue;
	    }
	    // calc adresses
	    currentAdress = parseWithFrontTrailing0(line);
	    applyMask(currentAdress, mask);
	    long[] adresses = getAdressesFromFloatingAdress(currentAdress);
	    long value = Long.parseLong(line.split(" ")[2]);

	    // save value in memory
	    for (long adress : adresses) {
		memory.put(adress, value);
	    }
	}

	final long result = memory.values().stream().mapToLong(Long::longValue).sum();
	return result;
    }

    public static StringBuffer parseWithFrontTrailing0(String line) {
	final StringBuffer buffer = new StringBuffer(Integer.toBinaryString(Integer.parseInt(line.replace("]", "[").replace("[", "P").split("P")[1])));
	buffer.insert(0, "0".repeat(36 - buffer.length()));
	return buffer;
    }

    public static StringBuffer applyMask(StringBuffer adress, String mask) {

	for (int i = 0; i < mask.length(); ++i) {
	    final char currChar = mask.charAt(i);
	    if (currChar == 'X' || currChar == '1')
		adress.setCharAt(i, currChar);
	}
	return adress;
    }

    public static long[] getAdressesFromFloatingAdress(StringBuffer floatingAdress) {
	final int numX = (int) floatingAdress.chars().filter(c -> c == 'X').count();
	final int numCombinations = (int) Math.pow(2, numX);
	long[] adresses = new long[numCombinations];
	// generate adresses
	for (int i = 0; i < numCombinations; i++) {
	    final StringBuffer adressResult = new StringBuffer(floatingAdress.toString());
	    // decimal to binary
	    String binString = Integer.toBinaryString(i);
	    // fill binString with front trialing 0s
	    binString = "0".repeat(numX - binString.length()) + binString;
	    int binStringIndex = 0;
	    // change Xs with chars of binary string
	    for (int j = 0; j < adressResult.length(); j++) {
		if (adressResult.charAt(j) == 'X') {
		    adressResult.setCharAt(j, binString.charAt(binStringIndex));
		    binStringIndex++;
		}
	    }
	    adresses[i] = Long.parseLong(adressResult.toString(), 2);
	}
	return adresses;
    }
}