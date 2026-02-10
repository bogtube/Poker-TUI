package Tisch;

import java.util.ArrayList;

public class Player{
    private String name;
    private int geld;
    private ArrayList<Cards> hand;

    public Player(String name, int startKapital){
        this.name = name;
        this.geld = startKapital;
        this.hand = new ArrayList<>();

    }


    public int setzen(int betrag){
        if(betrag > geld){
            System.out.println(name + "Nicht mehr genug Para! (brokie-mokie).   [All-In]");
            betrag = geld;
        }

        geld -= betrag;
        return betrag;                      // geht in den Pot
    }

    public void gewinnErhalten(int pot){
        geld += pot;
    }

    public void karteNehmen(Cards karte) {
        hand.add(karte);
    }
    
    public void handLeeren() {
        hand.clear();
    }

    // Getter für Main
    public Cards[] getHandArray() {
        return hand.toArray(new Cards[0]);
    }
    
    public String getName() { return name; }
    public int getGeld() { return geld; }


}


