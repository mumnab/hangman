import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

	public static void main(String[] args) throws FileNotFoundException {

		// Welcome message and asking user to begin the game.
		System.out.println("Welcome to the Hangman game!\n");
		System.out.println("Enter a letter:");
		System.out.println();
		System.out.println("|------");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println();

		// Importing a textfile from the dictionary.
		File dictionary = new File("/Users/mumna/eclipse-workspace/Hangman/src/engmix.txt");

		// In order to read the file you have to input we set such that we can read it
		// from the scanner.
		Scanner scan = new Scanner(dictionary);

		// This interface will allow us to create a list of elements based on the index
		// numbers.
		List<String> words = new ArrayList<>();

		// This while loop will allow us to go through the list of words
		int counterX = 0;
		while (scan.hasNext()) {
			words.add(scan.nextLine());
		}

		// To pick a random word from the list
		// We can create a random class and import
		Random random = new Random();

		// In order to get a random word from the list we can use the
		// Size which will select a random word from the list
		String wordFromList = words.get(random.nextInt(words.size()));

		// Uncomment the line below if you want to see your randomized word!
		//System.out.println(wordFromList);

		// Creating a character list
		// using a for loop which checks if the index iterating hasthe
		// character from the randomized word if yes it will print the character
		// if not then it will print a dash
		List<Character> guess = new ArrayList<>();
		for (int i = 0; i < wordFromList.length(); i++) {
			if (guess.contains(wordFromList.charAt(i))) {
				System.out.print(wordFromList.charAt(i));
			} else {
				System.out.print("-");
			}
		}
		System.out.println();

		// This boolean will help us end the game in two scenarios (winning and losing
		// the game).
		boolean stop = true;

		while (stop) {

			// Creating a scanner for the user's input
			// using the add method in order to add elements to our List
			Scanner scanner = new Scanner(System.in);
			String characterGuess = scanner.nextLine();

			guess.add(characterGuess.charAt(0));

			int counter = 0;
			for (int i = 0; i < wordFromList.length(); i++) {
				if (guess.contains(wordFromList.charAt(i))) {
					System.out.print(wordFromList.charAt(i));
					counter++;
				} else {
					System.out.print("-");
				}
			}
			System.out.println();
			System.out.println();

			// Creating a counter which keeps track of the amount of each wrong answer
			// this will help us keep track of the amount of lives.
			// We create an if statement to follows the condition of not having
			// the character and if there is enough lives left
			if (wordFromList.contains(characterGuess) != true && stop == true) {
				counterX++;

				switch (counterX) {

				case 1: {
					System.out.println("|------");
					System.out.println("|  O");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println();
					System.out.println("Please try again you have " + (6 - counterX) + " lives left\n");
					break;
				}

				case 2: {
					System.out.println("|------");
					System.out.println("|  O");
					System.out.println("|  |");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println();
					System.out.println("Please try again you have " + (6 - counterX) + " lives left\n");
					break;
				}

				case 3: {
					System.out.println("|------");
					System.out.println("|  O");
					System.out.println("| <|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println();
					System.out.println("Please try again you have " + (6 - counterX) + " lives left\n");
					break;
				}

				case 4: {
					System.out.println("|------");
					System.out.println("|  O");
					System.out.println("| <|>");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println();
					System.out.println("Please try again you have " + (6 - counterX) + " lives left\n");
					break;
				}

				case 5: {
					System.out.println("|------");
					System.out.println("|  O");
					System.out.println("| <|>");
					System.out.println("| /");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println();
					System.out.println("Please try again you have " + (6 - counterX) + " lives left\n");
					break;
				}

				case 6: {
					System.out.println("|------");
					System.out.println("|  O");
					System.out.println("| <|>");
					System.out.println("| / \\");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println("|");
					System.out.println();
					System.out.println("You have no more lives. You are dead!!\n"); // Display end game message.
					stop = false;
					break;

				}

				}
			}

			// Once the counter has the same number of characters as the random word
			// We will end the loop along with a display
			if (counter == wordFromList.length()) {
				stop = false; // Terminate game
				System.out.println("Congrats you figured out the word!"); // Display end game message.
			}

		}
		scan.close();

	}
}
