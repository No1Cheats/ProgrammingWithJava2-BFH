package Generics;

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

	public T getSecond() {
		return this.second;
	}

	@Override
	public String toString() {
		return "[" + first + "," + second + "]";
	}

	public static void main(String[] args) {

		Pair<String, Integer> pair1 = new Pair<>("HelloWorld", 100);
		String s1 = pair1.getFirst();
		int i1 = pair1.getSecond();

		Pair<Integer, String> pair2 = new Pair<>(100, "HelloWorld");
		int i2 = pair2.getFirst();
		String s2 = pair2.getSecond();
	}
}
