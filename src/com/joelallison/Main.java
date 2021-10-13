package com.joelallison;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //hangman list found at https://www.wordnik.com/lists/food--21
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("takoyaki",
                "pesto",
                "enoki",
                "dim sum",
                "banh beo",
                "macaron",
                "poutine",
                "filet mignon",
                "fried rice",
                "wonton",
                "lo mein",
                "chow mein",
                "bulgogi",
                "kimbap",
                "pasta",
                "potsticker",
                "peking duck",
                "croissant",
                "eggroll",
                "spring roll",
                "hummus",
                "tator tot",
                "naan",
                "crepe",
                "ahi tuna",
                "poke",
                "udon",
                "sashimi",
                "sushi",
                "okonomiyaki",
                "pad thai",
                "fries",
                "quesadilla",
                "burrito",
                "taco",
                "chai",
                "tea",
                "pho",
                "bun bo hue",
                "bok choy",
                "burger",
                "dumpling",
                "hot pot",
                "shabu shabu",
                "ramen",
                "curry"
        ));

        ArrayList<Boolean> guessed = new ArrayList<Boolean>();

        Random random = new Random();
        Scanner input = new Scanner(System.in);

        String chosenWord = words.get((random.nextInt(words.size())));

        for (int i = 0; i < chosenWord.length(); i++) {
            if (chosenWord.charAt(i) != ' '){
                guessed.add(false);
            }else{
                guessed.add(true);
            }
        }

        char guess = '0';
        int chances = chosenWord.length() + 4;
        System.out.println("Food related hangman!\nList found at https://www.wordnik.com/lists/food--21\nHave fun!\n\n");

        do {
            //print the word
            for (int i = 0; i < chosenWord.length(); i++) {
                if (guessed.get(i).equals(true)) {
                    System.out.print(chosenWord.charAt(i));
                } else {
                    System.out.print("_");
                }
                System.out.print(" ");
            }
            System.out.println("");
            System.out.println("Guess a letter: ");
            guess = input.next().charAt(0);

            for (int i = 0; i < chosenWord.length(); i++) {
                if (guess == chosenWord.charAt(i)) {
                    guessed.set(i, true);
                }
            }
            chances--;
        } while (guessed.contains(false) && chances > 0);
        for (int i = 0; i < chosenWord.length(); i++) {
            System.out.print(chosenWord.charAt(i) + " ");
        }
    }
}
