/*
 * Emma is playing a new mobile game that starts with consecutively numbered clouds. 
 * Some of the clouds are thunderheads and others are cumulus. 
 * She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.She must avoid the thunderheads. 
 * Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. It is always possible to win the game.
 * 
 *  
 *  For each game, Emma will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
 *  
 *  For example, c = [0,1,0,0,0,1,0] indexed from 0...6 The number on each cloud is its index in the list so she must avoid the clouds at indexes 1 and 5.
 *  She could follow the following two paths: 0->2->4->6  or 0->2->3->4->6 The first path takes 3 jumps while the second takes 4.
 */
package InterviewPreparationKit;

import java.util.Scanner;

public class JumpingOnTheClouds {
	static int jumpingOnClouds(int[] c) {
    	int jumps = 0;
    	int i = 0;
    	//for loop untill length -2 beacuse we check for i+2 in for loop, we dont want a get an out of bound exception
    	for (i = 0; i < c.length - 2;) {
    		// if 2 step ahead culumus cloud exists we simply jump on it
			if(c[i+2] == 0) {
				i+=2;
			} else {
				i++;
			}
			jumps++;
		}
    	/*
    	 * we have [length - 1] indexes to proceed, after for loop we might on c[length -2]
    	 */
    	if(i == c.length - 2) {
    		jumps++;
    	}
			
		return jumps;


    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("The total number of clouds : ");
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int[] clouds = new int[n];

		System.out.print("n space-separated binary integers describing clouds : ");
		for (int i = 0; i < clouds.length; i++) {
			clouds[i] = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		}

		int result = jumpingOnClouds(clouds);
		System.out.println("result : " + result);

	}
}
