package me.lefted.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
	String input = "FBFBFFBLLR\r\n" + "FBBBFFBLLL\r\n" + "BFBFFFFRRR\r\n" + "BFBBBFBRLL\r\n" + "FBFBBFBLLL\r\n" + "BBBFFFBRRR\r\n" + "FBFFFBFRRL\r\n"
	    + "BFFFFFFRLR\r\n" + "FBFFBBFRRL\r\n" + "FBFBBFBRLL\r\n" + "BFBBBFBRRR\r\n" + "BBFBFFBRLL\r\n" + "FBBFBFFLLL\r\n" + "FBBFFFBRLR\r\n"
	    + "BBFFFFBLRL\r\n" + "FFFBBBBRLR\r\n" + "FFBBBFBRLL\r\n" + "FBBBFBFLLL\r\n" + "FBBBFFFRLL\r\n" + "FBBFBBFLRR\r\n" + "FBFBBBBLLL\r\n"
	    + "BBFBFBFLRR\r\n" + "FBFFFBFRLR\r\n" + "FFFBBFBLLL\r\n" + "FBFFBBBRLL\r\n" + "FBBBFBFLRL\r\n" + "BFFFBFBRRL\r\n" + "BFFBFFBLRR\r\n"
	    + "BBFBBBBRRL\r\n" + "FBFBBBBRRR\r\n" + "BBBFFBBLRL\r\n" + "BBFBFFFRRR\r\n" + "FFBBBBBRRL\r\n" + "BFFBBFFLLR\r\n" + "BBFFFFBRRR\r\n"
	    + "FBFBFFFRLL\r\n" + "FFFBFBBLLL\r\n" + "FBBFBFBLRR\r\n" + "FBFBFBFLLL\r\n" + "BFFFFFFLRR\r\n" + "BFFBBFFRLL\r\n" + "FFBFBBFLLL\r\n"
	    + "FBFBBBFRLL\r\n" + "BFFFFFFLLR\r\n" + "FFFBFBFRLR\r\n" + "FBFFFFBLLL\r\n" + "FFBFBBBLLL\r\n" + "BBFFBBBLRL\r\n" + "BBFBBBBLRR\r\n"
	    + "BFBFBFFRLL\r\n" + "FFFBFBBRLL\r\n" + "FBBBFBBRLL\r\n" + "FBFFFFFLRR\r\n" + "BFFBFBBRLR\r\n" + "BFFBBBBRRR\r\n" + "FBBBBBFLRR\r\n"
	    + "BFFFBFFRRL\r\n" + "FBFBFFFLLR\r\n" + "FBBBFBBRRL\r\n" + "FFBFBBBLRR\r\n" + "FFBFBFBLRR\r\n" + "BFFFBFBLRL\r\n" + "BFFBFBBLRR\r\n"
	    + "BFFFFFBLLR\r\n" + "FBFFBBBRRL\r\n" + "BFFBFFFLLR\r\n" + "BBBFFFFRRL\r\n" + "FBBFBBBRRR\r\n" + "FBFBBBFLLL\r\n" + "FBBFFBFRRR\r\n"
	    + "FFBFFFBLRR\r\n" + "BFFFFBBRRL\r\n" + "FBBBFBFRLL\r\n" + "FFBBFFFLLL\r\n" + "BBFFFFFRLL\r\n" + "BFFBFFBRLR\r\n" + "FFBFFBFRRL\r\n"
	    + "FBBFFFBLLR\r\n" + "FFFBFBFLRR\r\n" + "BFBFBBBRLR\r\n" + "BFBFFBFLLR\r\n" + "FFFBBFBRLR\r\n" + "FFFBBBFLLL\r\n" + "BBFFFFBRLR\r\n"
	    + "FFBBFFFLRR\r\n" + "BBBFFBFLLR\r\n" + "FBFBFFFRRR\r\n" + "BBFFBFBRLL\r\n" + "FBFBFFFLRR\r\n" + "FBBFBFBRRR\r\n" + "FBBFBFFLRR\r\n"
	    + "BFBFFFBRRR\r\n" + "BFBFFFBRLR\r\n" + "BFFBBBFRRL\r\n" + "BBFFBBBLLL\r\n" + "BFBFFBFRRL\r\n" + "BFBFFFFLLL\r\n" + "BFBFFFBLLL\r\n"
	    + "FBFFFFFRRL\r\n" + "FFBFFBBLLL\r\n" + "BFFBFFBLRL\r\n" + "BFFBFBBLLR\r\n" + "FBBFFFBLLL\r\n" + "BFFFBFBLLR\r\n" + "FFFBBBFLRR\r\n"
	    + "BFBFBFFLRR\r\n" + "FBBFFFFRLR\r\n" + "FBFBBFFLLR\r\n" + "FBFFBFBRRL\r\n" + "FBBFFBFLLR\r\n" + "FBFBFBBLRL\r\n" + "FFFBFFBRLL\r\n"
	    + "BBFBBBFRLL\r\n" + "FFBFBBBRLL\r\n" + "BBBFFFBLLR\r\n" + "BFBBBFBLRL\r\n" + "BFBFFFFLRR\r\n" + "FFBFBFFRLR\r\n" + "FBFBFFBRLL\r\n"
	    + "FFBFFFFLLR\r\n" + "FBFFBFFLRL\r\n" + "FFFBFFBLLR\r\n" + "FFFBFBFRRR\r\n" + "BFBBFBBRRR\r\n" + "BFFBBBFLLL\r\n" + "BFFFBBBRRR\r\n"
	    + "BFBBBFFRRR\r\n" + "BBBFFFFRLL\r\n" + "BFBBBFBLLL\r\n" + "FFFBFBFLRL\r\n" + "FFBBFBFRRR\r\n" + "FFBBFBFRLR\r\n" + "BFBBBBBRLR\r\n"
	    + "BBBFBFFLLR\r\n" + "FFBBBBFLLL\r\n" + "BFBFBBFRLL\r\n" + "BFBFBBBRRL\r\n" + "BFBBBBBLRL\r\n" + "BFFBBFBRRR\r\n" + "FBFFFFFRLR\r\n"
	    + "BFFBFBFRRL\r\n" + "BFFBBFBLLR\r\n" + "FBBFFBFRRL\r\n" + "BFFFBFBRLR\r\n" + "BBFFBFFRRL\r\n" + "FBFFBBFRLL\r\n" + "FFBFFFBRLL\r\n"
	    + "BBBFFFBRRL\r\n" + "BFBFFBFLLL\r\n" + "FBFBBFBRRL\r\n" + "FFFBBFFRRR\r\n" + "BBFBFFBLRR\r\n" + "BBBFFFBLRL\r\n" + "BFFFBBBLRL\r\n"
	    + "FBFFFBBLLR\r\n" + "FBBFBBBRRL\r\n" + "FBFBBFBRLR\r\n" + "BFBFFFBRRL\r\n" + "FBBFBFBLRL\r\n" + "FFBBBFBLLL\r\n" + "FFBBBFFRRL\r\n"
	    + "FFBFFBFRLL\r\n" + "FBFBBBFRRL\r\n" + "BFBFBBFLLL\r\n" + "FFBFFBFLLL\r\n" + "FBBBBFBLLL\r\n" + "FFBFBFFRRR\r\n" + "FBBFFBFLRR\r\n"
	    + "BBFFFFBLLL\r\n" + "FBFFFFFRRR\r\n" + "BFFBBBFLLR\r\n" + "FFFBFFFRRL\r\n" + "BBFFFBBRRR\r\n" + "FFBFFBBLLR\r\n" + "FBFBFBFRRL\r\n"
	    + "BFBFFBBRLL\r\n" + "FFFBBBFRLR\r\n" + "FFBFFFFRRL\r\n" + "FBBBFFBLRL\r\n" + "BFFBBFBRLR\r\n" + "FBFBBBFRLR\r\n" + "FFFBFFBLRL\r\n"
	    + "BFFFFFBRLR\r\n" + "FBFFBBBRLR\r\n" + "BBBFBFFRLL\r\n" + "BBFFFBFRLR\r\n" + "FFBFBBFRLR\r\n" + "BFFFBBFLLR\r\n" + "BBFBFBFLLL\r\n"
	    + "BBBFFBBLLR\r\n" + "BFFFFBBLLR\r\n" + "BBFBBBBRLR\r\n" + "FBFFFBFRLL\r\n" + "BFBBFBBLRL\r\n" + "FBFBFFBRLR\r\n" + "FBBFFFBRRL\r\n"
	    + "BFBFFFFRRL\r\n" + "FFBFFFBLRL\r\n" + "BBFBBFBRLL\r\n" + "BFFFFFBLLL\r\n" + "BBBFFBFLLL\r\n" + "FBFBBBBLLR\r\n" + "BBFFFBFLLL\r\n"
	    + "BFFBFBFLRR\r\n" + "BBBFBFFLRL\r\n" + "FFBFBFFRLL\r\n" + "FBBFFFFLLL\r\n" + "FFBBFBBRRR\r\n" + "BFBFFFBLRR\r\n" + "BFFBFBBRRL\r\n"
	    + "BBFBBBFLRL\r\n" + "BFBBFBFLLL\r\n" + "BFBBBBFRLR\r\n" + "BBFBBFFLLL\r\n" + "BBFFBBFRLL\r\n" + "FBBBBFBRLR\r\n" + "FBBBBBFRLR\r\n"
	    + "BFFFFBFRLR\r\n" + "BFFFFFFRRL\r\n" + "FBBFBFFRRR\r\n" + "FFBFFBBLRR\r\n" + "BBBFFFBRLR\r\n" + "FFFBBFFLLR\r\n" + "BBFBBFBRRR\r\n"
	    + "FFBBFBFRRL\r\n" + "FBFFFFBRRR\r\n" + "FBBBBBBRRL\r\n" + "BBFBFFBRLR\r\n" + "BBBFFBBLLL\r\n" + "BFFBFBFLRL\r\n" + "BFFFFBBLRR\r\n"
	    + "BFFBBFBLRL\r\n" + "BFBBFBFRRL\r\n" + "BFBFBBBLRR\r\n" + "FBBFFFBRRR\r\n" + "FFFBBBBLLR\r\n" + "BBFBBBBRRR\r\n" + "FFBFFBFLRL\r\n"
	    + "BFBFBBFRRR\r\n" + "BFBFBFFRRR\r\n" + "FBBFFFFRRL\r\n" + "FFFBFBFRLL\r\n" + "BBFFFFFLLL\r\n" + "BBFBBBFRRR\r\n" + "FFBBBFFRLL\r\n"
	    + "FBBFBFFRLR\r\n" + "BFFFFFBRRR\r\n" + "BFFFBFFRRR\r\n" + "BBBFFBFRRL\r\n" + "BFFBBFFLRL\r\n" + "FBFFBFBRRR\r\n" + "BFBBFFBRLL\r\n"
	    + "BFFFBBBRLR\r\n" + "FFBBFBFLRR\r\n" + "FBFFBBBLRL\r\n" + "BBFFBFFRLL\r\n" + "FFFBFFFRRR\r\n" + "FBFBFFFRLR\r\n" + "FFBFBFFLRR\r\n"
	    + "BBFFBFBLRR\r\n" + "BBFFFBBRLL\r\n" + "BFBFBBFLRL\r\n" + "FBFFBBFRLR\r\n" + "BFFFBFBLLL\r\n" + "FBFFBFFRRL\r\n" + "FBBBBBFRRR\r\n"
	    + "FBFFBBFLLR\r\n" + "BFBBFBBRLR\r\n" + "FBBFBBBLLL\r\n" + "BBBFBFBLLL\r\n" + "BFBFBFBLLR\r\n" + "BFFFFBBLRL\r\n" + "BBFBFBBLLR\r\n"
	    + "BBFFFBBLRR\r\n" + "BBFFBFFRRR\r\n" + "BFFFFFFRRR\r\n" + "FBFBFBBRRL\r\n" + "BFBFFBFLRL\r\n" + "BFBBBBBLLR\r\n" + "BBBFFFFLLR\r\n"
	    + "FBFFBFFLRR\r\n" + "BFFFBFFRLL\r\n" + "FFBFBBFLRR\r\n" + "BFFBFBFLLR\r\n" + "FBFFFBFLLL\r\n" + "FFBBFFBLLR\r\n" + "BBFBFBFRLR\r\n"
	    + "FBFBBFFRLR\r\n" + "BFBBBBFLLR\r\n" + "FFBFBFFLRL\r\n" + "BFBBBBFLLL\r\n" + "BFFFBFFRLR\r\n" + "FBFFFBBLLL\r\n" + "FFBFBFBRLL\r\n"
	    + "FBFBFFBRRR\r\n" + "BFBBFBFLRL\r\n" + "FFFBBBBRRL\r\n" + "FFBFBBBRRR\r\n" + "BFFBBFFRLR\r\n" + "FBFBBFFLRR\r\n" + "FBFFFBBRRR\r\n"
	    + "BFBBFFFRLR\r\n" + "FFBFFFBRRR\r\n" + "FFBFFFBLLR\r\n" + "BFBFFFBLRL\r\n" + "FBFBFBBRLL\r\n" + "FBBBFBBRRR\r\n" + "BBFFBFBRLR\r\n"
	    + "BFFFBBFRLL\r\n" + "FBFBFBFLLR\r\n" + "FFBFFBBRRR\r\n" + "BFBFBBFLRR\r\n" + "FFBBFBBLLR\r\n" + "FFBFFFBRLR\r\n" + "FFFBBBBLLL\r\n"
	    + "BBBFFBFRRR\r\n" + "FBBFBBFLLR\r\n" + "BFBBBFFRRL\r\n" + "FBBBBFFLRL\r\n" + "BFBFBBBLRL\r\n" + "FFBFBBFLLR\r\n" + "BFFFBFBRLL\r\n"
	    + "BFFBFFFRRL\r\n" + "BFFBFFFRLL\r\n" + "FFBBFBBLLL\r\n" + "BBFFFBFRRL\r\n" + "BBFBFBFRRR\r\n" + "FBFBBFFRRL\r\n" + "BFBBFBBLLL\r\n"
	    + "FBFFBFFLLR\r\n" + "FBBBBFFRLR\r\n" + "FBFFBFBRLL\r\n" + "FFBBBBFRRR\r\n" + "FBBBBFBRRR\r\n" + "FBFBBBFLRR\r\n" + "FBBFBFBLLR\r\n"
	    + "FBBBFBFLRR\r\n" + "FBFFBBFLLL\r\n" + "BFBFFFBLLR\r\n" + "FBFFFFBLRR\r\n" + "BFBBBFFLRR\r\n" + "BFBFBBFRLR\r\n" + "FBBFFFBLRL\r\n"
	    + "FBBBBFFRLL\r\n" + "BBBFBFFRRL\r\n" + "BFBFBBBRLL\r\n" + "FFFBBBFLLR\r\n" + "FBBBBBFLLR\r\n" + "BFBFBBFLLR\r\n" + "BFBFBBBRRR\r\n"
	    + "BFBBFBBRLL\r\n" + "FBFFFFBRRL\r\n" + "BBFBFBBRRR\r\n" + "FFBFBFBRRR\r\n" + "FFBFBBFRRL\r\n" + "BBFFFFBRLL\r\n" + "BFFBBBFRLL\r\n"
	    + "FBBBFFBLLR\r\n" + "BFBFBFBRLL\r\n" + "FBBFFBBRLL\r\n" + "FBFFFBBRLR\r\n" + "BBFFBBBRRR\r\n" + "FBBBBBBRRR\r\n" + "FBBFBBFRRL\r\n"
	    + "BFFFBBFLRL\r\n" + "FFFBFBBLRR\r\n" + "FBBBBBBLLL\r\n" + "FFFBFBBRRL\r\n" + "BBBFFFFRRR\r\n" + "BFFFBFFLLL\r\n" + "FFFBFBBLLR\r\n"
	    + "FBFFBBFLRL\r\n" + "BFBBFFFRLL\r\n" + "BBFBFBBLLL\r\n" + "FBBBFFFLRR\r\n" + "BFFBFFBLLL\r\n" + "FBBFBFBRLL\r\n" + "BFBBFFFLLR\r\n"
	    + "FBBFFFBLRR\r\n" + "BFFBBBBLLL\r\n" + "BBFFFBFRRR\r\n" + "FFBBBBFLRL\r\n" + "FBBFFFFLRL\r\n" + "FFFBFBFLLR\r\n" + "BFBBBFBRRL\r\n"
	    + "FFFBBBFRRR\r\n" + "FBBBFBFRLR\r\n" + "BFBFBFFRLR\r\n" + "BFBFFBBLLR\r\n" + "FBFFBFBRLR\r\n" + "BBFBFFFLRL\r\n" + "FBBBFBBLLR\r\n"
	    + "FFBFFBBRLL\r\n" + "FBFFFBBRLL\r\n" + "BFFFFFBRLL\r\n" + "BFFBBBBLLR\r\n" + "FFBBBBFRLL\r\n" + "FFBBBFBRRR\r\n" + "FBBBFBBLLL\r\n"
	    + "FBBBFFBRRL\r\n" + "FFBBBBBLRR\r\n" + "BBFBBBFLRR\r\n" + "BBFBBFFLRL\r\n" + "BBFFBBBRLR\r\n" + "FBFBFFFRRL\r\n" + "BFBFFBBRRL\r\n"
	    + "BBFBBBBRLL\r\n" + "BFFBBBBRRL\r\n" + "BBFBBFFRLR\r\n" + "BFFBBFBLLL\r\n" + "FBBBBBBRLR\r\n" + "FBBFBBBLRL\r\n" + "FFBFFBFRRR\r\n"
	    + "FFFBFFBLRR\r\n" + "BFBBBFBLRR\r\n" + "FFBBFFBRRR\r\n" + "FFFBBBBRRR\r\n" + "FBFFBBBLRR\r\n" + "BFBFFBBLRL\r\n" + "FFBBBBBRLL\r\n"
	    + "BBFBFFBRRR\r\n" + "FFBBFFBLLL\r\n" + "BBFBBFBLLL\r\n" + "BFBFBBBLLR\r\n" + "FBBBFBBRLR\r\n" + "BFBBFFFLRL\r\n" + "BFBBFFFLLL\r\n"
	    + "BFBBFBFRLL\r\n" + "FBFFFFBRLR\r\n" + "FBBFFFFRLL\r\n" + "FFBFBFFLLR\r\n" + "BFFBFBFRRR\r\n" + "BFFBBFBRLL\r\n" + "BFBFBFBRRR\r\n"
	    + "FBFFBFFLLL\r\n" + "FBBFBBFLLL\r\n" + "BBFBBBFLLL\r\n" + "BBFBBFFRLL\r\n" + "BFFFBFFLRR\r\n" + "FBFFFBFRRR\r\n" + "FBBBBFFLRR\r\n"
	    + "FFBBBBBLLL\r\n" + "BFBBBBFRLL\r\n" + "FBBFFBBRRL\r\n" + "FFBFFBBRLR\r\n" + "BFBFBFBRLR\r\n" + "FFBFBBFLRL\r\n" + "FFBBBFBLRL\r\n"
	    + "BFFBBFFLRR\r\n" + "FBFBFBBRRR\r\n" + "FBFBBFBLRL\r\n" + "FBFFFFBLLR\r\n" + "FFBBBBFLRR\r\n" + "FBFBBBBLRL\r\n" + "FFFBBFFRLR\r\n"
	    + "BBBFFBFRLR\r\n" + "FFFBBFBRRR\r\n" + "FFBFFFFRLR\r\n" + "BFFBFFBRRL\r\n" + "FBFBFFFLRL\r\n" + "FFBFBFBLRL\r\n" + "FBBBFBBLRR\r\n"
	    + "BFFFFBFRRL\r\n" + "FBFFFBBLRL\r\n" + "FFFBBBFRLL\r\n" + "BFFBBFFLLL\r\n" + "FFFBFBBRLR\r\n" + "FBBFBBFLRL\r\n" + "BFFFFFFLLL\r\n"
	    + "FFFBBFFLRR\r\n" + "FFBFFBFLRR\r\n" + "FFBBBBFLLR\r\n" + "BFFFBFFLLR\r\n" + "FBBFBBBLRR\r\n" + "BBBFFBFLRR\r\n" + "FBBFFBBLRL\r\n"
	    + "FBFBBBBRRL\r\n" + "BBFFBBFLLR\r\n" + "BBBFFBFRLL\r\n" + "FBFFFFBLRL\r\n" + "BBBFBFFRLR\r\n" + "BBFFBBFLRL\r\n" + "BFBFBFBLLL\r\n"
	    + "FFBFBBFRRR\r\n" + "BFBBBFFLLR\r\n" + "FBBFFFFLRR\r\n" + "BFBFFFFRLL\r\n" + "FBFFBBBLLL\r\n" + "BBFFFFFLRL\r\n" + "BFFBFBFLLL\r\n"
	    + "BBFBBBFRRL\r\n" + "FBFFFBFLRL\r\n" + "BFFFBBBLLL\r\n" + "FFBBBFFLLL\r\n" + "BBFFFFFRRL\r\n" + "FBBFFBFLRL\r\n" + "FBBBFBBLRL\r\n"
	    + "FFBBFBFRLL\r\n" + "FFBFBBFRLL\r\n" + "BBFFFBBRLR\r\n" + "FBFBBFBLLR\r\n" + "FBFFBBBRRR\r\n" + "FBFFFFFLRL\r\n" + "BBFBBBBLLR\r\n"
	    + "FFBBBFFLRL\r\n" + "BFBBBBFRRR\r\n" + "FBBBBBFRLL\r\n" + "FFBBFFBRRL\r\n" + "FBBBFFBLRR\r\n" + "BFBFFBFRLR\r\n" + "FBFFFBFLRR\r\n"
	    + "FBFBFFBLRL\r\n" + "FBFBFBFRLL\r\n" + "BBFBFFFLLR\r\n" + "BFBBFFBLRR\r\n" + "FFFBFFBRRR\r\n" + "BBFFBFFLLR\r\n" + "BFFBFBFRLL\r\n"
	    + "BFBBFBFRLR\r\n" + "BBFFFFBLRR\r\n" + "BBFFFFFRRR\r\n" + "FFFBBFFRLL\r\n" + "BFFBFFFLRR\r\n" + "BFBBBBBRRL\r\n" + "FBBBFFBRLL\r\n"
	    + "BFFFBFBRRR\r\n" + "FFFBFFBRLR\r\n" + "FBBFBBBRLR\r\n" + "BFFFFFBLRL\r\n" + "BFBFFBFLRR\r\n" + "FBFBBFBLRR\r\n" + "FFBFBFBLLL\r\n"
	    + "BBFBFBBRRL\r\n" + "FBBBBFBLRR\r\n" + "FBFBBBFLLR\r\n" + "FBFBFFBLRR\r\n" + "BBFBFBFLLR\r\n" + "BBFFBFBLLL\r\n" + "FFBBFFBRLR\r\n"
	    + "FFBFBFFRRL\r\n" + "FBFBBBBRLR\r\n" + "BBFBBFFRRL\r\n" + "FFBBBBBRRR\r\n" + "BBFBFFBLLL\r\n" + "BFFBBFFRRR\r\n" + "BFBBFBFLLR\r\n"
	    + "FFBFFBBRRL\r\n" + "BFFBBFBRRL\r\n" + "FFBFFFFRLL\r\n" + "BFFBFFBRRR\r\n" + "BFFFBFBLRR\r\n" + "BFFFFFBLRR\r\n" + "FFBBFFFLRL\r\n"
	    + "FBFBBFBRRR\r\n" + "FBFBFBBRLR\r\n" + "BBFBFBFRLL\r\n" + "BFFBBBFLRL\r\n" + "BBFBBBFRLR\r\n" + "BBFBFBBLRL\r\n" + "FBBBFFBRRR\r\n"
	    + "FBBFFBFRLL\r\n" + "FBBBBBFLRL\r\n" + "FBBFFBBLLR\r\n" + "FBFBBFFRRR\r\n" + "FBFBBBBRLL\r\n" + "FFBFBBBRLR\r\n" + "FBBBBFFLLL\r\n"
	    + "BFBBFFBLRL\r\n" + "BBFBFBBRLR\r\n" + "FFBBFFBLRR\r\n" + "FFBFFFFRRR\r\n" + "FFBFBFFLLL\r\n" + "BFFFBBFRRR\r\n" + "FBBFBBBLLR\r\n"
	    + "BFFFBBFRLR\r\n" + "BFFFFBFLLL\r\n" + "BBFFFBFLLR\r\n" + "FBFFFFFLLL\r\n" + "BBBFFFBLLL\r\n" + "BBBFFBBRRL\r\n" + "BFFBBBBRLL\r\n"
	    + "BFBFFFFRLR\r\n" + "FBBBFFFRLR\r\n" + "BBFBFFFRLL\r\n" + "FFBBFFFRLL\r\n" + "BFBBFFBRRL\r\n" + "BBFFBBBLRR\r\n" + "BBBFFBBRRR\r\n"
	    + "FFFBBFBRRL\r\n" + "FFBFFFFLRL\r\n" + "BFBBFBBLRR\r\n" + "FFFBFBBLRL\r\n" + "FBFFBFBLLL\r\n" + "FBFBBBBLRR\r\n" + "BFBBBFFLLL\r\n"
	    + "FFBBFBBRRL\r\n" + "BBBFFFFLRR\r\n" + "BBFFFFFRLR\r\n" + "BBBFFFBRLL\r\n" + "BBBFFFFLRL\r\n" + "FFBBBFBRRL\r\n" + "FFBFFFBRRL\r\n"
	    + "BFFBBBFLRR\r\n" + "FFFBBFBLLR\r\n" + "BFBBFBBRRL\r\n" + "FBBBBFFRRR\r\n" + "FBFBFBFLRR\r\n" + "BBFBBFBRLR\r\n" + "BBFFBBFRLR\r\n"
	    + "BBFBFFFRRL\r\n" + "FBFBBBFLRL\r\n" + "BFFFFBBRLR\r\n" + "FBBBFFFRRR\r\n" + "BBFFBBFLRR\r\n" + "BFFFBBFLRR\r\n" + "FFBBFBFLLL\r\n"
	    + "FFBBBBBLLR\r\n" + "BFFBFFBRLL\r\n" + "BFFBFFFRRR\r\n" + "BBFBFBFRRL\r\n" + "BFBFFBBRLR\r\n" + "BBBFBFFRRR\r\n" + "FBFFBFBLRR\r\n"
	    + "FFFBBFFLRL\r\n" + "FBFBFBFRLR\r\n" + "BFBFFFFLRL\r\n" + "BBFFFFBLLR\r\n" + "FFBFBBBRRL\r\n" + "BBFBBFBLLR\r\n" + "BFFBFBBLLL\r\n"
	    + "BFBBBFBLLR\r\n" + "BFBBFFFRRR\r\n" + "BFFFBBFLLL\r\n" + "FFBBFFFLLR\r\n" + "FBFFFBBLRR\r\n" + "BFBFBFBLRR\r\n" + "BFBBFBFLRR\r\n"
	    + "BFFFBBBLRR\r\n" + "FBFBBFFLLL\r\n" + "BFBBBBBRLL\r\n" + "BFBFBFBRRL\r\n" + "BBBFFFBLRR\r\n" + "BBFFFFBRRL\r\n" + "BBFBFFBLRL\r\n"
	    + "FFBBBFBLRR\r\n" + "FBBFBFFRLL\r\n" + "FFBBFBBLRL\r\n" + "FBBFFFBRLL\r\n" + "BBBFBFFLRR\r\n" + "FFFBFFBLLL\r\n" + "BFBBBBBLLL\r\n"
	    + "BBFFFFFLLR\r\n" + "FBFBFFFLLL\r\n" + "BBFBBFBLRL\r\n" + "BFBFFBBLLL\r\n" + "BBFBBBBLRL\r\n" + "FBBBBFBRRL\r\n" + "BFFBFBBRRR\r\n"
	    + "FBFBBBFRRR\r\n" + "BFFBBBFRRR\r\n" + "BFFFBBBLLR\r\n" + "FFBBBBFRLR\r\n" + "BFBFFBFRRR\r\n" + "FBFBFBFRRR\r\n" + "FFFBFBBRRR\r\n"
	    + "BFBFFFFLLR\r\n" + "FBBBBBBLRL\r\n" + "BFFFFBFLRL\r\n" + "BFFFFFFLRL\r\n" + "BFFFBBBRLL\r\n" + "BFFFFBBRLL\r\n" + "FBBFFFFRRR\r\n"
	    + "BBBFFBBRLL\r\n" + "BFBBFFBLLL\r\n" + "FFFBBFBLRL\r\n" + "FBBBFBFLLR\r\n" + "BFFBFBBLRL\r\n" + "BBBFBFBLRL\r\n" + "BBFBFFFLRR\r\n"
	    + "BBFBFFBRRL\r\n" + "BFBFBFBLRL\r\n" + "FBBBBFBRLL\r\n" + "BBFBBFBRRL\r\n" + "BBFFBFBLRL\r\n" + "FBBBBBFRRL\r\n" + "FBBFBFBLLL\r\n"
	    + "FFBBFFBRLL\r\n" + "BBFFFBBLLL\r\n" + "BFFFBBFRRL\r\n" + "BBFBBFFRRR\r\n" + "FBBBBBBLRR\r\n" + "FFBBBFBRLR\r\n" + "BFFFFFBRRL\r\n"
	    + "FBFFFFFRLL\r\n" + "BBFFBFFRLR\r\n" + "BBFFBFBLLR\r\n" + "BBFFBFBRRL\r\n" + "BBBFFFFRLR\r\n" + "BBFFBFFLRR\r\n" + "FFBBFFFRRL\r\n"
	    + "BFFFBBBRRL\r\n" + "BBBFFFFLLL\r\n" + "BBFBFFBLLR\r\n" + "BBFBBFFLLR\r\n" + "FFBBBBFRRL\r\n" + "FBFBFBBLLR\r\n" + "FFFBBBBLRL\r\n"
	    + "BFBFFFBRLL\r\n" + "FBFFBFFRLL\r\n" + "FBBFFBFRLR\r\n" + "BFFFFBFLLR\r\n" + "FBBBBBFLLL\r\n" + "BBFBBBFLLR\r\n" + "FBBBBFBLLR\r\n"
	    + "FBFFBBBLLR\r\n" + "BBFFBBFRRL\r\n" + "FFBBBFBLLR\r\n" + "FBFFBFBLRL\r\n" + "FBFFFFBRLL\r\n" + "BFBFFBFRLL\r\n" + "FFBBFBFLRL\r\n"
	    + "FBBFFBFLLL\r\n" + "BBFBBFFLRR\r\n" + "FFBFFBFRLR\r\n" + "BFFFFBFLRR\r\n" + "BFBBFBBLLR\r\n" + "BFBFBFFLRL\r\n" + "FFBBFFBLRL\r\n"
	    + "FBBBFBFRRL\r\n" + "FFFBBFBRLL\r\n" + "BBFFBFFLRL\r\n" + "FBFBFFBLLL\r\n" + "FBBFBBFRRR\r\n" + "FFBFFFFLRR\r\n" + "FBFFBFFRLR\r\n"
	    + "FBBBFFBRLR\r\n" + "BBFFBFFLLL\r\n" + "BBFBBBBLLL\r\n" + "FBFBBFFRLL\r\n" + "BFBBBBFLRR\r\n" + "FBFFBBFLRR\r\n" + "BFFBBFBLRR\r\n"
	    + "BBFFFBFRLL\r\n" + "BBBFFBFLRL\r\n" + "BBFFBFBRRR\r\n" + "BBBFBFBLLR\r\n" + "FBFBFBBLLL\r\n" + "BBFBFFFRLR\r\n" + "BFFBFFFRLR\r\n"
	    + "BFBBBFFLRL\r\n" + "FFBBFFFRRR\r\n" + "FFBBBFFRLR\r\n" + "BFBFBFFLLL\r\n" + "FBBFFBBLLL\r\n" + "FBBFBBBRLL\r\n" + "FFBBBBBLRL\r\n"
	    + "FFFBBBBRLL\r\n" + "BFBBBBFRRL\r\n" + "FBBFFBBRRR\r\n" + "BFBBBBBLRR\r\n" + "BFBBFBFRRR\r\n" + "BBFFBBBRLL\r\n" + "BBFBFBBLRR\r\n"
	    + "BFBFFBBRRR\r\n" + "FBFBBFFLRL\r\n" + "FBBBFFFLLR\r\n" + "BFBBBFFRLR\r\n" + "BFFBBBBLRR\r\n" + "FFBBBFFRRR\r\n" + "FBBBFBFRRR\r\n"
	    + "FFFBBBFRRL\r\n" + "BFBFBBFRRL\r\n" + "FFBBFBBLRR\r\n" + "FFFBFBFLLL\r\n" + "FBBFBBFRLL\r\n" + "BBFFFBBLRL\r\n" + "FFFBBBFLRL\r\n"
	    + "FBFFFBBRRL\r\n" + "FBBBBFFRRL\r\n" + "FFBBFBBRLL\r\n" + "BBFFBBFLLL\r\n" + "BFFBFFFLLL\r\n" + "FFBBBFFLRR\r\n" + "BFBBBFBRLR\r\n"
	    + "BFFBBBFRLR\r\n" + "FFFBBFFLLL\r\n" + "FFBFFBBLRL\r\n" + "FBFFBFFRRR\r\n" + "BFBBBFFRLL\r\n" + "FBBFFBBRLR\r\n" + "BFFBBBBLRL\r\n"
	    + "BBFFFFFLRR\r\n" + "BBFBFFFLLL\r\n" + "FBFFFFFLLR\r\n" + "FBBBBFFLLR\r\n" + "BBFFFBFLRL\r\n" + "FBBFBFBRLR\r\n" + "FBBFBFBRRL\r\n"
	    + "FFBBFFFRLR\r\n" + "FFBFBBBLRL\r\n" + "FFBBBBBRLR\r\n" + "BBFFFBFLRR\r\n" + "BFBBFFFRRL\r\n" + "BBFBFBFLRL\r\n" + "FBBBBBBRLL\r\n"
	    + "FBBFBFFLRL\r\n" + "FBFBFBFLRL\r\n" + "BFBFBFFRRL\r\n" + "BFBBFFBRRR\r\n" + "FBFFFBFLLR\r\n" + "FBBBFFFLRL\r\n" + "BFBBFFBLLR\r\n"
	    + "FFBFFFFLLL\r\n" + "BFBBFFFLRR\r\n" + "FBBFBFFLLR\r\n" + "BBBFFBBRLR\r\n" + "FFBFBBBLLR\r\n" + "FBFBFFBRRL\r\n" + "FFBBFBFLLR\r\n"
	    + "BFFBFBFRLR\r\n" + "BFFBFFBLLR\r\n" + "BBBFBFFLLL\r\n" + "FFBFFBFLLR\r\n" + "FFFBBBBLRR\r\n" + "FFFBFFBRRL\r\n" + "FBBBFFFRRL\r\n"
	    + "BBFFFBBRRL\r\n" + "BBFBBFBLRR\r\n" + "BBFFBBBRRL\r\n" + "BBFBFBBRLL\r\n" + "BFFFFFFRLL\r\n" + "BFFBFFFLRL\r\n" + "BFFFFBFRRR\r\n"
	    + "BFFFBFFLRL\r\n" + "BFBFFBBLRR\r\n" + "FFBBFBBRLR\r\n" + "BFBBBBBRRR\r\n" + "BFFBBFFRRL\r\n" + "FFBFFFBLLL\r\n" + "FBBFBBFRLR\r\n"
	    + "BBFFBBBLLR\r\n" + "FFFBBFFRRL\r\n" + "FFFBBFBLRR\r\n" + "FBFBFBBLRR\r\n" + "FBBBFFFLLL\r\n" + "FFBFBFBLLR\r\n" + "BFBBFFBRLR\r\n"
	    + "BFFFFBBLLL\r\n" + "BFBBBBFLRL\r\n" + "FBBBBBBLLR\r\n" + "BFFFFBBRRR\r\n" + "BBFFFBBLLR\r\n" + "FFBBBFFLLR\r\n" + "FFFBFBFRRL\r\n"
	    + "BFFFFBFRLL\r\n" + "BFFBBBBRLR\r\n" + "FBFFBFBLLR\r\n" + "FBBFFBBLRR\r\n" + "BBBFFBBLRR\r\n" + "BFFBFBBRLL\r\n" + "BFBFBFFLLR\r\n"
	    + "FFBFBFBRRL\r\n" + "BBFFBBFRRR\r\n" + "FFBFBFBRLR\r\n" + "FBBFFFFLLR\r\n" + "FBBFBFFRRL\r\n" + "FBFFBBFRRR\r\n" + "FBBBBFBLRL\r\n";
	List<String> inputStrings = Arrays.asList(input.split("\r\n"));

	// PART 1
	// int foundMaxID = 0;
	 boolean[][] foundRowsColumns = new boolean[128][8];

	for (String string : inputStrings) {
	    final int row = getRow(string);
	    final int column = getColumn(string);
	    foundRowsColumns[row][column] = true;
	    // foundMaxID = Math.max(getId(string), foundMaxID);
	}

	for (int row = 9; row < 117; row++) {
	    for (int column = 0; column < 8; column++) {
		if (foundRowsColumns[row][column] == false) {
		    System.out.println(getId(row, column));
		}
	    }
	}

	// PART 1
	// System.out.println(String.format("Found %s", foundMaxID));
    }

    public static int getId(String string) {
	return getRow(string) * 8 + getColumn(string);
    }

    public static int getId(int row, int column) {
	return row * 8 + column;
    }

    public static int getRow(String string) {
	String significantLetters = string.substring(0, string.length() - 3).replace('B', '1').replace('F', '0');
	return Integer.parseInt(significantLetters, 2);
    }

    public static int getColumn(String string) {
	String significantLetters = string.substring(string.length() - 3, string.length()).replace('R', '1').replace('L', '0');
	return Integer.parseInt(significantLetters, 2);
    }
}
