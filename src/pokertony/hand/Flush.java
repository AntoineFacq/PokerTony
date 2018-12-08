package pokertony.hand;

import pokertony.*;
public class Flush extends Combination{

    

    public Boolean check(){
        /**
         * Return true if the player have a Flush
         */
        if(this.notNullComb3){
            this.hightestCardCombinaison = this.hightestCard(this.Combination3);
            return true;
        }
        else if(this.notNullComb2){
            this.hightestCardCombinaison = this.hightestCard(this.Combination2);
            return true;
        }
        else if(this.notNullComb1){
            this.hightestCardCombinaison = this.hightestCard(this.Combination1);
            return true;
        }
        else{
            return false;
        }
    }

    public Flush(Card[] playableCards){
        super(playableCards);
        this.createCombinationByColor(this.playableCards);
    }

}