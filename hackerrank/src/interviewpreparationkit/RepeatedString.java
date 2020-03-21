/*
 * Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.
 * Given an integer, n find and print the number of letter a's in the first n letters of Lilah's infinite string.
 * 
 * For example, if the string s='abcac' and n = 10 the substring we consider is abcacabcac the first 10 characters of her infinite string. 
 * There are 4 occurrences of a in the substring. 
 */
package interviewpreparationkit;

import java.util.Scanner;

public class RepeatedString {

	static long repeatedString(String s, long n) {
		long total = 0;
		long numberOfa = 0;
		long lastStringForCheck = n % s.length();

		/*
		 * this loop for the remaining part of dividing n / s.length();
		 */
		for (int i = 0; i < lastStringForCheck; i++) {
			if (s.charAt(i) == 'a')
				total++;
		}
		/*
		 * if n < s.length we dont need to check for all characters just untill n
		 * otherwise we should use loop below for the find number of a in a normal string
		 * and multiply it with dividing n / s.length() moreover adding to total
		 */
		 
		if (n > s.length()) {
			long dividing = n / s.length();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'a')
					numberOfa++;
			}
			total += (numberOfa*dividing);
		}

		return total;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Single string s :");
		String s = scanner.nextLine();

		System.out.print("integer n : ");
		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);
		System.out.println("result : " + result);

	}

}
