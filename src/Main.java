import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        double pot = 500.00;
        Scanner scanner = new Scanner(System.in);
        boolean stay = false;

        System.out.println("Your beginning pot is: " + pot);

        System.out.println("What NickName would you like to have?");
        String pAnswer = scanner.nextLine();

        Player me = new Player(pAnswer);
        Player dealer = new Player("Dealer");

        System.out.println(" Would you like to start a new game? 'Yes/no' ");
        pAnswer = scanner.nextLine();

        System.out.print("enter your intial bet: $");

        String initBet = scanner.nextLine();
        
        double betPlace = Double.parseDouble(initBet);

            me.placeBet(betPlace, pot);
       

            if (pAnswer.equalsIgnoreCase("Yes")) {

                
            

            Deck deck1 = new Deck();
            Card card1 = new Card(Face.ACE, Suit.CLUBS);

            deck1.Shuffle();

            me.addCard(deck1.dealNext());
            me.addCard(deck1.dealNext());
            me.getHand(true);
            System.out.println(" ");
            dealer.addCard(deck1.dealNext());
            dealer.addCard(deck1.dealNext());
            dealer.getHand(false);

            // PLAYER

            do {

                System.out.println("Would " + me.getName() + " like to hit or stay? 'Hit/Stay' ");
                pAnswer = scanner.nextLine();

                // BUST
                if (pAnswer.equalsIgnoreCase("Hit")) {

                    me.addCard(deck1.dealNext());
                    System.out.println(me.getHandSum());
                    if (me.getHandSum() > 21) {

                        System.out.println(
                                "Your hand " + me.getHandSum() + " is a bust, Dealer wins this time.");
                                me.loseBet();
                                       
                        System.exit(0);

                    }

                }

                // STAY
                if (pAnswer.equalsIgnoreCase("Stay")) {

                    System.out.println("You have chosen to stay. Your hand: " + me.getHandSum());

                }

            } while (pAnswer.equalsIgnoreCase("Hit"));

            stay = false;

            do {

                System.out.println(" ");
                System.out.println("- Dealers Turn -");

                // Draw card
                if (dealer.getHandSum() < 1) {

                    dealer.addCard(deck1.dealNext());

                } else if (dealer.getHandSum() == 21) {

                    System.out.println("BlackJack! dealer won. Your total is");
                    me.loseBet();

                } else if (dealer.getHandSum() > 21) {

                    System.out.println("Dealer busted with a hand of: " + dealer.getHandSum() + ". "
                            + me.getName() + "wins this time! the pot now is");
                            me.winBet();
                    

                    System.exit(0);

                } else {

                    System.out.println("Dealer has chosen to stay!");

                    int totDealerSum = dealer.getHandSum();
                    int totPlayerSum = me.getHandSum();

                  

                    if (totDealerSum > totPlayerSum) {
                        System.out.println("Both players have stayed, the winner is " + dealer.getName()
                                + " with a total of " + totDealerSum + ". ");
                                me.loseBet();
                    } else {

                        
                        System.out.println("Both players have stayed, the winner is " + me.getName()
                                + " with a total of " + totPlayerSum + ". you won!"
                        );
                                me.winBet();
                    }

                }

            } while (stay);

        }

    }
}
