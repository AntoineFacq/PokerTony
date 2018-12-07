package pokertony.hand;

import pokertony.*;
import pokertony.utils.*;

public class Straight extends Combination{

    public Boolean check(){
        /**
         * Return true if the player have a Straight
         */
        this.Combination1 = PokerUtils.clone(0 ,5,this.playableCards);
        this.Combination2 = PokerUtils.clone(1, 7, this.playableCards);
        this.Combination3 = PokerUtils.clone(2, 7, this.playableCards);

        if(this.checkFiveStraight(this.Combination3)){
            this.hightestCardCombinaison = this.hightestCard(Combination3);
            return true;
        }
        else if(this.checkFiveStraight(this.Combination2)){
            this.hightestCardCombinaison = this.hightestCard(Combination2);
            return true;
        }
        else if(this.checkFiveStraight(this.Combination1)){
            this.hightestCardCombinaison = this.hightestCard(Combination1);
            return true;
        }
        else{
            return false;
        }

    }

    public Straight(Card[] playableCards){
        super(playableCards);
        this.createCombinationByColor(this.playableCards);
    }
}