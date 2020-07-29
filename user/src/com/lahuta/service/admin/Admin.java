package com.lahuta.service.admin;

import com.lahuta.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private final static String USER_NAME = "Please enter User Name";
    private final static String USER_WEIGHT = "Please enter User weight";
    private final static String COMPLETE = "It is done";
    Scanner scanner = new Scanner(System.in);
    List<User> list = new ArrayList<>();

    public void addUser() {
        String name;
        double weight;

        System.out.println(USER_NAME);
        name = scanner.next();

        System.out.println(USER_WEIGHT);
        weight = scanner.nextDouble();

        System.out.println(COMPLETE);
        list.add(new User(name, weight));
    }

    public void printAllUsers() {
        var i = 1;
        for (User user : list) {
            System.out.println(i + ": " + user);
            i++;
        }
        System.out.println("---------------------------");
    }

    public void deleteUser() {
        printAllUsers();
        System.out.println(USER_NAME);
        int count = scanner.nextInt();
        for (var i = 0; i < list.size(); i++) {
            if (count == i + 1) {
                list.remove(i);
            }
        }
        System.out.println(COMPLETE);
    }

    public void changeUser() {
        User user;
        System.out.println("Choose user");
        printAllUsers();
        var number = scanner.nextInt();
        user = list.get(number - 1);
        System.out.println("What need to change?" + "\n1. Name" + "\n2. Weight");
        var number2 = scanner.nextInt();
        if (number2 == 1) {
            changeUserName(user);
            System.out.println(COMPLETE);
        } else if (number2 == 2) {
            System.out.println(USER_WEIGHT);
            ChangeUserWeight(user);
            System.out.println(COMPLETE);
        }
    }

    private void changeUserName(User user) {
        System.out.println(USER_NAME);
        user.setName(scanner.next());
        System.out.println(COMPLETE);
    }

    private void ChangeUserWeight(User user) {
        System.out.println(USER_WEIGHT);
        user.setWeight(scanner.nextInt());
        System.out.println(COMPLETE);
    }
}