package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException {
	System.out.println("This may take some time. Please wait at least 2 minutes before terminating.");

	LinkedList<Integer>[] decks = parseInput(new String(Files.readAllBytes(Paths.get("src/me/lefted/solution/input.txt"))));
	GameOutcome outcome = playGame(decks[0], decks[1]);

	long found = calcScore(outcome.getWinnerDeck());
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

    public static GameOutcome playGame(LinkedList<Integer> initDeck1, LinkedList<Integer> initDeck2) {
	List<LinkedList<Integer>[]> history = new ArrayList<>();
	LinkedList<Integer> deck1 = new LinkedList<Integer>(initDeck1);
	LinkedList<Integer> deck2 = new LinkedList<Integer>(initDeck2);

	while (deck1.size() != 0 && deck2.size() != 0) {

	    LinkedList<Integer>[] currRound = new LinkedList[] { deck1, deck2 };
	    if (hasConfigAppeared(history, currRound)) {
		deck2.clear();
	    } else {
		history.add(copyOfRound(currRound));

		// 'fight' between top values
		int value1 = deck1.pop();
		int value2 = deck2.pop();

		boolean player1Wins = value1 > value2;
		boolean mustPlaySubGame = deck1.size() >= value1 && deck2.size() >= value2;

		if (mustPlaySubGame) {

		    GameOutcome subGameOutcome = playGame(copyOfDeck(deck1, value1), copyOfDeck(deck2, value2));
		    if (subGameOutcome.isHasPlayer1Won()) {
			player1Wins = true;
		    } else {
			player1Wins = false;
		    }
		}

		if (player1Wins) {
		    deck1.addLast(value1);
		    deck1.addLast(value2);
		} else {
		    deck2.addLast(value2);
		    deck2.addLast(value1);
		}
	    }
	}

	boolean hasPlayer1Won = deck2.isEmpty();
	LinkedList<Integer> winnerDeck = hasPlayer1Won ? deck1 : deck2;
	GameOutcome outcome = new GameOutcome(winnerDeck, hasPlayer1Won);
	return outcome;
    }

    public static boolean hasConfigAppeared(List<LinkedList<Integer>[]> history, LinkedList<Integer>[] testRound) {

	for (LinkedList<Integer>[] round : history) {
	    if (Arrays.equals(round[0].toArray(), testRound[0].toArray()) && Arrays.equals(round[1].toArray(), testRound[1].toArray()))
		return true;
	}

	return false;
    }

    public static LinkedList<Integer> copyOfDeck(LinkedList<Integer> origDeck, int numCardsToCopy) {
	List list = Arrays.asList(origDeck.toArray().clone());
	LinkedList<Integer> deck = new LinkedList<>(list.subList(0, numCardsToCopy));
	return deck;
    }

    public static LinkedList<Integer>[] copyOfRound(LinkedList<Integer>[] round) {
	LinkedList<Integer>[] copy = new LinkedList[2];

	List list = Arrays.asList(round[0].toArray().clone());
	List list2 = Arrays.asList(round[1].toArray().clone());
	copy[0] = new LinkedList<Integer>(list);
	copy[1] = new LinkedList<Integer>(list2);

	return copy;
    }

    public static long calcScore(LinkedList<Integer> winnerDeck) {
	return IntStream.rangeClosed(1, winnerDeck.size()).mapToLong(index -> winnerDeck.get(winnerDeck.size() - (index)) * index).sum();
    }
}