package it.myBooks.runCode;

import it.myBooks.domain.Author;
import it.myBooks.domain.Book;
import it.myBooks.domain.CsvParser;
import it.myBooks.domain.XMLParser;
import it.myBooks.interfacce.Parser;

import java.nio.file.Path;
import java.util.ArrayList;


public class Startup {

    public static void main(String[] args) {

        // create a new parser with the ourFilePath as its path
        Path ourFilePath = Path.of("files/mybooks.csv");
        CsvParser newParser = new CsvParser(ourFilePath);
//        Parser newParser = new XMLParser();


        // create a new controller that will print the data
        BookController bookController = new BookController(newParser);

        // print the data through the controller here
        ArrayList<Book> newBookList = bookController.myParser.getBookList();
        ArrayList<Author> newAuthorList = bookController.myParser.getAuthorList();

        System.out.println(newAuthorList.size());
//        for (Author author: newAuthorList) {
//            bookController.printAuthorInfos(author);
//        }

    }


}
