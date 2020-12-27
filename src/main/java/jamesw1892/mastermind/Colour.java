package jamesw1892.mastermind;

public enum Colour {
    BLUE,
    GREEN,
    ORANGE,
    RED,
    YELLOW;

    /**
     * Get a comma and space separated string of all
     * possible colours
     */
    public static String getAllColours() {
        String colourStr = "";
        for (Colour colour: Colour.values()) {
            colourStr += ", " + colour.name().toLowerCase();
        }
        return colourStr.substring(2);
    }
}