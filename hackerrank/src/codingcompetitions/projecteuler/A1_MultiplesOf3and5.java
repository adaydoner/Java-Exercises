/*
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem
 *
 *
 * ---Question---
 * If we list all the natural numbers below 10 that are multiples of 3 or 5 , we get 3,5,6 and 9.
 * The sum of these multiples is is 23. Find the sum of all the multiples of 3 or 5 below N.
 * 
 * 
 * --Turkish--
 * 10 a kadar olan , 3 veya 5 'in katlari olan sayilara bakarsak  3, 5, 6 ve 9 u buluruz. Toplamlarıda 23 olur.
 * Bizden  girilen N sayisi icin benzer sekilde 3 veya 5 in kati olan sayılarin toplamini bulmamizi istiyor.
 * 
 *  
 * input : 
 * ilk girilen sayi test sayisi
 * daha sonra test sayisi kadar N girilicek
 * 
 * output
 * her test için toplamlari yazmamiz lazim
 * 
 */
package codingcompetitions.projecteuler;

import java.util.Scanner;

public class A1_MultiplesOf3and5 {
	
/*    private static int multiplesOf3and5(int topNumber) {
        int sum = 0;
        for (int i = 3; i < topNumber; i++) {
            if(i % 3 == 0){
                sum += i;
            } else if (i % 5 == 0){
                sum += i;
            }
        }
        return sum;
    }*/

	private static int sumOfMultiples3or5(double topNumber) {
		/*
		 * sum for numbers divided to 3 is (3 + 6 + 9 + N + ... + = ...
		 * sum for numbers divided to 5 is (5 + 10 + 15 + N + ... + = ...
		 * 
		 * 
		 * 
		 * sum of consecutive numbers
		 * ((Last Number - First Number) / Difference + 1) * ((Last Number + First Number) / 2 ) 
		 * 
		 */
		double sumOfNumbersDividedBy3 = 0;
		double sumOfNumbersDividedBy5 = 0;
		double sumOfNumbersDividedBy15 = 0;
		for (double i = topNumber - 1; i > 2; i--) {
			if(i % 3 == 0){
				sumOfNumbersDividedBy3 = (((i - 3) / 3) + 1) * ((i  + 3) / 2);
				break;
			}
		}
		for (double i = topNumber - 1; i > 4; i--) {
			if(i % 5 == 0){
				sumOfNumbersDividedBy5 = (((i - 5) / 5) + 1) * ((i  + 5) / 2);
				break;
			}
		}
		for (double i = topNumber - 1; i > 14; i--) {
			if(i % 15 == 0){
				sumOfNumbersDividedBy15 = (((i - 15) / 15) + 1) * ((i  + 15) / 2);
				break;
			}
		}
		
		
		return (int)(sumOfNumbersDividedBy3 + sumOfNumbersDividedBy5 - sumOfNumbersDividedBy15);
	}

	public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
        System.out.print("Test case : ");
        int t = in.nextInt();
        int[] arrayForN = new int[t];
        for(int i = 0; i < t; i++){
        	System.out.print("N for " + (i + 1) + ". case : ");
            arrayForN[i] = in.nextInt();
            System.out.println(sumOfMultiples3or5(arrayForN[i]));
        }
	}


}
