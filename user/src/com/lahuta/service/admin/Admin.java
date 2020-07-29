package com.lahuta.service.admin;

import com.lahuta.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private final static String UserName = "Please enter User Name";
    private final static String UserWeight = "Please enter User weight";
    private final static String Complete = "It is done";
    Scanner scanner = new Scanner(System.in);
    List<User> list = new ArrayList<>();

    public void addUser() {
        String name;
        double weight;

        System.out.println(UserName);
        name = scanner.next();

        System.out.println(UserWeight);
        weight = scanner.nextDouble();

        System.out.println(Complete);
        list.add(new User(name, weight));
    }

    public void printAllUsers() {
        System.out.println("---------------------------");
        var i = 1;
        for (User user : list) {
            System.out.println(i + ": " + user);
            i++;
        }
        System.out.println("---------------------------");
    }

    public void deleteUser() {
        printAllUsers();
        System.out.println(UserName);
        int count = scanner.nextInt();
        for (var i = 0; i < list.size(); i++) {
            if (count == i + 1) {
                list.remove(i);
            }
        }
        System.out.println(Complete);
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
            System.out.println(Complete);
        } else if (number2 == 2) {
            System.out.println(UserWeight);
            ChangeUserWeight(user);
            System.out.println(Complete);
        }
    }

    private void changeUserName(User user) {
        System.out.println(UserName);
        user.setName(scanner.next());
        System.out.println(Complete);
    }

    private void ChangeUserWeight(User user) {
        System.out.println(UserWeight);
        user.setWeight(scanner.nextInt());
        System.out.println(Complete);
    }
}