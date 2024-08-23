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

}
