package Generics;

import java.util.ArrayList;
import java.util.List;

public class Couple<T> extends Pair<T, T> {

	public Couple(T first, T second) {
		super(first, second);
	}

	public void swap() {
		T tmp = this.first;
		this.first = this.second;
		this.second = tmp;
	}

	public List<T> toList() {
		List<T> list = new ArrayList<>();
		list.add(this.first);
		list.add(this.second);
		return list;
	}

	public static void main(String[] args) {

		Couple<Integer> couple = new Couple<>(100, 200);
		int i1 = couple.getFirst();
		int i2 = couple.getSecond();
		List<Integer> list = couple.toList();
	}
}
