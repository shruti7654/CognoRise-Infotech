import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"hangman", "java", "programming", "computer", "developer", "algorithm"};

        Random random = new Random();
        String selectedWord = words[random.nextInt(words.length)];
        char[] wordToGuess = selectedWord.toCharArray();
        char[] displayWord = new char[wordToGuess.length];

        for (int i = 0; i < wordToGuess.length; i++) {
            displayWord[i] = '_';
        }

        int maxAttempts = 6;
        int incorrectGuesses = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");

        while (incorrectGuesses < maxAttempts) {
            System.out.println("Word: " + new String(displayWord));
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            if (containsLetter(wordToGuess, guess)) {
                updateDisplayWord(wordToGuess, displayWord, guess);
            } else {
                incorrectGuesses++;
                displayHangman(incorrectGuesses);
            }

            if (isWordGuessed(displayWord)) {
                System.out.println("Congratulations! You guessed the word: " + selectedWord);
                break;
            }
        }

        if (incorrectGuesses == maxAttempts) {
            System.out.println("Sorry, you ran out of attempts. The word was: " + selectedWord);
        }

        scanner.close();
    }

    private static boolean containsLetter(char[] word, char letter) {
        for (char c : word) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    private static void updateDisplayWord(char[] word, char[] display, char letter) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == letter) {
                display[i] = letter;
            }
        }
    }

    private static boolean isWordGuessed(char[] display) {
        for (char c : display) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private static void displayHangman(int incorrectGuesses) {
        switch (incorrectGuesses) {
            case 1:
                System.out.println("   _____");
                break;
            case 2:
                System.out.println("   _____");
                System.out.println("   |   |");
                break;
            case 3:
                System.out.println("   _____");
                System.out.println("   |   |");
                System.out.println("   O   |");
                break;
            case 4:
                System.out.println("   _____");
                System.out.println("   |   |");
                System.out.println("   O   |");
                System.out.println("  /    |");
                break;
            case 5:
                System.out.println("   _____");
                System.out.println("   |   |");
                System.out.println("   O   |");
                System.out.println("  / \\  |");
                break;
            case 6:
                System.out.println("   _____");
                System.out.println("   |   |");
                System.out.println("   O   |");
                System.out.println("  /|\\  |");
                System.out.println("  / \\  |");
                System.out.println("GAME OVER!");
                break;
        }
    }
}
