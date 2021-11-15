package project_2;

import java.util.*;

public class Poly<index> implements Iterable<Poly>, Comparable<Poly> {
	Comparator<Poly> compare;
	private index head;

	public Poly(String fromFile) {
		Scanner scan = new Scanner(fromFile);
		try {
			while (scan.hasNext()) {
				add(scan.nextDouble(), scan.nextInt());
			}
		} catch (Exception except) {
			System.out.println(except.getLocalizedMessage());
			throw new invalidPoly("Incorrect Syntax");
		}

	}

	public void add(double cons, int expon) {
		if (expon < 0) {
			throw new invalidPoly("No negatives");
		}
		index current = head;
		if(current == null)
		{
			head = new index(cons, expon);
			head.next = null;
		}else{
			while(current.next != null)
			{
				current.next = new index(cons, expon);
			}
		}
	}

	@Override
	public int compareTo(Poly o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterator<Poly> iterator() {
		// TODO Auto-generated method stub
		return null;

	}

}
