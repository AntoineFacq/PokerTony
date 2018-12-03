package pokertony;



public class Field{

    private Card[] cards;
    private int numberTurnedCards;

    Field(CardPack cardPack){
        this.cards = cardPack.takeNumberCard(5);
        this.numberTurnedCards = 3;
    }

    public void returnCard(){
        if(numberTurnedCards < 5 ){
        this.numberTurnedCards = this.numberTurnedCards + 1;
        }
        else{
            Error.printError(1);
        }

    }

    public Card[] getCards(){
        return cards;
    }


    public void display(){

        int x = 280 ;
        int y = PokerTony.Y/2-100;

        for(int i = 0; i < numberTurnedCards; i++){
            cards[i].display(x, y);
            x = x + 80;
        }

        for (int i = 0; i <(5 - numberTurnedCards);i++){
            BackCard.display(x , y);
            x = x + 80;
        }

    }

    public int getNumberTurnedCard(){
        return numberTurnedCards;

    }



}