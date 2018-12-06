package pokertony;

import PaD.*;
import java.util.*;

public class Player {

    private static int CARDS_COUNT = 2;

    private String name;

    private int winCount = 0;

    private PokerGame game;

    private CardPack cardPack = new CardPack(new Card[2]);

    public Player(String name, PokerGame game) {
        this.setName(name);
        this.game = game;
    }

    public PokerGame getGame() {
        return this.game;
    }

    public Field getField() {
        return this.getGame().getField();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public CardPack getCardPack() {
        return this.cardPack;
    }

    public Card[] getCards() {
        return this.getCardPack().getCards();
    }

    public void setCardPack(CardPack cardPack) {
        this.cardPack = cardPack;
    }

    public void display(int x, int y) {
        Texte texte = new Texte(x, y, name);

        PokerGame.game.getPaD().ajouter(texte);
        int i=0;
        for(Card c : this.getCards()){
            c.display(x+i*100, y + 25);
            i++;
        }
    }

    public void display(int y) {
    }

    public void GameValue() {
        /**
         * Gere la classe game value en l'attribuant au joueurs
         */
    }

}
