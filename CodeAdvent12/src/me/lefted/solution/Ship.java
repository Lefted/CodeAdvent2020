package me.lefted.solution;

public class Ship {

    private int direction;
    private int x;
    private int y;

    public Ship() {
	// facing east
	this.direction = 90;
    }

    public void moveForward(int value) {
	switch (this.direction) {
	case 0:
	    this.y += value;
	    break;
	case 90:
	    this.x += value;
	    break;
	case 180:
	    this.y -= value;
	    break;
	case 270:
	    this.x -= value;
	    break;
	}
    }

    public void move(char direction, int value) {
	switch (direction) {
	case 'N':
	    this.y += value;
	    break;
	case 'E':
	    this.x += value;
	    break;
	case 'S':
	    this.y -= value;
	    break;
	case 'W':
	    this.x -= value;
	    break;
	default:
	    break;
	}
    }

    public void rotate(boolean left, int value) {
	this.direction = left ? this.direction - value : this.direction + value;
	this.direction = this.direction < 0 ? 360 - Math.abs(this.direction % 360) : Math.abs(this.direction % 360);
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
