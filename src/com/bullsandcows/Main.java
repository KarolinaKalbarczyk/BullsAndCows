package com.bullsandcows;

import java.util.Scanner;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        System.out.println("Please, enter the secret code's length:");

        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();


        if (!num.matches("[0-9]*")) {
            System.out.println("Error: " + "\"" + num + "\" " + "isn't a valid number.");
            System.exit(0);
        }
        else if (Integer.parseInt(num) > 36 || Integer.parseInt(num) < 1) {
            System.out.println("Error: can't generate a secret number with a length of " + num + " because there aren't enough unique digits.");
            System.exit(0);
        }

        int n =  Integer.parseInt(num);
        System.out.println("Input the number of possible symbols in the code:");
        String em = scan.nextLine();

        if (!em.matches("[0-9]*")) {
            System.out.println("Error: " + "\"" + em + "\" " + "isn't a valid number.");
            System.exit(0);
        }

        int m = Integer.parseInt(em);
        if(Integer.parseInt(em) < Integer.parseInt(num)) {
            System.out.println("Error: it's not possible to generate a code with a length of " + n + " with " + m + " unique symbols.");
            System.exit(0);
        }else if(Integer.parseInt(em) > 36){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }

        //create new ArrayList
        ArrayList<String> aListColors = new ArrayList<String>();

        String[] otherList = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};


        aListColors.addAll(Arrays.asList(otherList));

        String[] newS = new String[m];

        for(int i =0; i < m; i++){
            int randomIndex = (int) (Math.random() * m);
            newS[i] = aListColors.get(randomIndex);
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < newS.length; i++) {
            sb.append(newS[i]);
        }

        String str = sb.toString();

        String[] S = str.split("");

        LinkedHashSet<String> hs = new LinkedHashSet<String>();

        for(int i = 0; i < S.length; i++){
            hs.add(S[i]);
        }

        String[] linkedHashSetToArray = new String[hs.size()];
        hs.toArray(linkedHashSetToArray);

        String delimiter = "";
        String result = String.join(delimiter, linkedHashSetToArray).substring(0,n);

        String star = "*";
        String sign = star.repeat(n);

        System.out.print("The secret is prepared: " + sign + " ");

        if(m < 9){
            System.out.println(" (0-" + (m-1) + ")");
        } else {
            System.out.print("(0-9, ");
            System.out.println("a-" + otherList[m-1] + ")");
        }

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