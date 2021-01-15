package me.lefted.solution;

public class Image {

    private char[][] data;

    public Image(Tile[][] grid) {
	this.data = this.getStichedImageData(grid);
    }

    public Image(char[][] data) {
	this.data = data;
    }

    public int getNumMonsters(Pattern pattern) {
	int num = 0;

	for (int y = 0; y < data.length; y++) {
	    posCheck: for (int x = 0; x < data[y].length; x++) {

		char currChar = data[y][x];
		if (currChar == '#') {

		    for (int[] relPos : pattern.getRelPos()) {
			try {
			    if (data[y + relPos[0]][x + relPos[1]] != '#')
				continue posCheck;
			} catch (IndexOutOfBoundsException e) {
			    continue posCheck;
			}
		    }
		    num++;
		}
	    }
	}

	return num;
    }

    private char[][] getStichedImageData(Tile[][] grid) {
	char[][][][] imageDataWithoutBorder = new char[grid.length][grid[0].length][Tile.TILE_SIZE - 2][Tile.TILE_SIZE - 2];

	final int imageWidth = grid[0].length * (grid[0][0].getData()[0].length - 2);
	final int imageHeight = grid.length * (grid[0][0].getData().length - 2);
	char[][] data = new char[imageWidth][imageHeight];

	for (int gridRowIndex = 0; gridRowIndex < grid.length; gridRowIndex++) {
	    for (int gridColumnIndex = 0; gridColumnIndex < grid[gridRowIndex].length; gridColumnIndex++) {

		final char[][] tileDataWithoutBorder = grid[gridRowIndex][gridColumnIndex].getImageDataWithoutBorder();
		imageDataWithoutBorder[gridRowIndex][gridColumnIndex] = tileDataWithoutBorder;
	    }
	}

	// combine the data into one 2d array
	int stichedImageRowIndex = 0;
	for (int gridRowIndex = 0; gridRowIndex < imageDataWithoutBorder.length; gridRowIndex++) {
	    char[][][] gridRowImageData = imageDataWithoutBorder[gridRowIndex];

	    for (int imageRowIndex = 0; imageRowIndex < Tile.TILE_SIZE - 2; imageRowIndex++) {
		int stichedColumnIndex = 0;
		for (int gridColumnIndex = 0; gridColumnIndex < imageDataWithoutBorder[gridRowIndex].length; gridColumnIndex++) {

		    for (int imageColumnIndex = 0; imageColumnIndex < Tile.TILE_SIZE - 2; imageColumnIndex++) {
			data[stichedImageRowIndex][stichedColumnIndex] = gridRowImageData[gridColumnIndex][imageRowIndex][imageColumnIndex];
			stichedColumnIndex++;
		    }
		}

		stichedImageRowIndex++;
	    }
	}

	return data;
    }

    public Image flipHorizontal() {
	char[][] newData = new char[data.length][data[0].length];

	int rowStartIndex = 0;
	int rowEndIndex = data.length - 1;

	while (rowStartIndex < rowEndIndex) {
	    newData[rowStartIndex] = data[rowEndIndex];
	    newData[rowEndIndex] = data[rowStartIndex];

	    rowStartIndex++;
	    rowEndIndex--;
	}
	return new Image(newData);
    }

    public Image flipVertical() {
	char[][] newData = new char[data.length][data[0].length];

	for (int rowIndex = 0; rowIndex < newData.length; rowIndex++) {

	    int columnStartIndex = 0;
	    int columnEndIndex = 0;

	    while (columnStartIndex < columnEndIndex) {
		newData[rowIndex][columnStartIndex] = data[rowIndex][columnEndIndex];
		newData[rowIndex][columnEndIndex] = data[rowIndex][columnEndIndex];

		columnStartIndex++;
		columnEndIndex--;
	    }
	}
	return new Image(newData);
    }

    public Image rotate(int steps) {
	if (steps > 0) {
	    char[][] dataCopy = copyOf(data);
	    char[][] newData = new char[data.length][data[0].length];

	    for (int stepIndex = 0; stepIndex < steps; stepIndex++) {
		for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
		    for (int columnIndex = 0; columnIndex < data[rowIndex].length; columnIndex++) {
			newData[rowIndex][columnIndex] = dataCopy[data.length - 1 - columnIndex][rowIndex];
		    }
		}
		dataCopy = copyOf(newData);
	    }
	    return new Image(newData);
	}
	return this;
    }

    public static char[][] copyOf(char[][] original) {
	char[][] copy = new char[original.length][original[0].length];

	for (int y = 0; y < original.length; y++) {
	    for (int x = 0; x < original[0].length; x++) {
		copy[y][x] = original[y][x];
	    }
	}

	return copy;
    }

    public void print() {
	for (char row[] : data) {
	    System.out.println(row);
	}
    }

    public char[][] getData() {
	return this.data;
    }
}
