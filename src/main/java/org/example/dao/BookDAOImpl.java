package org.example.dao;

import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{

    private SessionFactory sessionFactory;

    @Override
    public List<Book> getBooks() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Book> query = currentSession.createQuery("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.authors a", Book.class);
        List<Book> books = query.getResultList();
        return books;
    }

    @Override
    public void saveBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
    }

    @Override
    public Book getBook(int book_id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Book.class, book_id);
    }

    @Override
    public void deleteBook(int bookId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Book WHERE id = :id");
        query.setParameter("id", bookId);
        query.executeUpdate();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
}
