/*
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. 
 * During his last hike he took exactly n steps.For every step he took, he noted if it was an uphill U , or a downhill D step.
 * Gary's hikes start and end at sea level and each step up or down represents a 1 unit change in altitude. We define the following terms
 * 
 * Complete the countingValleys function in the editor below. It must return an integer that denotes the number of valleys Gary traversed. 
 */
package InterviewPreparationKit;

import java.util.Scanner;

public class CountingValleys {
	
	// Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    	int valleyCount = 0;
    	int position = 0;
    	String hikeStatus = "0";
    	for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='D'){
				position--;
			} else if(s.charAt(i) == 'U'){
				position++;
			}
			
			if(position < 0) {
				hikeStatus += "-";
			} else if (position > 0) {
				hikeStatus += "+";
			} else {
				hikeStatus += "0";
				if(hikeStatus.charAt(hikeStatus.length() - 2) == '-') valleyCount++;
			}
		}
    	
		return valleyCount;

    }
    
    private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		

		System.out.print("The number of steps : ");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.print("A string describing his path : ");
        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        
        System.out.println("Valley Count : " + result);

        scanner.close();

	}

}
