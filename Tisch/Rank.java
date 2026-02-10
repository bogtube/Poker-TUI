package Tisch;

public enum Rank{
    
    Zwei("2", 2),
    Drei("3", 3),
    Vier("4", 4),
    Fünf("5", 5),
    Sechs("6", 6),
    Sieben("7", 7),
    Acht("8", 8),
    Neun("9", 9),
    Zehn("10", 10),
    Junge("J", 11),
    Dame("D", 12),
    König("K", 13),
    Ass("A", 14);

    private final String label;
    private final int wert;

    Rank(String label, int wert){
        this.label = label;
        this.wert = wert;
    }

    public String getLabel(){ return label;}
    public int getWert(){ return wert;}
}
