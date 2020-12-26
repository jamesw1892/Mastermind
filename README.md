# Mastermind

A simulation of the board game Mastermind / Brain Master.

I aim to include an algorithm to solve it systematically and the ability to play manually.

# How the board game works

In the standard board game, each choice (answer or guess) contains 4 colours and there are 5 colours to choose from: blue, green, orange, red and yellow. I aim to make the core functionality work with different numbers of these, however my algorithm to solve it systematically currently only works when there is at least 1 more possible colour than the number in each choice.

Player 1 chooses exactly 4 colours (can include more than one of the same colour so there are 5^4 = 625 possibilities) as the answer that is hidden from player 2. Then player 2 repeatedly guesses 4 colours and is scored on that guess until the correct colours have been guessed. The aim of the game is to guess correctly in the shortest number of guesses.

A score consists of a number of white pegs and a number of black pegs. The number of white pegs is the number of colours guessed that are exactly correct (the correct colour in the correct position). The number of black pegs is the number of colours guessed that are the correct colour but in the wrong place. The sum of the number of white and black pegs is at most the number of colours in each choice (4 by default), but could be less if colours guessed do not appear in the answer.

# Core Files

- `Colour.java`: An enum containing all possible colours.
- `Choice.java`: An array of colours representing an answer of guess. Also contains a static method that calculates the score given an answer and a guess.
- `Score.java`: Encapsulates the number of white and black pegs.