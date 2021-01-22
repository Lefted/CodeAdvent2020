package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
	final String input = new String(Files.readAllBytes(Paths.get("src/me/lefted/solution/input.txt")));
	final LinkedList<Integer> startCups = parseInput(input);

	LinkedList<Integer> cups = playGame(startCups);
	System.out.println(String.format("found %s", compileString(cups)));
    }

    public static LinkedList<Integer> playGame(LinkedList<Integer> startLabeling) {
	LinkedList<Integer> labeling = copyOf(startLabeling);

	for (int i = 0; i < 100; i++) {
	    final int currCupIndex = i % startLabeling.size();
	    labeling = makeMove(labeling, currCupIndex);
	}

	return labeling;
    }

    public static LinkedList<Integer> parseInput(String input) {
	return new LinkedList<>(input.chars().mapToObj(ch -> Character.getNumericValue(ch)).collect(Collectors.toList()));
    }

    public static LinkedList<Integer> makeMove(LinkedList<Integer> prevCups, int currCupIndex) {
	LinkedList<Integer> cups = copyOf(prevCups);
	final int currCupValue = cups.get(currCupIndex);
	final int origCurrCupIndex = currCupIndex;

	// pick up cups
	int[] pickedUpCups = new int[3];
	for (int i = 0; i < 3; i++) {
	    final int location = (currCupIndex + 1) % cups.size();
	    final int value = cups.get(location);
	    pickedUpCups[i] = cups.remove(location);

	    // re-rotate
	    int numsToRotate = getNumsToRotate(cups, currCupValue, origCurrCupIndex);
	    Collections.rotate(cups, numsToRotate);
	}

	// update currCupIndex after picking up cups
	currCupIndex = cups.indexOf(currCupValue);

	// determine destination
	int destinationIndex = getDestinationValueIndex(cups, pickedUpCups, currCupIndex);

	// insert picked up cups after destination in order in which they were picked up
	for (int i = 0; i < 3; i++) {
	    cups.add(destinationIndex + 1, pickedUpCups[2 - i]);
	}

	// rotate so that currCup is at the previous index
	int numsToRotate = getNumsToRotate(cups, currCupValue, origCurrCupIndex);
	Collections.rotate(cups, numsToRotate);

	return cups;
    }

    public static String compileString(LinkedList<Integer> cups) {
	StringBuilder builder = new StringBuilder();

	for (int i = 0; i < cups.size() - 1; i++) {
	    builder.append(cups.get((i + cups.indexOf(1) + 1) % cups.size()));
	}

	return builder.toString();
    }

    public static int getNumsToRotate(LinkedList<Integer> cups, final int currCupValue, int origCurrCupIndex) {
	// find new index of currCup
	int newCurrCupIndex = cups.indexOf(currCupValue);

	// nums is distance
	return origCurrCupIndex - newCurrCupIndex;
    }

    public static int getDestinationValueIndex(LinkedList<Integer> cups, int[] pickedUpCups, int currCupIndex) {
	int minValue = cups.stream().mapToInt(Integer::valueOf).min().getAsInt();
	int maxValue = cups.stream().mapToInt(Integer::valueOf).max().getAsInt();

	int currValue = cups.get(currCupIndex) - 1;
	while (true) {

	    // flip back to maxValue if went below minValue
	    if (currValue < minValue)
		currValue = maxValue;

	    // skip if value matches a picked up cup
	    final int temp = currValue;
	    if (Arrays.stream(pickedUpCups).anyMatch(pickedUpCup -> temp == pickedUpCup)) {
		currValue--;
		continue;
	    }

	    // if value is on a cups
	    if (cups.contains(currValue)) {
		// return the index of this value
		return cups.indexOf(currValue);
	    }

	    currValue--;
	}
    }

    public static LinkedList<Integer> copyOf(LinkedList<Integer> original) {
	final List list = Arrays.asList(original.toArray().clone());
	return new LinkedList<Integer>(list);
    }
}