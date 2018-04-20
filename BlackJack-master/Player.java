import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private String name;
    private int money;
    public ArrayList<Card> hand;
    private int handTotal;

    /**
     * Constructor for objects of class Player
     */
    public Player(String nm, int m)
    {
        this.name = nm;
        this.money = m;
    }
    
    public int bet(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your bet");
        int b = scan.nextInt();
        this.money -= b;
        return b;
    }
    
    public int handTotal(){
        int total = 0;
        int aceCount = 0;
        for(Card c : hand){
            if(c.getValue() == 1){
                aceCount += 1;
            }
            total += c.getValue();
        }
        
        if(aceCount > 0 && total + 10 < 22){
            total += 10;
        }
        
        return total;
    }
    
    public String toString(){
        return "";
    }
    
    public void addMoney(int a){
        this.money += a;
    }
    
    public int getMoney(){
        return this.money;
    }
}
