package me.lefted.solution;

import java.util.LinkedList;

public class GameOutcome {

    private LinkedList<Integer> winnerDeck;
    private boolean hasPlayer1Won;

    public GameOutcome(LinkedList<Integer> winnerDeck, boolean hasPlayer1Won) {
	this.winnerDeck = winnerDeck;
	this.hasPlayer1Won = hasPlayer1Won;
    }

    public LinkedList<Integer> getWinnerDeck() {
	return winnerDeck;
    }

    public boolean isHasPlayer1Won() {
	return hasPlayer1Won;
    }
}
