package jamesw1892.mastermind;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
    private static int testNum = 0;

    private static void scoreTestTemplate(Colour[] answer, Colour[] guess, int numWhite, int numBlack) {

        Score score = Choice.score(new Choice(answer), new Choice(guess));

        assertEquals("Scoring " + testNum + " white incorrect", numWhite, score.getNumWhite());
        assertEquals("Scoring " + testNum + " black incorrect", numBlack, score.getNumBlack());

        testNum++;
    }

    @Test
    public void scoreTests() {

        scoreTestTemplate(
            new Colour[] {Colour.RED, Colour.RED, Colour.RED, Colour.RED},
            new Colour[] {Colour.RED, Colour.RED, Colour.RED, Colour.RED},
        4, 0);

        scoreTestTemplate(
            new Colour[] {Colour.RED, Colour.RED, Colour.RED, Colour.RED},
            new Colour[] {Colour.RED, Colour.RED, Colour.RED, Colour.ORANGE},
        3, 0);

        scoreTestTemplate(
            new Colour[] {Colour.RED, Colour.RED, Colour.RED, Colour.RED},
            new Colour[] {Colour.BLUE, Colour.YELLOW, Colour.GREEN, Colour.ORANGE},
        0, 0);

        scoreTestTemplate(
            new Colour[] {Colour.RED, Colour.RED, Colour.RED, Colour.ORANGE},
            new Colour[] {Colour.RED, Colour.RED, Colour.ORANGE, Colour.BLUE},
        2, 1);

        scoreTestTemplate(
            new Colour[] {Colour.RED, Colour.RED, Colour.RED, Colour.ORANGE},
            new Colour[] {Colour.RED, Colour.RED, Colour.ORANGE, Colour.ORANGE},
        3, 0);

        scoreTestTemplate(
            new Colour[] {Colour.RED, Colour.ORANGE, Colour.RED, Colour.ORANGE},
            new Colour[] {Colour.RED, Colour.RED, Colour.ORANGE, Colour.ORANGE},
        2, 2);

        scoreTestTemplate(
            new Colour[] {Colour.RED, Colour.ORANGE, Colour.BLUE, Colour.YELLOW},
            new Colour[] {Colour.ORANGE, Colour.BLUE, Colour.YELLOW, Colour.RED},
        0, 4);

        scoreTestTemplate(
            new Colour[] {Colour.RED, Colour.ORANGE, Colour.BLUE, Colour.RED},
            new Colour[] {Colour.RED, Colour.RED, Colour.ORANGE, Colour.YELLOW},
        1, 2);
    }
}