package it.myBooks.interfacce;

import it.myBooks.domain.Author;
import it.myBooks.domain.Book;
import it.myBooks.domain.DataException;

import java.io.IOException;
import java.util.Collection;

public interface Parser {
    // read method reads the file with the filePath as its path
    void read() throws DataException;

    Collection<Book> getBooks();

    Collection<Author> getAuthors();
}
