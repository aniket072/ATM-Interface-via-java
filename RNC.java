import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.playGame();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber;
        int attempts;
        int score = 0;
        String input;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            secretNumber = random.nextInt(100) + 1;
            attempts = 0;

            while (true) {
                System.out.print("Enter your guess (1-100) or 'q' to quit: ");
                input = scanner.nextLine();

                if (input.equalsIgnoreCase("q")) {
                    System.out.println("Thanks for playing! Your score is " + score + ".");
                    return;
                }

                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += attempts;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }