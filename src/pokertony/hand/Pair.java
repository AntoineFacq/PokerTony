package pokertony.hand;

import pokertony.*;
import pokertony.utils.PokerUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Pair extends Combination {

    public Boolean check() {
        /**
         * Return true if the player have a Pair
         */
        List list = Arrays.asList(this.Counter);
        if (PokerUtils.contain(2, 1, this.Counter)) {
            //this.hightestCardCombinaison = CounterCard[Collections.indexOfSubList(list, Arrays.asList(2))].getRank().ordinal();
            return true;
        }
        return false;
    }

    public Pair (Card[] playableCards){
        super(playableCards);
        this.createCombinationByColor(this.playableCards);

    }
}
