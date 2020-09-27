package algorithms;

/*
 * A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence between letters and digits, such that the given arithmetic equation consisting of letters holds true when the letters are converted to digits.

You have an array of strings crypt, the cryptarithm, and an an array containing the mapping of letters and digits, solution. The array crypt will contain three non-empty strings that follow the structure: [word1, word2, word3], which should be interpreted as the word1 + word2 = word3 cryptarithm.

If crypt, when it is decoded by replacing all of the letters in the cryptarithm with digits using the mapping in solution, becomes a valid arithmetic equation containing no numbers with leading zeroes, the answer is true. If it does not become a valid arithmetic solution, the answer is false.

Note that number 0 doesn't contain leading zeroes (while for example 00 or 0123 do).
 */

import java.math.BigDecimal;

public class IsCryptSolution {

	public static void main(String[] args) {
		String[] crypt = new String[] { "AAAAAAAAAAAAAA", "BBBBBBBBBBBBBB", "CCCCCCCCCCCCCC" };
		char[][] solution = new char[][] { { 'A', '1' }, { 'B', '2' }, { 'C', '3' } };

		System.out.println(isCryptSolution(crypt, solution));
	}

	private static boolean isCryptSolution(String[] crypt, char[][] solution) {
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < 3; j++) {
				crypt[j] = crypt[j].replace(solution[i][0], solution[i][1]);
				if (crypt[j].charAt(0) == '0' && crypt[j].length() > 1)
					return false;
			}
		}
		return (new BigDecimal(crypt[0]).add(new BigDecimal(crypt[1])).equals(new BigDecimal(crypt[2])));
	}
}
