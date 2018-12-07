package pokertony.hand;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import pokertony.*;

public class FullHouse extends Combination{

    public Boolean check(){
        /**
         * Return true if the player have a Full House
         */
        List list = Arrays.asList(this.Counter);
        if(list.contains(2) && list.contains(3)){
            this.hightestCardCombinaison = CounterCard[Collections.indexOfSubList(list, Arrays.asList(3))].getRank().ordinal();
            return true;
        }
        else{
            return false;
        }
        
    }

    public FullHouse(Card[] playableCards){
        super(playableCards);
        this.createCombinationByColor(this.playableCards);
    }
}