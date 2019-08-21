package medium;

import java.util.Scanner;

public class OrganizingContainersOfBalls {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("the number of queries : ");
		int numberOfQueries = scanner.nextInt();
		int[] numberOfContainers = new int[numberOfQueries];
		String[] result = new String[numberOfQueries];
		
		for (int i = 0; i < numberOfQueries; i++) {
			System.out.print("The number of containers (rows) and ball types (columns) : ");
			numberOfContainers[i] = scanner.nextInt();
			
			System.out.println("n lines contains n space-seperated integers describing row M[i]");
			int[][] matrix = new int[numberOfContainers[i]][numberOfContainers[i]];
			for (int row = 0; row < numberOfContainers[i]; row++) {
				for (int column = 0; column < numberOfContainers[i]; column++) {
					matrix[row][column] = scanner.nextInt();
				}
			}
			 result[i] = organizingContainers(matrix);
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static String organizingContainers(int[][] matrix) {
		String result = "";
		int[] numberOfBallsInEachContainer = new int[matrix.length];
		int[] typesOfBalls = new int[matrix.length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				numberOfBallsInEachContainer[i] += matrix[i][j];
				typesOfBalls[i] += matrix[j][i];
			}
		}
		
		for (int i = 0; i < typesOfBalls.length; i++) {
			boolean flag = false;
			for (int j = 0; j < typesOfBalls.length; j++) {
				if(numberOfBallsInEachContainer[i] == typesOfBalls[j]){
					flag = true;
					typesOfBalls[j] = -1;
					break;
				}
			}
			if(!flag){
				return "Impossible";
			}
		}
		
		return "Possible";
	}
}
