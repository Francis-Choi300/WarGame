/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author User
 */

//Factory Implementation
public class PlayerMaker implements PlayerMakerInterface {

        public Player p1;
        
        @Override
        public Player makePlayer(String name){
                this.p1 = new UserPlayer(name);
                return p1;
        }
        @Override 
        public Player makePlayer(){
            this.p1 = new ComputerPlayer();
            return p1;
        }
    }
    

