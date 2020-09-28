package gca1;

/*
 * You are implementing your own programming language and you've decided to add support for merging strings. A typical merge function would take two strings s1 and s2, and return the lexicographically smallest result that can be obtained by placing the symbols of s2 between the symbols of s1 in such a way that maintains the relative order of the characters in each string.

For example, if s1 = "super" and s2 = "tower", the result should be merge(s1, s2) = "stouperwer". 

checking characters and write smaller character and then next one compare 

You'd like to make your language more unique, so for your merge function, instead of comparing the characters in the usual lexicographical order, you'll compare them based on how many times they occur in their respective strings (fewer occurrences means the character is considered smaller). If the number of occurrences are equal, then the characters should be compared in the usual lexicographical way. If both number of occurences and characters are equal, you should take the characters from the first string to the result.

Given two strings s1 and s2, return the result of the special merge function you are implementing.




 */
public class MergeStrings {

	public static void main(String[] args) {
		String s1 = "ougtaleegvrabhugzyx";
		String s2 = "wvieaqgaegbxg";

		System.out.println(mergeStrings(s1, s2));
	}

	private static String mergeStrings(String s1, String s2) {
		String mergedString = "";
		for (int firstStringCnt = 0, secondStringCnt = 0; firstStringCnt + secondStringCnt <= s1.length() + s2.length();) {
			if (firstStringCnt == s1.length()) {
				for (int i = secondStringCnt; i < s2.length(); i++) {
					mergedString += s2.charAt(i);
				}
				break;
			}
			if (secondStringCnt == s2.length()) {
				for (int i = firstStringCnt; i < s1.length(); i++) {
					mergedString += s1.charAt(i);
				}
				break;
			}

			if (isFirstOccurLess(s1.charAt(firstStringCnt), s1, s2.charAt(secondStringCnt), s2)) {
				mergedString += s1.charAt(firstStringCnt);
				firstStringCnt++;
			} else {
				mergedString += s2.charAt(secondStringCnt);
				secondStringCnt++;
			}
		}

		return mergedString;
	}

	private static boolean isFirstOccurLess(char charAt, String s1, char charAt2, String s2) {
		int firstCharCounter = 0;
		int secondCharCounter = 0;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == charAt)
				firstCharCounter++;
		}

		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == charAt2)
				secondCharCounter++;
		}

		if (firstCharCounter < secondCharCounter || (firstCharCounter == secondCharCounter && charAt <= charAt2)) {
			return true;
		} else {
			return false;
		}
	}

}
