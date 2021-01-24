package me.lefted.solution;

public class LinkedList {

    private int currPointer = 0;
    private final int size;
    private final int[] values; // values[0] is startValue

    public LinkedList(int size) {
	this.size = size;
	values = new int[size];

	for (int i = 0; i < values.length; i++)
	    values[i] = -1;
    }

    public void add(int value) {
	values[currPointer] = value;
	currPointer = value;
    }

    public void linkCircle() {
	values[currPointer] = values[0];
    }

    public void link(int value, int nextValue) {
	values[value] = nextValue;
    }

    public int getStartValue() {
	return values[0];
    }

    public int size() {
	return size;
    }

    public int getNext(int current) {
	return values[current];
    }

    public int[] toArray() {
	int[] array = new int[size - 1]; // 0 is skipped

	int current = values[0];
	for (int i = 0; i < size - 1; i++) {
	    array[i] = current;
	    current = getNext(current);
	}

	return array;
    }
}