package linkedlists;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits. 
 * The represented number might have leading zeros. Your task is to add up these huge integers and return the result in the same format.
 * 
 * 
 * 
 * Example

For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
addTwoHugeNumbers(a, b) = [9876, 5434, 0].

Explanation: 987654321999 + 18001 = 987654340000.

For a = [123, 4, 5] and b = [100, 100, 100], the output should be
addTwoHugeNumbers(a, b) = [223, 104, 105].

Explanation: 12300040005 + 10001000100 = 22301040105.
 */

//Singly-linked lists are already defined with this interface:
//class ListNode<T> {
//ListNode(T x) {
//  value = x;
//}
//T value;
//ListNode<T> next;
//}
//
public class AddTwoHugeNumbers {

	public static void main(String[] args) {
		int[] a = new int[] { 9876, 5432, 1999};
		ListNode<Integer> k = new ListNode(new Integer(a[0]));
		ListNode<Integer> lastA = k;
		int[] b = new int[] { 1, 8001};
		ListNode<Integer> m = new ListNode(new Integer(b[0]));
		ListNode<Integer> lastB = m;

		ListNode<Integer> output = null;

		for (double i = 1; i < a.length; i++) {
			lastA.next = new ListNode(new Integer(a[(int) i]));
			lastA = lastA.next;
		}
		for (double i = 1; i < b.length; i++) {
			lastB.next = new ListNode(new Integer(b[(int) i]));
			lastB = lastB.next;
		}

		output = addTwoHugeNumbers(k, m);
		
		while (output.next != null) {
			System.out.print(output.value + ", ");
			output = output.next;
		}
		System.out.println(output.value);
	}

	private static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> k, ListNode<Integer> m) {
		String a = "";
		String b = "";
		a += k.value;
		b += m.value;
		k = k.next;
		m = m.next;
		while (k != null || m != null) {
			if (k != null) {
				int leadingZeros = 4 - k.value.toString().length();
				for (int i = 0; i < leadingZeros; i++) {
					a += "0";
				}
				a += k.value;
				k = k.next;
			}
			if (m != null) {
				int leadingZeros = 4 - m.value.toString().length();
				for (int i = 0; i < leadingZeros; i++) {
					b += "0";
				}
				b += m.value;
				m = m.next;
			}
		}

		String sum = new BigDecimal(a).add(new BigDecimal(b)).toString();

		int firstElementDigit = sum.length() % 4;
		Integer firstElement = 0;
		if(firstElementDigit != 0) {
			firstElement = Integer.valueOf(sum.substring(0, firstElementDigit));
		} else {
			firstElement = Integer.valueOf(sum.substring(0, 4));
			firstElementDigit = 4;
		}
		
		ListNode<Integer> head = new ListNode<Integer>(firstElement);
		ListNode<Integer> last = head;
		for (int i = firstElementDigit; i < sum.length(); i += 4) {
			last.next = new ListNode<Integer>(new Integer(Integer.valueOf(sum.substring(i,i+4))));
			last = last.next;
		}

		return head;
	}
}
