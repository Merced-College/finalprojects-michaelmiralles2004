# ByteBooks

**Author:** Michael Miralles
**Course:** CPSC 39 - Final Project
**Date:** July 18, 2025

## Project Description

**ByteBooks** is a Java-based Library Management System designed for small libraries, classrooms, or anyone learning object-oriented programming. It provides a command interface for:

- Viewing all books
- Checking out and returning books
- Tracking availability
- Viewing registered members
- Managing book waitlists
- Viewing recently returned books

Books are automatically sorted by title using a **recursive merge sort** when program is ran.

---

## Key Concepts Used

- **OOP:** 
    - Custom classes ('Book', 'Member', 'LibrarySystem')
- **Recursions** 
    - Merge sort for book titles
- **Custom Data Structures (implemented from scratch):** 

    - 'BookStack.java' - stack for tracking receent returns (linked list)
    - 'BookQueue.java' - queue for waitlisted users (linked list)
    - 'MemberHashTable.java' - hash table for managing members by ID

- **Other Structures & Techniques:**

    - Arrays and 'ArrayList'
    - Strings and Records
    - File I/O ('books.txt')
    - Scanner for user input

---

## Files Included

- 'Main.java' - Starting point for the program
- 'LibrarySystem.java' - Core menu and logic
- 'Book.java' - Book object with title, author, ISBN, and availability
- 'Member.java' - Member object with name and ID
- 'SortHelper.java' - Recursive sorting logic
- 'BookStack.java' - Custom stack for tracking recently returned books
- 'BookQueue.java' - Custom queue for book waitlists
- 'MemberHashtable.java' - Custom hashtable for storing and retrieving members
- 'books.txt' - External file filled with book data

---

## Quick look into the Project

**Menu Options**
1. View all books
2. Checkout a book
3. Return a book
4. View recently returned books
5. View the waitlist
6. View all members
7. Exit

---

## How to Run

1. **Compile:**
    ```bash
    javac *.java
    ```
2. **Run:**
    ```bash
   java Main
   ```
