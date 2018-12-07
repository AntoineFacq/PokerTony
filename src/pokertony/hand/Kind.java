package pokertony.hand;

import pokertony.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Kind extends Combination{

    public Boolean check(){
        /**
         * Return true if the player have a Kind
         */
        List list = Arrays.asList(this.Counter);
        if(list.contains(3)){ // PokerUtils.contain(3,1,this.counter)
           // this.hightestCardCombinaison = CounterCard[Collections.indexOfSubList(list, Arrays.asList(3))].getRank().ordinal();
            return true;
        }
        return false;
    }

    public Kind(Card[] playableCards){
        super(playableCards);
        this.createCombinationByColor(this.playableCards);
    }

}