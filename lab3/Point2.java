package eecs2030.lab3;

public class Point2 {

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
	
	public Point2(Point2 other){
		this.x = other.x;
		this.y = other.y;
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

	public Point2 add(Vector2 v) {
		this.x = this.x + v.getX();
		this.y = this.y + v.getY();
		return this;

	}

	public static Vector2 subtract(Point2 a, Point2 b) {
		Vector2 d = new Vector2();
		d.x = a.x - b.x;
		d.y = a.y - b.y;
		return d ;
	}

	public java.lang.String toString() {
		return "(" + x + ", " + y + ")";
	}

}
