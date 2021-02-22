package it.myBooks.runCode;

import it.myBooks.domain.*;
import it.myBooks.interfacce.Parser;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;


public class Startup {

    public static void main(String[] args) {


        // create a new parser with the ourFilePath as its path
        Path ourFilePath = Path.of("files/mybooks.csv");
        CsvParser newParser = new CsvParser(ourFilePath);
//        Parser newParser = new XMLParser();
        // Pazienza
//        try {
//            newParser.read();
//        } catch (DataException e) {
//            e.printStackTrace();
//        }


        // Exception handling
        BookController bookController = null;
        try {
            // create a new controller that will print the data
            bookController = new BookController(newParser);

            // everything that references the bookController stays inside the 'try'
            // print the data through the controller here
            Collection<Book> newBooks = bookController.getBooks();

            Collection<Author> newAuthors = bookController.getAuthors();

            // do the authors repeat in the list?
            System.out.println(newAuthors.size());

            // Prova per entrare nel 'catch'
//            if(1 == 1){
//                throw new DataException(" ", new Exception());
//            }
        } catch (DataException e) {
            System.out.println("DataException: Errore, contattare l'amministratore!");
        } catch (Exception e){
            System.out.println("Catchate tutte le altre eccezioni!");
        } finally {
            System.out.println("finally!!!");
            // Dare qualunque codice come argomento tranne '0'
            System.exit(-1);
        }


    }


}
