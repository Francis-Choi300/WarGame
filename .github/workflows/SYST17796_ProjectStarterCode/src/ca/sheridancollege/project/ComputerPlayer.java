/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author User
 */
public class ComputerPlayer extends Player {
        private String name;
    private ArrayList<Card> hand;
    private int score;
    
    public ComputerPlayer(){
        super("Computer");
        this.name = "Computer";
    }
    

    @Override
    public Card playCard(){
        

        Card pickCard = this.getHand().removeFirst();
        
        return pickCard;
    }
    
    
}
