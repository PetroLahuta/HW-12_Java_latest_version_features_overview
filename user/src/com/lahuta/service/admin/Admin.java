package com.lahuta.service.admin;

import com.lahuta.model.user.User;
import com.lahuta.util.ConsoleInputUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private final static String USER_NAME = "Please enter User Name";
    private final static String USER_WEIGHT = "Please enter User weight";
    private final static String USER_NUMBER = "Please enter number of User";
    private final static String COMPLETE = "It is done";
    private Scanner scanner = new Scanner(System.in);
    private ConsoleInputUtil consoleInputUtil = new ConsoleInputUtil();
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
        System.out.println(USER_NUMBER);
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
        System.out.println("Choose number of user");
        printAllUsers();


        var number = consoleInputUtil.read(1, list.size());
        user = list.get(number - 1);
        System.out.println("What need to change?" + "\n1. Name" + "\n2. Weight");
        var number2 = scanner.nextInt();
        if (number2 == 1) {
            changeUserName(user);
            System.out.println(COMPLETE);
        } else if (number2 == 2) {
            ChangeUserWeight(user);
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

    public void exit() {
        System.out.println("You have chosen to exit" + "\n" + COMPLETE);
        System.exit(0);
    }
}