package com.dsa.utils;

public class LLStack<T> implements Stack<T> {

	Node<T> top = null;
	int size = 0;
	
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new IllegalStateException("Stack Underflow !");
		return top.data;
	}

	@Override
	public T pop() {
		if (isEmpty())
			throw new IllegalStateException("Stack Underflow !");

		Node<T> temp = top;
		top = top.next;
		size--;
		return temp.data;
	}

	@Override
	public void push(T data) {
		Node<T> temp = new Node<T>(data);
		temp.next = top;
		top = temp;
		size++;
	}
	
	public void print() {
		Node<T> current = top;
		
		while(current != null) {
			if(current.next != null) System.out.print(current.data + " => ");
			else System.out.print(current.data + "\n");
			current = current.next;
		}
	}

}
