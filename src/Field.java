

public class Field{

    private Card[] cards;
    private int turnedCards;

    Field(CardPack cardPack){
        this.cards = cardPack.takeNumberCard(5);
        this.turnedCards = 3;
    }

    public void returnCard(){
        if(turnedCards < 5 ){
        this.turnedCards = this.turnedCards + 1;
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

        for(int i = 0; i < turnedCards; i++){
            cards[i].display(x, y);
            x = x + 80;
        }

        for (int i = 0; i <(5 - turnedCards);i++){
            BackCard.display(x , y);
            x = x + 80;
        }

    }



}