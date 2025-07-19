/**
 * Name: Michael Miralles
 * Date: July 18, 2025
 * Description: This class represents a Book object in the Library Management System.
 *              Each book contains a title, author, ISBN, and availability status.
 *              Includes methods for checking out, returning, and displaying book info.
 */

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private BookQueue waitlist;

    // Default constructor
    public Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.isAvailable = true;
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable =  true;
        this.waitlist = new BookQueue();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public BookQueue getWaitlist() {
        return waitlist;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Mark as checked out
    public void checkout() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been checked out.");
        }
        else {
            System.out.println("I'm sorry but " + title + " has already been checked out.");
        }
    }

    // Mark as returned
    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    // Returns string showing the book's details
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (ISBN: " + isbn + ")" + (isAvailable ? " - Available" : " - Checked Out");
    }
}