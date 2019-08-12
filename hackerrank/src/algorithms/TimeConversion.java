/*
 * https://www.hackerrank.com/challenges/time-conversion/problem
 */
package algorithms;

import java.util.Scanner;

public class TimeConversion {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		String inputTime;
		System.out.print("A single string containing a time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm.ssPM) where 01 <= hh <= 12 and 00 <= mm,ss <= 60 : ");
		inputTime = scan.nextLine();
		
		System.out.print("Formatted time : " + timeConversion(inputTime));

	}

	static String timeConversion(String s) {
		String lastTwo = s.substring(s.length() -2 , s.length());
		String hours = s.substring(0,2);
		String time = s.substring(0,s.length() - 2);
		
		if(hours.equals("12")){
			if(lastTwo.equalsIgnoreCase("AM")){
				return ("00" + time.substring(2, time.length()));
			} else {
				return time;
			}
		} else {
			if(lastTwo.equalsIgnoreCase("AM")){
				return time;
			} else {
				return ((Integer.parseInt(hours) + 12) + time.substring(2, time.length()));
			}
		}
	}
}
