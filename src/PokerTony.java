
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package pokertony;

import PaD.*;
import java.util.*;

public class PokerTony {

    public static Player[] players;
    public static PlancheADessin pad;
    public static Field field;
    public static int X = 1000;
    public static int Y = 700;
    public static CardPack cardPack;
    public static int playerCount;
    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        boolean rematch = true;
        Initialize();
        loop();

        while (rematch) {
            if (!promptString("Do you want to rematch? (y/n)").equals("y")) {
                echoln("Bye! Hope you had fun!");
                System.exit(0);
            }
            PokerTony.loop();
        }
    }


    public static void Initialize() {
        /**
         * Initializing the PlancheADessin and the card pack
         */
        pad = new PlancheADessin(X, Y);
        Texte header = new Texte(300, 20, "Welcome on PokerTony!\n A (not so) quick poker game!");
        Texte instructions = new Texte(300, 40, "To start, open your prompt and follow instructions...");
        pad.ajouter(header, instructions);
        cardPack = new CardPack();

        /**
         * Initializing players and giving them two cards
         */
        playerCount = promptInt("How many players to play? (2-4)");
        PokerTony.players = new Player[playerCount];

        pad.supprimer(header, instructions);

        promptString(""); // Workaround : else, first prompt doesn't wait for input

        PokerTony.players[0] = new HumanPlayer(promptString("Indicate player" + (1) + "'s name :"), PokerTony.cardPack);
        for (int i = 1; i < playerCount; i++) {
            PokerTony.players[i] = new MachinePlayer(promptString("Indicate player" + (i + 1) + "'s name :"),
                    PokerTony.cardPack);
        }

    }

    public static void loop() {
        /**
         * Cette fonction represente 1 partie de jeu
         */
        while ((PokerTony.playerCount - PokerTony.deadPlayer()) > 1) {
            PokerTony.round();
        }

    }

    public static void round() {
        /**
         * Cette fonction représente une manche de jeu
         */

        cardPack.shuffle();

        // All player draw cards
        for (int i = 0; i < PokerTony.playerCount; i++) {
            PokerTony.players[i].setHand();
        }
        PokerTony.field = new Field(PokerTony.cardPack);
        while (true) { // modifier la condition et ajouter certaines règles
            int firstPlayer = chooseFirstPlayer();
            PokerTony.turn(firstPlayer);

        }

    }

    public static void turn(int firstPlayer) {
        /**
         * Fonction a finir en priorité
         */

        PokerTony.displayGame();


        // First turn, 3 card returned on the field
        int n = 0;
        int i = firstPlayer;

        while (n < PokerTony.playerCount) {
            if (i == PokerTony.playerCount) {
                i = 0;
            }
            PokerTony.play(PokerTony.players[i]);
            PokerTony.displayGame();
            n = n + 1;
            i = i + 1;
        }



        if((PokerTony.playerCount - PokerTony.frozenPlayer()) > 1){

            PokerTony.field.returnCard();


            // Second turn,  4 card returned on the field
            n = 0;
            i = firstPlayer;
            while (n < PokerTony.playerCount) {
                if (i == PokerTony.playerCount) {
                    i = 0;
                }
                PokerTony.play(PokerTony.players[i]);
                PokerTony.displayGame();
                n = n + 1;
                i = i + 1;
            }
        }


        if((PokerTony.playerCount - PokerTony.frozenPlayer()) > 1){

            PokerTony.field.returnCard();

            // Last turn,  5 card returned on the field 
            n = 0;
            i = firstPlayer;
            while (n < PokerTony.playerCount) {
                if (i == PokerTony.playerCount) {
                    i = 0;
                }
                PokerTony.play(PokerTony.players[i]);
                PokerTony.displayGame();
                n = n + 1;
                i = i + 1;
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

    public static int chooseFirstPlayer() {
        Random rand = new Random();
        int firstPlayer = rand.nextInt(PokerTony.playerCount - 1);
        return firstPlayer;
    }

    public static int promptInt(String message) {
        echoln(message);
        return scan.nextInt();
    }

    public static void displayGame() {

        PokerTony.players[0].display(PokerTony.X / 2 - 250, PokerTony.Y - 220);
        PokerTony.players[1].display(PokerTony.X / 2 + 50, PokerTony.Y - 220);
        if (playerCount > 2)
            PokerTony.players[2].display(15, PokerTony.Y / 2 - 50);
        if (playerCount > 3)
            PokerTony.players[3].display(PokerTony.X - 155, PokerTony.Y / 2 - 50);

        PokerTony.field.display();

        PokerTony.field.display();

    }

    public static int frozenPlayer() {

        int numberFrozenPlayer = 0;
        for (int i = 0; i < PokerTony.playerCount; i++) {
            if (PokerTony.players[i].getFrozen()) {
                numberFrozenPlayer = numberFrozenPlayer + 1;
            }
        }
        return numberFrozenPlayer;
    }

    public static int deadPlayer(){

        int numberDeadPlayer = 0;
        for(int i = 0; i < PokerTony.playerCount; i++){
            if(PokerTony.players[i].getDead()){
                numberDeadPlayer = numberDeadPlayer + 1;
            }
        }
        return numberDeadPlayer;
    }

    public static void endTurn(){


    }

    public static void play(Player player) {
        int returnCode;

        if (!player.getFrozen()) {
            returnCode = player.play();

            switch (returnCode) {

            case -1:
                player.setFrozen(true);
                break;

            case 0:

            }
        }
    }

}