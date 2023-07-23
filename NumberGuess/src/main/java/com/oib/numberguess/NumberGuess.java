/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.oib.numberguess;

/**
 *
 * @author Admin
 */
import java.util.Random;
import java.util.Scanner;
public class NumberGuess {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Random random = new Random();
			int minRange = 1;
			int maxRange = 100;
			int maxAttempts = 5;
			System.out.println("Welcome to the Number Guessing Game!");
			boolean playAgain;
			do {
				int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
				int attemptsLeft = maxAttempts;
				System.out.printf("%nGuess a number between %d and %d You have %d attempts left.%n",minRange,maxRange,maxAttempts);

				int userGuess;
				do {
					System.out.print("Enter your guess: ");
					while (!scanner.hasNextInt()) {
						System.out.println("Invalid input, please enter a number.");
						scanner.next();
					}
					userGuess = scanner.nextInt();
					attemptsLeft--;

					if (userGuess == targetNumber) {
						System.out.println("Congratulations! You guessed the number!");
						int score = calculateScore(attemptsLeft);
						System.out.printf("Your score for this round is: %d%n", score);
						break;
					} else if (attemptsLeft == 0) {
						System.out.printf("Sorry, you have run out of attempts. The number was %d.",targetNumber);
						break;
					} else if (userGuess < targetNumber) {
						System.out.println("Your guess is too low. Try again.");
						System.out.printf("You have %d attempts left.%n", attemptsLeft);
					} else if (userGuess > targetNumber) {
						System.out.println("Your guess is too high. Try again.");
						System.out.printf("You have %d attempts left.%n", attemptsLeft);
					}
				} while (true);
				System.out.print("Would you like to play again? (yes/no): ");
				playAgain = scanner.next().equalsIgnoreCase("yes");
			} while (playAgain);
		}
		System.out.println("\n Thank you for playing this game!");
	}
	private  static int calculateScore(int attempts){
		return attempts*10;
	}
}


