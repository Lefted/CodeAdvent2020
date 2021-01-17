package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {

	LinkedList<Integer>[] decks = parseInput(new String(Files.readAllBytes(Paths.get("src/me/lefted/solution/input.txt"))));
	LinkedList<Integer> winningDeck = playGame(decks[0], decks[1]);

	long found = calcScore(winningDeck);
	System.out.println(String.format("found %s", found));
    }

    public static LinkedList<Integer>[] parseInput(String input) {
	LinkedList<Integer>[] decks = new LinkedList[2];
	String[] sections = input.split("\r\n\r\n");

	for (int i = 0; i < sections.length; i++) {

	    String section = sections[i];
	    String[] lines = section.split("\r\n");
	    for (int j = lines.length - 1; j > 0; j--) {
		LinkedList<Integer> deck = decks[i];

		if (deck == null)
		    decks[i] = new LinkedList<Integer>();
		decks[i].push(Integer.parseInt(lines[j]));
	    }
	}

	return decks;
    }

    public static LinkedList<Integer> playGame(LinkedList<Integer> deck1, LinkedList<Integer> deck2) {
	LinkedList<Integer> winnerDeck = null;

	while (deck1.size() != 0 && deck2.size() != 0) {

	    // 'fight' between top values
	    int value1 = deck1.pop();
	    int value2 = deck2.pop();

	    if (value1 > value2) { // player 1 wins
		deck1.addLast(value1);
		deck1.addLast(value2);
	    } else if (value2 > value1) { // player 2 wins
		deck2.addLast(value2);
		deck2.addLast(value1);
	    } else {
		System.err.println("This game makes no sense");
		System.exit(1);
	    }
	}

	winnerDeck = deck1.isEmpty() ? deck2 : deck1;
	return winnerDeck;
    }

    public static long calcScore(LinkedList<Integer> winnerDeck) {
	return IntStream.rangeClosed(1, winnerDeck.size()).mapToLong(index -> winnerDeck.get(winnerDeck.size() - (index)) * index).sum();
    }
}
