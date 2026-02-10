package Tisch;

public enum HandTyp {
    NICHTS(0),
    PAAR(1),
    ZWEI_PAAR(2),
    DRILLING(3),
    FULL_HOUSE(4),
    VIERLING(5),
    FLUSH(6);

    private final int wert;

    HandTyp(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }
}
