package codingcompetitions;

import java.util.Scanner;

public class CountDown {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Test cases : ");
		int testCase = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int scenario = 1;
		while (testCase > 0) {
			int N = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int K = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] integers = new int[N];
			for (int i = 0; i < N; i++) {
				integers[i] = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			}

			int countDown = findKCountDown(integers, K);
			System.out.println("Case #" + scenario + ": " + countDown);
			scenario++;
			testCase--;
		}

	}

	private static int findKCountDown(int[] integers, int k) {
		int cDown = 0;
		for (int i = 0; i < integers.length; i++) {
			if (integers[i] == k) {
				if (isItGoingUntillOne(integers, i, k)) {
					cDown++;
				}
			}
		}
		return cDown;
	}

	private static boolean isItGoingUntillOne(int[] integers, int i, int k) {
		if (integers.length > i + 1) {
			if (integers[i + 1] == k - 1 && k - 1 == 1) {
				return true;
			} else if (integers[i + 1] == k - 1) {
				if (isItGoingUntillOne(integers, i + 1, k - 1)) {
					return true;
				}
			}
		}
		return false;
	}

}
