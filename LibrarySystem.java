/**
 * Name: Michael Miralles
 * Date: July 18, 2025
 * Description: This file contains the main logic for the Library Management System.
 *              It manages book and member data, user interaction, and book checkout/return
 *              Books are loaded, sorted, and displayed through a menu-driven interface
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LibrarySystem {

    private BookStack returnedBooks = new BookStack();

    private ArrayList<Book> books;
    private MemberHashTable members;
    private Scanner scnr;

    public LibrarySystem() {
        books = new ArrayList<>();
        members = new MemberHashTable();
        scnr = new Scanner(System.in);

        // load books from file
        loadBooks("books.txt");

        // Add sample members
        members.put("M001", new Member("Mike", "M001"));
        members.put("M002", new Member("John", "M002"));
        members.put("M003", new Member("Alice", "M003"));

        // Sort books by title when start is called
        books = SortHelper.mergeSort(books);
    }
    
    // Starts the menu loop  for the LMS
    // Allows users to view, checkout, and return books, and exit the loop
    public void start() {
        System.out.println("====================================================");
        System.out.println("| Welcome to ByteBoks! A Library Management System |");
        System.out.println("====================================================");

        // Menu Loop
        while (true) {
            System.out.println("Main Menu: ");
            System.out.println("1. View all books");
            System.out.println("2. Checkout a book");
            System.out.println("3. Return a book");
            System.out.println("4. View recently returned books");
            System.out.println("5. View the waitlist");
            System.out.println("6. View all members");
            System.out.println("7. Exit");
            System.out.print("Please enter your choice(1-6): ");

            int choice = scnr.nextInt();
            scnr.nextLine();

            if (choice == 1) {
                displayBooks();
            }
            else if (choice == 2) {
                checkoutBook();
            }
            else if (choice ==3) {
                returnBook();
            }
            else if (choice == 4) {
                returnedBooks.printRecent(5);
            }
            else if (choice == 5) {
                viewWaitlist();
            }
            else if (choice == 6) {
                viewAllMembers();
            }
            else if (choice == 7) {
                System.out.println("Hope you enjoyed your stay. Goodbye!");
                return;
            }
            else {
                System.out.println("Invalid choice please try again.");
            }
        }
    }

    // Display Books
    private void displayBooks() {
        System.out.println("Book List: ");

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    // Prompts the user to choose a book and checks it out if available
    private void checkoutBook() {
        System.out.println("Which book would you like to checkout?");
        displayBooks();

        System.out.println("Enter book number: ");

        int index = scnr.nextInt();
        scnr.nextLine();

        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book number");
            return;
        }

        Book currBook = books.get(index - 1);

        if (currBook.getAvailability()) {
            currBook.checkout();
        }
        else {
            System.out.println("Im sorry that book is already checked out.");
            System.out.print("Would you like to be added to the wailist? (y/n): ");

            String usrResponse = scnr.nextLine();

            if (usrResponse.equalsIgnoreCase("y")) {
                System.out.print("Enter your name: ");

                String name = scnr.nextLine();

                currBook.getWaitlist().enqueue(name);

                System.out.println(name + " has been added to the waitlist.");
            }
        }
    }

    // Prompts user to choose a book and returns it if it was checked out
    private void returnBook() {
        System.out.println("Which book would you like to return?");
        displayBooks();

        System.out.print("Enter book number: ");

        int index = scnr.nextInt();
        scnr.nextLine();

        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book number.");
            return;
        }

        Book currBook = books.get(index - 1);

        if(!currBook.getAvailability()) {
            currBook.returnBook();
            returnedBooks.push(currBook);

            if (!currBook.getWaitlist().isEmpty()) {
                String nextUsr = currBook.getWaitlist().dequeue();
                currBook.checkout();
                System.out.println("Book auto-assigned to next user in waitlist: " + nextUsr);
            }
        }
        else {
            System.out.println("That book is already available.");
        }
    }

    // Load books from the text file
    private void loadBooks(String fileName) {
        try {
            Scanner scnr = new Scanner(new File("books.txt"));

            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    String isbn = parts[2].trim();

                    books.add(new Book(title, author, isbn));
                }
            }
            scnr.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error loading books from file: " + e.getMessage());
        }
    }

    // Prompts user to select a book and displays the waitlist (if any)
    private void viewWaitlist() {
        System.out.println("Which book's waitlist would you like to view?");
        displayBooks();

        System.out.print("Enter book number: ");

        int index = scnr.nextInt();
        scnr.nextLine();

        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book number.");
            return;
        }

        Book selectedBook = books.get(index - 1);
        BookQueue queue = selectedBook.getWaitlist();

        if (queue.isEmpty()) {
            System.out.println("No users are currently in the waitlist for this book.");
        }
        else {
            queue.printQueue();
        }
    }

    // Displays all registered members in the system
    private void viewAllMembers() {
        System.out.println("Registered Library Members: ");
        members.printTable();
    }
}