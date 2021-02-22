package it.myBooks.domain;

import it.myBooks.interfacce.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CsvParser implements Parser {

    // set a filePath variable, instantiated by the constructor
    public Path filePath;

    // variable with a list of books
    private Set<Book> books = new HashSet<>();

    // variable with a list of authors
    private Set<Author> authors = new HashSet<>();

    // constructor
    public CsvParser(Path path){
        this.filePath = path;
    }

    // read method reads the file with the filePath as its path
    @Override
    public void read() throws DataException{

        // Try with resources
        try (BufferedReader buf = new BufferedReader(new FileReader(filePath.toFile()))) {

            // Current line of the file being read
            String currentLine;

            // while there are lines, read them
            while((currentLine = buf.readLine()) != null){

                // put the content of the line in an array of strings
                String[] contentOfLine = currentLine.split(",");

                Author newAuthor = createAuthorFromCsvString(currentLine);

                this.authors.add(newAuthor);

                Book newBook = createBookFromCsvString(currentLine);
                // set author of the book
                newBook.setAuthor(newAuthor);


                // add this book to this author's list of books, if it doesn't contain it yet

                // save the book in the book list
                this.books.add(newBook);

            }
        } catch(IOException e) {
            throw new DataException(e.getMessage(),e);
        }


    }

    private Author createAuthorFromCsvString(String line){

        String[] contentOfLine = line.split(",");

        // first create a new author and set his/her values
        Author newAuthor = new Author();
        // author's name, trimmed and capitalized
        String trimmedName = contentOfLine[0].trim();
        String capitalizedName = trimmedName.substring(0, 1).toUpperCase() + trimmedName.substring(1);
        newAuthor.setName(capitalizedName);
        // author's last name, trimmed and capitalized
        String trimmedLastName = contentOfLine[1].trim();
        String capitalizedLastName = trimmedLastName.substring(0, 1).toUpperCase() + trimmedLastName.substring(1);
        newAuthor.setLastName(capitalizedLastName);
        // author's date of birth, trimmed
        newAuthor.setDateOfBirth(contentOfLine[2].trim());

        return newAuthor;
    }

    private Book createBookFromCsvString(String line){
        String[] contentOfLine = line.split(",");

        // then create the book written by that author
        Book newBook = new Book();
        // title of the book, trimmed and capitalized
        String trimmedTitle = contentOfLine[3].trim();
        String capitalizedTitle = trimmedTitle.substring(0,1).toUpperCase() + trimmedTitle.substring(1);
        newBook.setTitle(capitalizedTitle);
        // year the book was published
        newBook.setYearPublished(Integer.parseInt(contentOfLine[4].trim()));
        // number of pages
        newBook.setNumPages(Integer.parseInt(contentOfLine[5].trim()));

        return newBook;
    }

    @Override
    public Collection<Book> getBooks() {
        return books;
    }

    @Override
    public Collection<Author> getAuthors() {
        return authors;
    }
}
