package LijstenEnLijstiteratoren;

import logicalcollections.LogicalSet;

public class LijstIterator {
	
	/**
	 * @invar | index >= 0
	 * @invar | lijst == null || lijst.iteratoren.contains(this) && index <= lijst.getSize()
	 * @peerObjects
	 */
	Lijst lijst;
	int index;
	
	/**
	 * @peerObject
	 */
	public Lijst getLijst() { return lijst; }
	
	/**
	 * @throws IllegalStateException | getLijst() == null
	 */
	public int getIndex() {
		if (lijst == null)
			throw new IllegalStateException();
		return index;
	}

	public LijstIterator(Lijst lijst) {
		this.lijst = lijst;
		lijst.iteratoren.add(this);
	}
	
	/**
	 * @throws IllegalStateException | getLijst() == null
	 * @mutates_proporties | getLijst, getLijst().getIteratoren()
	 * @post | getLijst() != null
	 * @post | old(getLijst()).getIteratoren().equals(LogicalSet.minus(old(getLijst().getIteratoren()), this))
	 */
	public void deactiveer() {
		if (lijst == null)
			throw new IllegalStateException();
		lijst.iteratoren.remove(this);
		lijst = null;
	}

}
