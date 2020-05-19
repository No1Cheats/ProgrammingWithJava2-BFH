package ObjectDesign;

public class Pair<S, T> {

	protected S first;
	protected T second;

	public Pair(S first, T second) {
		this.first = first;
		this.second = second;
	}

	public S getFirst() {
		return this.first;
	}

	// Are setters really needed? Without them, the class is immutable!
	public void setFirst(S first) {
		this.first = first;
	}
}
