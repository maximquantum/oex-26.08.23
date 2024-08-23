package LijstenEnLijstiteratoren;

import java.util.Arrays;

public class BerekendeLijst extends Lijst {
	
	int start;
	int size;
	
	/**
	 * @post | getElementen().length == 0
	 */
	public BerekendeLijst() {}
	 
	@Override
	public int[] getElementen() {
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = start + i;
		}
		return result;
	}

	/**
	 * @throws UnsupportedOperationException | getElementen().length != 0 && element != getElementen()[0] + getElementen().length
	 * @mutates_proporties | getElementen()
	 * @post | getElementen().length == old(getElementen()).length + 1
	 * @post | Arrays.equals(getElementen(), 0, old(getElementen()).length, old(getElementen()), 0, old(getElementen()).length)
	 * @post | getElementen()[getElementen().length - 1] == element
	 */
	@Override
	public void add(int element) {
		if (size == 0)
			start = element;
		else if (element != start + size)
			throw new UnsupportedOperationException();
		size++;
	}
	
	/**
	 * @pre | getElementen().length > 0
	 * @mutates_proporties | getElementen()
	 * @post | getElementen().length == old(getElementen()).length - 1
	 * @post | Arrays.equals(getElementen(), 0, getElementen().length, old(getElementen()), 0, getElementen().length)
	 */
	@Override
	public void removeLast() {
		size--;
	}
	
	@Override
	public int getSize() { return size; }

	@Override
	public boolean heeftZelfdeGedragAls(Lijst andere) {
		return andere instanceof BerekendeLijst l && size == l.size && (size == 0 || start == l.start);
	}

}
