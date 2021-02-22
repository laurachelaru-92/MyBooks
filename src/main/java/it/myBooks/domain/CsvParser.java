package it.myBooks.domain;

import it.myBooks.interfacce.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class CsvParser implements Parser {

    // set a filePath variable, instantiated by the constructor
    public Path filePath;

    // variable with a list of books
    private ArrayList<Book> bookList = new ArrayList<>();

    // variable with a list of authors
    private ArrayList<Author> authorList = new ArrayList<>();

    // constructor
    public CsvParser(Path path){
        this.filePath = path;
    }

    // read method reads the file with the filePath as its path
    @Override
    public void read() throws IOException{

        // Try with resources
        try (BufferedReader buf = new BufferedReader(new FileReader(filePath.toFile()))) {

            // Current line of the file being read
            String currentLine;

            // while there are lines, read them
            while((currentLine = buf.readLine()) != null){

                // put the content of the line in an array of strings
                String[] contentOfLine = currentLine.split(",");

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

                // if the authorsList doesn't include this author, add him/her to it
                if(this.authorList.size() > 0){
                    for (Author author:this.authorList) {
                        if(author.compareTo(newAuthor) == 0){
                            this.authorList.add(newAuthor);
                            break;
                        }
//                        if (!(author.getName().equals(newAuthor.getName()) && author.getLastName().equals(newAuthor.getLastName()) && author.getDateOfBirth().equals(newAuthor.getDateOfBirth()))) {
//                            this.authorList.add(newAuthor);
//                            break;
//                        }
                    }
                } else {
                    this.authorList.add(newAuthor);
                }
//                if(this.authorList.size() > 0) {
//                    if(!newAuthor.getName().equals(this.authorList.get(0).getName())) {
//                        this.authorList.add(newAuthor);
//                    }
//                } else {
//                    this.authorList.add(newAuthor);
//                }

                // then create the book written by that author
                Book newBook = new Book();
                // title of the book, trimmed and capitalized
                String trimmedTitle = contentOfLine[3].trim();
                String capitalizedTitle = trimmedTitle.substring(0,1).toUpperCase() + trimmedTitle.substring(1);
                newBook.setTitle(capitalizedTitle);
                // author of the book
                newBook.setAuthor(newAuthor);
                // year the book was published
                newBook.setYearPublished(Integer.parseInt(contentOfLine[4].trim()));
                // number of pages
                newBook.setNumPages(Integer.parseInt(contentOfLine[5].trim()));

                // add this book to this author's list of books, if it doesn't contain it yet

                // save the book in the book list
                if(!this.bookList.contains(newBook)){
                    this.bookList.add(newBook);
                }
            }
        }
    }

    @Override
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    @Override
    public ArrayList<Author> getAuthorList() {
        return authorList;
    }
}
