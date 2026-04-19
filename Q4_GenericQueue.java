public class Q4_GenericQueue<T> implements Q3_QueueADT<T> {
    private Object[] queueData;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Q4_GenericQueue(int capacity) {
        this.capacity = capacity;
        this.queueData = new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (isFull()) {
            throw new RuntimeException("Queue Overflow: The queue is full");
        }
        rear = (rear + 1) % capacity;
        queueData[rear] = element;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow: The queue is empty");
        }
        T element = (T) queueData[front];
        queueData[front] = null; // facilitate garbage collection
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow: The queue is empty");
        }
        return (T) queueData[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println("Testing Generic Queue (Capacity: 3)");
        Q4_GenericQueue<String> queue = new Q4_GenericQueue<>(3);

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        System.out.println("Queue size: " + queue.size());

        try {
            queue.enqueue("Fourth"); // Should throw exception
        } catch (RuntimeException e) {
            System.out.println("Exception caught correctly: " + e.getMessage());
        }

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.enqueue("Fourth"); // Circular wrap-around
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        try {
            queue.dequeue(); // Should throw exception
        } catch (RuntimeException e) {
            System.out.println("Exception caught correctly: " + e.getMessage());
        }
    }
}
