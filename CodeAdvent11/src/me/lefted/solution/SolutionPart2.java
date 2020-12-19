package me.lefted.solution;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException, URISyntaxException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));

	int found = 0;
	found = playGameOfLife(parseInput(input));

	System.out.println(String.format("found %s", found));
    }

    public static int playGameOfLife(char[][] input) {
	boolean changed = false;
	char[][] afterRound = Arrays.stream(input).map(char[]::clone).toArray(char[][]::new);
	do {
	    changed = false;
	    for (int y = 0; y < input.length; ++y) {
		for (int x = 0; x < input[0].length; ++x) {
		    if (input[y][x] == '#' && numVisibleOccupiedSeats(x, y, input) >= 5) {
			afterRound[y][x] = 'L';
			changed = true;
		    } else if (input[y][x] == 'L' && numVisibleOccupiedSeats(x, y, input) == 0) {
			afterRound[y][x] = '#';
			changed = true;
		    }
		}
	    }
	    input = Arrays.stream(afterRound).map(char[]::clone).toArray(char[][]::new);
	} while (changed);
	return countOccupiedSeats(afterRound);
    }

    public static int countOccupiedSeats(char[][] input) {
	int num = 0;

	for (char[] line : input) {
	    for (char c : line) {
		if (c == '#')
		    num++;
	    }
	}
	return num;
    }

    public static int numVisibleOccupiedSeats(int x, int y, char[][] input) {
	int num = 0;

	for (int i = -1; i < 2; ++i) {
	    for (int j = -1; j < 2; ++j) {
		if (i == 0 && j == 0)
		    continue;
		if (isOccupationInDirection(x, y, j, i, input))
		    num++;
	    }
	}
	return num;
    }

    public static boolean isOccupationInDirection(int x, int y, int dirX, int dirY, char[][] input) {
	int max = Math.max(input.length, input[0].length);
	for (int dist = 1; dist < max; ++dist) {
	    try {
		switch (input[y + dirY * dist][x + dirX * dist]) {
		case '#':
		    return true;
		case 'L':
		    return false;
		default:
		    break;
		}
	    } catch (Exception e) {
	    }
	}
	return false;
    }

    // y x
    public static char[][] parseInput(List<String> input) {
	char[][] result = new char[input.size()][input.get(0).length()];

	for (int i = 0; i < input.size(); ++i) {
	    result[i] = input.get(i).toCharArray();
	}
	return result;
    }
}
