package org.jboss.reddeer.gef.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Class for chaining comparators.
 * 
 * @author Andrej Podhradsky (andrej.podhradsky@gmail.com)
 *
 */
public class ChainedComparator<T> implements Comparator<T> {

	private List<Comparator<T>> comparators;

	/**
	 * Instantiates a new chained comparator.
	 *
	 * @param comparators the comparators
	 */
	public ChainedComparator(Comparator<T>... comparators) {
		this.comparators = Arrays.asList(comparators);
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(T c1, T c2) {
		for (Comparator<T> comparator : comparators) {
			int result = comparator.compare(c1, c2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}
}
