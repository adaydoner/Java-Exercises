/**
 * Codility Award : https://app.codility.com/cert/view/cert2FCMM4-54TRKHR7WXSUKZT5/
 */

package zirconium2019;

public class Main {
	public static void main(String[] args) {
		int[] A = {7,1,8,4};
		int[] B = {5,3,4,3};
		int F = 3;
		System.out.println(solution(A,B,F));
	}
	
	
	public static int solution(int[] A, int[] B, int F) {
		int[] gapBetweenDeveloperCandidates = new int[A.length];
		int contribution = 0;
		int maxGap = Integer.MIN_VALUE;
		int maxValueIndex = 0;
		
		//compute gap between two array indexes
		for (int i = 0,length = gapBetweenDeveloperCandidates.length; i < length; i++) {
			gapBetweenDeveloperCandidates[i] = A[i] - B[i];
		}
		
		//choose front end developers depend on bigger gap
		for(int i = 0 ; i < F ; i++){
			for (int j = 0, length = A.length; j < length; j++) {
				if(gapBetweenDeveloperCandidates[j] > maxGap){
					maxGap = gapBetweenDeveloperCandidates[j];
					maxValueIndex = j;
				}
			}
			contribution += A[maxValueIndex];
			maxGap = Integer.MIN_VALUE;
			gapBetweenDeveloperCandidates[maxValueIndex] = Integer.MIN_VALUE;
		}

		//add backend developers
		for (int i = 0,length = gapBetweenDeveloperCandidates.length; i < length ; i++) {
			if (gapBetweenDeveloperCandidates[i] != Integer.MIN_VALUE) {
				contribution += B[i];
			}
		}
		
		
        return contribution;
    }
}
