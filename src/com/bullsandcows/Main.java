package com.bullsandcows;

import java.util.Scanner;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        System.out.println("Please, enter the secret code's length:");

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if(n > 10 || n < 0){
            System.out.println("Error: can't generate a secret number with a length of " + n + " because there aren't enough unique digits.");
            System.exit(0);
        }

        long pseudoRandomNumber = System.nanoTime();

        String newS = Long.toString(pseudoRandomNumber);
        String[] S = newS.split("");

        LinkedHashSet<String> hs = new LinkedHashSet<String>();

        for(int i = 0; i < S.length; i++){
            hs.add(S[i]);
        }

        String[] linkedHashSetToArray = new String[hs.size()];
        hs.toArray(linkedHashSetToArray);

        //the first digit cannot be zero
        if(linkedHashSetToArray[0] == "0"){
            String temp = linkedHashSetToArray[0];
            linkedHashSetToArray[0] = linkedHashSetToArray[1];
            linkedHashSetToArray[1] = temp;
        }

        String delimiter = "";
        String result = String.join(delimiter, linkedHashSetToArray).substring(0,n);

        System.out.println("Okay, let's start a game!");

        int bulls = 0;
        int turn = 1;

        while(bulls != n){

            int cows = 0;
            bulls = 0;
            System.out.println("Turn " + turn + " :");
            Scanner scanner = new Scanner(System.in);

            //the user gives his number 
            String fromUser = scanner.nextLine();

            for(int i = 0; i < n; i++){
                if(fromUser.charAt(i) == result.charAt(i)){
                    bulls++;
                }
                for (int j = i+1; j < n; j++){
                    if(fromUser.charAt(i) == result.charAt(j)){
                        cows++;
                    }
                }
            }

            if(cows > 0 && bulls > 0){
                System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
            } else if (cows > 0 && bulls == 0){
                System.out.println("Grade: " + cows + " cow(s).");
            } else if (cows == 0 && bulls > 0){
                System.out.println("Grade: " + bulls + " bull(s).");
            } else if (bulls == 0 && cows == 0){
                System.out.println("Grade: None.");
            }

            turn++;
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }
}
