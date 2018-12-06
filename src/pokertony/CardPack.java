package pokertony;

import PaD.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class CardPack {

    private Card[] cards;
    private int counter;

    public CardPack() {
        this.cards = new Card[52];
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

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    /**
     * Transfer cards to a CardPack to another
     *
     * @param dest CardPack to transfer the Cards to
     * @param count
     */
    public void transferCards(CardPack dest, int from, int to) {
        Card[] cardPackCards = this.getCards();
        Card[] cards = new Card[to - from];
        int j = 0;

        for (int i = from; i < to; i++) {

            cards[j] = cardPackCards[i];
            j++;
        }
        dest.setCards(cards);
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

    public Card[] takeNumberCard(int number) {

        Card[] returnCard = new Card[number];

        for (int i = counter; i < (counter + number); i++) {
            returnCard[i - counter] = cards[i];
        }
        this.counter = this.counter + number;
        return returnCard;
    }
}
