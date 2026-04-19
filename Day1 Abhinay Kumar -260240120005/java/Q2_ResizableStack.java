public class Q2_ResizableStack implements Stack {
    private int[] stackData;
    private int top;

    public Q2_ResizableStack(int initialCapacity) {
        stackData = new int[initialCapacity];
        top = -1;
    }

    @Override
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full, resizing...");
            resize();
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
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == (stackData.length - 1);
    }

    private void resize() {
        int newCapacity = stackData.length * 2;
        if (newCapacity == 0) {
            newCapacity = 1;
        }
        int[] newArray = new int[newCapacity];
        
        for (int i = 0; i <= top; i++) {
            newArray[i] = stackData[i];
        }
        stackData = newArray;
    }

    public static void main(String[] args) {
        System.out.println("Testing Resizable Stack:");
        Q2_ResizableStack stack = new Q2_ResizableStack(2);
        
        stack.push(10);
        stack.push(20);
        System.out.println("Pushed 10, 20. Is the stack full? " + stack.isFull());
        
        stack.push(30); // Should trigger resize
        System.out.println("Pushed 30. Is the stack full now? " + stack.isFull());
        
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        
        try {
            stack.pop(); // Should throw exception
        } catch (RuntimeException e) {
            System.out.println("Exception caught correctly: " + e.getMessage());
        }
    }
}
