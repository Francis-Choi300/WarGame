/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author User
 */

//Interface of Factory
public interface PlayerMakerInterface {
    public Player makePlayer();
    public Player makePlayer(String name);
    
}
