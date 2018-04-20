import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    private Player p1;
    private Player d;
    private Deck deckOfCards;
    
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        this.deckOfCards = new Deck();
        p1 = new Player("p1", 100);
        d = new Dealer();
        
        speak0();
        playGame();
    }
    
    public void playGame(){
        this.deckOfCards.initializeDeck();
        this.deckOfCards.shuffle();
        
        
        
        
        int b = p1.bet();
        
        this.p1.hand = this.deckOfCards.deal();
        this.d.hand = this.deckOfCards.deal();
        
        
        playerTurn();
        dealerTurn();
        
        int win = determineWinner();
        
        if(win == -1){
            speak4();
            System.out.println("\nYou have " + p1.getMoney() + " dollars");
        }
        else if(win == 0){
            speak3();
            p1.addMoney(b);
            System.out.println("\nYou have " + p1.getMoney() + " dollars");
        }
        else{
            speak2();
            p1.addMoney(2*b);
            System.out.println("\nYou have " + p1.getMoney() + " dollars");
        }
        
        System.out.println("Do you want to play again? (y/n)");
        Scanner scan = new Scanner(System.in);
        String cont = scan.nextLine();
        
        if(cont.equals("y")){
            playGame();
        }
        else{
            endGame();
        }
        
        
    }
    
    public int determineWinner(){
        int p1Total = p1.handTotal();
        int dTotal = d.handTotal();
        
        // if 1 player wins, if -1 dealer wins, if 0 tie
        int winner = 0;
        
        
        if(p1Total > 21 && dTotal <= 21){
            winner = -1;
        }
        else if(dTotal > 21 && p1Total <= 21){
            winner = 1;
        }
        else if(p1Total <= 21 && dTotal <= 21){
            if(p1Total > dTotal){
                winner = 1;
            }
            else{
                winner = -1;
            }
        }
        
        
        return winner;
    }
    
    public void endGame(){
        speak5();
    }
    
    public void speak0(){
        System.out.println("Welcome to BlackJack");
        System.out.println("\nYou have " + p1.getMoney() + " dollars");
        System.out.println();
    }
    
    public void speak1(){
        printPlayerHand();
        
        System.out.println("\nThe dealer is showing: ");
        System.out.println(d.hand.get(0));
        
        System.out.println("\nChoose one of the following:");
        System.out.println("hit");
        System.out.println("stand");
    }
    
    public void speak2(){
        System.out.println("\nYou win");
    }
    
    public void speak3(){
        System.out.println("\nIt's a tie");
    }
    
    public void speak4(){
        System.out.println("\nThe dealer wins");
    }
    
    public void speak5(){
        System.out.println("You ended with " + + p1.getMoney() + " dollars");
        System.out.println();
        System.out.println("Hope ya had fun because this was a pain to code");
    }
    
    public void printPlayerHand(){
        System.out.println("\nYour hand is: ");
        for(Card c : p1.hand){
            System.out.println(c);
        }
    }
    
    public void playerTurn(){
        while(true){
            if(p1.handTotal() >= 21){
                printPlayerHand();
                System.out.println("\nThe dealer is showing: ");
                System.out.println(d.hand.get(0));
                break;
            }
            
            speak1();
            
            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine();
            
            if(choice.equals("hit")){
                this.p1.hand.add(deckOfCards.getTopCard());
            }else{
                break;
            }
        }
    }
    
    public void dealerTurn(){
        while(d.handTotal() < 17){
            this.d.hand.add(deckOfCards.getTopCard());
        }
        
        System.out.println("\nThe dealer has: ");
        for(Card c : d.hand){
            System.out.println(c);
        }
    }
    
    public void showHands(){
        System.out.println("Player");
        for(Card c: p1.hand){
            System.out.println(c);
        }
        System.out.println("Dealer");
        for( Card c: d.hand){
            System.out.println(c);
        }
    }

}


