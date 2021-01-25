package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // [x][y]
    public static final int[][][] ODDR_DIRECTIONS = { { { +1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, +1 }, { 0, +1 } }, { { +1, 0 }, { +1, -1 }, { 0,
	    -1 }, { -1, 0 }, { 0, +1 }, { +1, +1 } }, };

    public static void main(String[] args) throws IOException {
	final List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	final int[][] grid = createGrid(input);
	final List<List<String>> instructionList = parseInput(input);

	flipTiles(grid, instructionList);

	final int found = Arrays.stream(grid).mapToInt(row -> Arrays.stream(row).filter(stateID -> stateID == TileState.BLACK.getID()).sum()).sum();
	System.out.println(String.format("found %s", found));
    }

    /**
     * @param input
     * @return “odd-r” horizontal layout<br>
     *         shoves odd rows right
     */
    public static int[][] createGrid(List<String> input) {
	final int maxChars = input.stream().mapToInt(line -> line.length()).max().getAsInt();
	final int[][] grid = new int[maxChars * 2][maxChars * 2]; // create grid that is certainly large enough

	// fill with -1 for undefined
	for (int y = 0; y < grid.length; y++) {
	    for (int x = 0; x < grid[y].length; x++) {
		grid[y][x] = TileState.UNDEFINED.getID();
	    }
	}

	return grid;
    }

    public static List<List<String>> parseInput(List<String> input) {
	final List<List<String>> instructionList = new ArrayList<>();

	for (int i = 0; i < input.size(); i++) {
	    final String line = input.get(i);
	    final List<String> instructions = getInstructionsFromLine(line);
	    instructionList.add(instructions);
	}

	return instructionList;
    }

    public static List<String> getInstructionsFromLine(String line) {
	List<String> instructions = new ArrayList<>();

	for (int j = 0; j < line.length(); j++) {
	    char ch = line.charAt(j);
	    if (ch == 'e' || ch == 'w') {
		instructions.add(String.valueOf(ch));
	    } else {
		instructions.add(line.substring(j, j + 2));
		j++;
	    }
	}

	return instructions;
    }

    public static void flipTiles(int[][] grid, List<List<String>> instructionsAll) {
	final int center = grid.length / 2;

	for (List<String> instructions : instructionsAll) {

	    // go to tile
	    int[] pos = new int[] { center, center };
	    for (String direction : instructions) {
		goDirection(pos, direction);
	    }

	    // flip the tile
	    final int y = pos[0];
	    final int x = pos[1];
	    grid[y][x] = flipTile(grid[y][x]).getID();
	}
    }

    public static int[] getNeighbourOffset(int row, int direction) {
	final int parity = row & 1;
	return ODDR_DIRECTIONS[parity][direction];
    }

    public static void goDirection(int[] currPos, String direction) {
	int directionID = -1;

	switch (direction) {
	case "e":
	    directionID = 0;
	    break;
	case "w":
	    directionID = 3;
	    break;
	case "se":
	    directionID = 5;
	    break;
	case "sw":
	    directionID = 4;
	    break;
	case "nw":
	    directionID = 2;
	    break;
	case "ne":
	    directionID = 1;
	    break;
	default:
	    break;
	}

	final int[] neighbourOffset = getNeighbourOffset(currPos[0], directionID);
	// currPos[y][x] neighbourOffset[x][y]
	currPos[0] += neighbourOffset[1];
	currPos[1] += neighbourOffset[0];
    }

    public static TileState flipTile(int stateID) {
	TileState newState = null;

	if (stateID == TileState.BLACK.getID()) {
	    newState = TileState.WHITE;
	} else {
	    newState = TileState.BLACK;
	}

	return newState;
    }

    public enum TileState {
	UNDEFINED(-1), WHITE(0), BLACK(1);

	private int id;

	TileState(int id) {
	    this.id = id;
	}

	public int getID() {
	    return id;
	}
    }
}