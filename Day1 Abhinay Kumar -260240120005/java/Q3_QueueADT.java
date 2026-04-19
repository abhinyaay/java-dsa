public interface Q3_QueueADT<T> {
    void enqueue(T element);
    T dequeue();
    T peek();
    boolean isEmpty();
    boolean isFull();
    int size();
}
