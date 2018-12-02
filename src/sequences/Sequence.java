/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package pokertony.sequences;

//import pokertony.*;

/**
 *
 * @author antoine
 */
public class Sequence {

    private CardPack cardPack;
    
    /**
     * Times a sequence matches
     */
    private int count;
    
    /**
     * Level of the sequence (highest level is royal_flush)
     */
    private int level;
    
    /**
     * 
     */
    private int degree;

    public Sequence(CardPack cardPack) {
        this.setCardPack(cardPack);
        this.getCardPack().rapidSort();
    }

    public void setCardPack(CardPack cardPack) {
        this.cardPack = cardPack;
    }

    public CardPack getCardPack() {
        return this.cardPack;
    }

    public Card[] getCards() {
        return this.getCardPack().getCards();
    }

    public void incrementCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }

    public int compare(Sequence seq) {
        if (this.compareLevel(seq) == 0) {
            return this.compareDegree(seq);
        }
        return this.compareLevel(seq);
    }

    public int compareLevel(Sequence seq) {
        return this.getLevel() - seq.getLevel();
    }

    public int compareDegree(Sequence seq) {
        return this.getDegree() - seq.getDegree();
    }

    public int getLevel() {
        return this.level;
    }

    public int getDegree() {
        return this.degree;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

}
