/**
 * Name: Michael Miralles
 * Date: July 18, 2025
 * Description: This file contains a custom queue using linked list to manage
 *              book waitlist.
 */

public class BookQueue {
    
    // Inner Node class to store Book and link to next node
    private static class Node {
        String user;
        Node next;

        Node(String user) {
            this.user = user;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    // Default constructor
    public BookQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add a book to the rear of the queue
    public void enqueue(String user) {
        Node newNode = new Node(user);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Remove and return the book at the front of the queue
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Waitlist is empty.");
            return null;
        }

        String user = front.user;
        front = front.next;
        size--;

        // Reset rear if queue is empty
        if (front == null) {
            rear = null;
        }

        return user;
    }  

    // Peek at the book at the front without removing
    public String peek() {
        if (isEmpty()) {
            return null;
        }

        return front.user;
    }

    // Return the number of books in the queue
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Print all books in queue
    public void printQueue() {
        Node current = front;
        System.out.println("People in Waitlist (Front to Back): ");

        while (current != null) {
            System.out.println(current.user);
            current = current.next;
        }

        if (isEmpty()) {
            System.out.println("No people in waitlist");
        }
    }
}
