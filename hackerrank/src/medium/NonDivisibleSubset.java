/*
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
package medium;

import java.io.*;
import java.util.*;

public class NonDivisibleSubset {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.print("n and k : ");
		String[] firstMultipleInput = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		System.out.print("n space-seperated integers : ");
		String[] sTemp = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> s = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int sItem = Integer.parseInt(sTemp[i]);
			s.add(sItem);
		}

		int result = NonDivisibleSubset.nonDivisibleSubset(k, s);

		System.out.println(result);
	}

	public static int nonDivisibleSubset(int k, List<Integer> s) {
		ArrayList<Integer> copy = new ArrayList<Integer>(s);
		int firstSize = 0, lastSize = 0;

		do {
			firstSize = copy.size();
			for (int i = 0; i < copy.size() - 1; i++) {
				for (int j = i + 1; j < copy.size(); j++) {
					if ((copy.get(i) + copy.get(j)) % k == 0) {
						int removableNumber = removeWhat(copy, copy.get(i), copy.get(j), k);
						if (removableNumber == copy.get(j)) {
							j--;
						} else {
							j = i + 1;
						}
						copy.remove(copy.indexOf(removableNumber));
					}
				}
			}
			lastSize = copy.size();
		} while (firstSize != lastSize);
		return lastSize;
	}

	/*
	 * this method would detect num1 or num2 is being more duo with other numbers for dividing k
	 */
	private static int removeWhat(ArrayList<Integer> copy, Integer num1, Integer num2, int k) {
		int num1Counter = 0;
		int num2Counter = 0;
		for (Integer elementInList : copy) {
			if((elementInList + num1) % k == 0){
				num1Counter++;
			}
			if((elementInList + num2) % k == 0){
				num2Counter++;
			}
		}
		return num1Counter > num2Counter ? num1 : num2;
	}
}
