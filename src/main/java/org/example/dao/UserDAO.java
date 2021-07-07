package org.example.dao;

import org.example.entity.User;

public interface UserDAO {

    void saveUser(User user);
    User getUser(String userId);
    boolean isAdmin(String userId);

}
