package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException {
	final String input = new String(Files.readAllBytes(Paths.get("src/me/lefted/solution/input.txt")));
	final LinkedList cups = parseInput(input);
	cups.linkCircle();

	playGame(cups);

	final int nextTo1 = cups.getNext(1);
	final int twoNextTo1 = cups.getNext(nextTo1);
	final long found = (long) nextTo1 * (long) twoNextTo1;

	System.out.println(String.format("found %s", found));
    }

    public static LinkedList parseInput(String input) {
	LinkedList list = new LinkedList(1000001); // 0 wont be used

	// input
	for (char ch : input.toCharArray()) {
	    list.add(Character.getNumericValue(ch));
	}
	// up to 1 million
	for (int i = 10; i < 1000001; i++) {
	    list.add(i);
	}

	return list;
    }

    public static LinkedList playGame(LinkedList cups) {
	int currCup = cups.getStartValue();

	for (int i = 0; i < 10000000; i++) {
	    makeMove(cups, currCup);
	    currCup = cups.getNext(currCup);
	}

	return cups;
    }

    public static void makeMove(LinkedList cups, int currCup) {

	// pick up cups
	int[] pickedUp = new int[3];
	int current = currCup;
	for (int i = 0; i < 3; i++) {
	    final int value = cups.getNext(current);
	    pickedUp[i] = value;
	    current = value;
	}

	// determine destination
	int destination = getDestinationValue(cups, currCup, pickedUp);

	// link current cup to the cup after the gap of the picked up ones
	final int cupAfterGap = cups.getNext(pickedUp[2]);
	cups.link(currCup, cupAfterGap);

	// relink picked up cups after destination
	final int temp = cups.getNext(destination);
	current = destination;
	for (int i = 0; i < 3; i++) {
	    final int next = pickedUp[i];
	    cups.link(current, next);
	    current = next;
	}
	// link last picked up cup to next cup
	cups.link(current, temp);
    }

    public static int getDestinationValue(LinkedList cups, int currCup, int[] pickedUp) {
	final int min = 1;
	final int max = 1000000;

	int destination = currCup - 1;

	search: while (true) {

	    if (destination < min) {
		destination = max;
	    }

	    for (int i = 0; i < 3; i++) {
		if (pickedUp[i] == destination) {
		    destination--;
		    continue search;
		}
	    }

	    return destination;
	}
    }

    public static String compileString(LinkedList cups) {
	StringBuilder builder = new StringBuilder();

	int current = 1;
	for (int i = 0; i < (cups.size() - 2); i++) {
	    int next = cups.getNext(current);
	    builder.append(next);
	    current = next;
	}

	return builder.toString();
    }
}