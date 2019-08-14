/*
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */
package medium;

import java.io.IOException;
import java.util.Scanner;

public class ClimbingTheLeaderboard {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

    	System.out.print("The number of players on the leaderboard : ");
        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        System.out.print("The leaderboard scores in decreasing order : ");
        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        System.out.print("denoting the number games Alice plays : ");
        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        System.out.print("Alice's game scores : ");
        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));
        }
        scanner.close();
    }
    


    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
    	int[] rank = new int[scores.length];
    	int[] alicesRank = new int[alice.length];
    	rank = setRankBoard(scores,rank);
    	int rankCounter = rank.length - 1;
    	
    	for (int i = 0; i < alicesRank.length; i++) {
			for (int j = rankCounter ; j >= 0; j--) {
				if (alice[i] < scores[j]) {
					alicesRank[i] = rank[j] + 1;
					rankCounter = j;
					break;
				} else if (alice[i] == scores[j]){
					alicesRank[i] = rank[j];
					rankCounter = j;
					break;
				}else if (alice[i] > scores[0]){
					alicesRank[i] = 1;
					break;
				}  else {
					continue;
				}
			}
		}
		return alicesRank;
    }



	private static int[] setRankBoard(int[] scores, int[] rankBoard) {
		//first score is always ranked 1
		rankBoard[0] = 1;
		
		for (int scoreCounter = 1,rank = 1; scoreCounter < scores.length; scoreCounter++) {
			if (scores[scoreCounter] != scores[scoreCounter - 1])rank++;
			rankBoard[scoreCounter] = rank;
		}
		return rankBoard;
	}
}
