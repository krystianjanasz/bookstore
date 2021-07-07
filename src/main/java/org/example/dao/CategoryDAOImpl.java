package org.example.dao;

import org.example.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Category> getCategories() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Category> query = currentSession.createQuery("FROM Category");
        List<Category> categories = query.getResultList();
        System.out.println(categories);
        return categories;
    }

    @Override
    public void saveCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
    }

    @Override
    public Category getCategory(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }

    @Override
    public void deleteCategory(int id) {

    }
}