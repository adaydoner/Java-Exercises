package algorithms;

import java.util.Scanner;

public class CountingSort1 {

	// Complete the countingSort function below.
	static int[] countingSort(int[] arr) {
		int max = 0;
		for(int i = 0 ; i<arr.length; i++){
			if(arr[i] > max) max = arr[i];
		}
		
		int[] newArrayForSorting = new int[max+1];
		
		for (int i : arr) {
			newArrayForSorting[i] += 1;
		}
		
		int[] sortedArray = new int[arr.length];
		for (int i = 0,sortedArrayCounter=0; i < newArrayForSorting.length; i++) {
			for (int j = newArrayForSorting[i]; j > 0; j--) {
				sortedArray[sortedArrayCounter] = i;
				sortedArrayCounter++;
			}
		}
		
		return sortedArray;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("the number of items in array : ");
		int theNumberOfItems = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[theNumberOfItems];

		System.out.print("Array elements : ");
		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < theNumberOfItems; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int[] result = countingSort(arr);
		
		for (int i : result) {
			System.out.print(i + " ");
		}

		scanner.close();
	}

}
