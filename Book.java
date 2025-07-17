public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book (String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable =  true;
    }

    // Getters
    public String getTitle () {
        return title;
    }

    public String getAuthor () {
        return author;
    }

    public String getIsbn () {
        return isbn;
    }

    public boolean getAvailability () {
        return isAvailable;
    }

    // Setters
    public void setTitle (String title) {
        this.title = title;
    }

    public void setAuthor (String author) {
        this.author = author;
    }

    // TODO: ADD checkout() AND returnBook() methods
}
