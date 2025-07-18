import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private Scanner scnr;

    public LibrarySystem () {
        books = new ArrayList<>();
        members = new ArrayList<>();
        scnr = new Scanner(System.in);

        // Add sample books to test proj
        books.add(new Book("Crooked Kingdom", "Leigh Bardugo", "1250076978"));
        books.add(new Book("1984", "George Orwell", "9780451524935"));
        books.add(new Book("The Stone Face", "William Gardner Smith", "1681375168"));

        // Add sample members
        members.add(new Member("John", "M001"));
        members.add(new Member("Alice", "M002"));

        // Sort books by title when start is called
        books = SortHelper.mergeSort(books);
    }
    
    public void start () {
        System.out.println("============================================");
        System.out.println("| Welcome to my Library Management System! |");
        System.out.println("============================================");

        // Menu Loop
        while (true) {
            System.out.println("Main Menu: ");
            System.out.println("1. View all books");
            System.out.println("2. Checkout a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");

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
                System.out.println("Hope you enjoyed your stay. Goodbye!");
                return;
            }
            else {
                System.out.println("Invalid choice please try again.");
            }
        }
    }

    // Display Books
    private void displayBooks () {
        System.out.println("Book List: ");

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    // Prompts the user to choose a book and checks it out if available
    private void checkoutBook () {
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
        }
        else {
            System.out.println("That book is already available.");
        }
    }
}
