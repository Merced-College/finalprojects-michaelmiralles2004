/**
 * Name: Michael Miralles
 * Date: July 18, 2025
 * Description: Custom has table implementation for storing library members.
 *              Supprts adding, retrieving, and removing members using a hash key.
 */

public class MemberHashTable {

    // Inner class representing a node in the hash table
    private static class Node {
        String key;
        Member value;
        Node next;      // Pointer to next node for chaining

        Node(String key, Member value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] table;   // Array of Node references
    private int capacity;
    private int size;

    // default constructor initializes table with default capacity
    public MemberHashTable() {
        this.capacity = 10;
        this.table = new Node[capacity];
        this.size = 0;
    }

    // Computes hash index for a given key
    private int hash(String key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // Adds a new ke-value pair to the table, or updates existing key
    public void put(String key, Member value) {
        int index = hash(key);
        Node current = table[index];

        // If key exists, update value
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }

            current = current.next;
        }

        // Otherwise insert new node at the beginning of chain
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }

    // Gets a member by key
    public Member get(String key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    // Returns true if key exists in the table
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    // Removes a key-value pair by key
    public void remove(String key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                }
                else {
                    prev.next = current.next;
                }

                size--;
                return;
            }

            prev = current;
            current = current.next;
        }
    }

    // Prints all members currently in the hash table
    public void printTable() {
        System.out.println("Library Members:");

        for (int i = 0; i < capacity; i++) {
            Node current = table[i];

            while (current != null) {
                System.out.println("- " + current.value);
                current = current.next;
            }
        }
    }

    // Returns the number of members stored
    public int getSize() {
        return size;
    }
}
