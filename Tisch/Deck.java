package Tisch;

import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    private ArrayList<Cards> karten;

    public Deck(){
        this.karten = new ArrayList<>();
        generiereDeck();
    }

    private void generiereDeck(){
        for(Suit s : Suit.values()){
            for(Rank r : Rank.values()){
                this.karten.add(new Cards(r, s));
            }
        }
    }

    public Cards[] getKartenArray(){
        return this.karten.toArray(new Cards[0]);
    }

    public void mischen(){
        Collections.shuffle(this.karten);
    }

    public Cards ziehen(){
        if(this.karten.size() > 0){
            return this.karten.remove(0);    
        }else{
            System.out.println("Der stapel ist leer bro, mache ein neuen auf!");
            return null;
        }
    }
    

}
