package com.java.test.project.dao.usersDao;

import com.java.test.project.models.Auto;
import com.java.test.project.models.User;

import java.util.List;

public interface UserDao {
    User findById(Integer id);
    void save(User user);
    void update(User user);
    void delete(User user);
    Auto findAutoById(Integer id);
    void changeName(String name);
    List<User> findAll();
}
