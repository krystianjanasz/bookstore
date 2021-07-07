package org.example.dao;

import org.example.entity.Author;
import org.example.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Author> getAuthors() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Author> query = currentSession.createQuery("FROM Author");
        List<Author> authors = query.getResultList();
        System.out.println(authors);
        return authors;
    }

    @Override
    public void saveAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.save(author);
    }

    @Override
    public Author getAuthor(int author_id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Author.class, author_id);
    }

    @Override
    public void deleteAuthor(int author_id) {

    }
}
