package com.joelallison;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String dir = System.getProperty("user.dir");

        File wordlistFile = new File(dir + "\\src/com/joelallison/hangmanList.txt");

        Scanner fileReader = new Scanner(wordlistFile);

        ArrayList<String> words = new ArrayList<String>();

        while (fileReader.hasNextLine()) {
            String word = fileReader.nextLine();
            words.add(word);
        }
        fileReader.close();

        //hangman list found at https://www.wordnik.com/lists/food--21


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
        System.out.println("Food related hangman!\nList found at https://www.wordnik.com/lists/food--21\nHave fun!\n\nThe word is " + chosenWord.length() + " characters long.\n");


        do {
            //print the word
            System.out.println();
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

            if(chosenWord.indexOf(guess) == -1){
                System.out.println("Nope!");
            }

            chances--;
        } while (guessed.contains(false) && chances > 0);
        for (int i = 0; i < chosenWord.length(); i++) {
            System.out.print(chosenWord.charAt(i) + " ");
        }
        if (chances > 0){
            System.out.println("\nYou got it!");
        }else{
            System.out.println("\nBetter luck next time...");
        }
    }
}
