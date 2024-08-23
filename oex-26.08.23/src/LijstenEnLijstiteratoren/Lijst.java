package LijstenEnLijstiteratoren;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import logicalcollections.LogicalSet;

public abstract class Lijst {
	
	/**
	 * @invar | iteratoren != null
	 * @invar | iteratoren.stream().allMatch(i -> i != null)
	 * 
	 * @representationObjects
	 * @peerObjects
	 */
	Set<LijstIterator> iteratoren = new HashSet<>();
	
	/**
	 * @post | result != null
	 * @post | result.stream().allMatch(i -> i != null)
	 * @creates | result
	 * @peerObjects
	 */
	public Set<LijstIterator> getIteratoren() {
		return Set.copyOf(iteratoren);
	}
	
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
	public abstract void add(int element);
	
	/**
	 * @pre | getElementen().length > 0
	 * @mutates_proporties | getElementen()
	 * @post | getElementen().length == old(getElementen()).length - 1
	 * @post | Arrays.equals(getElementen(), 0, getElementen().length, old(getElementen()), 0, getElementen().length)
	 */
	public abstract void removeLast();
	
	/**
	 * @mutates_proporties | getIteratoren()
	 * @post | getIteratoren().equals(LogicalSet.plus(old(getIteratoren()), result))
	 * @return
	 */
	public LijstIterator maakLijstiterator() {
		return new LijstIterator(this);
	}
	
	public abstract int getSize();
	
	public abstract boolean heeftZelfdeGedragAls(Lijst andere);

}
