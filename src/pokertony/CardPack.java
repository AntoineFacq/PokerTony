package pokertony;

import PaD.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import pokertony.*;

public class CardPack {

    private ArrayList<Card> cards = new ArrayList<Card>();

    public CardPack() {
        for (Color color : Color.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(rank, color));
            }
        }
    }

    public CardPack(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Card drawFromDeck() {
        return this.cards.remove(this.cards.size() - 1);
    }

    /**
     * Transfer cards to a CardPack to another
     *
     * @param dest CardPack to transfer the Cards to
     * @param count
     */
    public void transferCards(CardPack dest, int from, int to) {
        ArrayList<Card> cardPackCards = this.getCards();
        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = from; i < to; i++) {

            cards.add(cardPackCards.get(i));
        }
        dest.setCards(cards);
    }

    public void swap(int first, int second) {

        Card temp = cards.get(first);

        cards.set(first, cards.get(second));
        cards.set(second, temp);
    }

    public void shuffle() {

        Random rand = new Random();

        int first;
        int second;

        for (int i = 0; i < this.cards.size(); i++) {

            first = rand.nextInt(52);
            second = rand.nextInt(52);

            swap(first, second);
        }
    }

    int partition(int low, int high, boolean byColor) {

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (this.cards.get(j).compareTo(this.cards.get(high), byColor) < 0) {

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
        rapidSort(0, cards.size() - 1, false);
    }

    public void rapidSort(boolean byColor) {
        rapidSort(0, cards.size() - 1, false);
    }

    public void display(double x, double y) {
        int j = 0;
        int i = 0;
        for (Card card : this.cards) {
            if (i == 13) {
                i = 0;
                j++;
            }
            card.display(i * 70 + x, j * 100 + y);
            i++;
        }
    }

    public void display() {
        this.display(0, 0);
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
