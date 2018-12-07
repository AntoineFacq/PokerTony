package pokertony;

import PaD.*;

public class GameValue {

    private Card[] handAndAllField = new Card[7];
    private Card[] handAndAutorizeFiled;

    GameValue(Player player) {
        // this.handAndField = player.getHand() + PokerTony.field.getCards();
    }

    /*
    public Card[] autorizeCard(){
        /**
         * Créer un tableau que avec la main du joueur et les cartes retournés
         
        return 
    }
     */
    public Boolean checkPair(Card[] cards) {
        /**
         * Return true if the player have a Pair
         */
        return true;
    }

    public Boolean checkTwoPair() {
        /**
         * Return true if the player have two Pair
         */
        return true;
    }

    public Boolean checkKind() {
        /**
         * Return true if the player have a Kind
         */
        return true;
    }

    public Boolean checkThreeOfKind() {
        /**
         * Return true if the player have a ThreeOfKind
         */
        return true;
    }

    public Boolean checkStraight() {
        /**
         * Return true if the player have a Straight
         */
        return true;
    }

    public Boolean checkFlush() {
        /**
         * Return true if the player have a Flush
         */
        return true;
    }

    public Boolean checkFullHouse() {
        /**
         * Return true if the player have a Full House
         */
        return true;
    }

    public Boolean checkFourOfKind() {
        /**
         * Return true if the player have a Four Of Kind
         */
        return true;
    }

    public Boolean checkStraightFlush() {
        /**
         * Return true if the player have a Straight Flush
         */
        return true;
    }

    public Boolean checkRoyalFlush() {
        /**
         * Return true if the player have a Royal Flush
         */
        return true;
    }

    public static void compareGameValue() {
        /**
         * Compare GameValue of all player
         */
    }

}
