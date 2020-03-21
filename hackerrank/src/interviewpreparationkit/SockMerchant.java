/*
 * John works at a clothing store. He has a large pile of socks that he must pair by color for sale. 
 * Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
 * 
 * 
 */

package interviewpreparationkit;

import java.util.Scanner;

public class SockMerchant {

	static int sockMerchant(int n, int[] ar) {
		int pairs = 0;
		
		//sort array
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if(ar[i] < ar[j]) continue;
				else {
					//replace
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < ar.length - 1;) {
			if(ar[i] == ar[i+1]){
				pairs++;
				i+=2;
			} else {
				i++;
			}
		}
		
		return pairs;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("The number of socks : ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int[] ar = new int[n];
		
		
		System.out.print("n space-separated integers describing the colors : ");
		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);
		System.out.println("Number of pair socks: " + result);

		scanner.close();
	}
}
