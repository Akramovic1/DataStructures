/*********************************************************************
 * Copyright (C) 2020-2021 Ahmed Akram <eng.akramovic@gmail.com>     *
 *                                                                   *
 * This file is part of Data Structures I projects .                 *
 *                                                                   *
 * The code can not be copied and/or distributed without the express *
 * permission of Ahmed Akram                                         *
 *********************************************************************/
package eg.edu.alexu.csd.datastructure.hangman.cs18010056;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String[] words = { "Tesla" };
        Hangman game = new Hangman();
        Scanner scn = new Scanner(System.in);
        game.setDictionary(words);
        System.out.print("Please enter the total numbers of guesses ");
        game.setMaxWrongGuesses(scn.nextInt());
        System.out.println(game.getHidden());
        while (game.getMaxWrongGuesses() > 1 && !game.isWin()) {
            System.out.println("Maximum numbers of guesses :" + game.getMaxWrongGuesses());
            System.out.println("Enter the new character :");
            System.out.println(game.guess(scn.next().charAt(0)));
            System.out.println();
            System.out.println();
            System.out.println();
        }
        if (game.getMaxWrongGuesses() <= 1)
            game.loser();
        else
            game.winner();
        scn.close();
    }
}