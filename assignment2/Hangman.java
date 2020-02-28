/*********************************************************************
 * Copyright (C) 2020-2021 Ahmed Akram <eng.akramovic@gmail.com>     *
 *                                                                   *
 * This file is part of Data Structures I projects .                 *
 *                                                                   *
 * This code can not be copied and/or distributed without the express *
 * permission of Ahmed Akram                                         *
 *********************************************************************/
package eg.edu.alexu.csd.datastructure.hangman.cs18010056;
import java.util.*;
import java.io.BufferedReader ;
import java.io.FileReader ;

public class Hangman implements IHangman {
    private int MW ;
     private String[] words;
     private boolean OP = false;
     private String randomWord;
     private String hiddenWord;
     private int WAL = 0;

        public void readFromFile () {
            try {
                BufferedReader br = new BufferedReader(new FileReader("Dictionary.txt"));
                this.linesCounter("Dictionary.txt");
                this.words = new String[this.WAL];
                for (int i = 0; i < this.words.length; i++) {
                    this.words[i] = br.readLine();
                }

                br.close();
            } catch (Exception e) {
                System.out.println("File Not Found!!");
            }
        }
        public void linesCounter (String fileName){
            try {
                BufferedReader fileTraverser = new BufferedReader(new FileReader(fileName));
                while (fileTraverser.readLine() != null)
                    this.WAL++;
                fileTraverser.close();
            } catch (Exception e) {
                System.out.println("File not found!!");
            }
        }
        @Override
        public void setDictionary (String[]words){
            this.OP = false;
            this.words = new String[100];
            this.words = words;
            this.WAL = this.words.length;
        }
        @Override
        public String selectRandomSecretWord () {
            if (OP)
                return null;
            if (this.WAL == 0)
                return null;
            else {
                int randomLineNumber;
                Random randomNumberGenerator = new Random();
                randomLineNumber = randomNumberGenerator.nextInt(this.WAL);
                this.randomWord = this.words[randomLineNumber];
                return this.randomWord;
            }
        }

        @Override
        public String guess (Character c){
            boolean flag = false;
            if (!OP)
                this.hiddenWord = getHidden();
            if (c == null)
                return null;
            else if (this.MW > 0) {
                String temp = "";
                for (int i = 0; i < this.randomWord.length(); i++) {
                    if (Character.toLowerCase(this.randomWord.charAt(i)) == Character.toLowerCase(c)) {
                        temp += this.randomWord.charAt(i);
                        flag = true;
                    } else if (this.hiddenWord.charAt(i) != '-') {
                        temp += this.hiddenWord.charAt(i);
                    } else
                        temp += "-";

                }
                this.hiddenWord = temp;
                if (!flag)
                    this.MW--;
                if (this.MW == 0)
                    return null;
                else
                    return this.hiddenWord;
            } else
                return null;
        }
        @Override
        public void setMaxWrongGuesses (Integer max){
            if (max == null)
                this.MW = 0;
            else
                this.MW = max;
        }

        public String setHidden ( int lettersNumber){
            String hiddenWord = "";
            for (int i = 0; i < lettersNumber; i++) {
                hiddenWord += "-";
            }
            return hiddenWord;
        }

        public int getMaxWrongGuesses () {
            return this.MW;
        }

        public boolean isWin () {
            if (this.hiddenWord.equalsIgnoreCase(this.randomWord))
                return true;
            return false;
        }

        public void loser () {
            System.out.println("Sorry you lose! :(");
        }

        public void winner () {
            System.out.println("Congratulations you win ! :)");
        }

        public String getHidden () {
            this.selectRandomSecretWord();
            this.hiddenWord = setHidden(this.randomWord.length());
            OP = true;
            return this.hiddenWord;
        }
    }
