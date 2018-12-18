package hackerrank.datastructures;

public class LinkedList {

    private static class Node {
        private Node next;
        private int data;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);

    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) return;

        // Special case for when head == data
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {

            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return false;

    }

}
