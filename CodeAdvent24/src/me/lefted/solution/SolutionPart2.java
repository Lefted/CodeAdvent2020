package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SolutionPart2 {

    // [x][y]
    public static final int[][][] ODDR_DIRECTIONS = { { { +1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, +1 }, { 0, +1 } }, { { +1, 0 }, { +1, -1 }, { 0,
	    -1 }, { -1, 0 }, { 0, +1 }, { +1, +1 } }, };

    public static final Function<int[][], Integer> FKT_GET_COUNT_BLACK_NEIGHBOURS_TILES = grid -> Arrays.stream(grid).mapToInt(row -> (int) Arrays.stream(row)
	.filter(stateID -> stateID == TileState.BLACK.getID()).count()).sum();

    public static void main(String[] args) throws IOException {
	final List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	final int[][] grid = createGrid(input);
	final List<List<String>> instructionList = parseInput(input);

	flipTiles(grid, instructionList);

	int[][] roomGrid = grid;
	roomGrid = simulateLivingArt(roomGrid);

	final int found = FKT_GET_COUNT_BLACK_NEIGHBOURS_TILES.apply(roomGrid);
	System.out.println(String.format("found %s", found));
    }

    public static int[][] simulateLivingArt(int[][] grid) {

	for (int day = 0; day < 100; day++) {

	    int[][] temp = copyOf(grid);
	    for (int y = 0; y < temp.length; y++) {
		for (int x = 0; x < temp[y].length; x++) {

		    final int numBlackNeighbourTiles = getNumBlackNeighbourTiles(y, x, temp, day);
		    if (temp[y][x] == TileState.BLACK.getID()) {

			if (numBlackNeighbourTiles == 0 || numBlackNeighbourTiles > 2) {
			    grid[y][x] = TileState.WHITE.getID();
			}
		    } else if (numBlackNeighbourTiles == 2) {
			grid[y][x] = TileState.BLACK.getID();
		    }
		}
	    }
	}

	return grid;
    }

    public static int[][] copyOf(int[][] grid) {
	int[][] result = new int[grid.length][grid.length];

	for (int i = 0; i < grid.length; i++) {
	    result[i] = grid[i].clone();
	}

	return result;
    }

    public static int getNumBlackNeighbourTiles(int y, int x, int[][] grid, int day) {
	int num = 0;

	for (int direction = 0; direction < 6; direction++) {

	    int parity = y % 2;
	    final int[] offset = getNeighbourOffset(parity, direction);
	    final int checkY = y + offset[1];
	    final int checkX = x + offset[0];

	    try {
		if (grid[checkY][checkX] == TileState.BLACK.getID())
		    num++;
	    } catch (IndexOutOfBoundsException e) {
	    }
	}

	return num;
    }

    /**
     * @param input
     * @return “odd-r” horizontal layout<br>
     *         shoves odd rows right
     */
    public static int[][] createGrid(List<String> input) {
	final int maxChars = input.stream().mapToInt(line -> line.length()).max().getAsInt();
	final int[][] grid = new int[500][500]; // create large enough grid

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

    public static int[] getNeighbourOffset(int parity, int direction) {
	// final int parity = row & 1;
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

	final int[] neighbourOffset = getNeighbourOffset(currPos[0] & 1, directionID);
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
	UNDEFINED(-1), WHITE(2), BLACK(5);

	private int id;

	TileState(int id) {
	    this.id = id;
	}

	public int getID() {
	    return id;
	}
    }
}