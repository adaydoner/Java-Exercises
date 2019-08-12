package algorithms;

import java.util.Scanner;

public class CatsAndaMouse {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Denote the number of queries : ");
		int queries = scanner.nextInt();
		
		System.out.print("three space-separated integers describing the respective values of cat A's location cat B's location and Mouse C's location : ");
		for (int i = 0; i < queries ; i++) {
			String[] xyz = scanner.nextLine().split(" ");
			
			int catA = Integer.parseInt(xyz[0]);
			int catB = Integer.parseInt(xyz[1]);
			int mouseC = Integer.parseInt(xyz[2]);
			
			System.out.println(catAndMouse(catA, catB, mouseC));
		}
	}

	private static String catAndMouse(int catA, int catB, int mouseC) {
		if (Math.abs(catA - mouseC) < Math.abs(catB - mouseC)) {
			return "Cat A";
		} else if (Math.abs(catA - mouseC) > Math.abs(catB - mouseC)) {
			return "Cat B";
		} else {
			return "Mouse C";
		}
	}
}
