/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokertony;

import PaD.*;
import java.util.*;

public class PokerTony {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean rematch = true;

        /**
         * Initializing the PlancheADessin and the card pack
         */
        PlancheADessin pad = new PlancheADessin(1000, 1000);
        Texte header = new Texte(300, 0, "Welcome on PokerTony!\n A (not so) quick poker game!");
        Texte instructions = new Texte(300, 25, "To start, open your prompt and follow instructions...");
        pad.ajouter(header, instructions);
        CardPack cardPack = new CardPack();
        cardPack.shuffle();
        
        
        /**
         * Initializing players and giving them two cards
         */
        int playerCount = promptInt("How many players to play? (1-4)");
        Player[] players = new Player[playerCount];
        
        pad.supprimer(header, instructions);
        
        promptString(""); // Workaround : else, first prompt doesn't wait for input
        for (int i = 0; i < playerCount; i++) {
            players[i] = new Player(promptString("Indicate player" + (i+1) + "'s name :"));
            players[i].takeCards(cardPack, i * 2, (i + 1) * 2);
            players[i].display(pad, 125 * i);
        }

        while (rematch) {
            cardPack.shuffle();
            
            if (!promptString("Do you want to rematch? (y/n)").equals("y")) {
                echoln("Bye! Hope you had fun!");
                System.exit(0);
            }
        }
    }

    public static void echoln(String message) {
        System.out.println(message);
    }

    public static void echo(String message) {
        System.out.print(message);
    }

    public static String promptString(String message) {
        echoln(message);
        return scan.nextLine();
    }

    public static int promptInt(String message) {
        echoln(message);
        return scan.nextInt();
    }
}
