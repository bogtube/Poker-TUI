import Tisch.*;
import java.util.Scanner;

public class Main {
    
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
                                                                                    // 1. Deck erstellen und mischen
        Deck stapel = new Deck();
        stapel.mischen();

        Player[] players = new Player[2];
        // nur nicht als array sondern zyklische Linked List
        
        players[0] = new Player("me", 1000); 
        players[1] = new Player("bot", 1000);
        
        for (Player player : players) {
            player.karteNehmen(staphel.ziehen());
            player.karteNehmen(staphel.ziehen());
        }
		// je nach dem wie das backend funktioniert auch so:
		for (int i = 0; i < players.length; i++) {
			Player player = players[i];
			player.karteNehmen(staphel.ziehen());
            player.karteNehmen(staphel.ziehen());
		}
                                                                                    // 3. Tisch vorbereiten 
        Cards[] tischKarten = new Cards[5];
        for(int i = 0; i < 5; i++) {
            tischKarten[i] = stapel.ziehen();
        }

                                                                                    //  Game Start!
        int[] phasen = {0, 3, 4, 5}; 
        String[] phasenNamen = {"PRE-FLOP", "FLOP", "TURN", "RIVER"};

        for (int i = 0; i < phasen.length; i++) {
            int anzahlOffen = phasen[i];
            
            clearScreen(); 

            System.out.println("=== TEXAS HOLD'EM: " + phasenNamen[i] + " ===");
            
                                                                                    // Gegner (verdeckt)
            System.out.println("Gegner (" + cpu.getGeld() + "$):");
            printBack(2); 
            System.out.println();

                                                                                    // Tisch
            System.out.println("Tisch:");
            printTisch(tischKarten, anzahlOffen);
            System.out.println();

                                                                                    // Eigene Hand
            System.out.println("Deine Hand (" + ich.getGeld() + "$):");
            printHand(ich.getHandArray());
            System.out.println();

            System.out.println("[Drücke ENTER für nächste Phase...]");
            scanner.nextLine();
        }

                                                                                    // Game End (alle decken auf)
        clearScreen();
        System.out.println("=== SHOWDOWN ===");
        
        System.out.println("Gegner deckt auf:");
        printHand(cpu.getHandArray()); 
        
        System.out.println("\nTisch:");
        printTisch(tischKarten, 5); 

        System.out.println("\nDeine Hand:");
        printHand(ich.getHandArray());

                                                                                    // Auswertung 
        System.out.println("\n--- ERGEBNIS ---");

                                                                                    // 1. HandTyp bestimmen
        HandTyp typIch = PokerRegeln.checkHand(ich.getHandArray(), tischKarten);
        HandTyp typCpu = PokerRegeln.checkHand(cpu.getHandArray(), tischKarten);

        System.out.println("Du hast: " + typIch);
        System.out.println("Bot hat: " + typCpu);

                                                                                    // 2. Vergleich
        if (typIch.getWert() > typCpu.getWert()) {
            System.out.println("GEWONNEN! Dein Bild ist stärker.");
        } 
        else if (typCpu.getWert() > typIch.getWert()) {
            System.out.println("VERLOREN! Bot hat das bessere Bild.");
        } 
        else {
                                                                                    // Tie-Breaker (Höchste Karte auf der Hand)
            int meinMax = PokerRegeln.getHighCard(ich.getHandArray());
            int botMax = PokerRegeln.getHighCard(cpu.getHandArray());

            if (meinMax > botMax) {
                System.out.println("GEWONNEN! Gleiches Bild, aber du hast den höheren Kicker.");
            } else if (botMax > meinMax) {
                System.out.println("VERLOREN! Gleiches Bild, Bot hat höhere Karte.");
            } else {
                System.out.println("UNENTSCHIEDEN! (Split Pot)");
            }
        }

    }                                                                                  // <--- HIER ENDET DIE MAIN METHODE

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public static void printTisch(Cards[] karten, int anzahlOffen) {
        String[] rueckseiteBild = getBackImage(); 
        int kartenHoehe = 11; 

        for (int zeile = 0; zeile < kartenHoehe; ++zeile) {
            for (int k = 0; k < karten.length; ++k) {
                if (k < anzahlOffen) {
                    System.out.print(karten[k].getBild()[zeile] + "  ");
                } else {
                    System.out.print(rueckseiteBild[zeile] + "  ");
                }
            }
            System.out.println(); 
        }
    }

    public static void printHand(Cards[] hand){
        int kartenHoehe = hand[0].getBild().length;
        for(int i = 0; i < kartenHoehe; ++i){
            for(int j = 0; j < hand.length; ++j){
                System.out.print(hand[j].getBild()[i] + "  ");
            }
            System.out.println();
        }
    }

    public static void printBack(int anzahl){
        String[] rueckseite = getBackImage();
        for(int i = 0; i < 11; ++i){
            for(int k=0; k < anzahl; k++) {
                System.out.print(rueckseite[i] + "  ");
            }
            System.out.println();
        }
    }

    public static String[] getBackImage() {
        return new String[] {
            "╭──────────────╮",
            "|*'-._.-*'-._.-|",
            "|'-._.-*'-._.-*|",
            "|-._.-*'-._.-*'|",
            "|._.-*'-._.-*'-|",
            "|_.-*'-._.-*'-.|",
            "|.-*'-._.-*'-._|",
            "|-*'-._.-*'-._.|",
            "|*'-._.-*'-._.-|",
            "|'-._.-*'-._.-*|",
            "╰──────────────╯"
        };
    }

} 
