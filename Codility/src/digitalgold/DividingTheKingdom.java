/**
 *  Result : https://app.codility.com/demo/results/training6P6UMX-BMA/
 */
package digitalgold;

public class DividingTheKingdom {

	public static void main(String[] args) {
		int[] x = new int[]{0,0,0,0};
		int[] y = new int[]{0,1,2,3};
		System.out.println(solution(5,0,x,y));
	}
	
	public static int solution(int N, int M, int[] X, int[] Y) {
		int counter = 0;
		int line = 1;
		while(line < N ){
			if(countUp(line,Y) == countDown(line,Y)){
				counter++;
			}
			line++;
		}
		line = 1;
		while(line < M){
			if(countUp(line,X) == countDown(line,X)){
				counter++;
			}
			line++;
		}
		
		return counter;
    }
	private static int countDown(int line, int[] array) {
		int mines = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] >= line){
				mines++;
			}
		}
		return mines;
	}

	private static int countUp(int line, int[] y) {
		int mines = 0;
		for (int i = 0; i < y.length; i++) {
			if(y[i] < line){
				mines++;
			}
		}
		return mines;
	}
}
