package main.java.com.lahuta.executor;

import com.lahuta.service.admin.Admin;

import java.util.Scanner;

public class Executor {
    Scanner scanner = new Scanner(System.in);
    private Admin admin = new Admin();
    private final String[] adminMenuList = {"1. New user", "2. Change user", "3. Delete user",
            "4. All users", "-----------------------------"};
    private static final String RepeatInput = "Incorrect input! Try again";

    public void printAdminMemu() {
        int choise = 0;
        while (true) {
            printMenus(adminMenuList);
            try {
                choise = scanner.nextInt();
            } catch (NumberFormatException u) {
                System.out.println(RepeatInput);
                printAdminMemu();
            }
            switch (choise) {
                case 1:
                    admin.addUser();
                    break;
                case 2:
                    admin.changeUser();
                    break;
                case 3:
                    admin.deleteUser();
                    break;
                case 4:
                    admin.printAllUsers();
                    break;
            }
        }
    }

    private void printMenus(String[] menus) {
        for (String menu : menus) {
            System.out.println(menu);
        }
    }
}