


import java.util.ArrayList;

public class Player{

    private String name;
    ArrayList<String> names = new ArrayList<String>();
    private int numOfCards;

    public String getName(){

        return name;

    }  

    public void setName(String name){

        this.name = name;

    }

    public boolean checkName(String name){

        boolean isUnique = false;

        if(names.contains(name)){

            return isUnique;

        }else{

            return isUnique = true;

        }

    }

    ArrayList<Card> playerHand;

    public Player(String name){
    
        this.name = name;
        names.add(name);
        playerHand = new ArrayList<Card>();

    }


    public void addCard(Card aCard){

        playerHand.add(aCard);
        this.numOfCards++;

    }

    public int getHandSum(){

        int sum = 0;

        for(Card countSum : playerHand){

            sum = sum + countSum.getFace();

        }

        return sum;

    }

    public boolean checkGetHandSum(boolean result){

        int sum = 0;

        for(Card countSum : playerHand){

            sum = sum + countSum.getFace();

        }

        return result;

    }


    public void getHand(boolean hideCards){

        System.out.println(this.name + " your current Hand.");

        for(int c = 0; c < numOfCards; c++){

            if(c==0 && !hideCards){

                System.out.println(" [Hidden Card] ");

            }else{

                System.out.println(playerHand.get(c).toString());

            }

        }

    }


}