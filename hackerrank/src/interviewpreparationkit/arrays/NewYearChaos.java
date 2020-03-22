/*
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! 
 * There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. 
 * Initial positions increment by 1 from 1 at the front of the line to n at the back
 * 
 *  Any person in the queue can bribe the person directly in front of them to swap positions.
 *  If two people swap positions, they still wear the same sticker denoting their original places in line. 
 *  One person can bribe at most two others. For example, if n=8 and Person 5 bribes Person 4, the queue will look like this: 1,2,3,5,4,6,7,8
 *  
 *  Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!
 *  
 *  
 *  Print an integer denoting the minimum number of bribes needed to get the queue into its final state. 
 *  Print Too chaotic if the state is invalid, i.e. it requires a person to have bribed more than 2 people
 */
package interviewpreparationkit.arrays;

import java.util.Scanner;

public class NewYearChaos {

	/*
	 * this will find the number that bigger than original number for the left side.
	 * Let say 
	 * queue : 2,1,5,3,4
	 * 
	 * for 2 : bribes = 0
	 * for 1 : bribes = 1 because (2>1)
	 * for 5 : bribes = 0 
	 * for 3 : bribes = 1 because (5 > 3)
	 * for 4 : bribes = 1 because (5> 4)
	 * 
	 * total needed bribe is 3 
	 * 
	 * 
	 * if any differene between value and indices more than +2 which is mean it has to move forward more than 2 , line configuration is impossible
	 * else sum of (number of bigger number on the lef of a number) would be total needed bribes  
	 * 
	 */
	static void minimumBribes(int[] queue){
		int currentBribe = 0;
		boolean chaotic = false;
		int bribes = 0;
		for (int i = 0; i < queue.length; i++) {
			 //a person cannot give bribe more than 2
			if(queue[i] - (i+1) > 2) {
				chaotic = true;
				break;
			} else {
				for (int j = 0; j < i; j++) {
					if(queue[j] > queue[i]) bribes++;
				}
			}
		}
		
		if(chaotic) System.out.println("Too chaotic");
		else System.out.println(bribes);
		
	}
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("The number of test cases : ");
		int testCase = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		for (int i = 0; i < testCase; i++) {
			System.out.print("The number of people in the " + (i+1) + ". queue : ");
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			
			int[] q = new int[n];
			
			System.out.print("Enter the current queue status : ");
			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			
			for (int j = 0; j < n; j++) {
                int qItem = Integer.parseInt(qItems[j]);
                q[j] = qItem;
            }
			
			minimumBribes(q);
		}
		
	}
}
