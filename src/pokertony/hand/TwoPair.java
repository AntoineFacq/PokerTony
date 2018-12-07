package pokertony.hand;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import pokertony.*;

public class TwoPair extends Combination {

    public Boolean check() {
        /**
         * Return true if the player have two Pair
         */
        List list = Arrays.asList(this.Counter);
        if (Collections.frequency(list, 2) >= 2) {
            return true;
        }
        return false;
    }

    public TwoPair(Card[] playableCards){
        super(playableCards);
        this.createCombinationByColor(this.playableCards);
    }
}
