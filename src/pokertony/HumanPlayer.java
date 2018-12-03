package pokertony;



import PaD.*;
import java.util.*;

public class HumanPlayer extends Player{

    HumanPlayer(String name, CardPack cardPack){
        super(name,cardPack);
    }


    public void display(int x, int y) {
        /**
         * Function witch display card only if player is not frozen
         */
        if(!this.getFrozen()){

            Texte texte = new Texte(x, y, name);

            PokerTony.pad.ajouter(texte);
            for (int i = 0; i < this.gethand().length; i++) {
                this.gethand()[i].display(x + i * 70, y + 25);
            }
        }
    }



    public int play(){
        /**
         *  Function witch ask the player's decision
         */
        return -1;
    }

}

