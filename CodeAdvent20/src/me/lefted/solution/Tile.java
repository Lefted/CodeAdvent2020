package me.lefted.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tile {

    public static final int TILE_SIZE = 10;

    private String id;
    private char[][] data; // row column / y x

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
			if (Objects.nonNull(alignment[y + i][x + j]))
			    return true;
		    } catch (Exception e) {
		    }
		}
	    }
	}
	return false;
    }

    // [row/y][column/x]
    public static List<int[]> getSolvedNeighbours(Tile[][] alignment, int x, int y) {
	List<int[]> solved = new ArrayList<>();
	for (int i = -1; i < 2; i++) {
	    for (int j = -1; j < 2; j++) {

		// skip corners and testTile itself
		if (Math.abs(i) != Math.abs(j)) {
		    // System.out.println(String.format("i %s j %s", i, j));
		    try {
			if (Objects.nonNull(alignment[y + i][x + j]))
			    solved.add(new int[] { i, j });
		    } catch (Exception e) {
		    }
		}
	    }
	}
	return solved;
    }

    public boolean fitsNeighbours(List<int[]> relNeighbourPos, int x, int y, Tile[][] grid) {
	for (int[] relPos : relNeighbourPos) {
	    int relY = relPos[0];
	    int relX = relPos[1];

	    if (!Objects.isNull(grid[y + relY][x + relX])) {

		if (relX == -1) {
		    // check right side of neighbour and check left side of current
		    Tile neighbour = grid[y + relY][x + relX];
		    Tile self = this;

		    for (int row = 0; row < TILE_SIZE; row++) {
			char[] neighbourRow = neighbour.getData()[row];
			char[] selfRow = self.getData()[row];
			if (neighbourRow[TILE_SIZE - 1] != selfRow[0])
			    return false;
		    }
		} else if (relX == 1) {
		    // check left side of neighbour and right side of self
		    Tile neighbour = grid[y + relY][x + relX];
		    Tile self = this;

		    for (int row = 0; row < self.getData().length; row++) {
			char[] neighbourRow = neighbour.getData()[row];
			char[] selfRow = self.getData()[row];

			if (neighbourRow[0] != selfRow[TILE_SIZE - 1])
			    return false;
		    }
		} else if (relY == -1) { // neighbour is above testTile
		    // check down side of neighbour and top side of self
		    Tile neighbour = grid[y + relY][x + relX];
		    Tile self = this;

		    if (!Arrays.equals(neighbour.getData()[TILE_SIZE - 1], self.getData()[0]))
			return false;
		} else if (relY == 1) { // neighbour is below testTile
		    // check top side of neighbour and down side of self
		    Tile neighbour = grid[y + relY][x + relX];
		    Tile self = this;

		    if (!Arrays.equals(neighbour.getData()[0], self.getData()[TILE_SIZE - 1]))
			return false;
		}
	    } else {
		System.out.println(String.format("tile null at pos y %s x %s", y + relY, x + relX));
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

    public static void printGrid(Tile[][] grid) {
	for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
	    Tile[] row = grid[rowIndex];

	    if (row.length > 0)
		if (Tile.printRowwise(row)) {
		    System.out.println();
		}
	}
    }

    public static boolean printRowwise(Tile... tiles) {
	boolean hadRowTiles = false;
	for (int row = 0; row < TILE_SIZE; row++) {
	    boolean hasReachedTiles = false;
	    for (Tile tile : tiles) {
		if (tile == null) {
		    if (hasReachedTiles) {
			System.out.print("          ");
			System.out.print(" ");
		    }
		} else {
		    hasReachedTiles = true;
		    hadRowTiles = true;
		    System.out.print(tile.getData()[row]);
		    System.out.print(" ");
		}
	    }
	    if (hasReachedTiles)
		System.out.println("");
	}
	return hadRowTiles;
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