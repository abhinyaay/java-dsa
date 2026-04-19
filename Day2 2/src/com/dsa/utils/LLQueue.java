package com.dsa.utils;

public class LLQueue<T> implements Queue<T> {

	Node<T> front = null;
	Node<T> rear = null;
	int size = 0;
	
	@Override
	public T dequeue() {
		if(isEmpty()) {
            throw new RuntimeException("Queue Underflow !");
        }

		Node<T> temp = front;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		
        size--;
		return temp.data;
	}

	@Override
	public void enqueue(T data) {
		Node<T> temp = new Node<T>(data);
		if(isEmpty()) {
			front = rear = temp;
		} else {
			rear.next = temp;
			rear = temp;
		}
		size++;
	}

	@Override
	public boolean isEmpty() {
		return front == null;
	}
	
	public void print() {
		Node<T> current = front;
		
		while(current != null) {
			if(current.next != null) System.out.print(current.data + " <= ");
			else System.out.print(current.data + "\n");
			current = current.next;
		}
	}

}
