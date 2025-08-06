/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import ca.sheridancollege.project.Card.Value;
import java.util.ArrayList;


/**
 *
 * @author User
 */
public class WarGame extends Game {
    
    private String name = "War Game";
    private UserPlayer human;
    private ComputerPlayer computer;
            
    public WarGame() {
        super("WarGame");
    }
           
    public String getName() {
        return name;
    }

    public Player getHuman() {
        return human;
    }

    public void setHuman(UserPlayer human) {
        this.human = human;
    }

    public Player getComputer() {
        return computer;
    }

    public void setComputer(ComputerPlayer computer) {
        this.computer = computer;
    }
    

    

    
    public int compareCards(Card c1, Card c2)
    {
        int val1 =  c1.getValue().getVal();
        int val2 =  c2.getValue().getVal();
        
        if (val1 > val2){return 1;} //player wins
        else if (val2 > val1) {return 2;} //computer wins
        else {return 3;}//tie
        
        
    }

    public void round(int point){
        
        Card card1 = this.human.playCard();
        Card card2 = this.computer.playCard();
        
        System.out.println("You have chosen! " + card1.toString());
        System.out.println("Computer has chosen! " + card2.toString());
        
        int result = this.compareCards(card1, card2);
        System.out.println();
        
        if (result==1) 
            {System.out.println("You have won the Round!");
             this.human.addPoints(point);}
        
        else if (result==2)
            {System.out.println("Computer has won the Round!");
            this.computer.addPoints(point);}
        
        else
        {
            System.out.println("A TIE HAS OCCURRED ITS TIME FOR WAAAAAAAARRRRR!!!");
            System.out.println("/////////////////////////////////////////////////");
            System.out.println();
            
            this.tieBreak(1);
        }
        
        System.out.println();
        System.out.println("THE SCORE IS");  
        System.out.println(human.getName() + ": " + human.getScore() );
        System.out.println(computer.getName() + ": " + computer.getScore() );
    }
    
    public void tieBreak(int bonusPoints){
        
            int cardsRemaining = this.human.getHand().size();
            System.out.println("cards Remaining:" + cardsRemaining);
            // remove the top 3 cards then play a tiebreaker
            // if 3 or more cards are left
            if (cardsRemaining > 3)
                {
                   
                  for (int i = 0; i < 3; i++)
                    {
                     this.human.getHand().removeFirst();
                     System.out.println("chungus");
                     this.computer.getHand().removeFirst();
                    } 
                  System.out.println("hello");
                  round(bonusPoints + 3 + 1);
                } 
            
            // if not enough cards are left, check the last card in the deck to see who wins the round
            else 
                {System.out.println("NOT ENOUGH CARDS REMAINING, THE WAR WILL BE SETTLED WITH THE LAST CARD!");
                 int totalPoints = cardsRemaining + bonusPoints;
                 int lastcard = this.compareCards(
                                     this.human.getHand().removeLast(), 
                                     this.computer.getHand().removeLast() );
                
                 if (lastcard == 1){
                     System.out.println("You have won the war you get " + totalPoints + " points!");
                     this.human.addPoints(totalPoints);
                 }
                 else if (lastcard ==2){
                     System.out.println("Computer has won the war, they get " + totalPoints + " points!");
                     this.computer.addPoints(totalPoints);
                 }
                 else 
                     {System.out.println("No Cards Left in Deck. No one wins!");}
                 
                 this.human.getHand().clear();
                 this.computer.getHand().clear();
                }
    }

     /**
     * When the game is over, use this method to declare and display a winning player.
     */
    @Override
    public void declareWinner(){
        
    String message = "";
    
    if (this.human.getScore() > this.computer.getScore())
        { message = "!!!!YOU WON THE GAME CONGRATULATIONS " +human.getName() +" !!!!!";}
    else if (this.human.getScore() < this.computer.getScore())
        { message = "!!! YOU LOST THE GAME, " +human.getName()+ " TRY AGAIN NEXT TIME !!!!!";}
    else
        { message = "!!! ITS A DRAW, NO ONE WINS !!!!";}
        System.out.println("-------------------------------------------");
        System.out.println(message);
        System.out.println("-------------------------------------------");  
        
    }
    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    @Override
    public void play(String name, int rounds){
        
        //ask for name and number of rounds

        // make players         
        PlayerMakerInterface pm = new PlayerMaker();
        
        Player p1 = pm.makePlayer(name);
        Player p2 = pm.makePlayer();
        
        this.setHuman( (UserPlayer) p1 );
        this.setComputer( (ComputerPlayer)p2);
        
        //make a Singleton dealer and have them deal hands to players
        Dealer dealer = Dealer.getDealer(rounds);
        
        ArrayList<Card> hand1 = dealer.dealHand();
        ArrayList<Card> hand2 = dealer.dealHand();
        
        this.human.setHand(hand1);
        this.computer.setHand(hand2);
        
        System.out.println();
        
        // keep playing rounds until both hands are empty
        while(!this.human.getHand().isEmpty() )
            {
              round(1);
              System.out.println();
            }
        this.declareWinner();
        
    }


    public void cheat(){
        

        // make players         
        PlayerMakerInterface pm = new PlayerMaker();
        
        Player p1 = pm.makePlayer(name);
        Player p2 = pm.makePlayer();
        
        this.setHuman( (UserPlayer) p1 );
        this.setComputer( (ComputerPlayer)p2);
        
        //make a Singleton dealer and have them deal hands to players
        Dealer dealer = Dealer.getDealer(8);
        
        Card c1 = new Card( Suit.DIAMOND , Value.FIVE) ;
        Card c2 = new Card( Suit.DIAMOND , Value.FOUR) ;
        Card c3 = new Card( Suit.DIAMOND , Value.SIX) ;
                
        ArrayList<Card> hand1 = new ArrayList<Card>();
        ArrayList<Card> hand2 = new ArrayList<Card>();
        
        hand1.add(c1);hand1.add(c1); hand1.add(c1); hand1.add(c1); hand1.add(c1); hand1.add(c1); hand1.add(c3); hand1.add(c2);
        hand2.add(c1);hand2.add(c1); hand2.add(c1); hand2.add(c1); hand2.add(c1); hand2.add(c1); hand2.add(c1); hand2.add(c1);
        this.human.setHand(hand1);
        this.computer.setHand(hand2);
        
        System.out.println();
        
        // keep playing rounds until both hands are empty
        while(!this.human.getHand().isEmpty() )
            {
              round(1);
              System.out.println();
            }
        this.declareWinner();
        
    }
    
}
