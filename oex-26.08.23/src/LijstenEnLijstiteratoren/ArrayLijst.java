package LijstenEnLijstiteratoren;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayLijst extends Lijst {
	
	/**
	 * @invar | elementen != null
	 * 
	 * @representationObjects
	 */
	int[] elementen = new int[0];
	
	@Override
	public int[] getElementen() { return elementen.clone(); }
	
	/**
	 * @post | getElementen().length == 0
	 */
	public ArrayLijst() {}
	
	public void add(int element) {
		elementen = Arrays.copyOf(elementen, elementen.length + 1);
		elementen[elementen.length - 1] = element;
	}
	
	/**
	 * @pre | getElementen().length > 0
	 * @mutates_proporties | getElementen()
	 * @post | getElementen().length == old(getElementen()).length - 1
	 * @post | Arrays.equals(getElementen(), 0, getElementen().length, old(getElementen()), 0, getElementen().length)
	 */
	@Override
	public void removeLast() {
		elementen = Arrays.copyOf(elementen, elementen.length - 1);
	}

	@Override
	public int getSize() { return elementen.length; }

	@Override
	public boolean heeftZelfdeGedragAls(Lijst andere) {
		return andere instanceof ArrayLijst l && Arrays.equals(elementen, l.elementen);
	}

}
