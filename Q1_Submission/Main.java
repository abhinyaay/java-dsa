public class Main {
    public static void main(String args[]) {
        try {
            System.out.println("===== Q1: Queue using Singly Linked List =====");
            LLQueue<String> q = new LLQueue<String>();
            
            q.enqueue("Element A");
            q.enqueue("Element B");
            q.enqueue("Element C");
            
            System.out.println("Queue Size is: " + q.size);
            q.print();
            
            System.out.println("Dequeuing: " + q.dequeue());
            q.print();
            
            System.out.println("Dequeuing: " + q.dequeue());
            System.out.println("Dequeuing: " + q.dequeue());
            
            System.out.println("Queue Size is now: " + q.size);
            
            // This should throw an exception
            System.out.println("Attempting to dequeue from empty queue...");
            q.dequeue();
            
        } catch (Exception e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }
    }
}
