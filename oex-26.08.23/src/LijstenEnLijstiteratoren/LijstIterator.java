package LijstenEnLijstiteratoren;

public class LijstIterator {
	
	/**
	 * @invar | index >= 0
	 * @invar | lijst == null || lijst.iteratoren.contains(this) && index <= lijst.getSize()
	 * @peerObjects
	 */
	Lijst lijst;
	int index;

	public LijstIterator(Lijst lijst) {
		this.lijst = lijst;
		lijst.iteratoren.add(this);
	}

}
