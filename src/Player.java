//package pokertony;

import PaD.*;
import java.util.*;

public class Player {

    protected String name;
    private Card[] hand = new Card[cardPackLenght];
    private CardPack cardPack;
    private static int cardPackLenght = 2;
    private Boolean frozen = false;
    private int cash;


    public Player(String name, CardPack cardPack) {
        this.name = name;
        this.cardPack = cardPack;
    }




    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Card[] gethand() {
        return this.hand;
    }

    public void setHand() {
        this.hand = cardPack.takeNumberCard(2);
    }

    public CardPack getCardPack() {
        return this.cardPack;
    }

    public void setCardPack(CardPack cardPack) {
        this.cardPack = cardPack;
    }


    public void display(int x, int y) {
    }


    public void display(int y) {
    }


    public int play(){
        return -1;
    }

    public void setFrozen(Boolean frozen){
        this.frozen = frozen;
    }

    public Boolean getFrozen(){
        return this.frozen;
    }

}
