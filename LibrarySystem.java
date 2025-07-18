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

        // Add sample members
        members.add(new Member("John", "M001"));
        members.add(new Member("Alice", "M002"));
    }
    
    public void start () {
        System.out.println("============================================");
        System.out.println("| Welcome to my Library Management System! |");
        System.out.println("============================================");

        // Menu Loop
        while (true) {
            System.out.println("Main Menu: ");
            System.out.println("1. View all books");
            System.out.println("2. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scnr.nextInt();
            scnr.nextLine();

            if (choice == 1) {
                displayBooks();
            }
            else if (choice == 2) {
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

        for (Book b : books) {
            System.out.println(b);
        }
    }
}
