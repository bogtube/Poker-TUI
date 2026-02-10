package Tisch;

public class Cards{
    private Rank rank; 
    private Suit suit;

    public Cards(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String[] getBild(){
        String symbol = this.suit.getSuit();
        String label = this.rank.getLabel();

        String leerzeichenO;
        String leerzeichenU;

        if(label.equals("10")){
            leerzeichenO = "         ";
            leerzeichenU = "         ";
        }else{
            leerzeichenO = "          ";
            leerzeichenU = "          ";
        }

        String[] bild = {
            "╭──────────────╮",
            "| " + label + " " + symbol + leerzeichenO + "|",
            "|              |",
            "|              |",
            "|              |",
            "|      " + symbol + "       |",
            "|              |",
            "|              |",
            "|              |",
            "|"+ leerzeichenU + symbol + " " + label + " |",
            "╰──────────────╯"
        };

        return bild;
    }
}

