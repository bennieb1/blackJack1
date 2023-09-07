
import java.util.ArrayList;

public class Player {

    private String name;
    ArrayList<String> names = new ArrayList<String>();
    private int numOfCards;
    private double bet;
    private double balance;

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public boolean checkName(String name) {

        boolean isUnique = false;

        if (names.contains(name)) {

            return isUnique;

        } else {

            return isUnique = true;

        }

    }

    ArrayList<Card> playerHand;

    public Player(String name) {

        this.name = name;
        names.add(name);
        playerHand = new ArrayList<Card>();
        bet = 0;

    }

    public void placeBet(double amount, double pot) {

        if (amount <= pot) {

            bet = amount;
            pot -= amount;
            System.out.println(name + " placed a bet of $" + amount);
            System.out.println("Balance: $" + pot);

        } else {

            System.out.println("Invalid bet. Please try again with a valid amount.");

        }

    }

    public void winBet() {

        double winnings = bet * 2;
        balance += winnings;
        bet = 0;
        System.out.println(name + " won Balance now is $ " + winnings);

    }

    public void loseBet() {

        double lost = bet;
        balance += lost;
        bet = 0;
        System.out.println(name + " lost the bet. $" + lost);

    }

    public double getBalance() {

        return balance;

    }

    public double getBet() {

        return bet;

    }

    public void addCard(Card aCard) {

        playerHand.add(aCard);
        this.numOfCards++;

    }

    public int getHandSum() {

        int sum = 0;

        for (Card countSum : playerHand) {

            sum = sum + countSum.getFace();

        }

        return sum;

    }

    public boolean checkGetHandSum(boolean result) {

        int sum = 0;

        for (Card countSum : playerHand) {

            sum = sum + countSum.getFace();

        }

        return result;

    }

    public void getHand(boolean hideCards) {

        System.out.println(this.name + " your current Hand.");

        for (int c = 0; c < numOfCards; c++) {

            if (c == 0 && !hideCards) {

                System.out.println(" [Hidden Card] ");

            } else {

                System.out.println(playerHand.get(c).toString());

            }

        }

    }
}