package eecs2030.lab3;

import java.awt.Color;

import princeton.introcs.StdDraw;

public class Turtle {
	private Color pencolor;
	private Point2 position;
	// private double x;
	// private double y;
	private double angle;

	/**
	 * Create a turtle at location (0.5, 0.5) with an angle of 0.0 degrees and a
	 * pen color of Color.BLACK.
	 */

	public Turtle() {
		this.position.setX(0.5);
		this.position.setY(0.5);
		this.angle = 0.0;
		pencolor = Color.BLACK;
	}

	/**
	 * Create a turtle from another turtle. The created turtle is initialized
	 * having the same position, angle, and pen color as the other turtle, but
	 * moves independently of the other turtle.
	 * 
	 * @param other
	 */

	public Turtle(Turtle other) {
		this.position = new Point2(other.position.getX(), other.position.getY());
		this.angle = other.angle;
		pencolor = other.pencolor;

	}

	/**
	 * 
	 * @param position
	 */
	//
	public Turtle(Point2 position) {
		if (position.getX() >= 0.0 && position.getX() <= 1.0 && position.getY() >= 0.0 && position.getY() <= 1.0) {

			this.position = new Point2(position.getX(), position.getY());
			pencolor = Color.BLACK;
		} else {
			throw new IllegalArgumentException("Invalid starting position");
		}

	}

	/**
	 * 
	 * @param position
	 * @param angle
	 */

	public Turtle(Point2 position, double angle) throws IllegalArgumentException {

		if (position.getX() >= 0.0 && position.getX() <= 1.0 && position.getY() >= 0.0 && position.getY() <= 1.0) {
			this.position.setX(position.getX());
			this.position.setY(position.getY());
			this.angle = angle;
		} else {
			throw new IllegalArgumentException("Invalid starting position");
		}
	}

	/**
	 * 
	 * @param position
	 * @param angle
	 * @param c
	 */
	public Turtle(Point2 position, double angle, Color c) throws IllegalArgumentException {
		if (position.getX() >= 0.0 && position.getX() <= 1.0 && position.getY() >= 0.0 && position.getY() <= 1.0) {

			this.angle = angle;
			this.position.setX(position.getX());
			this.position.setY(position.getY());

			this.setPenColor(c);
		} else {
			throw new IllegalArgumentException("Invalid starting position");
		}

	}

	/**
	 * Moves the turtle by a given distance in the direction the turtle is
	 * currently facing.
	 * 
	 * A line is drawn as the turtle moves to the new position using the current
	 * pen color.
	 * 
	 * The distance can be negative, in which case the turtle moves backwards in
	 * the direction opposite to the direction it is currently facing in.
	 * 
	 */

	/**
	 * 
	 * @param distance
	 */
	public void move(double distance) {
		Point2 oldSpot = new Point2(this.position);
		Vector2 direction = Vector2.dirVector(this.angle);
		direction.multiply(distance);
		this.position.add(direction);
		StdDraw.setPenColor(this.getPenColor());

		StdDraw.line(oldSpot.getX(), oldSpot.getY(), this.position.getX(), this.position.getY());
		// this.position=oldSpot;

	}

	public void turnLeft() {
		this.angle += 90;
		this.angle %= 360;
	}

	public void turnRight() {
		this.angle -= 90;
		if (this.angle < 0) {
			this.angle += 360;
		}
	}

	/**
	 * A positive delta turns the turtle to the left (counterclockwise) and the
	 * negative delta turns the turtle to the right (clockwise). The angle of
	 * the turtle is always corrected to lie within the range of -360 degrees
	 * and +360 degrees.
	 * 
	 * @param delta
	 */
	public void turn(double delta) {
		this.angle += delta;
		this.angle %= 360.0;

	}

	/**
	 * 
	 * 
	 * @param c
	 * @throws IllegalArgumentException
	 */
	public void setPenColor(Color c) throws IllegalArgumentException {
		if (c == null) {
			throw new IllegalArgumentException();
		} else {
			this.pencolor = c;
			StdDraw.setPenColor(pencolor);
		}

	}

	public Color getPenColor() {
		return this.pencolor;

	}

	public Point2 getPosition() {
		return this.position;

	}

	public double getAngle() {
		return angle;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(angle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pencolor == null) ? 0 : pencolor.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turtle other = (Turtle) obj;
		if (Double.doubleToLongBits(angle) != Double.doubleToLongBits(other.angle))
			return false;
		if (pencolor == null) {
			if (other.pencolor != null)
				return false;
		} else if (!pencolor.equals(other.pencolor))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	public String toString() {
		return this.getPosition() + ", " + this.getAngle() + " degrees, " + this.getPenColor();
	}

}