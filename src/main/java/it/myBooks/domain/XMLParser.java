package it.myBooks.domain;

import it.myBooks.interfacce.Parser;

import java.util.List;

public class XMLParser implements Parser {
    @Override
    public void read() throws DataException {
        System.out.println("Ciao");
    }

    @Override
    public List<Book> getBooks() {
        return null;
    }

    @Override
    public List<Author> getAuthors() {
        return null;
    }
}

// REGOLE DELL'OVERRIDE - può cambiare?
// - Nome della funzione: NO
// - Parametri della funzione: NO, devono essere stesso tipo e avere stesso ordine (stessa firma)
// - Eccezioni: posso aggiungere eccezioni checked nella figlia non dichiarate nella madre? NO
// - Eccezioni: posso non lanciare eccezioni nella figlia dichiarate nella madre? SI
// - Visibilità: posso restringere la visibilità di un metodo nella figlia (public->private)? NO
// - Visibilità: posso aumentare la visibilità di un metodo nella figlia (protected->public)? SI
// - Tipo di ritorno: posso cambiarlo arbitrariamente? NO
// - Tipo di ritorno: posso fargli ritornare una madre del tipo originario? NO
// - Tipo di ritorno: posso fargli ritornare un tipo figlio? SI   ------Tipo di ritorno co-variante-----