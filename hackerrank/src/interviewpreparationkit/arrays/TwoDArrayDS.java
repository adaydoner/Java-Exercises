/*
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 
 * We define an hourglass in A to be a subset of values with indices falling in this pattern in arr's graphical representation:
 * a b c
 *   d
 * e f g
 * 
 * There are 16 hourglasses in arr and an hourglass sum is the sum of an hourglass' values. 
 * Calculate the hourglass sum for every hourglass in arr then print the maximum hourglass sum.
 */

/*
 * 00 01 02 11 20 21 22
 * 01 02 03 12 21 22 23
 * 02 03 04 13 22 23 24
 * 03 04 05 14 23 24 25
 * 
 * 10 11 12 21 30 31 32
 * 11 12 13 22 31 32 33
 * 12 13 14 23 32 33 34
 * 13 14 15 24 33 34 35 
 */
package interviewpreparationkit.arrays;

import java.util.Scanner;

public class TwoDArrayDS {

	static int hourglassSum(int[][] arr) {
		int maxHourGlassSum = Integer.MIN_VALUE;
		for (int row = 0; row < arr.length - 2; row++) {
			for (int column = 0; column < arr.length - 2; column++) {
				int total = 0;
				total = arr[row][column] + arr[row][column + 1] + arr[row][column + 2] + arr[row + 1][column + 1] +
						arr[row + 2][column] + arr[row + 2][column + 1] + arr[row + 2][column + 2];
				if(total > maxHourGlassSum) maxHourGlassSum = total;
			}
		}
		
		return maxHourGlassSum;


    }

    private static final Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args) {
		
		System.out.println("Print array space seperated");
		int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        int result = hourglassSum(arr);
        System.out.print("result : " + result);

	}

}
