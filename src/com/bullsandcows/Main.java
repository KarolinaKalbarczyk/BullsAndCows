package com.bullsandcows;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("How many digits should the random number contain?");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

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

        if(n < 10) {
            System.out.println("The random secret number is " + String.join(delimiter, linkedHashSetToArray).substring(0,n) + ".");
        } else {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        }

    }
}