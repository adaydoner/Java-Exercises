/*
 * In this challenge, we use regular expressions (RegEx) to remove instances of words that are repeated more than once, 
 * but retain the first occurrence of any case-insensitive repeated word. For example, the words love and to are repeated in the sentence I love Love to To tO code. 
 * Can you complete the code in the editor so it will turn I love Love to To tO code into I love to code? 
 */
package medium;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegexDuplicateWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfSentences = input.nextInt();
		String[] sentence = new String[numberOfSentences + 1];
		

		String regex = "\\b(\\w+)(\\s+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		
		
		for (int i = 0; i <= numberOfSentences; i++) {
			sentence[i] = input.nextLine();
			
			Matcher m = p.matcher(sentence[i]);
			while (m.find()) {
				sentence[i] = sentence[i].replaceAll(m.group(), m.group(1));
	        }
		}
		
		
		for (String string : sentence) {
			System.out.println(string);
		}
		
		
		input.close();
	}
}
