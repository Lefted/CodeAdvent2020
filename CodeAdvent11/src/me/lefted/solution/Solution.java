package me.lefted.solution;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Solution {

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
		    if (input[y][x] == '#' && numAdjacentOccupiedSeats(x, y, input) >= 4) {
			afterRound[y][x] = 'L';
			changed = true;
		    } else if (input[y][x] == 'L' && numAdjacentOccupiedSeats(x, y, input) == 0) {
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

    public static int numAdjacentOccupiedSeats(int x, int y, char[][] input) {
	int num = 0;

	for (int i = -1; i < 2; ++i) {
	    for (int j = -1; j < 2; ++j) {
		if (j == 0 && i == 0)
		    continue;
		try {
		    if (input[y + i][x + j] == '#')
			num++;
		} catch (Exception e) {
		}
	    }
	}
	return num;
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
