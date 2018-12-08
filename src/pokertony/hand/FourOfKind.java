package pokertony.hand;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import pokertony.*;

public class FourOfKind extends Combination{

    public Boolean check(){
        /**
         * Return true if the player have a Four Of Kind
         */
    
        List list = Arrays.asList(this.Counter);
        if(list.contains(4)){
            this.hightestCardCombinaison = CounterCard[Collections.indexOfSubList(list, Arrays.asList(4))].getRank().ordinal();
            return true;
        }
        else{
            return false;
        }
        
    }

    public FourOfKind(Card[] playableCards) {
        super(playableCards);
        this.createCombinationByColor(this.playableCards);
    }
}