package com.pepinho.programacion.biblioteca.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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
        TypedQuery<Book> consulta = em.createQuery("select b from Book b", Book.class);
        List <Book> libros = consulta.getResultList();
        return libros;
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
        TypedQuery<Long> consulta = em.createQuery("select b.idBook from Book b", Long.class);
        List <Long> ids = consulta.getResultList();
        return ids;

    }

    @Override
    public void updateLOB(Book book, String f) {
        /*em.createQuery("UPDATE Book b SET b.portada = :newValue WHERE b.idBook = :id")
                .setParameter("newValue", f)
                .setParameter("id", book.getIdBook())
                .executeUpdate();*/
        book.setPortada(f);
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();

    }

    @Override
    public void updateLOBById(long id, String f) {
        Book temp = get(id);
        temp.setPortada(f);
        em.getTransaction().begin();
        em.merge(temp);
        em.getTransaction().commit();

    }

    @Override
    public void deleteAll() {
        List <Long> ids = getAllIds();
        for (Long id: ids){
            deleteById(id);
        }
    }
}
