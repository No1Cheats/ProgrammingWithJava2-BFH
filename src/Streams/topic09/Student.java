package Streams.topic09;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
	
	private String firstName;
	private String lastName;
	private int semester;
	private double averageGrade;
	
	private static Random random = new Random();
	private static String[] firstNames = {"Tom", "Ben", "Joe", "Andy", "Pete", "Sam"};
	private static String[] lastNames = {"Smith", "Miller", "Jordan", "Wright", "Bush"};

	public Student() {
		this.firstName = firstNames[random.nextInt(firstNames.length)];
		this.lastName = lastNames[random.nextInt(lastNames.length)];
		this.semester = random.nextInt(10) + 1;
		this.averageGrade = 5*random.nextDouble() + 1;
	}
		
	public static void main(String[] args) {

		// Compute a string containing a sorted list of 10 first/last names of students in 6th semester in upper-case
		String names = Stream.generate(Student::new)
			.filter(s -> s.semester == 6)
			.limit(10)
			.peek(s -> System.out.println(s.semester)) // for testing
			.sorted(Comparator.comparing(s -> s.lastName))
			.map(s -> s.firstName + " " + s.lastName)
			.map(String::toUpperCase)
			.collect(Collectors.joining(", "));
		System.out.println(names);
		
		// From the first 100 students, print the average of their rounded average grades >= 4.0
		Stream.generate(Student::new)
			.limit(100)
			.filter(s -> s.averageGrade >= 4.0)
			.mapToDouble(s -> s.averageGrade)
			.map(d -> Math.round(d))
			.average()
			.ifPresentOrElse(System.out::println, () -> System.out.println("No average"));
	}

}

