package pokertony;

import PaD.*;

public class Card {

    private Color color;

    private Rank rank;

    private Image img;

    public Card(Rank r, Color c) {

        this.rank = r;
        this.color = c;
    }

    public Color getColor() {
        return this.color;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int compareTo(Card c, boolean byColor) {
        if (byColor) {
            if (this.getColor().ordinal() == c.getColor().ordinal()) {

                return this.rank.ordinal() - c.getRank().ordinal();
            }
        }
        return this.getColor().ordinal() - c.getColor().ordinal();
    }

    public void display(PlancheADessin pad, double x, double y) {
        String path = "src/pokertony/images/" + this.getRank().toString().toLowerCase() + "-" + this.getColor().toString().toLowerCase() + ".gif";

        img = new PaD.Image(path);
        img.setOrig(x, y);

        pad.ajouter(this.img);
    }

    @Override
    public String toString() {
        return this.rank + " (" + this.rank.getValue() + ") of " + this.getColor();
    }
}
