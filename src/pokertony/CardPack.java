package pokertony;

import PaD.*;
import java.util.Random;
import java.util.Vector;

public class CardPack {

    private Card[] cards;

    public CardPack() {
        cards = new Card[52];
        int i = 0;

        for (Color color : Color.values()) {

            for (Rank rank : Rank.values()) {
                this.cards[i] = new Card(rank, color);
                i++;
            }
        }
    }

    public CardPack(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return this.cards;
    }
    
    public Object[] getCardsByValue(Rank rank) {
        var cards = new Vector();
        for(Card c : this.getCards()) {
            if(c.getRank() == rank){
                cards.addElement(c);
            }
        }
        return cards.toArray();
    }
    
    public Object[] getCardsByColor(Color color) {
        var cards = new Vector();
        for(Card c : this.getCards()) {
            if(c.getColor() == color){
                cards.addElement(c);
            }
        }
        return cards.toArray();
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public void swap(int first, int second) {

        Card temp = cards[first];

        cards[first] = cards[second];
        cards[second] = temp;
    }

    public void shuffle() {

        Random rand = new Random();

        int first;
        int second;

        for (int i = 0; i < this.cards.length; i++) {

            first = rand.nextInt(52);
            second = rand.nextInt(52);

            swap(first, second);
        }
    }

    int partition(int low, int high, boolean byColor) {

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (this.cards[j].compareTo(this.cards[high], byColor) < 0) {

                i++;

                swap(i, j);
            }
        }

        swap(i + 1, high);

        return i + 1;
    }

    void rapidSort(int low, int high, boolean byColor) {

        if (low < high) {

            int p = partition(low, high, byColor);

            rapidSort(low, p - 1);

            rapidSort(p + 1, high);
        }
    }

    void rapidSort(int low, int high) {
        rapidSort(low, high, false);
    }

    public void rapidSort() {
        rapidSort(0, cards.length - 1, false);
    }
    
    public void rapidSort(boolean byColor) {
        rapidSort(0, cards.length - 1, false);
    }

    public void display(PlancheADessin pad, double x, double y) {
        int j = 0;
        int i = 0;
        for (Card card : this.cards) {
            if (i == 13) {
                i = 0;
                j++;
            }
            card.display(pad, i * 70 + x, j * 100 + y);
            i++;
        }
    }

    public void display(PlancheADessin pad) {
        this.display(pad, 0, 0);
    }

    /**
     *
     * @return the card list
     */
    @Override
    public String toString() {

        String output = "";

        for (Card card : this.cards) {
            output += card + "\n";
        }

        return output;
    }
}
