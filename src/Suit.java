


public enum Suit{

    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");



    private final String suit;

    private Suit(String type){

    this.suit = type;

    }


    public String printSuit(){


        return suit;


    }

}