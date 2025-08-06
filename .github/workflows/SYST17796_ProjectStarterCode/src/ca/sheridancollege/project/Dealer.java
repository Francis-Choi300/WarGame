/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author User
 */

//Singleton Class
public class Dealer {
    
    private static Dealer dealer = null;
    private static int handsize = 5;
    
    private Dealer(int num){this.handsize=num;}
    
    public static Dealer getDealer(int num){
      if (dealer == null){
            dealer = new Dealer(num);
        }
        else{}
        
        return dealer;
    }
    
    public ArrayList<Card> dealHand(){
        
        ArrayList<Card> hand = new ArrayList<Card>();
        
        for (int i=0; i < handsize ;i++)
            {
                Card card = new Card();
                
                hand.add(card);
            }
        return hand;
    
    }
}
