package com.java.test.project.services.userService;

import com.java.test.project.dao.usersDao.UserDao;
import com.java.test.project.dao.usersDao.UserDaoImpl;
import com.java.test.project.models.Auto;
import com.java.test.project.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private UserDao usersDao = new UserDaoImpl();

    public UserServiceImpl() {
    }

    @Override
    public User findUser(Integer id) {
        if(usersDao.findById(id) == null){
            System.out.println("User id: '" + id + "' can't be found");
        }
        return usersDao.findById(id);
    }

    @Override
    public void saveUser(User user) {
        usersDao.save(user);
    }

    @Override
    public void deleteUser(User user) {
      try {
          usersDao.delete(user);
      }
        catch (Exception e){
          System.out.println("User is " + user + " - can't be deleted");
        }
    }

    @Override
    public void updateUser(User user) {
        usersDao.update(user);
    }

    @Override
    public void changeName(String newName) {
      usersDao.changeName(newName);
    }

    @Override
    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    @Override
    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }
}
