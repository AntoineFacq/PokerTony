package pokertony;

import PaD.*;
import java.util.*;

public class Player {

    private static int CARDS_COUNT = 2;

    private String name;

    private int winCount = 0;

    private CardPack cardPack = new CardPack(new ArrayList<Card>());
    

    private Hand hand;
    
    public Player(String name, int id) {
        this.setName(name);
        PokerGame.game.getCardPack().transferCards(this.getCardPack(), id * 2 + 7, (id + 1) * 2 + 7);
        this.hand = new Hand(this.getPlayableCards());
        
    }
    
    public Hand getHand(){
        return this.hand;
    }
    
    public ArrayList<Card> getPlayableCards(){
        ArrayList<Card> merged = new ArrayList<Card>();
        for(Card c : this.getCards()){
            merged.add(c);
        }
        for(Card c : this.getField().getCards()){
            merged.add(c);
        }
        return merged;
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

    public ArrayList<Card> getCards() {
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

}
