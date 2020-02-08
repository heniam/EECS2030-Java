package eecs2030.lab1;

public class Point2 {

	/**
	 * A simple class for representing points in 2D Cartesian coordinates. Every
	 * Point2D instance has an x and y coordinate.
	 */

	private double x;
	private double y;

	public Point2() {
		x = 0;
		y = 0;
	}

	public Point2(double newX, double newY) {
		x = newX;
		y = newY;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setX(double newX) {
		this.x = newX;
	}

	public void setY(double newY) {
		this.y = newY;
	}

	public void set(double newX, double newY) {
		x = newX;
		y = newY;

	}

	public java.lang.String toString() {
		return "(" + x + ", " + y + ")";
	}

}
