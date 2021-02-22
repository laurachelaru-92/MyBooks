package it.myBooks.domain;

public class DataException extends Exception{

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
}







// Throwable è madre di Exception ed Error
// Error è la madre di tutti gli errori
