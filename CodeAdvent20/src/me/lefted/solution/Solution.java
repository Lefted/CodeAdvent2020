package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
	String input = new String(Files.readAllBytes(Paths.get("src/me/lefted/solution/input.txt")));
	List<Tile> tiles = parseInput(input);

	long found = calcSolution(tiles);
	System.out.println(String.format("found %s", found));
    }

    public static List<Tile> parseInput(String input) {
	List<Tile> tiles = new ArrayList<>();

	String[] sections = input.split("\r\n\r\n");

	// section loop
	for (String section : sections) {
	    Tile currTile = null;
	    String[] lines = section.split("\r\n");
	    for (int i = 0; i < lines.length; i++) {
		String line = lines[i];
		if (i == 0) {
		    // title
		    String[] split = line.split(" ");
		    String id = split[1].substring(0, split[1].length()-1);
		    currTile = new Tile(id);
		} else {
		    // data
		    currTile.getData()[i - 1] = line.toCharArray();
		}
	    }
	    tiles.add(currTile);
	}
	return tiles;
    }

    public static long calcSolution(List<Tile> tiles) {
	long result = 0L;
	long corner1ID = 0L;
	long corner2ID = 0L;
	long corner3ID = 0L;
	long corner4ID = 0L;
	
	Tile[][] solvedGrid = bruteforcePuzzle(tiles);
	
	// get the corner values
	corner1: for (int x = 0; x < solvedGrid.length; x++) {
	    for (int y = 0; y < solvedGrid[x].length; y++) {
		if (solvedGrid[y][x] != null) {
		    corner1ID = Integer.parseInt(solvedGrid[y][x].getID());
		    break corner1;
		}
	    }
	}
	corner2: for (int x = solvedGrid.length - 1; x > 0; x--) {
	    for (int y = 0; y < solvedGrid[x].length; y++) {
		if (solvedGrid[y][x] != null) {
		    corner2ID = Integer.parseInt(solvedGrid[y][x].getID());
		    break corner2;
		}
	    }
	}
	corner3: for (int x = 0; x < solvedGrid.length; x++) {
	    for (int y = solvedGrid[x].length - 1; y > 0; y--) {
		if (solvedGrid[y][x] != null) {
		    corner3ID = Integer.parseInt(solvedGrid[y][x].getID());
		    break corner3;
		}
	    }
	}
	corner4: for (int x = solvedGrid.length - 1; x > 0; x--) {
	    for (int y = solvedGrid[x].length - 1; y > 0; y--) {
		if (solvedGrid[y][x] != null) {
		    corner4ID = Integer.parseInt(solvedGrid[y][x].getID());
		    break corner4;
		}
	    }
	}

	// multiply them together
	result = corner1ID * corner2ID * corner3ID * corner4ID;
	return result;
    }

    public static Tile[][] bruteforcePuzzle(List<Tile> tiles) {
	// size of puzzle is at most tiles.size * 1 so this provides enough space
	final int gridSize = tiles.size();
	Tile[][] grid = new Tile[gridSize][gridSize];

	// pick first tile and put it somewhere in the middle
	Tile firstTile = tiles.remove(0);

	grid[gridSize / 2][gridSize / 2] = firstTile;

	puzzleSolved: while (true) {
	    // go through all tiles
	    for (int y = 0; y < gridSize; y++) {
		for (int x = 0; x < gridSize; x++) {

		    Tile currTile = grid[x][y];
		    // if tile is not solved yet
		    if (Objects.isNull(currTile)) {

			// if the tile has a solved neighbour
			if (currTile.hasSolvedNeighbour(grid, x, y)) {
			    
			    // get neighbours
			    List<int[]> neighbourPos = Tile.getSolvedNeighbours(grid, x, y);
			    
			    // attempt to solve current tile with unsolved tiles available
			    Tile solution = Tile.attemptToSolve(neighbourPos, x, y, grid, tiles);

			    // if tile was solved
			    if (!Objects.isNull(solution)) {
				
				// add it
				grid[x][y] = solution;
				
				// check if there are unsolved tiles left
				if (tiles.isEmpty()) {
				    break puzzleSolved;
				}
			    }
			}
		    }
		}
	    }
	}
	return grid;
    }

    public static class Tile {

	public static final int TILE_SIZE = 10;

	private String id;
	private char[][] data;

	public Tile(String id) {
	    super();
	    this.id = id;
	    this.data = new char[TILE_SIZE][TILE_SIZE];
	}

	// rotates clockwise
	public Tile rotate(int steps) {
	    char[][] newData = new char[TILE_SIZE][TILE_SIZE];

	    if (steps > 0) {
		for (int step = 0; step < steps; step++) {
		    for (int i = 0; i < TILE_SIZE; i++) {
			for (int j = 0; j < TILE_SIZE; j++) {
			    newData[i][j] = data[TILE_SIZE - j - 1][i];
			}
		    }
		}
	    } else {
		newData = data;
	    }
	    Tile newTile = new Tile(id);
	    newTile.setData(newData);

	    return newTile;
	}

	public Tile flipHorizontal() {
	    char[][] newData = new char[TILE_SIZE][TILE_SIZE];

	    int start = 0;
	    int end = newData.length - 1;

	    while (start < end) {
		newData[start] = data[end];
		newData[end] = data[start];
		start++;
		end--;
	    }

	    Tile newTile = new Tile(id);
	    newTile.setData(newData);

	    return newTile;
	}

	public Tile flipVertical() {
	    char[][] newData = new char[TILE_SIZE][TILE_SIZE];

	    int start = 0;
	    int end = newData.length - 1;

	    while (start < end) {

		for (int row = 0; row < TILE_SIZE; row++) {
		    newData[row][start] = data[row][end];
		    newData[row][end] = data[row][start];
		}

		start++;
		end--;
	    }

	    Tile newTile = new Tile(id);
	    newTile.setData(newData);

	    return newTile;
	}

	public static Tile attemptToSolve(List<int[]> neighbourPos, int x, int y, Tile[][] grid, List<Tile> tiles) {

	    for (Tile testTile : tiles) {
		// test in every rotation
		for (int rotationSteps = 0; rotationSteps < 4; rotationSteps++) {

		    // apply rotation
		    Tile rotated = testTile.rotate(rotationSteps);

		    // just test rotation
		    if (rotated.fitsNeighbours(neighbourPos, x, y, grid)) {
			tiles.remove(testTile);
			return rotated;
		    }

		    // test horizontally flipped
		    Tile hFlip = rotated.flipHorizontal();
		    if (hFlip.fitsNeighbours(neighbourPos, x, y, grid)) {
			tiles.remove(testTile);
			return hFlip;
		    }

		    // test vertically flipped
		    Tile vFlip = rotated.flipVertical();
		    if (vFlip.fitsNeighbours(neighbourPos, x, y, grid)) {
			tiles.remove(testTile);
			return vFlip;
		    }

		    // test horizontally and vertically flipped
		    Tile hvFlip = hFlip.flipVertical();
		    if (hvFlip.fitsNeighbours(neighbourPos, x, y, grid)) {
			tiles.remove(testTile);
			return hvFlip;
		    }
		}
	    }
	    return null;
	}

	public static boolean hasSolvedNeighbour(Tile[][] alignment, int x, int y) {
	    for (int i = -1; i < 2; i++) {
		for (int j = -1; j < 2; j++) {

		    // skip corners and tile itself
		    if (Math.abs(i) != Math.abs(j)) {
			try {
			    if (Objects.nonNull(alignment[x + j][y + i]))
				return true;
			} catch (Exception e) {
			}
		    }
		}
	    }
	    return false;
	}

	public static List<int[]> getSolvedNeighbours(Tile[][] alignment, int x, int y) {
	    List<int[]> solved = new ArrayList<>();
	    for (int i = -1; i < 2; i++) {
		for (int j = -1; j < 2; j++) {

		    // skip corners and testTile itself
		    if (Math.abs(i) != Math.abs(j)) {
			// System.out.println(String.format("i %s j %s", i, j));
			try {
			    if (Objects.nonNull(alignment[x + j][y + i]))
				solved.add(new int[] { j, i });
			} catch (Exception e) {
			}
		    }
		}
	    }
	    return solved;
	}

	public boolean fitsNeighbours(List<int[]> relNeighbourPos, int x, int y, Tile[][] grid) {
	    for (int[] relPos : relNeighbourPos) {
		int relX = relPos[0];
		int relY = relPos[1];

		if (!Objects.isNull(grid[x + relX][y + relY])) {

		    if (relX == -1) {
			// check right side of neighbour and check left side of current
			Tile neighbour = grid[x + relX][y + relY];
			Tile self = this;

			for (int row = 0; row < TILE_SIZE; row++) {
			    char[] neighbourRow = neighbour.getData()[row];
			    char[] selfRow = self.getData()[row];
			    if (neighbourRow[TILE_SIZE - 1] != selfRow[0])
				return false;
			}
		    } else if (relX == 1) {
			// check left side of neighbour and right side of self
			Tile neighbour = grid[x + relX][y + relY];
			Tile self = this;

			for (int row = 0; row < self.getData().length; row++) {
			    char[] neighbourRow = neighbour.getData()[row];
			    char[] selfRow = self.getData()[row];
			    if (neighbourRow[0] != selfRow[TILE_SIZE - 1])
				return false;
			}
		    } else if (relY == -1) { // neighbour is above testTile
			// check down side of neighbour and top side of self
			Tile neighbour = grid[x + relX][y + relY];
			Tile self = this;

			if (!Arrays.equals(neighbour.getData()[TILE_SIZE - 1], self.getData()[0]))
			    return false;
		    } else if (relY == 1) { // neighbour is below testTile
			// check top side of neighbour and down side of self
			Tile neighbour = grid[x + relX][y + relY];
			Tile self = this;

			if (!Arrays.equals(neighbour.getData()[0], self.getData()[TILE_SIZE - 1]))
			    return false;
		    }
		} else {
		    System.out.println(String.format("tile null at pos x %s and %s", x + relX, y + relY));
		    System.exit(1);
		}
	    }
	    return true;
	}

	public void print() {
	    for (char[] row : data) {
		for (char ch : row) {
		    System.out.print(ch);
		}
		System.out.println();
	    }
	}

	public static void printRowwise(Tile... tiles) {
	    for (int row = 0; row < TILE_SIZE; row++) {
		for (Tile tile : tiles) {
		    if (tile == null) {
			System.out.print(" ");
			continue;
		    }
		    System.out.print(tile.getData()[row]);
		    System.out.print(" ");
		}
		System.out.println();
	    }
	}

	public static void printRowwiseIDs(Tile... tiles) {
	    for (Tile tile : tiles) {
		if (tile == null) {
		    System.out.print("      ");
		    continue;
		}
		System.out.print(tile.getID());
		System.out.print(" ");
	    }
	    System.out.println();
	}

	public char[][] getData() {
	    return data;
	}

	public void setData(char[][] data) {
	    this.data = data;
	}

	public String getID() {
	    return id;
	}
    }
}