/*
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
package algorithms;

import java.util.Scanner;

public class BirthdayCakeCandles {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("The number of candles on the cake : ");
		int arCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[arCount];

		System.out.print("space-separated integers , where each integer describes the height of candle : ");
		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < arCount; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		System.out.println("Number of candles she can blow out : " + birthdayCakeCandles(ar));

		scanner.close();

	}

	static int birthdayCakeCandles(int[] ar) {
		int max = 0;
		int totalCandleThatBlowsOut = 0;
		for (int i : ar) {
			if (i > max) {
				max = i;
				totalCandleThatBlowsOut = 1;
			} else if (i == max) {
				totalCandleThatBlowsOut++;
			}
		}

		return totalCandleThatBlowsOut;
	}

}
