
import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private Card[] deck;
    private static final Random random = new Random();

    private int currentCard;
    private static int Num_Of_Cards = 52;

    public Deck(){

        Face[] faces = {

            Face.ACE, Face.DEUCE, Face.THREE, 
            Face.FOUR, Face.FIVE, Face.SIX, Face.SEVEN,
            Face.EIGHT, Face.NINE, Face.TEN, Face.JACK,
            Face.QUEEN, Face.KING, Face.Ace

        };

        Suit[] suits = { 

            Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES, 
            Suit.CLUBS

        };

        deck = new Card[Num_Of_Cards];
        currentCard = 0;

        for(int count = 0; count < deck.length; count++){

            deck[count] = new Card(faces[count % 13], suits[count / 13]);

        }

    }

    public void Shuffle(){

        currentCard = 0;

        for(int first = 0; first < deck.length; first++){

            int second = random.nextInt(Num_Of_Cards);

            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;


        }

    }

    public boolean getCardDeck(){

        int start = 1;

            for(Card k : deck){

                System.out.println( " " + start + "/52" + k);
                start++;

            }

            boolean getAllCards = false;

            if(start >= 53){

                return getAllCards = true;

            }else
                return getAllCards;

    }

    public Card dealNext(){

        Card topcard= this.deck[0];

            for(int currentCard = 1; currentCard < Num_Of_Cards; currentCard++){

                this.deck[currentCard - 1] = this.deck[currentCard];

            }

            this.deck[Num_Of_Cards - 1] = null;

            this.Num_Of_Cards --;

            return topcard;

    }

    public boolean checkDealNext(boolean r){

        Card topcard = this.deck[0];

        for(int currentCard = 1; currentCard < Num_Of_Cards; currentCard++){

            this.deck[currentCard - 1] = this.deck[currentCard];

        }

        this.deck[Num_Of_Cards - 1] = null;

        this.Num_Of_Cards --;

        return r;



    }

    
}
