import java.util.Scanner;
import java.util.Random;

public class noGUESSINGgame{
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");

        // Generate a random number between 1 and 100
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        int attempts = 0;
        int maxAttempts = 5;  // Define the maximum number of attempts

        Scanner scanner = new Scanner(System.in);

        while (attempts < maxAttempts) {
            // Get user input for their guess
            System.out.print("Guess the number between 1 and 100: ");
            int guess = scanner.nextInt();
            attempts++;

            // Compare the user's guess with the generated number
            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        // Provide feedback if the user couldn't guess the number within the limit
        if (attempts == maxAttempts && secretNumber != -1) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
        }

        scanner.close();
    }
}
