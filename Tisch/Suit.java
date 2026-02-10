package Tisch;

public enum Suit{

    Herz("\u001B[31m♥\u001B[0m"),   // Rotes Herz
    Karo("\u001B[31m♦\u001B[0m"),   // Rotes Karo
    Peak("♠"),
    Kreuz("♣");

    private final String symbol;

    Suit(String symbol){
        this.symbol = symbol;
    }

    public String getSuit(){
        return symbol;
    }
}

