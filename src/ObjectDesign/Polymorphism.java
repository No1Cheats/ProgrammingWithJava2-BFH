package ObjectDesign;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Polymorphism {

	public static void main(String[] args) {

		Collection<String> collection;
		
		collection = new ArrayList<>();
		collection.add("Hello");

		collection = new HashSet<>();
		collection.add("World");

	}

}
