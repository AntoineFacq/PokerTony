package pokertony;
import pokertony.hand.HandValue;

import PaD.*;
import java.util.*;

public class Player {

    private static int CARDS_COUNT = 2;

    private String name;

    private int winCount = 0;

    private CardPack cardPack = new CardPack(new Card[2]);

    private HandValue handValue;

    private int[] powerHand;
    

    public Player(String name) {
        this.setName(name);
    }

    public Field getField() {
        return PokerGame.game.getField();
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

    //temp
    public void printHand(){
        System.out.println("Joueur:  " + this.name);    //supe
        System.out.println();
        this.handValue = new HandValue(this);
        this.powerHand = handValue.powerHand;
        
        System.out.println("###Combinaison "  + powerHand[0]);
        System.out.println("###Carte hautes" +  powerHand[1]);
        }

}
