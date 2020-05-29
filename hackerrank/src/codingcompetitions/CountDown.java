/*
 * https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff43/00000000003380d2
 */
package codingcompetitions;

import java.util.Scanner;

public class CountDown {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Test cases : "); // Sample 1
		int testCase = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int scenario = 1;
		while (testCase > 0) {
			System.out.print("N : "); // Sample 12
			int N = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			System.out.print("K : "); // Sample 3
			int K = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			System.out.println("Integers : "); // Sample 1 2 3 7 9 3 2 1 8 3 2 1
			int[] integers = new int[N];
			for (int i = 0; i < N; i++) {
				integers[i] = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			}

			// this is the method that run our algorithm
			int countDown = findKCountDown(integers, K);
			System.out.println("Case #" + scenario + ": " + countDown);
			scenario++;
			testCase--;
		}

	}

	private static int findKCountDown(int[] integers, int k) {
		int cDown = 0;
		for (int i = 0; i < integers.length; i++) {
			// we'r searching array for equal number with our K value 
			if (integers[i] == k) {
				if(k == 1) { // if we'r looking for 1-CountDown we can check if k == 1 and increase countdown directly
					cDown++;
				} else if (isItGoingUntillOne(integers, i, k)) { //if we find any we call isItGoingUntillOne method to check if this element has k-1, k-2 k-3 values right after its index untill 1.
					cDown++;
				}
			}
		}
		return cDown;
	}

	private static boolean isItGoingUntillOne(int[] integers, int i, int k) {
 
		if (integers.length > i + 1) { // checking this for avoiding out of index error  
			if (integers[i + 1] == k - 1 && k - 1 == 1) { // FOUND K-Countdown . next element is 1 and elements that before this is also respect our rule
				return true;
			} else if (integers[i + 1] == k - 1) { 		// to make this method recursive , we only check if(i+1. index is equal to k -1) if its true we call this method again
				if (isItGoingUntillOne(integers, i + 1, k - 1)) {
					return true;
				}
			}
		}
		return false;
	}

}
