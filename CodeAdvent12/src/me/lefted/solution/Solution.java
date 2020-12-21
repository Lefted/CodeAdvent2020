package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Solution {

    // public static Ship ship = new Ship();
    public static ShipSolution2 ship = new ShipSolution2();

    public static void main(String[] args) throws IOException {
	List<String> input = Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt"));
	int found = 0;
	found = calcManhattenDistance(input);
	System.out.println(String.format("found %s", found));
    }

    public static int calcManhattenDistance(List<String> input) {
	for (String line : input) {
	    char instruction = line.charAt(0);
	    int value = Integer.parseInt((String) line.subSequence(1, line.length()));

	    if (instruction == 'R' || instruction == 'L') {
		ship.rotate(instruction == 'L', value);
	    } else if (instruction == 'F') {
		ship.moveForward(value);
	    } else {
		ship.move(instruction, value);
	    }
	}
	return ship.getManhattenDistance();
    }
}
