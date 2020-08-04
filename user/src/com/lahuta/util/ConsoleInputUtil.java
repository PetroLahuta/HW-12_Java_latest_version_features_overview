package com.lahuta.util;

import java.util.Scanner;

public class ConsoleInputUtil {
    private Scanner scanner;

    public ConsoleInputUtil() {
        this.scanner = new Scanner(System.in);
    }

    public Integer read(int min, int max) {
        String next = scanner.next();
        Integer choise = Integer.parseInt(next);
        if (choise >= min && choise <= max) {
            return choise;
        } else {
            throw new NumberFormatException("Input out of bounds");
        }
    }
}
