/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokertony;

import PaD.*;
import java.util.*;
import pokertony.*;

public class PokerTony {

    public static void main(String[] args) {
        try {
            new PokerGame();
        } catch (InterruptedException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
