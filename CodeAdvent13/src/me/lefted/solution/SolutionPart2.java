package me.lefted.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException {
	List<String> busIntervals = Arrays.asList(Files.readAllLines(Paths.get("src/me/lefted/solution/input.txt")).get(1).split(","));
	long found = 0;
	found = calcMagicTimestamp(busIntervals);
	System.out.println(String.format("found %s", found));
    }

    public static long calcMagicTimestamp(List<String> busIntervals) {
	long time = 0;
	long step = -1;

	for (int i = 0; i < busIntervals.size(); ++i) {
	    if (busIntervals.get(i).equals("x"))
		continue;
	    final int interval = Integer.parseInt(busIntervals.get(i));
	    if (step == -1) {
		step = interval;
		continue;
	    }

	    while (true) {
		final long nextDepart = time + i;
		if (nextDepart % interval == 0) {
		    step *= interval;
		    break;
		} else
		    time += step;
	    }
	}
	return time;
    }
}
