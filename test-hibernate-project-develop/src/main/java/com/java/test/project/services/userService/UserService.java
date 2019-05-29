package com.java.test.project.services.userService;

import com.java.test.project.models.Auto;
import com.java.test.project.models.User;

import java.util.List;

public interface UserService {
    User findUser(Integer id);
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    void changeName(String newName);
    List<User> findAllUsers();
    Auto findAutoById(int id);
}
