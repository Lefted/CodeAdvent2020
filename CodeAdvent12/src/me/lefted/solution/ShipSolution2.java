package me.lefted.solution;

public class ShipSolution2 {

    private int x;
    private int y;
    private int rel_WP_X;
    private int rel_WP_Y;

    public ShipSolution2() {
	this.rel_WP_X = 10;
	this.rel_WP_Y = 1;
    }

    // moves towards waypoint
    public void moveForward(int value) {
	this.x += this.rel_WP_X * value;
	this.y += this.rel_WP_Y * value;
    }

    // moves the waypoint
    public void move(char direction, int value) {
	switch (direction) {
	case 'N':
	    this.rel_WP_Y += value;
	    break;
	case 'E':
	    this.rel_WP_X += value;
	    break;
	case 'S':
	    this.rel_WP_Y -= value;
	    break;
	case 'W':
	    this.rel_WP_X -= value;
	    break;
	default:
	    break;
	}
    }

    public void rotate(boolean left, int value360) {
	int val = value360 / 90;
	// how many 90 degree steps
	int steps = val % 4;
	steps = left ? 4 - steps : steps;
	rotateClockwise(steps);
    }

    private void rotateClockwise(int steps) {
	final int tempX = rel_WP_X;
	final int tempY = rel_WP_Y;
	switch (steps) {
	case 1:
	    rel_WP_Y = -tempX;
	    rel_WP_X = tempY;
	    break;
	case 2:
	    rel_WP_X = -tempX;
	    rel_WP_Y = -tempY;
	    break;
	case 3:
	    rel_WP_Y = tempX;
	    rel_WP_X = -tempY;
	    break;
	default:
	    break;
	}
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public int getManhattenDistance() {
	return Math.abs(x) + Math.abs(y);
    }
}