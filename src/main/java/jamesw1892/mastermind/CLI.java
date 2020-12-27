package jamesw1892.mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CLI {

    /**
     * Get a choice of colours from stdin
     */
    private static Choice inputChoice(Scanner scanner) {

        Colour[] colours = new Colour[Choice.NUM_COLOURS_TO_CHOOSE];
        for (int index = 0; index < Choice.NUM_COLOURS_TO_CHOOSE; index++) {
            try {
                System.out.print(String.format("Colour %d: ", index + 1));
                colours[index] = Colour.valueOf(Colour.class, scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid colour. Available colours are: " + Colour.getAllColours());
                index--;
            }
        }

        return new Choice(colours);
    }

    /**
     * Play the game by asking the user for guesses and printing the results until they have guessed correctly
     */
    private static void play(Game game, Scanner scanner) {

        Score score;
        do {
            System.out.println(String.format("\nGuess %d:", game.getNumGuesses() + 1));
            score = game.guess(inputChoice(scanner));
            System.out.println(String.format("That guess's score is %d white pegs and %d black pegs", score.getNumWhite(), score.getNumBlack()));
        } while (score.getNumWhite() != Choice.NUM_COLOURS_TO_CHOOSE);

        System.out.println(String.format("\nYou guessed correctly in %d guesses!", game.getNumGuesses()));
    }

    /**
     * Generate a random choice of colours
     */
    private static Game randomChoice() {
        Colour[] allPossibleColours = Colour.values();

        Random r = new Random();
        Colour[] answer = new Colour[Choice.NUM_COLOURS_TO_CHOOSE];
        for (int index = 0; index < Choice.NUM_COLOURS_TO_CHOOSE; index++) {
            answer[index] = allPossibleColours[r.nextInt(allPossibleColours.length)];
        }

        return new Game(new Choice(answer));
    }

    /**
     * Get an answer from stdin
     */
    private static Game inputAnswer(Scanner scanner) {

        System.out.println("Player 2 look away and player 1 input answer:");
        
        Choice choice = inputChoice(scanner);

        for (int i = 0; i < 100; i++) System.out.println();
        System.out.println("Player 2 can look now");

        return new Game(choice);
    }

    /**
     * Run the CLI to ask the user what they want to do
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("MENU:\n1) Let one player input an answer and another guess\n2) Let the user try to guess a random answer\nChosen option: ");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                play(inputAnswer(scanner), scanner);
                break;
            case 2:
                play(randomChoice(), scanner);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}