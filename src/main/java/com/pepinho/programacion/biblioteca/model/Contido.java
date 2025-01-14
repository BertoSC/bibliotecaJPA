package com.pepinho.programacion.biblioteca.model;

import java.sql.Connection;
import java.util.Objects;

/**
 * @autor pepecalo
 * CREATE TABLE PUBLIC.Contido (
 * 	idContido INTEGER NOT NULL AUTO_INCREMENT,
 * 	idBook INTEGER NOT NULL,
 * 	contido CHARACTER LARGE OBJECT,
 * 	CONSTRAINT Contido_PK PRIMARY KEY (idContido),
 * 	CONSTRAINT FK_ID_BOOK FOREIGN KEY (idBook) REFERENCES PUBLIC.Book(idBook) ON DELETE CASCADE ON UPDATE CASCADE
 * );
 * CREATE UNIQUE INDEX PRIMARY_KEY_9 ON PUBLIC.Contido (idContido);
 */
public class Contido {

    private Long idContido;
    private Book book;
    private String contido;

    public Contido() {
    }

    public Contido(Book book, String contido) {
        this.book = book;
        this.contido = contido;
    }

    public Contido(Long idContido, Book book) {
        this.idContido = idContido;
        this.book = book;
    }

    public Contido(Long idContido, Book book, String contido) {
        this.idContido = idContido;
        this.book = book;
        this.contido = contido;
    }

    public Long getIdContido() {
        return idContido;
    }

    public void setIdContido(Long idContido) {
        this.idContido = idContido;
    }


    public Book getIdBook() {
        return book;
    }

    public void setIdBook(Book book) {
        this.book = book;
    }

    public String getContido() {
        return contido;
    }

    public void setContido(String contido) {
        this.contido = contido;
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Objects.hashCode(this.idContido);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Contido other)) return false;
        return Objects.equals(this.idContido, other.idContido);
    }

    @Override
    public String toString() {
        return idContido + " (" + book + "): " + contido;
    }
}
