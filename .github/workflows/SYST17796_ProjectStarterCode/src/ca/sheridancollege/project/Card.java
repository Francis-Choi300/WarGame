/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.Objects;
import java.util.Random;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {
    //default modifier for child classes

    public enum Suit {HEART, DIAMOND, SPADE, CLUB};
    public enum Value {ACE(14), TWO(2), THREE(3),FOUR(4), FIVE(5) , SIX(6), 
                       SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
                       
                       private int val;
                       private Value(int val){this.val = val;}
                       
                       public int getVal(){return this.val;}
    };
    private Suit suit;
    private Value value;
    Random rng = new Random();
    
    
    //No args Constructor: makes a random card
    public Card(){
        
        
        int rng4 = rng.nextInt(4);
        int rng13 = rng.nextInt(13);
      
        switch (rng4) {
            case 0:
                this.suit = Suit.HEART;
                break;
            case 1:
                this.suit = Suit.DIAMOND;
                break;
            case 2:
                this.suit = Suit.SPADE;
                break;
            default:
                this.suit = Suit.CLUB;
                break;
        }
        
        switch (rng13){
            case 0:
                this.value = Value.TWO;
                break;
            case 1:
                this.value = Value.THREE;
                break;
            case 2:
                this.value = Value.FOUR;
                break;
            case 3:
                this.value = Value.FIVE;
                break;
            case 4:
                this.value = Value.SIX;
                break;
            case 5:
                this.value = Value.SEVEN;
                break;
            case 6:
                this.value = Value.EIGHT;
                break;
            case 7:
                this.value = Value.NINE;
                break;
            case 8:
                this.value = Value.TEN;
                break;
            case 9:
                this.value = Value.JACK;
                break;
            case 10:
                this.value = Value.QUEEN;
                break;
            case 11:
                this.value = Value.KING;
                break;
            default:
                this.value = Value.ACE;
                break;
        }
        
        
    }
    //Constructor (suit and value)
    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
        }

    //    //Constructor index
//    public Card(int index){
//        this.index = index;
//    
//        if (index >0){
//            if (index < 14)
//                {this.suit = "hearts";
//                 this.value = index;}
//            else if (index < 27 )
//                {this.suit = "diamonds";
//                this.value = index - 13;}
//            else if (index < 40)
//                {this.suit = "spades";
//                 this.value = index - 26;}
//            else if (index < 53)
//            {this.suit = "clubs";
//             this.value = index - 39;}
//            else
//            {System.out.println("Error, enter a number between 1-52!");}
    

    public Suit getSuit() {
        return suit;
    }
    public Value getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "The " + value +" of " + suit +"s";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.suit);
        hash = 53 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.suit != other.suit) {
            return false;
        }
        return this.value == other.value;
    }
}
