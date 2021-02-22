package it.myBooks.interfacce;

import it.myBooks.domain.Author;
import it.myBooks.domain.Book;

import java.io.IOException;
import java.util.ArrayList;

public interface Parser {
    // read method reads the file with the filePath as its path
    void read() throws IOException;

    ArrayList<Book> getBookList();

    ArrayList<Author> getAuthorList();
}
