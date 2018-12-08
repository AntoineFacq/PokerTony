package pokertony.hand;

import java.util.Arrays;
import java.util.List;
import pokertony.*;
import java.util.Collections;

public class ThreeOfKind extends Combination{

    public Boolean check(){
        /**
         * Return true if the player have a ThreeOfKind
         */
        List list = Arrays.asList(this.Counter);
        if(list.contains(3)){
            if (this.CounterCard[Collections.indexOfSubList(list, Arrays.asList(3))].getRank() == Rank.KING) {
                this.hightestCardCombinaison = CounterCard[Collections.indexOfSubList(list, Arrays.asList(3))].getRank().ordinal();
                return true;
            }
        }
        return false;
    }

    public ThreeOfKind(Card[] playableCards){
        super(playableCards);
        this.createCombinationByColor(this.playableCards);
    }
}