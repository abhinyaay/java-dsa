package com.dsa.utils;

public class Program {

	public static void main(String args[]) {

		
		try {
			
			System.out.println("\n===== Queue Operations =====\n");
			LLQueue<String> q = new LLQueue<String>();
			
			q.enqueue("Hello");
			q.enqueue("How are You!");
			q.enqueue("Hope You are Fine");
			
			System.out.println("Queue Size is: " + q.size);
			q.print();
			System.out.println(q.dequeue());
			q.print();
			
			System.out.println("\n===== Stack Operations =====\n");
			LLStack<String> s = new LLStack<String>();
			
			s.push("Hello");
			s.push("How are You!");
			s.push("Hope You are Fine");
			
			System.out.println("Stack Size is: " + s.size);
			s.print();
			System.out.println(s.pop());
			s.print();
			
			System.out.println("\n===== Linked List Operations =====\n");
			LinkedList<String> ll = new LinkedList<String>();
			
			ll.insertAtEnd("Hello");
			ll.insertAtEnd("How are You!");
			ll.insertAtEnd("Hope You are Fine");
			
			System.out.println("Linked List Size is: " + ll.size);
			ll.print();
			System.out.println(ll.deleteAtEnd());
			System.out.println(ll.deleteAtEnd());
			System.out.println(ll.deleteAtEnd());
			ll.print();
			
		} catch (Exception e) {
			System.out.println("Exception Message says: " + e.getMessage());
		}
			
	}
}
