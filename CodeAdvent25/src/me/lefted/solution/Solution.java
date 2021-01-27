package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
	
	String input = new String(Files.readAllBytes(Paths.get("src/me/lefted/solution/input.txt")));
	final int[] parsedInput = parseInput(input);
	final int doorPublicKey = parsedInput[0];
	final int cardPublicKey = parsedInput[1];

	final int doorKeyLoopSize = getNumsLoop(doorPublicKey, 7);
	final int cardKeyLoopSize = getNumsLoop(cardPublicKey, 7);
	
	final long encryptionKey = transformSubjectNum(doorPublicKey, cardKeyLoopSize);
	System.out.println(String.format("found encryption key %s", encryptionKey));
    }

    public static int[] parseInput(String input) {
	return Arrays.stream(input.split("\r\n")).mapToInt(Integer::parseInt).toArray();
    }

    public static int getNumsLoop(int publicKey, int subjectNum) {
	int nums;
	int value = 1;

	for (nums = 0; nums < Integer.MAX_VALUE; nums++) {
	    
	    value *= subjectNum;
	    value %= 20201227;
	    
	    if (value == publicKey)
		break;
	}

	return nums + 1;
   }
    
    public static long transformSubjectNum(int subjectNum, int loopSize) {
	long value = 1;
	
	for (int i = 0; i < loopSize; i++) {

	    value *= subjectNum;
	    value %= 20201227;
	}
	
	return value;
    }
}