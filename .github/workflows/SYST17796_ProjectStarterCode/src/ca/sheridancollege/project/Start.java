/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Start {
    public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
        
    System.out.println("What is your name?");
    String name =sc.nextLine();
        
    System.out.println("Choose the Hand Size");
    int rounds = sc.nextInt();
    
    //make a WarGame
    WarGame wargame = new WarGame();
    
    //start the game
    //wargame.play(name,rounds);
    
    //cheat method used to test Tiebreakers
    wargame.cheat();
    }
}
