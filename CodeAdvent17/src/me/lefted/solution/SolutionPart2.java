package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SolutionPart2 {

    public static final int GRID_SIZE = 40;

    /*
     * grid [x][y][z][w] 
     */
    public static void main(String[] args) throws IOException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	boolean[][][][] startGrid = parseInput(input);
	boolean[][][][] afterSimulation = simulateCycle(startGrid, 6);
	int countActiveCubes = getCountActiveCubes(afterSimulation);
	System.out.println(String.format("found %s", countActiveCubes));
    }

    // returns the initial grid state of the simulation
    public static boolean[][][][] parseInput(List<String> input) {
	boolean[][][][] grid = new boolean[GRID_SIZE][GRID_SIZE][GRID_SIZE][GRID_SIZE];

	for (int lineIndex = 0; lineIndex < input.size(); lineIndex++) {
	    String line = input.get(lineIndex);
	    for (int charIndex = 0; charIndex < line.length(); charIndex++) {
		char currChar = line.charAt(charIndex);
		if (currChar == '#') {
		    grid[charIndex + 18][18][18][lineIndex + 18] = true;
		}
	    }
	}
	return grid;
    }

    public static boolean[][][][] simulateCycle(boolean[][][][] beforeStep, int steps) {
	// copy grid
	boolean[][][][] afterStep = copyOf(beforeStep);

	for (int step = 0; step < steps; step++) {
	    // simulate one step
	    // x
	    for (int x = 0; x < GRID_SIZE; x++) {
		// y
		for (int y = 0; y < GRID_SIZE; y++) {
		    // z
		    for (int z = 0; z < GRID_SIZE; z++) {
			// w
			for (int w = 0; w < GRID_SIZE; w++) {
			    boolean state = beforeStep[x][y][z][w];
			    int countActiveNeighbours = getCountActiveNeighbours(beforeStep, x, y, z, w);

			    if (state == true && !(countActiveNeighbours == 2 || countActiveNeighbours == 3)) {
				afterStep[x][y][z][w] = false;
			    }
			    if (state == false && countActiveNeighbours == 3) {
				afterStep[x][y][z][w] = true;
			    }
			}
		    }
		}
	    }

	    // before step becomes after step;
	    beforeStep = copyOf(afterStep);
	}
	return afterStep;
    }

    public static boolean[][][][] copyOf(boolean[][][][] source) {
	int sizeX = source.length;
	int sizeY = source[0].length;
	int sizeZ = source[0][0].length;
	int sizeW = source[0][0][0].length;
	boolean[][][][] result = new boolean[sizeX][sizeY][sizeZ][sizeW];

	for (int x = 0; x < sizeX; x++) {
	    for (int y = 0; y < sizeY; y++) {
		for (int z = 0; z < sizeZ; z++) {
		    for (int w = 0; w < sizeW; w++) {
			result[x][y][z][w] = source[x][y][z][w];
		    }
		}
	    }
	}
	return result;
    }

    public static int getCountActiveNeighbours(boolean[][][][] grid, int cubeX, int cubeY, int cubeZ, int cubeW) {
	int count = 0;

	// x
	for (int x = -1; x < 2; x++) {
	    // y
	    for (int y = -1; y < 2; y++) {
		// z
		for (int z = -1; z < 2; z++) {
		    // w
		    for (int w = -1; w < 2; w++) {
			// skip own cube
			if (x == 0 && y == 0 && z == 0 && w == 0)
			    continue;

			try {
			    if (grid[cubeX + x][cubeY + y][cubeZ + z][cubeW + w] == true)
				count++;
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		    }
		}
	    }
	}
	return count;
    }

    public static int getCountActiveCubes(boolean[][][][] grid) {
	int count = 0;

	for (int x = 0; x < GRID_SIZE; x++) {
	    for (int y = 0; y < GRID_SIZE; y++) {
		for (int z = 0; z < GRID_SIZE; z++) {
		    for (int w = 0; w < GRID_SIZE; w++) {
			if (grid[x][y][z][w] == true)
			    count++;
		    }
		}
	    }
	}
	return count;
    }
}