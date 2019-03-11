package shoppinglistproblem;

import java.io.File;
import java.util.Scanner;

public class Main {
	static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		String fileName ;
		//String fileName = "testdata\\input.txt";
		
		while (true) {
			System.out.print("File Name (e.g testdata\\input.txt): ");
			fileName = input.nextLine();
			if(new File(fileName).exists()){
				break;
			}
		}
		input.close();
		
		Shopping s = new Shopping(fileName);
		s.processFile();
	}
}
