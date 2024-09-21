import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rounds = 3;
        int maxAttempts = 5;
        int totalScore = 0;

        System.out.println("\n\n\t\tWelcome to the Guess the Number Game!");
        
        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1; // Generates a random number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n\nRound " + round + ":");
            System.out.println("\nYou have " + maxAttempts + " attempts to guess the number between 1 and 100.\n");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    guessedCorrectly = true;
                    int points = (maxAttempts - attempts + 1) * 10; // Points based on attempts left
                    totalScore += points;
                    System.out.println("\nCorrect! You've earned " + points + " points.\n");
                } else if (guess < numberToGuess) {
                    System.out.println("\nThe number is higher than your guess.");
                } else {
                    System.out.println("\nThe number is lower than your guess.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n\nOops..!!!\n\nYou've run out of attempts.\n\nThe correct number was " + numberToGuess + ".");
            }
        }

        System.out.println("\n\t\tGame over!\n\nYour total score is: " + totalScore);
        scanner.close();
    }
}
