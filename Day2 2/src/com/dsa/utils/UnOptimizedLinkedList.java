package com.dsa.utils;

public class UnOptimizedLinkedList<T> {

	Node<T> head = null;
	Node<T> end = null;
	int size = 0;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void insertAtFront(T data) {
		Node<T> temp = new Node<T>(data);
		if (isEmpty()) {
			head = temp;
			end = temp;
		} else {
			temp.next = head;
			head = temp;
		}
		size++;
	}

	public void insertAtIndex(T data, int pos) {
		if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }
        if (pos == 0) {
            insertAtFront(data);
            return;
        }
        if (pos == size) {
            insertAtEnd(data);
            return;
        }
        Node<T> newNode = new Node<T>(data);
        Node<T> current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
		size++;
	}
	
	public void insertAtEnd(T data) {
		Node<T> temp = new Node<T>(data);
		if(isEmpty()) {
			head = temp;
			end = temp;
		} else {
			end.next = temp;
			end = temp;
		}
		size++;
	}

	public T deleteAtFront() {
		if(isEmpty()) throw new IllegalStateException("List is empty !");

		T data = head.data;
		head = head.next;
		if (head == null) {
			end = null;
		}
		
		size--;
		return data;
	}

	public T deleteAtIndex(int pos) {
		if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }
        if (pos == 0) {
            return deleteAtFront();
        }
        if (pos == size - 1) {
            return deleteAtEnd();
        }

        Node<T> current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }

        Node<T> nodeToDelete = current.next;
        T data = nodeToDelete.data;
        current.next = nodeToDelete.next;
        size--;

        return data;
	}
	
	public T deleteAtEnd() {
		if(isEmpty()) throw new IllegalStateException("List is empty !");
		
		if (head.next == null) {
			T data = head.data;
			head = null;
			end = null;
			size--;
			return data;
		}
		
		Node<T> current = head;
		while(current.next != end) {
			current = current.next;
		}
		
		T data = end.data;
		current.next = null;
		end = current;
		size--;
		
		return data;
	}
	
	public void print() {
		Node<T> current = head;
		
		while(current != null) {
			if(current.next != null) System.out.print(current.data + " => ");
			else System.out.print(current.data + "\n");
			current = current.next;
		}
	}

}
