/*
 * https://www.hackerrank.com/challenges/encryption/problem
 */
package medium;

import java.util.Scanner;

public class Encryption {

	private static final Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		System.out.print("One line of text, the string s :");
        String s = scanner.nextLine();

        System.out.println(encryption(s));

        scanner.close();
    }


	private static String encryption(String s) {
		String removedSpaces = s.replaceAll("\\s+","");
		int row = (int) Math.sqrt(removedSpaces.length());
		int column;
		String output = "";

		if(row * row == removedSpaces.length()){
			column = row;
		} else {
			column = row + 1;
		}
		
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				if(i + (j * column) <= removedSpaces.length()){
					output += removedSpaces.charAt(i + (j * column));
				} else {
					break;
				}
			}
			output += " ";
		}
		
		
		return output;
	}

}
