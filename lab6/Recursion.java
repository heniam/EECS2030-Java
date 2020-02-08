package eecs2030.lab6;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

/**
 * A utility class containing recursive methods.
 * 
 * @author EECS2030 Fall 2016
 *
 */
public class Recursion {

	// DON'T ADD ANY STATIC FIELDS; YOU DON'T STATIC FIELDS AND YOUR METHODS
	// WON'T WORK CORRECTLY IF YOU USE STATIC FIELDS

	private Recursion() {
		// empty by design
	}

	/**
	 * Return the sum of the integers 1 through n where n is a strictly positive
	 * integer. Note that the sum might overflow if n is too large; this method
	 * does not check if the sum overflows (i.e., it's the client's problem).
	 * 
	 * @pre n is greater than 0
	 * 
	 * @param n
	 *            a strictly positive number
	 * @return the sum 1 + 2 + ... + n
	 */
	public static int sum(int n) {
		if (n > 0) {
			return n + sum(n - 1);
		} else {
			return 0;

		}

	}

	/**
	 * Returns a new string equal to the reversal of string s. The reversal of
	 * the empty string is equal to the empty string.
	 * 
	 * @pre s is not null
	 * 
	 * @param s
	 *            -- a string
	 * @return a string equal to the reversal of s
	 */
	public static String reverse(String s) {

		if ((s.length() <= 1)) {
			return s;
		}
		// String allButLastChar = s.substring(0, s.length() - 1);

		return reverse(s.substring(1)) + s.charAt(0);
	}

	/**
	 * Returns the minimum element in the list t. This method does not modify
	 * the list <code>t</code>.
	 * 
	 * @pre t.size() is greater than 0
	 * 
	 * @param t
	 *            a non-empty list
	 * 
	 * @return the minimum element in t
	 */
	public static int min(List<Integer> t) {

		int minimum;
		if (t.size() == 1) {

			return t.get(0);
		} else {
			// index -- first index

			int index = t.get(0);
			List<Integer> u = t.subList(1, t.size());
			minimum = Math.min(index, u.get(0));
			
		}
		return minimum;

	}

	/**
	 * Downsample a picture <code>n</code> times by a factor of 2 using
	 * recursion. See the lab problem for a description of downsampling.
	 * 
	 * @pre the width and height of the picture are both multiples of 2 to the
	 *      power n
	 * 
	 * @pre1 n is greater than or equal to zero
	 * 
	 * @param p
	 *            the picture to downsample
	 * @param n
	 *            the number of times to downsample the picture by a factor of 2
	 * @return the downsampled picture
	 */
	public static Picture downsample(Picture p, int n) {
		if (n == 0) {
			return p;
		}
		int width = p.width() / 2;
		int height = p.height() / 2;

		Picture a = new Picture(width, height);
		for (int ax = 0; ax < width; ax++) {
			for (int ay = 0; ay < height; ay++) {
				int px = 2 * ax;
				int py = 2 * ay;

				Color c00 = p.get(px, py);
				Color c01 = p.get(px + 1, py);
				Color c10 = p.get(px, py + 1);
				Color c11 = p.get(px + 1, py + 1);

				int r = c00.getRed() + c01.getRed() + c10.getRed() + c11.getRed();
				int g = c00.getGreen() + c01.getGreen() + c10.getGreen() + c11.getGreen();
				int b = c00.getBlue() + c01.getBlue() + c10.getBlue() + c11.getBlue();
				a.set(ax, ay, new Color(r / 4, g / 4, b / 4));
			}
		}
		return downsample(a, n - 1);
	}

	/**
	 * Binary search for the string <code>s</code> in a list <code>t</code>. If
	 * <code>s</code> is in the list, then this method returns the index of the
	 * location of <code>s</code> in <code>t</code>; otherwise, this method
	 * returns the index where <code>s</code> would be located if it were to be
	 * inserted into the list <code>t</code>.
	 * 
	 * <p>
	 * This method does not modify the list <code>t</code>.
	 * 
	 * @pre t.size() is zero or more
	 * @pre1 t is in sorted order
	 * @pre2 t has no duplicate elements
	 * 
	 * @param s
	 *            a string
	 * @param t
	 *            a list
	 * @return the index of s if s is in the list; otherwise, returns the index
	 *         where s would be located if it were to be inserted into the list
	 */
	public static int bsearch(String s, List<String> t) {

		int pos = Collections.binarySearch(t, s);

		if (pos < 0) {
			t.add(-pos - 1, s);
		}

		else if (t.contains(s)) {
			return t.indexOf(s);
		}

		return t.indexOf(-pos - 1);

	}

	public static void main(String[] args) {
		// RUN THIS TO TEST downsample

		Picture p = new Picture("ice.jpg");
		p.show();
		downsample(p, 1).show();
		downsample(p, 2).show();
		downsample(p, 3).show();

		// System.out.println( Recursion.sum(6));
		// System.out.println( Recursion.reverse("ORANGE"));

	}
}