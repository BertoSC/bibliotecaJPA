package com.pepinho.programacion.biblioteca.model;

import jakarta.persistence.EntityManager;

import java.util.List;

public class BookJpaDAO implements DAO<Book>{
    EntityManager em;

    public BookJpaDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Book get(long id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public void save(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();

    }

    @Override
    public void update(Book book) {
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();

    }

    @Override
    public void delete(Book book) {
        em.getTransaction().commit();
        em.remove(book);
        em.getTransaction().commit();

    }

    @Override
    public boolean deleteById(long id) {
        Book temp = get(id);
        delete(temp);
        return true;
    }

    @Override
    public List<Long> getAllIds() {
        return null;
    }

    @Override
    public void updateLOB(Book book, String f) {

    }

    @Override
    public void updateLOBById(long id, String f) {

    }

    @Override
    public void deleteAll() {

    }
}
