package com.java.test.project;

import com.java.test.project.models.Auto;
import com.java.test.project.models.User;
import com.java.test.project.services.UserService;
import com.java.test.project.services.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        User user = new User("Sasha",26);
        userService.saveUser(user);
		User user2 = new User("Dasha",26);
		userService.saveUser(user2);

        System.out.println("One" + userService.findUser(1));
        Auto ferrari = new Auto("Ferrari", "red");
		ferrari.setUser(user2);

        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);

        userService.updateUser(user);

    }
}
