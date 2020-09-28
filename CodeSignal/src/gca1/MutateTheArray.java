package gca1;

/*
 * Given an integer n and an array a of length n, your task is to apply the following mutation to a:

Array a mutates into a new array b of length n.
For each i from 0 to n - 1, b[i] = a[i - 1] + a[i] + a[i + 1].
If some element in the sum a[i - 1] + a[i] + a[i + 1] does not exist, it should be set to 0. For example, b[0] should be equal to 0 + a[0] + a[1].

 *
 *For n = 5 and a = [4, 0, 1, -2, 3], the output should be mutateTheArray(n, a) = [4, 5, -1, 2, 1].

b[0] = 0 + a[0] + a[1] = 0 + 4 + 0 = 4
b[1] = a[0] + a[1] + a[2] = 4 + 0 + 1 = 5
b[2] = a[1] + a[2] + a[3] = 0 + 1 + (-2) = -1
b[3] = a[2] + a[3] + a[4] = 1 + (-2) + 3 = 2
b[4] = a[3] + a[4] + 0 = (-2) + 3 + 0 = 1
So, the resulting array after the mutation will be [4, 5, -1, 2, 1].
 *
 */

public class MutateTheArray {

	public static void main(String[] args) {
		int n = 5;
		int[] a = new int[] { 4, 0, 1, -2, 3 };

		int[] b = new int[a.length];

		b = mutateTheArray(n, a);

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}

	private static int[] mutateTheArray(int n, int[] a) {
		int[] c = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int first = 0;
			int last = 0;

			if (i == 0) {
				first = 0;
			} else {
				first = a[i - 1];
			}
			if (i == a.length - 1) {
				last = 0;
			} else {
				last = a[i + 1];
			}

			c[i] = first + a[i] + last;
		}
		return c;
	}

}
