package problemsolving;

import java.util.Scanner;

public class PlusMinus {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("number of elements : ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		System.out.print("elements : ");
		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}

	private static void plusMinus(int[] arr) {
		double numOfPositives = 0, numOfNegatives = 0, numOfZeros = 0;
		
		for (int i : arr) {
			if(i < 0){
				numOfNegatives++;
			} else if (i > 0){
				numOfPositives++;
			} else {
				numOfZeros++;
			}
		}
		
		System.out.printf("Occurrence of positives : %.7f \nOccurrence of negatives : %.7f \nOccurrence of zeros : %.7f",numOfPositives / arr.length, numOfNegatives / arr.length, numOfZeros / arr.length);
		//System.out.println("Occurrence of positives : " + numOfPositives/arr.length + "\n" + "Occurrence of negatives : " + numOfNegatives/arr.length + "\n" +"Occurrence of zeros : " +  numOfZeros/arr.length);
		
	}
}
