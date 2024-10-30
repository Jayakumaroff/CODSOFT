 import java.util.Random;
import java.util.Scanner;

public class numberGuessingGame {
    private static final int MAX_TRIES = 5; // Limit on number of attempts
    private static final int LOWER_BOUND = 1; // Minimum possible number
    private static final int UPPER_BOUND = 100; // Maximum possible number

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int totalGames = 0;
        int gamesWon = 0;

        boolean playAgain;
        do {
            totalGames++;
            int target = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attempts = 0;
            boolean isCorrect = false;

            System.out.println("Game " + totalGames + ": Guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");

            while (attempts < MAX_TRIES && !isCorrect) {
                System.out.print("Your guess: ");
                int guess = input.nextInt();
                attempts++;

                if (guess < LOWER_BOUND || guess > UPPER_BOUND) { System.out.println("Out of range! Please guess a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
                } else if (guess < target) {
                    System.out.println("Too low! Try again.");
                } else if (guess > target) {
                    System.out.println("Too high! Try again.");
                } else {
                    isCorrect = true;
                    System.out.println("Nice work! You've guessed it: " + target);
                    gamesWon++;
                }
            }

            if (!isCorrect) {
                System.out.println("Out of tries! The number was: " + target);
            }

            System.out.print("Play another game? (yes/no): ");
            playAgain = input.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Summary: You played " + totalGames + " games and won " + gamesWon + " times.");
        input.close();
    }
}

