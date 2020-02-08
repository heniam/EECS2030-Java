package eecs2030.lab3;

/**
 * A class that represents two dimensional spatial vectors (a direction and a
 * magnitude). Every vector has a real-valued x-component and a y-component. The
 * class provides some basic mathematical operations such as vector addition and
 * subtraction, and scalar multiplication.
 * 
 * @author EECS2030 Fall 2016
 * 
 */

public final class Vector2 {
	public double x;
	public double y;

	public Vector2() {
		this.x = 0.0;
		this.y = 0.0;
	}

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public Vector2(Vector2 other) {
		this.x = other.x;
		this.y = other.y;

	}

	/**
	 * Returns the x component of the vector.
	 * 
	 * @return the x component of the vector.
	 */
	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Returns the y component of the vector.
	 * 
	 * @return the y component of the vector.
	 */
	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;

	}

	public void set(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public double mag() {
		double a = Math.sqrt((this.x * this.x) + (this.y * this.y));
		return a;

	}

	public Vector2 add(Vector2 other) {
		this.x = this.x + other.x;
		this.y = this.y + other.y;
		return this;

	}

	public Vector2 subtract(Vector2 other) {
		this.x = this.x - other.x;
		this.y = this.y - other.y;
		return this;

	}

	public Vector2 multiply(double s) {
		this.x = s * this.x;
		this.y = s * this.y;
		return this;

	}

	public static Vector2 add(Vector2 a, Vector2 b) {
		Vector2 c = new Vector2();
		c.x = a.x + b.x;
		c.y = a.y + b.y;
		return c;

	}

	public static Vector2 subtract(Vector2 a, Vector2 b) {
		Vector2 d = new Vector2();
		d.x = a.x - b.x;
		d.y = a.y - b.y;
		return d;

	}

	public static Vector2 multiply(double s, Vector2 a) {
		Vector2 e = new Vector2();
		e.x = a.x * s;
		e.y = a.y * s;
		return e;

	}

	public static Vector2 dirVector(double theta) {

		double h = Math.toRadians(theta);
		return new Vector2(Math.cos(h), Math.sin(h));

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Vector2 other = (Vector2) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	/**
	 * Returns a string representation of the vector. The string is the name of
	 * the vector, followed by the comma separated components of the vector
	 * inside parentheses.
	 * 
	 * @return a string representation of the vector
	 */

	@Override
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}

	public boolean similarTo(Vector2 other, double tol) {

		if (other.mag() - this.mag() < tol) {

			return true;
		}

		else {
			return false;
		}

	}

}