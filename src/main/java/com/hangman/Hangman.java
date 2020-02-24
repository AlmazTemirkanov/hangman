package com.hangman;


import java.io.*;

public class Hangman {
    private static File file = new File("C:\\Users\\Almaz\\Desktop\\Java\\test.txt");
    private static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String word;

    static {
        try {
            word = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
    private static int count = 0;

    public Hangman() {
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (count < 6 && asterisk.contains("*")) {
            System.out.println("Введите букву");
            System.out.println(asterisk);
            String guess = bufferedReader.readLine();
            hang(guess);
        }
        bufferedReader.close();
    }

    public static void hang(String guess) {
        String newasterisk = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newasterisk += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk += word.charAt(i);
            } else {
                newasterisk += "*";
            }
        }

        if (asterisk.equals(newasterisk)) {
            count++;
            hangman();
        } else {
            asterisk = newasterisk;
        }
        if (asterisk.equals(word)) {
            System.out.println("_/﹋\\_");
            System.out.println("(҂`_´]");
            System.out.println("<,︻╦╤─");
            System.out.println("/﹋\\");
            System.out.println("Все верно! :) " + word);
        }
    }

    public static void hangman() {
        if (count == 1) {
            System.out.println("(•_•)");
            System.out.println("<) )╯ Хоп");
            System.out.println("/ \\");
            System.out.println("Не угадал, попробуйте еще раз");

        }
        if (count == 2) {
            System.out.println("\\(•_•)");
            System.out.println("( (> Хей");
            System.out.println("/ \\");
            System.out.println("Не угадал, попробуйте еще раз");
        }
        if (count == 3) {
            System.out.println("(•_•)");
            System.out.println("<) )> Ла ла лей");
            System.out.println("/ \\");
            System.out.println("Не угадал, попробуйте еще раз");
        }
        if (count == 4) {
            System.out.println("(•_•)");
            System.out.println("(/ )/");
            System.out.println("/ |");
            System.out.println("Не угадал, попробуйте еще раз");
        }
        if (count == 5) {
            System.out.println("(•_•)\uD80C\uDCBA");
            System.out.println("<) )╯");
            System.out.println("/ \\");
            System.out.println("Не угадал, попробуйте еще раз");
        }

        if (count == 6) {
            System.out.println("_______________");
            System.out.println("|. |           |");
            System.out.println("|. |         (•_•)");
            System.out.println("|. |\t      -|-");
            System.out.println("|. |\t       /\\ ");
            System.out.println("|. |");
            System.out.println("Игра завершена!");

        }
    }
}

