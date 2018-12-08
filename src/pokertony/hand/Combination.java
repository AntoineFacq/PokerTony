package pokertony.hand;

import pokertony.*;
import pokertony.utils.*;
import java.lang.Enum.*;
import pokertony.Rank;
import pokertony.Card;

public class Combination {

    protected Card[] playableCards;

    protected int hightestCardCombinaison;
    protected Card[] spadeCards = new Card[7];
    protected int spCard = 0;
    protected Card[] clubCards  = new Card[7];
    protected int cbCard = 0;
    protected Card[] diamondCards  = new Card[7];
    protected int diCard = 0;
    protected Card[] heartCards  = new Card[7];
    protected int heCard = 0;
    protected Card[] firstPair;
    protected Card[] secondPair;

    protected Card[] Combination1;
    protected Card[] Combination2;
    protected Card[] Combination3;

    protected Card[] finalCombinaison;

    protected Card[] CounterCard = new Card[7];
    protected int[] Counter = new int[7];
    protected int iCounter = 0;
    protected int iCounterCard = 0;

    protected Boolean notNullComb1 = false;
    protected Boolean notNullComb2 = false;
    protected Boolean notNullComb3 = false;

    public Combination(Card[] cards) {
        this.playableCards = Combination.sort(cards);
        this.countSameCard();
        sortColor();
        compilTabloid();
        PokerUtils.printTabloid(this.CounterCard);
        PokerUtils.printTabloid(Counter);
        /*System.out.println("SPCard " + spCard+ " " +spadeCards.length);
        
        System.out.println(diCard);
        System.out.println(heCard);*/

        
    }

        public void compilTabloid(){
            
            Card [] temp = new Card[7];
            int[] temp2 = new int[7];

            temp = this.spadeCards;
            this.spadeCards = new Card[this.spCard];
            this.spadeCards = PokerUtils.clone(0, this.spCard, temp);
            temp = this.diamondCards;
            this.diamondCards = new Card[this.diCard];
            this.diamondCards = PokerUtils.clone(0, this.diCard, temp);
            temp = this.clubCards;
            this.clubCards = new Card[this.diCard];
            this.clubCards = PokerUtils.clone(0, this.cbCard, temp);
            temp = this.heartCards;
            this.heartCards = new Card[this.heCard];
            this.heartCards = PokerUtils.clone(0, this.heCard, temp);
            temp = this.CounterCard;
            this.CounterCard = new Card[this.iCounterCard];
            this.CounterCard = PokerUtils.clone(0, this.iCounterCard,temp);
            temp2 = this.Counter;
            this.Counter = new int[this.iCounter];
            this.Counter = PokerUtils.clone(0, this.iCounter,temp2);
        }

    public void sortColor() {
        for (int i = 0; i < playableCards.length-1; i++) {
            if (this.playableCards[i].getColor() == Color.SPADE) {
                this.spadeCards[this.spCard+1] = this.playableCards[i];
                this.spCard = this.spCard + 1;
            } else if (this.playableCards[i].getColor() == Color.CLUB) {
                this.clubCards[cbCard + 1] = this.playableCards[i];
                this.spCard  =this.spCard + 1;
            } else if (this.playableCards[i].getColor() == Color.DIAMOND) {
                this.diamondCards[diCard + 1] = this.playableCards[i];
                this.diCard = this.diCard + 1;
            } else {
                this.heartCards[heCard + 1] = this.playableCards[i];
                this.heCard = this.heCard + 1;
            }
        }

    }
    public Boolean check(){
        return true;
    }

    public Boolean checkFiveStraight(Card[] cCombination) {

        if (((cCombination[0].getRank().ordinal()) == ((cCombination[1].getRank().ordinal())- 1))  && ((cCombination[0].getRank().ordinal()) == ((cCombination[2].getRank().ordinal())- 2))
        && ((cCombination[0].getRank().ordinal()) == ((cCombination[3].getRank().ordinal())- 3)) && ((cCombination[0].getRank().ordinal()) == ((cCombination[4].getRank().ordinal())- 4))) {

            return true;
        } else {
            return false;
        }
    }

    public Boolean checkFiveColor(Card [] cCombination){
        if (((cCombination[0].getColor().ordinal()) == ((cCombination[1].getColor().ordinal())- 1))  && ((cCombination[0].getColor().ordinal()) == ((cCombination[2].getColor().ordinal())- 2))
        && ((cCombination[0].getColor().ordinal()) == ((cCombination[3].getColor().ordinal())- 3)) && ((cCombination[0].getColor().ordinal()) == ((cCombination[4].getColor().ordinal())- 4))) {

            return true;
        }
    else{
        return false;
    }
}

    public int hightestCard(Card[] cCombination) {

        Card hightestCard = cCombination[0];
        for (int i = 0; i < cCombination.length; i++) {
            if (cCombination[i].getRank().ordinal() > hightestCard.getRank().ordinal()) {
                hightestCard = cCombination[i];
            }

        }
        return hightestCard.getRank().ordinal();
    }

    public int smallestCard(Card[] cCombination) {

        Card smallestCard = cCombination[0];
        for (int i = 0; i < cCombination.length; i++) {
            if (cCombination[i].getRank().ordinal() < smallestCard.getRank().ordinal()) {
                smallestCard = cCombination[i];
            }

        }
        return smallestCard.getRank().ordinal();

    }


    

    /*---------------------------------------------*/
    public static Card[] sort(Card cards[]) {
        /**
         * Sort Card by Rank and Color, value is more important 
         */

        /* Sort Card at first by Rank */
        int i = 0;
        int n = 1;
        
        while (i < (cards.length - 1)) {
            if (cards[i].getRank().ordinal() > cards[i + n].getRank().ordinal()) {
                // index color card 1 > index color card 2
                cards = PokerUtils.swapTwoCards(i, i + n, cards); // swap position of cards
                n = 1;
            } else if (n + i == cards.length-1) { // max table
                i = i + 1;
                n = 1;
            } else {
                n = n + 1;
            }
        }
        /* Sort Card in Second by Color */
        i = 0;
        n = 1;
        while (i < (cards.length - 1)) {

            if (cards[i].getRank().ordinal() == cards[i + n].getRank().ordinal()
                    && cards[i].getColor().ordinal() > cards[i + n].getColor().ordinal()) {
                // same color but superior value
                cards = PokerUtils.swapTwoCards(i, i + 1, cards);
                n = 1;
            } else if (n + i == cards.length-1) {
                i = i + 1;
                n = 1;
            } else {
                n = n + 1;
            }
        }
        return cards;
    }

    public void createCombinationByColor(Card[] Combination) {
        if (this.spadeCards.length >= 5) {
            int y = spadeCards.length;
            if (y == 5) {
                this.Combination1 = PokerUtils.clone(0, 5, spadeCards);
                this.notNullComb1 = true;
            }
            if (y == 6) {
                this.Combination1 = PokerUtils.clone(0, 5, spadeCards);
                this.Combination2 = PokerUtils.clone(1, 6, spadeCards);
                this.notNullComb1 = true;
                this.notNullComb2 = true;
            }
            if (y == 7) {
                this.Combination1 = PokerUtils.clone(0, 5, spadeCards);
                this.Combination2 = PokerUtils.clone(1, 6, spadeCards);
                this.Combination3 = PokerUtils.clone(2, 7, spadeCards);
                this.notNullComb1 = true;
                this.notNullComb2 = true;
                this.notNullComb3 = true;
            }

        } else if (this.clubCards.length >= 5) {
            int y = clubCards.length;
            if (y == 5) {
                this.Combination1 = PokerUtils.clone(0, 5, clubCards);
                this.notNullComb1 = true;
            }
            if (y == 6) {
                this.Combination1 = PokerUtils.clone(0, 5, clubCards);
                this.Combination2 = PokerUtils.clone(1, 6, clubCards);
                this.notNullComb1 = true;
                this.notNullComb2 = true;
            }
            if (y == 7) {
                this.Combination1 = PokerUtils.clone(0, 5, clubCards);
                this.Combination2 = PokerUtils.clone(1, 6, clubCards);
                this.Combination3 = PokerUtils.clone(2, 7, clubCards);
                this.notNullComb1 = true;
                this.notNullComb2 = true;
                this.notNullComb3 = true;
            }
        } else if (this.diamondCards.length >= 5) {
            int y = diamondCards.length;
            if (y == 5) {
                this.Combination1 = PokerUtils.clone(0, 5, diamondCards);
                this.notNullComb1 = true;
            }
            if (y == 6) {
                this.Combination1 = PokerUtils.clone(0, 5, diamondCards);
                this.Combination2 = PokerUtils.clone(1, 6, diamondCards);
                this.notNullComb1 = true;
                this.notNullComb2 = true;
            }
            if (y == 7) {
                this.Combination1 = PokerUtils.clone(0, 5, diamondCards);
                this.Combination2 = PokerUtils.clone(1, 6, diamondCards);
                this.Combination3 = PokerUtils.clone(2, 7, diamondCards);
                this.notNullComb1 = true;
                this.notNullComb2 = true;
                this.notNullComb3 = true;
            }
        } else if (this.heartCards.length >= 5) {
            int y = heartCards.length;
            if (y == 5) {
                this.Combination1 = PokerUtils.clone(0, 5, heartCards);
                this.notNullComb1 = true;
            }
            if (y == 6) {
                this.Combination1 = PokerUtils.clone(0, 5, heartCards);
                this.Combination2 = PokerUtils.clone(1, 6, heartCards);
                this.notNullComb1 = true;
                this.notNullComb2 = true;
            }
            if (y == 7) {
                this.Combination1 = PokerUtils.clone(0, 5, heartCards);
                this.Combination2 = PokerUtils.clone(1, 6, heartCards);
                this.Combination3 = PokerUtils.clone(2, 7, heartCards);
                this.notNullComb1 = true;
                this.notNullComb2 = true;
                this.notNullComb3 = true;
            }
        } else {


        }
    }

    public int countSameCard() {
        int counter = 1;

        for (int i = 0; i < this.playableCards.length-1; i++) {
            if (playableCards[i].getRank() == playableCards[i + 1].getRank()) {
                counter = counter + 1;
                //System.out.println(playableCards[i].toString() +"   " + playableCards[i+1].toString());
            }
            else {
                //System.out.println(playableCards[i].toString() +"   " + playableCards[i+1].toString());
                Counter[iCounter] = counter;
                CounterCard[iCounterCard] = playableCards[i];
                iCounterCard = iCounterCard + 1;
                iCounter = iCounter + 1;
                counter = 1;
            }
            
            

        }
        Counter[iCounter] = counter;
        CounterCard[iCounterCard] = playableCards[this.playableCards.length-1];
        iCounterCard = iCounterCard + 1;
        iCounter = iCounter + 1;


        


        //System.out.println("------FIN--------");
        return counter;

    }



}