package Streams.topic09;

import java.math.BigInteger;
import java.util.stream.Stream;

public class BigIntegerProduct {

	public static void main(String[] args) {
		
		BigInteger b1 = BigInteger.valueOf(7);
		BigInteger b2 = BigInteger.valueOf(10);
		BigInteger b3 = BigInteger.valueOf(5);
		BigInteger b4 = BigInteger.valueOf(2);

		Stream.of(b1, b2, b3, b4).reduce((x, y) -> x.multiply(y)).ifPresent(System.out::println);
	}

}
