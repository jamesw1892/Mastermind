package jamesw1892.mastermind;

import java.util.TreeSet;

public class Choice {
    public static final int NUM_COLOURS_TO_CHOOSE = 4;
    private Colour[] colours;

    /**
     * Create a new choice with the given colours
     */
    public Choice(Colour[] choice) {
        if (choice.length != NUM_COLOURS_TO_CHOOSE) {
            throw new RuntimeException("Invalid number of colours");
        }
        this.colours = choice;
    }

    /**
     * Calculate the score of a guess given it and the correct answer
     */
    public static Score score(Choice answer, Choice guess) {
        int numWhite = 0;
        int numBlack = 0;

        TreeSet<Integer> indicesAnswerNotScored = new TreeSet<>();
        TreeSet<Integer> indicesGuessNotScored = new TreeSet<>();

        // determine number of white pegs - correct colour in correct place
        // and add all remaining indices to the tree sets
        for (int index = 0; index < NUM_COLOURS_TO_CHOOSE; index++) {
            Colour correctColour = answer.colours[index];
            if (correctColour == guess.colours[index]) {
                numWhite++;
            } else {
                indicesAnswerNotScored.add(index);
                indicesGuessNotScored.add(index);
            }
        }

        // determine the number of black pegs - correct colour but
        // wrong place. Here we only consider those that have not already
        // been scored so we need to edit the indices as we go

        // for colour in answer that is not white:
        for (int indexAnswer: indicesAnswerNotScored) {

            boolean matches = false;
            int indexGuessToRemove = -1;

            // if it matches at least one colour in the guess that has not been
            // scored yet, add a black peg and remove that index of the guess
            // so it cannot be scored again
            for (int indexGuess: indicesGuessNotScored) {
                if (answer.colours[indexAnswer] == guess.colours[indexGuess]) {
                    matches = true;
                    indexGuessToRemove = indexGuess;
                    break;
                }
            }
            if (matches) {
                numBlack++;
                indicesGuessNotScored.remove(indexGuessToRemove);
            }
        }

        return new Score(numWhite, numBlack);
    }
}