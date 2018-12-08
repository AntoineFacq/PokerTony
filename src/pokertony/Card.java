package pokertony;

import PaD.*;
import pokertony.*;

import java.util.*;

public class Card {

    private Color color;
    private Rank rank;
    private Image img;

    private boolean turned = false;

    public Card(Rank r, Color c) {
        this.rank = r;
        this.color = c;
    }

    public void setTurned(boolean toggle) {
        this.turned = toggle;
    }

    public boolean isTurned() {
        return this.turned;
    }

    public Color getColor() {
        return this.color;
    }

    public Rank getRank() {
        return this.rank;
    }

    public static String rankAsString(int i) {
        return Rank.values()[i].toString();
    }
    
    public static String suitAsString(int i) {
        return Color.values()[i].toString();
    }

    public int compareTo(Card c, boolean byColor) {
        if (byColor) {
            if (this.getColor().ordinal() == c.getColor().ordinal()) {

                return this.rank.ordinal() - c.getRank().ordinal();
            }
        }
        return this.getColor().ordinal() - c.getColor().ordinal();
    }

    public void display(double x, double y) {
        String path;
        if (this.isTurned()) {
            path = "resources/images/" + this.getRank().toString().toLowerCase() + "-" + this.getColor().toString().toLowerCase() + ".gif";
        } else {
            path = "resources/images/back.gif";
        }
        img = new Image(path);
        img.setOrig(x, y);

        PokerGame.game.getPaD().ajouter(this.img);
    }

    @Override
    public String toString() {
        return this.rank + " (" + this.rank.getValue() + ") of " + this.getColor();
    }

}
