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
		
		if (front.next != null) {
			front = front.next;
		} else {
            front = null;
            rear = null;
        }
		
        size--;
		return temp.data;
	}

	@Override
	public void enqueue(T data) {
		
		if(isEmpty()) {
			front = new Node<T>();
			front.data = data ;
		}
		
		else if(front != null && front.next == null){
			rear = new Node<T>();
			rear.data = data;
			rear.next = null;
			front.next = rear;
		}
		
		else {
			Node<T> temp = new Node<T>();
			temp.data = data;
			temp.next = null;
			rear.next = temp;
			rear = temp;
		}
		
		size++ ;
	}

	@Override
	public boolean isEmpty() {
		if (front == null) return true;
		return false;
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
