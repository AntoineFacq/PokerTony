package pokertony;

import java.util.Arrays;
import pokertony.utils.PokerException;

public final class Field {

    public static final int HIDDEN = 0;
    public static final int FIRST_SHOW = 1;
    public static final int SECOND_SHOW = 2;
    
    private int state;
    private int shownCards;
    private final CardPack cardPack = new CardPack(new Card[5]);

    public Field() {
        PokerGame.game.getCardPack().transferCards(this.getCardPack(), 0, 5);
        this.setState(Field.HIDDEN);
    }

    public void setState(int state) {
        this.state = state;
        switch (state) {
            case Field.HIDDEN:
                this.shownCards = 0;
                break;
            case Field.FIRST_SHOW:
                this.shownCards = 3;
                break;
            case Field.SECOND_SHOW:
                this.shownCards = 5;
                break;
        }
        for (int i = 0; i < this.shownCards; i++) {
            this.getCards()[i].setTurned(true);
        }
    }

    public Card[] getCards() {
        return this.getCardPack().getCards();
    }

    public CardPack getCardPack() {
        return this.cardPack;
    }

    public void display() {

        int x = 280;
        int y = PokerGame.game.Y / 2 - 100;
        for (Card card : this.getCards()) {
            card.display(x, y);
            x = x + 80;
        }

    }
}
