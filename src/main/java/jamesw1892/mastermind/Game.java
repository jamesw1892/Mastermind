package jamesw1892.mastermind;

public class Game {
    private int numGuesses;
    private Choice answer;

    /**
     * Create a new game with the specified answer
     */
    public Game(Choice answer) {
        this.numGuesses = 0;
        this.answer = answer;
    }

    /**
     * Make a guess and return its score
     */
    public Score guess(Choice guess) {
        numGuesses++;
        return Choice.score(this.answer, guess);
    }

    /**
     * Get the number of guesses currently made
     */
    public int getNumGuesses() {
        return this.numGuesses;
    }
}