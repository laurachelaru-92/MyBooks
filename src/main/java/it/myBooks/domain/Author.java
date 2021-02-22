package it.myBooks.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Author implements Comparable{

    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private ArrayList<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    public ArrayList<Book> getBooks(){
        return this.books;
    }

    public void addBook(Book b){
        this.books.add(b);
    }

    // in order to verify if the author repeats,
        // we have to compare the name, last name and date of birth of the authors
//    @Override
    public int compareTo(Object o) {
        if(this.name.equals(((Author) o).getName())) {
            if (this.lastName.equals(((Author) o).getLastName())) {
                if (this.dateOfBirth.isEqual((((Author) o).getDateOfBirth()))){
                    return 1;
                }
            }
        }
        return 0;
    }
}
