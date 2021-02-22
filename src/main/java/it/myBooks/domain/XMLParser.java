package it.myBooks.domain;

import it.myBooks.interfacce.Parser;

import java.io.IOException;
import java.util.ArrayList;

public class XMLParser implements Parser {
    @Override
    public void read() throws IOException {

    }

    @Override
    public ArrayList<Book> getBookList() {
        return null;
    }

    @Override
    public ArrayList<Author> getAuthorList() {
        return null;
    }
}
