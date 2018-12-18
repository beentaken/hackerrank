package hackerrank.datastructures;

import java.util.Stack;

public class QueueTwoStacks<T> {

    private Stack<T> newestOnTop = new Stack<>();
    private Stack<T> oldestOnTop = new Stack<>();


    public void enqueue(T item) {
        newestOnTop.push(item);
    }

    public T peek() {
        shiftStacks();
        return oldestOnTop.peek();
    }


    public T deque() {
        shiftStacks();
        return oldestOnTop.pop();
    }

    private void shiftStacks() {
        if (!oldestOnTop.empty()) {
            while (!newestOnTop.empty()) {
                oldestOnTop.push(newestOnTop.pop());
            }
        }
    }
}
