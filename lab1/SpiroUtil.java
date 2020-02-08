package eecs2030.lab1;

public class SpiroUtil {

	public static final double BIG_WHEEL_RADIUS = 1.0;

	public static double hypoX(double wheelRadius, double pencilRadius, double degrees) {
		if (wheelRadius < 0.0) {
			throw new IllegalArgumentException("wheel radius is negative");
		}
		if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
			throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
		}
		if (pencilRadius < 0.0) {
			throw new IllegalArgumentException("pencil radius is negative");
		}
		if (pencilRadius > wheelRadius) {
			throw new IllegalArgumentException("pencil radius is greater than wheel radius");
		}

		double h = Math.toRadians(degrees);
		double ro = ((SpiroUtil.BIG_WHEEL_RADIUS - wheelRadius) / wheelRadius);
		double x = (SpiroUtil.BIG_WHEEL_RADIUS - wheelRadius) * Math.cos(h) + pencilRadius * Math.cos((ro) * h);

		return x;
	}

	public static double hypoY(double wheelRadius, double pencilRadius, double degrees) {
		if (wheelRadius < 0.0) {
			throw new IllegalArgumentException("wheel radius is negative");
		}
		if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
			throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
		}
		if (pencilRadius < 0.0) {
			throw new IllegalArgumentException("pencil radius is negative");
		}
		if (pencilRadius > wheelRadius) {
			throw new IllegalArgumentException("pencil radius is greater than wheel radius");
		}

		double h = Math.toRadians(degrees);
		double ro = ((SpiroUtil.BIG_WHEEL_RADIUS - wheelRadius) / wheelRadius);
		double y = (SpiroUtil.BIG_WHEEL_RADIUS - wheelRadius) * Math.sin(h) - pencilRadius * Math.sin((ro) * h);

		return y;
	}

	public static Point2 hypo(double wheelRadius, double pencilRadius, double degrees) {
		if (wheelRadius < 0.0) {
			throw new IllegalArgumentException("wheel radius is negative");
		}
		if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
			throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
		}
		if (pencilRadius < 0.0) {
			throw new IllegalArgumentException("pencil radius is negative");
		}
		if (pencilRadius > wheelRadius) {
			throw new IllegalArgumentException("pencil radius is greater than wheel radius");
		}

		double x = hypoX(wheelRadius, pencilRadius, degrees);
		double y = hypoY(wheelRadius, pencilRadius, degrees);

		return new Point2(x, y);
	}
}
