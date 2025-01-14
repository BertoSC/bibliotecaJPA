package com.pepinho.programacion.biblioteca.view;

import com.pepinho.programacion.biblioteca.model.BibliotecaJpaManager;
import com.pepinho.programacion.biblioteca.model.BibliotecaJpaSimpleManager;
import com.pepinho.programacion.biblioteca.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class APP {
        public static void main(String[] args) {
           BibliotecaJpaSimpleManager bib = BibliotecaJpaSimpleManager.getInstance("bibliotecaH2");
           EntityManagerFactory enf= bib.getEmFactory();
            EntityManager en = enf.createEntityManager();

            Book b = en.find(Book.class, 1L);
            System.out.println(b);

        }
    }


