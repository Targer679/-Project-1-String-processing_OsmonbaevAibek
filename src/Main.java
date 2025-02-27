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

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ajbek\\IdeaProjects\\Project-1_String_processing\\out\\production\\Project-1_String_processing\\words.txt"));
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] wordArray = line.split("\\s+");

                // Store each word in a StringBuilder object
                for (String word : wordArray) {
                    words[index] = new StringBuilder(word);
                    index++;
                }
            }

            reader.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate a random index
        Random random = new Random();
        int rand = random.nextInt(20);

        // Print underscores for each character in the selected word
        for (int i = 0; i < words[rand].length(); i++) {
            System.out.print("_");
        }
    }
}
