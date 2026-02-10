package Tisch;

import java.util.ArrayList;

public class PokerRegeln {

    public static HandTyp checkHand(Cards[] hand, Cards[] tisch) {
        
        // 1. Alle Karten in eine gemeinsame Liste packen
        ArrayList<Cards> alleKarten = new ArrayList<>();
        for (Cards c : hand) alleKarten.add(c);
        for (Cards c : tisch) alleKarten.add(c);

        // 2. STRICHLISTE ERSTELLEN (Counts)
        // Array Größe 15, damit wir Platz bis Index 14 (Ass) haben.
        int[] wertZaehler = new int[15]; 
        
        // Zählen der Suits für Flush (0=Herz, 1=Karo etc. - vereinfacht)
        // Hier zählen wir nur Werte, Flush Logik kommt extra, wenn du willst.
        
        for (Cards k : alleKarten) {
            int wert = k.getRank().getWert(); // z.B. 14 für Ass
            wertZaehler[wert]++; // Mach einen Strich bei 14
        }

        // 3. STRICHLISTE AUSWERTEN
        boolean hatDrei = false;
        boolean hatVier = false;
        int anzahlPaare = 0;

        for (int i = 2; i < 15; i++) {
            if (wertZaehler[i] == 4) {
                hatVier = true;
            }
            if (wertZaehler[i] == 3) {
                hatDrei = true;
            }
            if (wertZaehler[i] == 2) {
                anzahlPaare++;
            }
        }

        // 4. ENTSCHEIDUNG (Von stark nach schwach prüfen)
        if (hatVier) {
            return HandTyp.VIERLING;
        }
        if (hatDrei && anzahlPaare >= 1) {
            return HandTyp.FULL_HOUSE; 
        }
        // (Sonderfall: 2 Drillinge sind auch Full House, ignorieren wir hier kurz der Einfachheit halber)
        
        if (hatDrei) {
            return HandTyp.DRILLING;
        }
        if (anzahlPaare >= 2) {
            return HandTyp.ZWEI_PAAR;
        }
        if (anzahlPaare == 1) {
            return HandTyp.PAAR;
        }

        return HandTyp.NICHTS;
    }

    // Hilfsmethode: Gibt den Wert der höchsten Karte zurück (für Gleichstand)
    public static int getHighCard(Cards[] hand) {
        int max = 0;
        for (Cards c : hand) {
            if (c.getRank().getWert() > max) {
                max = c.getRank().getWert();
            }
        }
        return max;
    }
}
