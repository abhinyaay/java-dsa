package day2.ads.java;

public class FixedSizeStack implements Stack {
	private int[] stackData;
	private int top;

	public FixedSizeStack(int n) {
		stackData = new int[n];
		top = -1;
	}

	@Override
	public void push(int element) {
		if (isFull()) {
			throw new RuntimeException("Stack Overflow: Stack is full");
		}

		top = top + 1;
		stackData[top] = element;
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack Underflow: Stack is empty");
		}

		int result = stackData[top];
		top = top - 1;
		return result;
	}

	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (top == (stackData.length - 1)) {
			return true;
		}
		return false;
	}

}
