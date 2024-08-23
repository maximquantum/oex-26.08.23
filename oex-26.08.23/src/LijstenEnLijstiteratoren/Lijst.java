package LijstenEnLijstiteratoren;

import java.util.Arrays;

public abstract class Lijst {
	
	/**
	 * @post | result != null
	 * @creates | result
	 */
	public abstract int[] getElementen();
	
	/**
	 * @may_throw UnsupportedOperationException | true
	 * @mutates_proporties | getElementen()
	 * @post | getElementen().length == old(getElementen()).length + 1
	 * @post | Arrays.equals(getElementen(), 0, old(getElementen()).length, old(getElementen()), 0, old(getElementen()).length)
	 * @post | getElementen()[getElementen().length - 1] == element
	 */
	public abstract void add(int element); // done 4

}
