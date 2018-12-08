package pokertony.utils;

import pokertony.*;

public class PokerUtils {

    public static int indice(Card[] tab) {
        /**
         * Return end indice of tabloid
         */
        int i = 0;
        try{
            while (tab[i] != null ) {
            i = i + 1;
        }
        }
        catch(Exception e){
            return i;
        }
        return i;
    }

    public static Card[] clone(int x, int y, Card[] tab) {
        /**
         * Copy part of a tab
         */

        Card[] returnTab = new Card[y-x];

        for (int i = 0; i < (y - x); i++) {
            returnTab[i] = tab[x + i];
        }
        return returnTab;

    }


    public static int[] clone(int x, int y, int[] tab) {
        /**
         * Copy part of a tab
         */

        int[] returnTab = new int[y-x];

        for (int i = 0; i < (y - x); i++) {
            returnTab[i] = tab[x + i];
        }
        return returnTab;

    }

    public static Card[] swapTwoCards(int pos1, int pos2, Card[] deck ){
        Card tmpCard = deck[pos1];
        deck[pos1] = deck[pos2];
        deck[pos2] = tmpCard;
        return deck;
    }

    public static void printTabloid(Card[] card){
        for(int i =0;i<card.length;i++){
            System.out.println(card[i].toString());
            
        }
    }
    public static void printTabloid(int[] card){
        for(int i =0;i<card.length;i++){
            System.out.println(card[i]);
        }
    }

    public static Boolean contain(int n, int p, int[] tabloid){
        int counter = 0;
        for(int i=0;i<tabloid.length;i++){
            if (tabloid[i] == n) {
                counter = counter + 1;
            }
        }
        if(counter == p){
            return true;
        }
        return false;
    }


}