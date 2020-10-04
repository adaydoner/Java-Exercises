package linkedlists;

import java.util.ArrayList;

/*
 * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers, determine whether or not it's a palindrome.

Note: in examples below and tests preview linked lists are presented as arrays just for simplicity of visualization: in real data you will be given a head node l of the linked list

Example

For l = [0, 1, 0], the output should be
isListPalindrome(l) = true;

For l = [1, 2, 2, 3], the output should be
isListPalindrome(l) = false.
 * 
 * 
 */
/*class ListNode<T> {
	ListNode(T x) {
		value = x;
	}

	T value;
	ListNode<T> next;
}*/

public class IsListPalindrome {

	public static void main(String[] args) {
		int[] a = new int[] { 1,0,1 };
		ListNode<Integer> l = new ListNode<Integer>(new Integer(a[0]));
		ListNode<Integer> last = l;
		ListNode<Integer> output;

		for (double i = 1; i < a.length; i++) {
			last.next = new ListNode(new Integer(a[(int) i]));
			last = last.next;
		}

		System.out.println(isListPalindrome(l));

	}

	private static boolean isListPalindrome(ListNode<Integer> l) {
		ArrayList<Integer> arList = new ArrayList<>();
		ListNode<Integer> middle = l;
		ListNode<Integer> x2Fast = l;

		while (x2Fast != null && x2Fast.next != null) {
			arList.add(middle.value);
			middle = middle.next;
			x2Fast = x2Fast.next.next;
		}
		if (x2Fast != null)
			middle = middle.next;

		while (middle != null) {
			if (middle.value.equals(arList.get(arList.size()-1))) {
				arList.remove(arList.size() - 1);
				middle = middle.next;
			} else {
				return false;
			}
		}
		return true;
	}
}
