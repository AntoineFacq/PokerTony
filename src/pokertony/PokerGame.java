/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokertony;

import PaD.*;
import java.util.*;

public class PokerGame {

    private Player[] players;
    public String[] names = new String[]{"Rayan", "Antoine F.", "Antoine B.", "Maxime", "Clément", "Raphael", "Loic", "Maeva", "Océane", "Océane", "Oriane", "Salomé", "Kevin", "Pierre", "Lucas", "Jérémie", "Charly", "Yidong", "Hanwen", "Tommy", "Louis"};

    public Player player;

    public int X = 1000;
    public int Y = 700;

    private PlancheADessin pad = new PlancheADessin(X, Y);
    public Field field;
    public CardPack cardPack = new CardPack(); // Initialize 52 CardPack;

    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();

    public static PokerGame game;

    public PokerGame() throws InterruptedException {
        game = this;
        this.getCardPack().shuffle(); // Shake it
        this.field = new Field();
        boolean rematch = true;

        Texte header = new Texte(300, 20, "Welcome on PokerTony!\nA (not so) quick poker game!");
        Texte instructions = new Texte(300, 40, "To start, open your prompt and follow instructions...");
        pad.ajouter(header, instructions);
        this.displayDecoration();

        int botCount = 0;
        while (botCount < 1 || botCount > 3) {
            botCount = promptInt("How many bots do you want to play with? (1-3)");
        }
        this.players = new Player[botCount + 1];

        var nick = promptString("Please provide your name:");
        
        while (rematch) {
            pad.clear();
            this.player = this.players[0] = new Player(nick, this);
            this.getCardPack().transferCards(this.player.getCardPack(), 5, 7);
            for (Card c : this.player.getCards()) {
                c.setTurned(true);
            }

            for (int i = 1; i < this.getPlayers().length; i++) {
                this.players[i] = new Player(names[random.nextInt(names.length)], this);
                this.getCardPack().transferCards(this.players[i].getCardPack(), i * 2 + 7, (i + 1) * 2 + 7);
            }
            this.setGameState(Field.HIDDEN);
            this.displayGame();

            Thread.sleep(2000);
            this.setGameState(Field.FIRST_SHOW);
            Thread.sleep(2000);
            this.setGameState(Field.SECOND_SHOW);

            Thread.sleep(2000);

            for (Player p : this.players) {
                for (Card c : p.getCards()) {
                    c.setTurned(true);
                }
            }
            displayGame();

            if (!promptString("Do you want to rematch? (y/n)").equals("y")) {
                echoln("Bye! Hope you had fun!");
                System.exit(0);
            }
        }
    }

    public void setGameState(int state) {
        /*
        switch (state) {
            case Field.HIDDEN:
                break;
            case Field.FIRST_SHOW:
                break;
            case Field.SECOND_SHOW:
                break;
        }
         */
        this.getField().setState(state);
        this.getField().display();
    }

    public PlancheADessin getPaD() {
        return this.pad;
    }

    public Field getField() {
        return this.field;
    }

    public CardPack getCardPack() {
        return this.cardPack;
    }

    public void displayGame() {

        this.getPlayers()[0].display(this.X / 2 - 250, this.Y - 220);
        this.getPlayers()[1].display(this.X / 2 + 50, this.Y - 220);
        if (this.getPlayers().length > 2) {
            this.getPlayers()[2].display(15, this.Y / 2 - 50);
        }
        if (this.getPlayers().length > 3) {
            this.getPlayers()[3].display(this.X - 185, this.Y / 2 - 50);
        }

        this.getField().display();

    }

    public void displayDecoration() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            CardPack decoration = new CardPack();
            if (i != 9) {
                decoration = new CardPack(new Card[]{decoration.getCards()[random.nextInt(52)], decoration.getCards()[random.nextInt(52)]});
            } else {
                decoration = new CardPack(new Card[]{new Card(Rank.ACE, Color.HEART), new Card(Rank.ACE, Color.SPADE)});
            }
            for (Card c : decoration.getCards()) {
                c.setTurned(true);
            }
            decoration.display(425, 200);
            Thread.sleep(100);
        }

    }

    public Player[] getPlayers() {
        return this.players;
    }

    public static void echoln(String message) {
        System.out.println(message);
    }

    public static void echo(String message) {
        System.out.print(message);
    }

    public static String promptString(String message) {
        echoln(message);
        String line = scan.nextLine();
        scan.nextLine();
        return line;
    }

    public static int promptInt(String message) {
        echoln(message);
        int line = scan.nextInt();
        scan.nextLine();
        return line;
    }

}
