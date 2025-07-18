/**
 * Name: Michael Miralles
 * Date: July 18, 2025
 * Description: This is a custom stack using a linked list to store recently returned books
 */

public class BookStack {
    private Node top;
    private int size;

    // Inner class to define a node in the linked list
    private class Node {
        Book data;
        Node next;

        Node(Book data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to initialize an empty stack
    public BookStack() {
        top = null;
        size = 0;
    }

    // Push a book onto the stack
    public void push (Book book) {
        Node newNode = new Node(book);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop the top book off the stack
    public Book pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return null;
        }

        Book poppedBook = top.data;
        top = top.next;
        size--;
        return poppedBook;
    }

    // Peek at the top book without removing it
    public Book peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }

        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Getter
    public int getSize() {
        return size;
    }

    // Print the most recently returned books (top to bottom)
    public void printRecent(int count) {
        Node current = top;
        int printed = 0;

        if (isEmpty()) {
            System.out.println("No books have been returned yet.");
            return;
        }

        System.out.println("Recently Returned Books (Top to Bottom):");
        while (current != null && printed < count) {
            System.out.println(current.data);
            current = current.next;
            printed++;
        }
    }
}
