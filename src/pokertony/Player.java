package pokertony;

import PaD.*;
import java.util.*;

public class Player {

    String name;

    CardPack cardPack;

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Card[] getCards() {
        return this.getCardPack().getCards();
    }

    public void setCards(Card[] cards) {
        this.setCardPack(new CardPack(cards));
    }

    public CardPack getCardPack() {
        return this.cardPack;
    }

    public void setCardPack(CardPack cardPack) {
        this.cardPack = cardPack;
    }

    public void takeCards(CardPack cardPack, int from, int to) {

        Card[] cardPackCards = cardPack.getCards();
        Card[] cards = new Card[to - from];
        int j = 0;

        for (int i = from; i < to; i++) {

            cards[j] = cardPackCards[i];
            j++;
        }
        this.setCards(cards);

    }

    public void display(PlancheADessin pad, double x, double y) {

        Texte texte = new Texte(x, y, name);

        pad.ajouter(texte);
        for (int i = 0; i < this.getCards().length; i++) {
            this.getCards()[i].display(pad, x + i * 70, y + 25);
        }
    }

    public void display(PlancheADessin pad, double y) {
        this.display(pad, 0, y);
    }
}
