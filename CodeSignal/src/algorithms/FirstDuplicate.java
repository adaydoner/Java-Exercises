package algorithms;

/*
 * https://app.codesignal.com/interview-practice/task/pMvymcahZ8dY4g75q
 * Given an array a that contains only numbers in the range from 1 to a.length, 
 * find the first duplicate number for which the second occurrence has the minimal index. In other words, 
 * if there are more than 1 duplicated numbers, return the number for which the second occurrence has a smaller index than the second occurrence of the other number does. 
 * If there are no such elements, return -1.
 * 
 * 
 * For a = [2, 1, 3, 5, 3, 2], the output should be firstDuplicate(a) = 3.
 */

public class FirstDuplicate {

	public static int firstDuplicateMethod(int[] a) {
		int returnVal = -1;
		int duplicatesLastIndex = Integer.MAX_VALUE;
		int duplicatesFirstIndex = 0;
		boolean founded = false;

		// find first duplicate
		for (int i = 0; i < a.length; i++) {
			int foundIndex = -1;
			foundIndex = searchForward(a, a[i], i);
			if (foundIndex != -1 && foundIndex < duplicatesLastIndex) {
				returnVal = i < foundIndex ? a[i] : a[foundIndex];
				duplicatesLastIndex = foundIndex;
				duplicatesFirstIndex = i;
				break;
			}
		}

		while (!founded && returnVal != -1) {
			
			// check if there is another duplicate before founded one
			for (int i = duplicatesLastIndex -1 ; i >= duplicatesFirstIndex; i--) {
				int foundIndex = -1;
				foundIndex = searchBackward(a, a[i], i);
				if (foundIndex != -1) {
					duplicatesLastIndex = i;
					duplicatesFirstIndex = foundIndex;
					returnVal = a[foundIndex];
					founded=false;
					break;
				} else {
					founded=true;
				}
			}
		}
		
		
		
		
		return returnVal;
	}

	public static int searchForward(int[] a, int element, int i) {
		for (int j = i+1; j < a.length; j++) {
			if (a[j] == element)
				return j;
		}
		return -1;
	}

	public static int searchBackward(int[] a, int element, int i) {
		for (int j = i - 1; j > 0; j--) {
			if (a[j] == element)
				return j;
		}
		return -1;
	}

/*	public static int firstDuplicate(int[] a) {
	    for(int i=0;i<a.length;i++)
	        if(a[Math.abs(a[i])-1]<0)
	            return Math.abs(a[i]);
	        else{
	            a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
	        }
	    return -1;
	}*/
	
	
	
	public static void main(String[] args) {
		System.out.println(firstDuplicateMethod(new int[] {1, 5, 1, 5, 2, 3}));
	}

}
