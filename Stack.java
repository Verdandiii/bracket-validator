public class Stack<T> {
    private final T[] elements;
    private int top;

    // Кастомные unchecked исключения
    public static class StackEmptyException extends RuntimeException {
        public StackEmptyException(String message) {
            super(message);
        }
    }

    public static class StackFullException extends RuntimeException {
        public StackFullException(String message) {
            super(message);
        }
    }

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.elements = (T[]) new Object[capacity];
        this.top = 0;
    }

    public T peek() {
        if (top == 0) throw new StackEmptyException("Stack is empty");
        return elements[top - 1];
    }

    public void push(T item) {
        if (item == null) throw new IllegalArgumentException("Null not allowed");
        if (top == elements.length) throw new StackFullException("Stack is full");
        elements[top++] = item;
    }

    public T pop() {
        if (top == 0) throw new StackEmptyException("Stack is empty");
        T item = elements[--top];
        elements[top] = null;
        return item;
    }

    public boolean isEmpty() { return top == 0; }
    public int size() { return top; }
}