package com.bullsandcows;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        int[] number = new int[4];

        //generating a guessable number
        for (int i = 0; i < 4; i++) {
            number[i] = random.nextInt(10);
        }

        System.out.println("Enter your 4-digit number:");

        //the user gives his number
        String fromUser = scan.nextLine();
        String[] s = fromUser.split("");
        int[] user = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            user[i] = Integer.parseInt(s[i]);
        }

        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < 4; i++) {
            if (user[i] == number[i]) {
                bulls++;
            }
            for (int j = i + 1; j < 4; j++) {
                if (user[i] == number[j]) {
                    cows++;
                }
            }
        }

        if (cows > 0 && bulls > 0) {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + Arrays.toString(number).replaceAll("[\\,\\[\\]\\ ]", ""));
        } else if (cows > 0 && bulls == 0) {
            System.out.println("Grade: " + cows + " cow(s). The secret code is " + Arrays.toString(number).replaceAll("[\\,\\[\\]\\ ]", ""));
        } else if (cows == 0 && bulls > 0) {
            System.out.println("Grade: " + bulls + " bull(s). The secret code is " + Arrays.toString(number).replaceAll("[\\,\\[\\]\\ ]", ""));
        } else {
            System.out.println("Grade: None. The secret code is " + Arrays.toString(number).replaceAll("[\\,\\[\\]\\ ]", ""));
        }
    }
}