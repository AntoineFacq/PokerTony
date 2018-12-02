/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package pokertony.sequences;

//import pokertony.*;


/**
 *
 * @author antoine
 */
public class HighCard extends Sequence {

    public HighCard(CardPack cardPack) {
            super(cardPack);
    }

    public boolean hasInHand() {
        return true;
    }

}
