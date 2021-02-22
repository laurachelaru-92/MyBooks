package it.myBooks.runCode;

import it.myBooks.domain.Author;
import it.myBooks.domain.Book;
import it.myBooks.domain.CsvParser;
import it.myBooks.interfacce.Parser;

import java.nio.file.Path;


public class BookController {

    public Parser myParser;

//    private CsvParser parser = new CsvParser();

//    public BookController(String fileName){
//        this.myParser = new CsvParser(Path.of(fileName));
//        // Exception handling
//        try {
//            // call newParser's read method to read the file
//            this.myParser.read();
//        } catch (Exception e) {
//            System.out.println("Something went wrong with your file reading. Contact the boss.");
//            e.printStackTrace();
//        }
//    }

    public BookController(Parser parser){
        this.myParser = parser;
        // Exception handling
        try {
            // call myParser's read method to read the file
            this.myParser.read();
        } catch (Exception e) {
            System.out.println("Something went wrong with your file reading. Contact the boss.");
            e.printStackTrace();
        }
    }




    // method that, given a book, prints all the infos
    public void printBookAuthorInfos(Book book) {
        System.out.println("---Book infos---");
        this.printBookInfos(book);
        System.out.println("---Author infos---");
        this.printAuthorInfos(book.getAuthor());
    }

    // method that, given a book, prints all the infos of the book
    public void printBookInfos(Book book){
        System.out.println("Title of the book: " + book.getTitle());
        System.out.println("Author of the book: " + book.getAuthor().getName() + " " + book.getAuthor().getLastName());
        System.out.println("Year the book was published: " + book.getYearPublished());
        System.out.println("Nr of pages of the book: " + book.getNumPages());
    }

    // method that, given an author, prints his/her infos
    public void printAuthorInfos(Author author){
        System.out.println("Author's name: " + author.getName());
        System.out.println("Author's last name: " + author.getLastName());
        System.out.println("Author's date of birth: " + author.getDateOfBirth());
    }

}
