https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;
import Dice.Die;

/**
 *
 * @author Jack (skeleton) + Adem
 */
public class Player {
    
    private Token token;
    private int cash;
    private boolean passedGo;
    private int jailSkips;
    private String name;
    private Property[] properties;
    private int turnCount;
    private int position;
    private boolean outOfGame;
    private int jailTime;
    private int rolledDie1;
    private int rolledDie2;
    
    public Player(String name, Token token) {
	    this.token = token;
	    this.name = name;
	    this.position = 1;
	    this.cash = 1500;
    }

    public void mortgage(Property property){
        property.isMortgaged = true; //when isMortgaged = true   no rent will be collected !
        cash =+ property.mortgageValue; 
    }
	
    //increases property.development by 1
    //decreases cash by property.buildCost
    public void build(Property property){
        property.development =+ 1;
	cash =- property.buildCost;
    }
    
    //asks the player to bid and runs checks
    public int bid(int bid){
       if (bid<=cash)
       {
	       return 1; // 1 = true/can bid
       }
        return 0; // 0 = false/cant bid
    }
    
<<<<<<< HEAD
    public int roll(){
        //roll 2 dices and increment position
	rollDie();
        return position =+ rolledDie1+rolledDie2;
=======
    private void rollDie(Die die1,Die die2){
       rolledDie1 = die1.roll();
       rolledDie2 = die2.roll();
>>>>>>> 3dc7b0345a752b91f940397ca2d9efadacb4b021
    }
    //asks user for a trade, maybe not the best way to do this...
    public boolean trade(Property gaining, Property losing){
	    boolean tradeAccepted;
        if (tradeAccepted = true){
	    properties.remove(losing);
	    properties.add(gaining);
		retrun true;
	}
	    else{
        return false;
	    }
    }
    
    public String getName(){
        return name;
    }
    
    public int getPosition(){
        return position;
    }

    public Property[] getProperties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getCash() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
