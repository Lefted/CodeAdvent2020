package me.lefted.solution;

import java.util.ArrayList;
import java.util.List;

public class Pattern {

    public static final String patternString = "                  # \r\n" + "#    ##    ##    ###\r\n" + " #  #  #  #  #  #   ";

    private char[][] pattern;
    private List<int[]> relPos;
    private int[] anchor;

    public Pattern(String pattern) {
	relPos = new ArrayList<>();
	this.pattern = parsePattern(pattern);
    }

    private char[][] parsePattern(String pattern) {
	String[] split = pattern.split("\r\n");
	int numChars = split[0].length();
	int numRows = split.length;

	char[][] data = new char[numRows][numChars];

	for (int row = 0; row < numRows; row++) {
	    data[row] = split[row].toCharArray();
	}

	// anchor point is first #
	// add all other # positions relative to the first found #
	for (int y = 0; y < numRows; y++) {
	    for (int x = 0; x < numChars; x++) {

		if (data[y][x] == '#') {
		    if (anchor == null) {
			anchor = new int[] { y, x };
		    } else {
			int relY = y - anchor[0];
			int relX = x - anchor[1];
			relPos.add(new int[] { relY, relX });
		    }
		}
	    }
	}

	return data;
    }

    public List<int[]> getRelPos() {
	return this.relPos;
    }
}