package pokertony.hand;

import pokertony.*;
import pokertony.utils.PokerUtils;

public class RoyalFlush extends Combination {

    public Boolean check() {
        /**
         * Return true if the player have a Royal Flush
         */
        if (notNullComb1) {
            PokerUtils.printTabloid(this.Combination1);
            if (checkFiveStraight(this.Combination1) && hightestCard(this.Combination1) == Rank.ACE.ordinal()) {
                return true;
            }
        } else if (notNullComb2) {
            if (checkFiveStraight(this.Combination2) && hightestCard(this.Combination2) == Rank.ACE.ordinal()) {
                return true;
            }
        } else if (notNullComb3) {
            if (checkFiveStraight(this.Combination2) && hightestCard(this.Combination2) == Rank.ACE.ordinal()) {
                return true;
            }
        } 
        return false;

    }

    public RoyalFlush(Card[] playableCards) {
        super(playableCards);
        this.createCombinationByColor(this.playableCards);
    }

}