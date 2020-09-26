package algorithms;

/*
 * https://app.codesignal.com/interview-practice/task/uX5iLwhc6L5ckSyNC
 * Given a string s consisting of small English letters, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
 * 
 * 
 * For s = "abacabad", the output should be firstNotRepeatingCharacter(s) = 'c'.
 */

public class FirstNotRepeatingCharacter {

	public static void main(String[] args) {
		String s = "abacabaabacaba";

		System.out.println(firstNotRepeatingCharacter2(s));
	}

	private static char firstNotRepeatingCharacter(String s) {
		char wanted = '_';
		
		for (int i = 0; i < s.length(); i++) {
			boolean breakForLoop = false;
			
			if (s.charAt(i) != '?') {
				wanted = s.charAt(i);
			} else {
				continue;
			}

			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(j) == wanted) {
					s = s.replace(s.charAt(j), '?');
					breakForLoop = true;
					break;
				}
			}
			if (!breakForLoop)
				return wanted;
		}

		return '_';
	}

	private static char firstNotRepeatingCharacter2(String s) {
		char[] c = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(c[i]) == s.lastIndexOf(c[i]))
				return c[i];
		}
		return '_';
	}

}
