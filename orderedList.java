package project_2;

import java.util.*;
/**
 * @author tyler
 *Project 2
 *11/18/21
 *This is the ordered list class. This is where the array is to be determined if it is sorted and checks to see if the list is 
 *needed to have an exception thrown.
 */
public class orderedList {
	/**
	 * Checks to see if the list is sorted, extends comparable interface.
	 */
	public static <L extends Comparable<? super L>> boolean checkSorted(List<L> list) {
		// returns true for being sorted, unless found to be false.
		boolean isSorted = true;
		for (int i = list.size() - 1; i > 0; i--) {
			L curr = list.get(i);
			if (!checkSorted(list, curr)) {
				isSorted = false;
			}
		}
		return isSorted;
	}

	// Is supplied an additional parameter that is an object of a class that
	// implements the Comparator interface.
	private static <L extends Comparable<? super L>> boolean checkSorted(List<L> list, L curr) {
		L currInd = list.get(list.indexOf(curr));
		L nextInd = list.get(list.indexOf(curr) - 1);
		if (nextInd != null) {
			return currInd.compareTo(nextInd) >= 0;
		}
		return true;
	}
}
