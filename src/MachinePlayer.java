

import PaD.*;
import java.util.*;

public class MachinePlayer extends Player{

    MachinePlayer(String name, CardPack cardPack){
        super(name,cardPack);
    }

    public void display(int x, int y){
        /**
         * Function witch display card only if player is not frozen
         */
        if(!this.getFrozen()){
            Texte texte = new Texte(x, y, name);

            PokerTony.pad.ajouter(texte);
            for (int i = 0; i < this.gethand().length; i++) {
                BackCard.display(x + i * 70, y + 25);
            }
        }

    }

    public int play(){
        return -1;
    }
}