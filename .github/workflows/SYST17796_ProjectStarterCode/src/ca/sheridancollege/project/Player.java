/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */


public abstract class Player {

    private String name; //the unique name for this player
    private ArrayList<Card> hand;
    private int score = 0;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Card> getHand() {
        return this.hand;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    public Player(String name) {
        this.name = name;
    }


    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     * @return 
     */
    public abstract Card playCard();
   
    public void printHand(){
        
        System.out.println("Your hand is: ");
        int count = 1;
        for (Card card : this.getHand()){
            
            System.out.println("Card " +count+ ": " + card.toString());
            count = count + 1;
        }
    }
    
    public void addPoints(int num){ this.score += num;}

}
