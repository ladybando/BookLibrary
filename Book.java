import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Book {
    String title = "n/a";
    String author = "n/a";
    String genre = "n/a";
    static HashMap<String, Integer> catalog = new HashMap<>();

    public static void main(String[] args) {

        getCatalog();
        printCatalog(catalog);
        Book newBook = new Book("Mind of my Mind", "Octavia Butler");

        System.out.println("What would you like to do? Add a book, remove a book, or list by genre?" +
                "Type 'add' to add a book " +
                "Type 'remove to remove a book " +
                "Type 'genre' to list by genre ");
        Scanner input = new Scanner(System.in);
        String answer = input.next();

            if (answer == "add") {
                addBook(newBook);
            } else if (answer == "remove") {
                removeBook(newBook);
            } else if (answer == "genre") {
                getGenreOfBooks(newBook.genre);
            }
        //for (Book book : catalog) {}

    }


    public Book(String book_title, String book_author) {
        this.title = book_title;
        this.author = book_author;
    }
    public Book() {}

    public Book(String book_title) {
        this.title = book_title;
    }

    public Book(String book_title, String book_author, String book_genre) {
        this.title = book_title;
        this.author = book_author;
        this.genre = book_genre;
    }

        // 1. Using maps, create a 'library catalog' of books
        // What should be the key and value for our map?
        // Key = author (string), Value = quantity (int)
        public static Map<String, Integer> getCatalog() {
            List<Book> startingListOfBooks = getListOfInitialBooks();


            // The books we have, the number of copies of each book we have.

            // Loop through my list of books, and add it to my map
            for (Book book : startingListOfBooks) {
                // See if the map already has this book

                boolean bookExists = catalog.containsKey(book.title);

                if (bookExists) {
                    // If it does, add one to the count
                    int currentNumberOfCopies = catalog.get(book.title);
                    currentNumberOfCopies++;
                    catalog.put(book.title, currentNumberOfCopies);
                } else {
                    // If it doesn't, add it to the map
                    catalog.put(book.title, 1);
                }

            }
            System.out.println(catalog);
            return catalog;
        }

        // TODO Create a method that takes in a new book and adds it to the catalog
        public static void addBook(Book book) {
            Map<String, Integer> catalog = getCatalog();
            Scanner input = new Scanner(System.in);
            System.out.println("How many copies would you like to add? ");
            String answer = input.next();
            if (parseInt(answer) >= 1 )
                System.out.println("Enter book title: ");
                book.title = input.next();
                System.out.println("Enter author name: ");
                book.author = input.next();
                System.out.println("Enter genre or n/a: ");
                book.genre = input.next();
                book = new Book(book.title, book.author, book.genre);
                catalog.put(book.title, parseInt(answer));
                catalog.put(book.author, parseInt(answer));
                catalog.put(book.genre, parseInt(answer));
        }

        // TODO Create a method that removes a book from the catalog
        public static void removeBook(Book book) {
            Map<String, Integer> catalog = getCatalog();
            Scanner input = new Scanner(System.in);
            String amountToRemove = ("How many copies would you like to remove? ");
            String answer = input.next(amountToRemove);
            catalog.remove(book,parseInt(answer));
        }

        // TODO Create a method that given a catalog prints a list of all the books and the number of copies the library has
        // IE: "Harry Potter - 3, Think and Grow Rich - 1, Lord of the Flies - 2, ... "
        public static void printCatalog(Map<String, Integer> catalog) {
            catalog = getCatalog();
            for (int i = 0; i < catalog.size(); i++){
                if (!catalog.isEmpty()){
                    System.out.print(catalog);
                }
            }

        }

        // TODO Super challenge: How might we implement a method that lets us return all books of a certain genre?
        // For example, maybe we want all non-fiction books we have in the catalog

        public static void getGenreOfBooks(String genre) {
            Map<String, Integer> catalog = getCatalog();
            for (int i = 0; i < catalog.size(); i++){
                if (catalog.containsKey(genre)){
                    System.out.print(catalog.get(genre));
                }
            }
        }

        static List<Book> getListOfInitialBooks() {
            List<Book> books = new ArrayList<>();

            books.add(new Book("Harry Potter", "JK Rowling"));
            books.add(new Book("Think and Grow Rich", "Napoleon Hill", "Non-Ficiton"));
            books.add(new Book("Start with Why"));
            books.add(new Book("Lord of the Flies"));
            books.add(new Book("The Midnight Library"));
            books.add(new Book("The Giver"));
            books.add(new Book("The Book Thief"));
            books.add(new Book("To Kill a Mockingbird"));
            books.add(new Book("Animal Farm"));
            books.add(new Book("Harry Potter", "JK Rowling"));
            books.add(new Book("Lord of the Flies"));
            books.add(new Book("Harry Potter", "JK Rowling"));
            books.add(new Book("To Kill a Mockingbird"));
            books.add(new Book("Harry Potter", "JK Rowling"));
            books.add(new Book("Wild Seed", "Octavia Butler", "Fiction"));


            return books;
        }


}
