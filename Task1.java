package cogni;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int targetNumber = random.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        int maxAttempts = 7;
        boolean hasWon = false;

        System.out.println("=== Welcome to the Number Guessing Game! ===");
        System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                scanner.next();
                continue;
            }

            int guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                hasWon = true;
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try again. (Attempts left: " + (maxAttempts - attempts) + ")");
            } else {
                System.out.println("Too high! Try again. (Attempts left: " + (maxAttempts - attempts) + ")");
            }
        }

        if (!hasWon) {
            System.out.println("Game Over! The correct number was: " + targetNumber);
        }

        scanner.close();
    }
}