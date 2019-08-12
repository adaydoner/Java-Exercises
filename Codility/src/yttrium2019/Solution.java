/**
 * result : https://app.codility.com/demo/results/trainingWF9JUF-N3Q/
 */

package yttrium2019;

import java.util.HashMap;

public class Solution {
	public static void main(String[] args) {
		System.out.println(solution("aabcabc",1));
	}
	
	public static int solution(String S, int K){
		int substringLength = Integer.MAX_VALUE;
		for (int i = 0; i < S.length() - 1; i++) {
			String copyS = S;
			for (int j = i; j < S.length(); j++) {
				copyS = S;
				String substring = copyS.substring(i, j + 1);
				copyS = copyS.replaceFirst(substring, "");
				HashMap<String, Integer> contChars = new HashMap<String, Integer>();
				for (int k = 0,length = copyS.length(); k < length; k++) {
					if(contChars.containsKey(String.valueOf(copyS.charAt(k)))){
						contChars.put(String.valueOf(copyS.charAt(k)), Integer.valueOf(contChars.get(String.valueOf(copyS.charAt(k))) + 1));
					} else {
						contChars.put(String.valueOf(copyS.charAt(k)), 1);
					}
				}
				if(contChars.size() == K){
					if(substringLength > substring.length()){
						substringLength = substring.length();
					}
				}
				
				
			}
		}
		if(substringLength != Integer.MAX_VALUE){
			return substringLength;
		} else {
			return -1;
		}
	}
}
