//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Create an array of StringBuilder to store the words
        StringBuilder[] words = new StringBuilder[20];
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO THE HANGMAN GAME!!\n" +
                "THE GOAL OF THIS GAME IS TO GUESS THE WORD BY TYPING LETTERS\n" +
                "YOU HAVE 8 LIVES, EACH WRONG GUESS WILL TAKE AWAY 1 LIVE\n"+
                "IF YOU HAVE 0 LIVES, THE GAME WILL END\n" +
                "TYPE IN CAPITAL LETTERS ONLY" );

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/words.txt"));
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] wordArray = line.split("\\s+");

                // Store each word in a StringBuilder object
                for (String word : wordArray) {
                    if (word != null && index < words.length) {
                        words[index] = new StringBuilder(word);
                        index++;
                    }
                }

            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate a random index
        Random random = new Random();
        int rand = random.nextInt(20);
        int lv = 8;
        // Print underscores for each character in the selected word
        StringBuilder guess = new StringBuilder(words[rand]);
        StringBuilder mq = new StringBuilder(words[rand]);
        String dq = mq.toString();
        for (int i = 0; i < guess.length(); i++) {
            guess.replace(i, i + 1, "_");
        }
        System.out.println(guess.length());
        System.out.println(guess);

        while (!guess.toString().equals(mq.toString())) {

            char x = scanner.next().charAt(0);
            if (dq.contains(String.valueOf(x))) {
                guess.replace(dq.indexOf(String.valueOf(x)), dq.indexOf(String.valueOf(x)) + 1, String.valueOf(x));
                guess.replace(dq.lastIndexOf(String.valueOf(x)), dq.lastIndexOf(String.valueOf(x)) + 1, String.valueOf(x));
                System.out.println(guess);
            }
            if (!dq.contains(String.valueOf(x))) {
                lv = lv - 1;
                System.out.println("LIVES LEFT: " + lv);
                if (lv == 7) {
                    System.out.println("  *****\n" +
                            "  *\n" +
                            "  *\n" +
                            "  *\n" +
                            "  *\n" +
                            "*****");
                }
                if (lv == 6) {
                    System.out.println("  *****\n" +
                            "  *   |\n" +
                            "  *\n" +
                            "  *\n" +
                            "  *\n" +
                            "*****");
                }
                if (lv == 5) {
                    System.out.println("  *****\n" +
                            "  *   |\n" +
                            "  *   O\n" +
                            "  *\n" +
                            "  *\n" +
                            "  *\n" +
                            "*****");
                }
                if (lv == 4) {
                    System.out.println("  *****\n" +
                            "  *   |\n" +
                            "  *   O\n" +
                            "  *   |\n" +
                            "  *\n" +
                            "  *\n" +
                            "*****");
                }
                if (lv == 3) {
                    System.out.println("  *****\n" +
                            "  *   |\n" +
                            "  *   O\n" +
                            "  *  /|\n" +
                            "  *\n" +
                            "  *\n" +
                            "*****");
                }
                if (lv == 2) {
                    System.out.println("  *****\n" +
                            "  *   |\n" +
                            "  *   O\n" +
                            "  *  /|\\\n" +
                            "  *\n" +
                            "  *\n" +
                            "*****");
                }
                if (lv == 1) {
                    System.out.println("  *****\n" +
                            "  *   |\n" +
                            "  *   O\n" +
                            "  *  /|\\\n" +
                            "  *  /\n" +
                            "  *\n" +
                            "*****");
                }
                if (lv == 0) {
                    System.out.println("  *****\n" +
                            "  *   |\n" +
                            "  *   O\n" +
                            "  *  /|\\\n" +
                            "  *  / \\\n" +
                            "  *\n" +
                            "*****");
                    System.out.println("GAME OVER(");
                    break;
                }



            }
            if(guess.toString().equals(mq.toString())){
                System.out.println("CONGRATULATIONS!!\n" + "YOU HAVE WON!!");
            }
        }
    }
}
