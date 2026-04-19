package day2.ads.java;

import java.util.Arrays;

public class day2App {

	public static void reverseArray(int[] arr, Stack s) {
		for (int no : arr) {
			s.push(no);
		}

		int i = 0;
		while (!s.isEmpty()) {
			arr[i] = s.pop();
			i = i + 1;
		}
	}

	public static void reverseUsingStack() {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println("Before reverse - " + Arrays.toString(arr));

		Stack s1 = new FixedSizeStack(10);
		reverseArray(arr, s1);

		System.out.println("After reverse - " + Arrays.toString(arr));
	}

	public static void testPushSilentFail() {
		Stack s1 = new FixedSizeStack(3);

		try {
			s1.push(10);
			s1.push(20);
			s1.push(30);
			s1.push(40); // Should throw exception
			s1.push(50);
		} catch (RuntimeException e) {
			System.out.println("Exception caught during push: " + e.getMessage());
		}

		while (!s1.isEmpty()) {
			System.out.println("Popped - " + s1.pop());
		}
	}

	public static void main(String[] args) {
		// testPushSilentFail();
		reverseUsingStack();
	}

}
