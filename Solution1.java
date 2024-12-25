import java.util.ArrayList;

    //class book
    class Book {
        private int bookID;
        private String title;
        private String author;
        private boolean isAvailable;

        //parameterised constructor
        public Book(int bookID, String title, String author, boolean isAvailable) {
            this.bookID = bookID;
            this.title = title;
            this.author = author;
            this.isAvailable = isAvailable;
        }
        //getter methods
        public int getBookID(){
            return bookID;
        }
        public String getTitle(){
            return title;
        }
        public String getAuthor(){
            return author;
        }
        public boolean isAvailable(){
            return isAvailable;
        }
        public void setAvailable(boolean available){
            isAvailable = available;
        }
        @Override
        public String toString() {
            return "Book[ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable + "]";
        }
    }
    //library class
    class Library{
        private ArrayList<Book> books;

        public Library() {
            books = new ArrayList<>();
        }
        //method to add book
        public void addBook(Book book) {
            books.add(book);
            System.out.println("Book added: "+ book);
        }
        //method to remove book
        public void removeBook(int bookID) {
            for (Book book : books) {
                if (book.getBookID()==bookID) {
                    books.remove(book);
                    System.out.println("Book removed: "+book);
                    return;
                }
            }
            System.out.println("Book with ID "+ bookID+" not found.");
        }
        //method to search book
        public Book searchBook(int bookID) {
            for (Book book : books) {
                if (book.getBookID() == bookID) {
                    System.out.println("Book found: "+book);
                    return book;
                }
            }
            System.out.println("Book with ID "+ bookID+" not found.");
            return null;
        }
        //method to display books
        public void displayBooks() {
            if (books.isEmpty()) {
                System.out.println("No books in the library.");
            } else {
                System.out.println("Books in the Library:");
                for (Book book : books) {
                    System.out.println(book);
                }
            }
        }
    }
public class Solution1 {
    public static void main(String[] args) {
        Library library = new Library();

        //add books
        library.addBook(new Book(101, "Java for Beginners", "John Doe", true));
        library.addBook(new Book(102, "Python Crash Course", "Jane Smith", false));
        library.addBook(new Book(103, "The Lord of the Rings", "J.R.R. Tolkien", true));

        //search
        Book book = library.searchBook(102);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found!");
        }

        //display books
        library.displayBooks();

        //remove book
        library.removeBook(101);
        library.displayBooks();


    }
}
