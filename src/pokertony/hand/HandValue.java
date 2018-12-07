package pokertony.hand;

import pokertony.Player;
import pokertony.PokerTony;
import pokertony.Card;
import pokertony.*;

public class HandValue {

    private Card[] playableCards = new Card[7];
    private Combination c;


    /*-------------------------------------------*/
    // This tabloid contain the combination (Straight, pair)
    // and the hightest card of the combinaison (as, 10)

    public int[] powerHand = new int[2];
    public Boolean treatment;
    /*-------------------------------------------*/

    /* ################################################################## */

    // Constructor //
    public HandValue(Player player){
      getPlayableCard(player);
      treatment = gameValue();
      
    }

    private void getPlayableCard(Player player) {
        /**
         * Get access to playable card only
         */
        int i = 0;
        while (i < player.getCards().length) {
            this.playableCards[i] = player.getCards()[i];
            i++;
        }
        i = 0;
        while (i < PokerGame.game.getField().getCards().length){
            this.playableCards[i+2] = PokerGame.game.getField().getCards()[i];
            i++;
        }
    }

    public Boolean gameValue() {

        c = new RoyalFlush(playableCards);
        if (c.check()) {
            powerHand[0] = 10;
            powerHand[1] = c.hightestCardCombinaison;
            return true;
            
        }
        c = new StraightFlush(playableCards);
        if (c.check()) {
            powerHand[0] = 9;
            powerHand[1] = c.hightestCardCombinaison;
            return true;
        }
        c = new FourOfKind(playableCards);
        if (c.check()) {
            powerHand[0] = 8;
            powerHand[1] = c.hightestCardCombinaison;
            return true;
        }
        c = new FullHouse(playableCards);
        if (c.check()) {
            powerHand[0] = 7;
            powerHand[1] = c.hightestCardCombinaison;
            return true;
        }
        c = new Flush(playableCards);
        if (c.check()) {
            powerHand[0] = 6;
            powerHand[1] = c.hightestCardCombinaison;
            return true;
        }
        c = new Straight(playableCards);
        if (c.check()) {
            powerHand[0] = 5;
            powerHand[1] = c.hightestCardCombinaison;
            return true;
        }
        c = new ThreeOfKind(playableCards);
        if (c.check()) {
            powerHand[0] = 4;
            powerHand[1] = c.hightestCardCombinaison;
            return true;
        }
        c = new Kind(playableCards);
        if (c.check()) {
            powerHand[0] = 3;
            powerHand[1] = c.hightestCardCombinaison;
            return true;
        }
        c = new TwoPair(playableCards);
        if (c.check()) {
            powerHand[0] = 2;
            powerHand[1] = c.hightestCardCombinaison;
            return true;
        }
        c = new Pair(playableCards);
        if (c.check()) {
            powerHand[0] = 1;
            powerHand[1] = c.hightestCardCombinaison;
            return true;
        } else {
            c = new Combination(playableCards);
            powerHand[0] = 0;
            powerHand[1] = c.hightestCard(c.playableCards);
            return true;

        }

    }

}
