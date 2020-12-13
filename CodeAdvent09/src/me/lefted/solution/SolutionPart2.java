package me.lefted.solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SolutionPart2 {

    public static void main(String[] args) throws IOException {
	String test = "35\r\n" + "20\r\n" + "15\r\n" + "25\r\n" + "47\r\n" + "40\r\n" + "62\r\n" + "55\r\n" + "65\r\n" + "95\r\n" + "102\r\n" + "117\r\n"
	    + "150\r\n" + "182\r\n" + "127\r\n" + "219\r\n" + "299\r\n" + "277\r\n" + "309\r\n" + "576";

	List<Long> numberList = Files.lines(Paths.get("src/me/lefted/solution/input.txt")).map(str -> Long.parseLong(str)).collect(Collectors.toList());
	long invalidNumber = 0;
	long weaknes = 0;

	invalidNumber = findNumber(numberList, 25);
	weaknes = findWeaknes(numberList, invalidNumber);

	System.out.println(String.format("Invalid Number %s", invalidNumber));
	System.out.println(String.format("Weaknes %s", weaknes));
    }

    public static long findWeaknes(List<Long> input, long invalidNumber) {

	for (int start = 0; start < input.size() - 1; ++start) {
	    for (int end = start + 1; end < input.size(); ++end) {

		List<Long> test = input.subList(start, end + 1);
		Supplier<LongStream> streamSupplier = () -> test.stream().mapToLong(Long::longValue);
		if (streamSupplier.get().sum() == invalidNumber)
		    return streamSupplier.get().min().getAsLong() + streamSupplier.get().max().getAsLong();
	    }
	}
	return 0;
    }

    public static long findNumber(List<Long> input, int preambleSize) {

	for (int i = preambleSize; i < input.size(); ++i) {
	    List<Long> testInput = input.subList(i - preambleSize, i);
	    long numberToTest = input.get(i);
	    if (!isValid(testInput, numberToTest))
		return numberToTest;
	}
	return 0;
    }

    public static boolean isValid(List<Long> input, long numberToTest) {

	for (long i : input) {
	    for (long j : input) {

		if (i != j) {
		    if (i + j == numberToTest)
			return true;
		}
	    }
	}
	return false;
    }
}