/*
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */
package medium;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Integer : ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		extraLongFactorials(n);

		scanner.close();

	}

	static void extraLongFactorials(int n) {
		System.out.println(fact(BigInteger.valueOf(n)));
	}

	static BigInteger fact(BigInteger number) {
		if (number.compareTo(BigInteger.valueOf(1)) != 0) {
			return number.multiply(fact(number.subtract(BigInteger.ONE))) ;
		}
		return BigInteger.ONE;
	}
}
