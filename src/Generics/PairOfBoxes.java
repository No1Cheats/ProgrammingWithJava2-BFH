package Generics;

public class PairOfBoxes<S, T> extends Pair<Box<S>, Box<T>> {

	public PairOfBoxes(Box<S> first, Box<T> second) {
		super(first, second);
	}

	public PairOfBoxes(S firstContent, T secondContent) {
		super(new Box<>(firstContent), new Box<>(secondContent));
	}

	public S getFirstContent() {
		return this.first.getContent();
	}

	public T getSecondContent() {
		return this.second.getContent();
	}
	
	public static void main(String[] args) {

		PairOfBoxes<String, Integer> pairOfBoxes = new PairOfBoxes<>("HelloWorld", 200);

		Box<String> stringBox = pairOfBoxes.getFirst();
		Box<Integer> integerBox = pairOfBoxes.getSecond();

		String s = pairOfBoxes.getFirstContent();
		Integer i = pairOfBoxes.getSecondContent();
	}
}
