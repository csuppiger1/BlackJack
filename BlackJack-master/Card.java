
/**
 * Write a description of class Card here.
 *
 * it's a card for a black jack game
 *
 * @author (Erik Voss)
 * @version (a version number or a date)
 */
public class Card
{
    private int value;
    private String suit;
    private String rank;

    /**
     * Constructor for objects of class Card
     */
    public Card(int val, String st, String rk)
    {
        this.value = val;
        this.suit = st;
        this.rank = rk;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public String getSuit(){
        return this.suit;
    }

    public String getRank(){
        return this.rank;
    }
    
    public String toString(){
        return "Suit: " + this.suit + " Rank: " + this.rank;
    }
    
    
}
