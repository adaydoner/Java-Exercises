/*
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem
 *
 *
 * ---Question---
 * If we list all the natural numbers below 10 that are multiples of 3 or 5 , we get 3,5,6 and 9.
 * The sum of these multiples is is 23. Find the sum of all the multiples of 3 or 5 below N.
 * 
 * First line contains T that denotes the number of test cases. This is followed by T lines, each containing an integer, N.
 * 
 * 
 * --Turkish--
 * 10 a kadar olan , 3 veya 5 'in katlari olan sayilara bakarsak  3, 5, 6 ve 9 u buluruz. Toplamlarıda 23 olur.
 * Bizden  girilen N sayisi icin benzer sekilde 3 veya 5 in kati olan sayılarin toplamini bulmamizi istiyor.
 * 
 * 
 * ilk girilen sayi test sayisi
 * daha sonra test sayisi kadar N girilicek
 * her test için toplamlari yazmamiz lazim.
 * 
 */
package codingcompetitions.projecteuler;

import java.util.Scanner;

public class A1_MultiplesOf3and5 {
	
	// Dont do this :)
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

	/*
	 * 3 ve 5 'in katlarinin toplamini bulmak icin, matematikteki ardisik sayilarin toplami formulunu kullanacagiz.
	 * [               Terim Sayisi                ] * [     Aritmetik Ortalama    ]
	 * ((Son Terim - Ilk Terim) / Artis miktari + 1) * ( Son terim + Ilk Terim ) / 2
	 * 
	 * 15 ve katlari olan sayilar , hem 3 icin yaptigimiz hesaplamada, hem de 5 icin yaptigimiz hesaplamada toplama dahil olacagi icin 
	 * bu sayilarin toplam degerini bulup hesaplamamizdan cikaracagiz ki ayni sayilari iki kere toplamis olmayalim.
	 * 
	 */
	public static long sumOfMultiples3or5(long N) {
		
		// 3,5 ve 15 in katlarinin toplamlarini tuttugumuz degiskenler
        long sumOfMultiples3 = 0;
        long sumOfMultiples5 = 0;
        long sumOfMultiples15 = 0;
        
        /*
         * N olarak 10 girildiyse , 10 hesaplamaya dahil edilmesin isteniyor soruda , bu yuzden (N - 1)'den baslayarak , 1' e dogru giderken
         * 3, 5 ve 15 i tam bolebilen en buyuk sayilari bulacagiz.
         * 
         * Ilk terimlerimiz ve artis miktarlarimiz 3, 5 ve 15 oluyor , en buyuk sayiyi bulduktan sonra toplam formulunu hesaplayacagiz.  
         */
        
        for (long i = N - 1; i >= 1; i--) {
            if(i % 3 == 0){
                sumOfMultiples3 = sumOfConsecutiveNumbers(3, i, 3);
                break;
            }
        }
        for (long i = N - 1; i >= 1; i--) {
            if(i % 5 == 0){
                sumOfMultiples5 = sumOfConsecutiveNumbers(5, i, 5);
                break;
            }
        }
        for (long i = N - 1; i >= 1; i--) {
            if(i % 15 == 0){
                sumOfMultiples15 = sumOfConsecutiveNumbers(15, i, 15);
                break;
            }
        }
        return (sumOfMultiples3 + sumOfMultiples5 - sumOfMultiples15);
    }
	
	/**
	 * 
	 * @param firstNumber : first number of consecutive numbers
	 * @param lastNumber : last number of consecutive numbers
	 * @param difference : difference between each number
	 * @return firstNumber + (firstNumber + difference) + ( firstNumber + (2*difference)) + (firstNumber + (3*difference))... + lastNumber
	 */
	public static long sumOfConsecutiveNumbers(long firstNumber, long lastNumber , int difference){
		return ((lastNumber - firstNumber) / difference + 1) * (lastNumber  + firstNumber) / 2;
	}
	
	/*
	 * ilk terimlerimiz sabit oldugu icin terim sayisini buldugumuz formulu son terim / artis miktari olarak, sadelestirebiliriz ve asagidaki gibi hesaplayabiliriz.
	 * 
	 * sumOfMultiples3 = sumOfConsecutiveNumbers(3, i, 3); yerine sumOfMultiples3 = (i / 3) * (i  + 3) / 2;
	 * sumOfMultiples5 = sumOfConsecutiveNumbers(5, i, 5); yerine sumOfMultiples5 = (i / 5) * (i  + 5) / 2;
	 * sumOfMultiples15 = sumOfConsecutiveNumbers(15, i, 15); yerine sumOfMultiples15 = (i / 15) * (i  + 15) / 2;
	 * 
	 */
	
	

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Test case : ");
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
        	System.out.print("N : ");
            int N = in.nextInt();
            System.out.println(sumOfMultiples3or5(N));
        }
    }


}
