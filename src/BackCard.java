

import PaD.*;

public class BackCard {

    private static String path = "../ressources/images/back.gif";

    public static void display(double x, double y){

        PaD.Image img = new PaD.Image(path);
        img.setOrig(x,y);
        PokerTony.pad.ajouter(img);
    }
}