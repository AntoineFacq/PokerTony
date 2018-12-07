package pokertony.hand;

import pokertony.*;

public class StraightFlush extends Combination{

    
    public Boolean check(){
        /**
         * Return true if the player have a Straight Flush
         */
        if (notNullComb3) {
            if (checkFiveStraight(this.Combination3)) {
                this.hightestCardCombinaison = this.hightestCard(Combination3);
                return true;
            }
        } else if (notNullComb2) {
            if (checkFiveStraight(this.Combination2)) {
                this.hightestCardCombinaison = this.hightestCard(Combination2);
                return true;
            }
        } else if (notNullComb1) {
            if (checkFiveStraight(this.Combination1)) {
                this.hightestCardCombinaison = this.hightestCard(Combination1);
                return true;
            }
        } else {
            return false;
        }
        return false; // Attention !

    }
    
   public StraightFlush(Card[] playableCards){
        super(playableCards);
        this.createCombinationByColor(this.playableCards);
   }
}


