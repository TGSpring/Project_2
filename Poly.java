package project_2;

import java.util.*;
/**
 * @author tyler
 *Project 2
 *11/18/21
 *This is the Poly class that has a constructor for the array made in the main class, it then computes the sorting of the array created in here
 *based on strong or weak sorting and checks exceptions for valid input, it calls that check from the invalidPoly class.
 */
public class Poly implements Iterable<Poly.Spot>, Comparable<Poly> {
	/**
	 * Implementing Iterable and Comparable. It worked so I am guessing I did it
	 * right..
	 */
	private Comparator<Poly> compare;

	public Poly(Comparator<Poly> compare) {
		this.compare = compare;
	}

	// making two instances to be used to compare exponents.
	public Poly() {
		compare = (Poly o1, Poly o2) -> o1.Expon(o2);
	}

	// creating head of list from nested static class.
	private Spot head;

	// taking the array from the input file in the main class and reading it to be
	// used for comparisons.
	public Poly(String fromFile) {
		head = null;
		Scanner scan = new Scanner(fromFile);
		try {
			while (scan.hasNext()) {
				addSpot(scan.nextDouble(), scan.nextInt());
			}
		}
		// checking for errors with exceptions.
		catch (Exception except) {
			System.out.println(except.getLocalizedMessage());
			throw new invalidPoly("Incorrect Syntax.");
		}
		scan.close();
	}

	// adding terms together in order to create new poly terms for output.
	public void addSpot(double coe, int exp) {
		if (exp < 0 || coe < 0) {
			// checking for negative values, throws exception if found.
			throw new invalidPoly("No negative terms allowed.");
		}
		Spot curr = head;
		if (curr == null) {
			head = new Spot(coe, exp);
			head.next = null;
		} else {
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new Spot(coe, exp);
		}
	}

	/**
	 * Overrides method. Compares two different instances created from the nested
	 * class to order the list.
	 */
	@Override
	public int compareTo(Poly o) {
		Spot thisCurr = this.head;
		Spot diffCurr = o.head;

		while (thisCurr != null && diffCurr != null) {
			if (thisCurr.getExp() != diffCurr.getExp()) {
				return thisCurr.getExp() - diffCurr.getExp();
			} else if (thisCurr.getCoe() != diffCurr.getCoe()) {
				if (diffCurr.getCoe() > thisCurr.getCoe()) {
					return -1;
				} else if (diffCurr.getCoe() < thisCurr.getCoe()) {
					return +1;
				}
			}
			thisCurr = thisCurr.getNext();
			diffCurr = diffCurr.getNext();
		}
		if (thisCurr == null && diffCurr == null) {
			return 0;
		}
		if (thisCurr == null) {
			return -1;
		} else {
			return +1;
		}
	}

	/**
	 * Compares two instances for the exponents. If two polynomials have the same
	 * highest order exponent with the same coefficients the next highest exponent
	 * is examined.
	 */
	public int Expon(Poly o1) {
		Spot thisExp = this.head;
		Spot diffExp = o1.head;
		while (thisExp != null && diffExp != null) {
			if (thisExp.getExp() != diffExp.getExp()) {
				return thisExp.getExp() - diffExp.getExp();
			} else {
				thisExp = thisExp.getNext();
				diffExp = diffExp.getNext();
			}
		}
		if (thisExp == null && diffExp == null) {
			return 0;
		}
		if (diffExp == null) {
			return +1;
		} else {
			return -1;
		}
	}

	/**
	 * Produces an iterator the iterates across the terms of the polynomial from
	 * highest exponent to lowest and returns and an object that contains only the
	 * coefficient and exponent of the next term
	 */
	@Override
	public Iterator<Spot> iterator() {
		return new Iterator() {
			private Spot curr = getHead();

			@Override
			public boolean hasNext() {
				return curr != null && curr.getNext() != null;
			}

			public Spot next() {
				Spot data = curr;
				curr = curr.next;
				return data;
			}
		};

	}

	/**
	 * Converts a polynomial to a string. Terms with 0 coefficients should be
	 * omitted entirely
	 */
	@Override
	public String toString() {
		StringBuilder polyBuild = new StringBuilder();
		if (head.coe > 0) {
			polyBuild.append(head.toString());
		} else {
			polyBuild.append("-").append(head.toString());
		}
		for (Spot place = head.next; place != null; place = place.next) {
			if (place.coe < 0) {
				polyBuild.append("-").append(place.toString());
			} else {
				polyBuild.append("+").append(place.toString());
			}
		}
		return polyBuild.toString();
	}

	/**
	 * Creates the nodes of the linked list as instances of a static nested class
	 * inside the Polynomial class
	 */
	static class Spot {
		private double coe;
		private int exp;
		private Spot next;

		private Spot(double coe1, int exp1) {
			coe = coe1;
			exp = exp1;
			next = null;
		}

		private int getExp() {
			return this.exp;
		}

		private double getCoe() {
			return this.coe;
		}

		private Spot getNext() {
			return next;
		}

		public String toString() {
			String outString = String.format("%.1f", Math.abs(coe));
			if (exp == 0) {
				return outString;
			} else if (exp == 1) {
				return outString + "x";
			} else {
				return outString + "x^" + exp;
			}
		}
	}

	private Spot getHead() {
		return head;
	}

}
