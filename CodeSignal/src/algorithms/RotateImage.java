package algorithms;

/*
 * Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview. 
 * You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
 * 
 * 
 *  for a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
     
    output should be rotateImage(a) =
    [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
 */

public class RotateImage {

	public static void main(String[] args) {
		int[][] a = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] rotated = new int[a.length][a[0].length];
		
		write2DArray(a);
		
		System.out.println("------------------------");
		
		rotated = rotateImage(a);
		write2DArray(rotated);
		

	}

	private static void write2DArray(int[][] rotated) {
		for (int i = 0; i < rotated.length; i++) {
			for (int j = 0; j < rotated.length; j++) {
				System.out.print(rotated[i][j]);
				if(j != rotated.length - 1) System.out.print(" - ");
			} 
			System.out.println();
		}
		
	}

	private static int[][] rotateImage(int[][] a) {
		int[][] newA = new int[a.length][a.length];
		copyArrayByValue(a,newA);
		
		
		for (int i = 0; i < newA.length; i++) {
			for (int j = 0; j < newA.length; j++) {
				int rotatedX = j;
				int rotatedY = a.length - 1 - i;
				newA[rotatedX][rotatedY] = a[i][j];
			}
		}
		
		return newA;
	}

	private static void copyArrayByValue(int[][] a, int[][] newA) {
		for (int i = 0; i < newA.length; i++) {
			for (int j = 0; j < newA.length; j++) {
				newA[i][j] = a[i][j];
			}
		}
	}
	
	
	
	/*
	3x3
	 
	00 01 02 
	10 11 12
	20 21 22
	
	20 10 00
	21 11 01
	22 12 02
	
	x'i 0 olanın , yeni x'i y leri oldu, y'leri ise n-1-x oldu
	x = y , y = n-1-x
	00 -> 02
	01 -> 12
	02 -> 22
	
	x'i 1 olanın , yeni x'i y'leri oldu, y'leri ise n-1-x oldu
	x = y , y = n-1-x
	10 -> 01
	11 -> 11
	12 -> 21
	
	x'i 2 olanın, yeni x'i y'leri oldu, y'leri ise n-1-x oldu
	x = y , y = n-1-x
	20 -> 00
	21 -> 10
	22 -> 20
	
	
	*/
}
