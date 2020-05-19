package Streams.topic09;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ParallelStreams {

	public static void main(String[] args) {

		int n = 100000; // stream length
		int m = 1000000; // number of increments

		int[] array1 = new int[n];
		int[] array2 = new int[n];
		
		long t1 = System.currentTimeMillis();

		IntStream.range(0, n).forEach(i -> {
			for (int j = 0; j < m; j++) {
				array1[i]++;
			}
		});
		
		long t2 = System.currentTimeMillis();

		IntStream.range(0, n).parallel().forEach(i -> {
			for (int j = 0; j < m; j++) {
				array2[i]++;
			}
		});

		long t3 = System.currentTimeMillis();

		System.out.println("Single core: " + (t2 - t1));
		System.out.println("Multiple cores: " + (t3 - t2));
		System.out.println(Arrays.equals(array1, array2));
	}

}
