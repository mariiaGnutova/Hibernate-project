package com.java.test.project;

import com.java.test.project.models.Auto;
import com.java.test.project.models.User;
import com.java.test.project.services.autoService.AutoService;
import com.java.test.project.services.autoService.AutoServiseImpl;
import com.java.test.project.services.userService.UserService;
import com.java.test.project.services.userService.UserServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
		AutoService autoService = new AutoServiseImpl();

        User user = new User("Sasha",26);
        userService.saveUser(user);
		User user2 = new User("Dasha",26);
		userService.saveUser(user2);

        System.out.println("One" + userService.findUser(1));

        Auto ferrari = new Auto("Ferrari", "red");
		ferrari.setUser(user2);
		autoService.save(ferrari);

        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
		autoService.save(ford);

        userService.updateUser(user);
		userService.updateUser(user2);
        autoService.update(ferrari);
		autoService.update(ford);

		printAllUsers(userService);
		printAllAutos(autoService);
		userService.changeName("5555555");

		userService.deleteUser(userService.findUser(user2.getId()));

		printAllUsers(userService);
		printAllAutos(autoService);


    }
    public static void printAllUsers (UserService userService){
		List<User> allUsers = userService.findAllUsers();
		Map<Integer, String> idAndName = allUsers.stream()
				.collect(Collectors.toMap(User::getId,
						User::getName));

		idAndName.entrySet().stream().forEach(e -> System.out.println(e));
	}
	public static void printAllAutos (AutoService autoService){
		List<Auto> allAutos = autoService.findAllAutos();
		Map<Integer, String> idAndModel = allAutos.stream()
				.collect(Collectors.toMap(Auto::getId,
						Auto::getModel));

		idAndModel.entrySet().stream().forEach(e -> System.out.println("Car: " + e));
	}
}
