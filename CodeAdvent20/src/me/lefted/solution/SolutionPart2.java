package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException {
	String input = new String(Files.readAllBytes(Paths.get("src/me/lefted/solution/input.txt")));
	List<Tile> tiles = parseInput(input);

	Tile[][] solvedGrid = bruteforcePuzzle(tiles);
	Image image = new Image(solvedGrid);
	Pattern pattern = new Pattern(Pattern.patternString);
	
	long numMonsters = getNumMonsters(image, pattern);
	long found = calcWaterRoughness(image, numMonsters);

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
		    String id = split[1].substring(0, split[1].length() - 1);
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

    public static long calcWaterRoughness(Image image, long numMonsters) {
	long roughness = 0;

	// count every #
	for (char[] row : image.getData()) {
	    for (char ch : row) {
		if (ch == '#')
		    roughness++;
	    }
	}

	// subtract numMusters
	roughness -= numMonsters * Pattern.patternString.chars().filter(ch -> ch == '#').count();

	return roughness;
    }

    public static long getNumMonsters(Image image, Pattern pattern) {
	long numFoundMonsters = 0;
	List<Image> checkedImageLayouts = new ArrayList<>();

	for (int rotationSteps = 0; rotationSteps < 4; rotationSteps++) {
	    Image rotatedImage = image.rotate(rotationSteps);
	    if (!hasImageBeenChecked(rotatedImage, checkedImageLayouts)) {
		numFoundMonsters += rotatedImage.getNumMonsters(pattern);
		checkedImageLayouts.add(rotatedImage);
	    }

	    Image vFlip = rotatedImage.flipVertical();
	    if (!hasImageBeenChecked(vFlip, checkedImageLayouts)) {
		numFoundMonsters += vFlip.getNumMonsters(pattern);
		checkedImageLayouts.add(vFlip);
	    }

	    Image hFlip = rotatedImage.flipHorizontal();
	    if (!hasImageBeenChecked(hFlip, checkedImageLayouts)) {
		numFoundMonsters += hFlip.getNumMonsters(pattern);
		checkedImageLayouts.add(hFlip);
	    }

	    Image vhFlip = rotatedImage.flipVertical().flipHorizontal();
	    if (!hasImageBeenChecked(vhFlip, checkedImageLayouts)) {
		numFoundMonsters += vhFlip.getNumMonsters(pattern);
		checkedImageLayouts.add(vhFlip);
	    }
	}
	return numFoundMonsters;
    }

    public static boolean hasImageBeenChecked(Image testImage, List<Image> checkedImageLayouts) {
	for (Image image : checkedImageLayouts) {
	    if (Arrays.equals(testImage.getData(), image.getData())) {
		System.out.println("ret true");
		return true;
	    }
	}
	return false;
    }

    public static Tile[][] bruteforcePuzzle(List<Tile> tiles) {
	// size of puzzle is at most tiles.size * 1 so this provides enough space
	final int gridSize = tiles.size();
	// [row/y][column/x]
	Tile[][] grid = new Tile[gridSize][gridSize];

	// pick first tile and put it somewhere in the middle
	Tile firstTile = tiles.remove(0);
	grid[gridSize / 2][gridSize / 2] = firstTile;

	puzzleSolved: while (true) {
	    // go through all tiles
	    for (int y = 0; y < gridSize; y++) {
		for (int x = 0; x < gridSize; x++) {

		    Tile currTile = grid[y][x];
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
				grid[y][x] = solution;

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

	// remove rows and columns that are only null
	int startY = -1;
	int startX = -1;
	int endY = -1;
	int endX = -1;

	// determine startX
	xLoop: for (int x = 0; x < gridSize; x++) {
	    for (int y = 0; y < gridSize; y++) {
		Tile tileAtPos = grid[y][x];
		if (!Objects.isNull(tileAtPos)) {
		    startX = x;
		    break xLoop;
		}
	    }
	}

	// determine startY
	yLoop: for (int y = 0; y < gridSize; y++) {
	    for (int x = 0; x < gridSize; x++) {
		Tile tileAtPos = grid[y][x];
		if (!Objects.isNull(tileAtPos)) {
		    startY = y;
		    break yLoop;
		}
	    }
	}

	// determine endX
	xLoop: for (int x = gridSize - 1; x >= 0; x--) {
	    for (int y = gridSize - 1; y >= 0; y--) {
		Tile tileAtPos = grid[y][x];
		if (!Objects.isNull(tileAtPos)) {
		    endX = x;
		    break xLoop;
		}
	    }
	}

	// determine endY
	yLoop: for (int y = gridSize - 1; y >= 0; y--) {
	    for (int x = gridSize - 1; x >= 0; x--) {
		Tile tileAtPos = grid[y][x];
		if (!Objects.isNull(tileAtPos)) {
		    endY = y;
		    break yLoop;
		}
	    }
	}

	// create new grid that contains only the necessary tiles
	final int necessaryGridSizeY = Math.abs(endX - startX) + 1;
	final int necessaryGridSizeX = Math.abs(endY - startY) + 1;
	Tile[][] resultGrid = new Tile[necessaryGridSizeY][necessaryGridSizeX];

	// fill the grid with the tiles
	for (int y = 0; y < necessaryGridSizeY; y++) {
	    for (int x = 0; x < necessaryGridSizeX; x++) {
		resultGrid[y][x] = grid[startY + y][startX + x];
	    }
	}

	return resultGrid;
    }
}