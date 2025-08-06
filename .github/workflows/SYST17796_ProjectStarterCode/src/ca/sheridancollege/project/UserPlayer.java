/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class UserPlayer extends Player{
    private String name;
    private ArrayList<Card> hand;
    private int score;
    
    public UserPlayer(String name){
        super(name);
        this.name = name;
    }

    
    @Override
    public Card playCard(){
        
        System.out.println("Pick a card from your hand By entering a number");
        this.printHand();
        System.out.println("---------------------------------------------------");
        
        Scanner sc = new Scanner(System.in);
        int pickNum = sc.nextInt();
        
        
        Card pickCard = this.getHand().remove(pickNum-1);
        
        //  Card pickCard = this.getHand().getFirst();
        return pickCard;
    }
    
    
    
    
}
