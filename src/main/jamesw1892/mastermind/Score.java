package jamesw1892.mastermind;

public class Score {
    private final int numWhite;
    private final int numBlack;

    /**
     * Create a new score with the given number of white and black pegs
     * @param numWhite The number of correct colours in the correct place
     * @param numBlack The number of correct colours in the wrong place
     */
    public Score(int numWhite, int numBlack) {
        this.numWhite = numWhite;
        this.numBlack = numBlack;
    }

    /**
     * Get the number of white pegs (the number
     * of correct colours in the correct place)
     */
	public int getNumWhite() {
		return this.numWhite;
	}

	/**
     * Get the number of black pegs (the number
     * of correct colours in the wrong place)
     */
	public int getNumBlack() {
		return this.numBlack;
	}
}