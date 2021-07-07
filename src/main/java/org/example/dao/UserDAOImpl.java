package org.example.dao;

import org.example.entity.Authority;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User getUser(String userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("SELECT u from User u where u.username=:id", User.class)
                .setParameter("id", userId);
        return query.uniqueResult();
    }

    @Override
    public boolean isAdmin(String userName){
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Authority> query = currentSession.createQuery("SELECT a FROM Authority a WHERE a.username=:id AND a.authority ='ROLE_ADMIN'", Authority.class)
                .setParameter("id", userName);
        if(query.getResultList().size() != 0){
            return true;
        }
        return false;
    }
}
