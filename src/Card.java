public class Card {

    private Face face; 
    private Suit suit;

    int total = 0;

        public Card(Face cardFace, Suit cardSuit){
            
            this.face = cardFace;
            this.suit = cardSuit;
        
        }

        public int getFace(){

            return face.getValue();

        }

        public String getSuit(){

            return suit.printSuit();

        }

        @Override
        public String toString(){

            return face + " of " + suit;

        }

}