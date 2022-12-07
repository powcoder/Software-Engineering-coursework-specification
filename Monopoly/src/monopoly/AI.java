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
import java.util.Random;

/**
 *
 * @author Jack
 */
public class AI extends Player{
    
    private Random random = new Random();

    public AI(String name, Token token){
       super(name, token);
    }
    
     public void mortgage(Property property){
        //decides at random 
    }
     
    public void build(Property property){
        //decides at random
    }
    
    public int bid(int bid){
        //decides at random
        return 0;
    }
    
    public boolean trade(Property gaining, Property losing){
        //runs a brief check to make sure trade isnt unfair
        return false;
    }
    
    //Suggested methods by Adem
   /**
    *AI Chooses between purchasing, not purchasing or mortgaging a property.
    *(Maybe checks if it has enough cash)
    */
    public void aiPropertyPurchase(Property property) {
     int option = random.nextInt(3);
        if (option = 0) {
         //Purchase property   
        }
        if (option = 1) {
         //Not purchase property 
        }
        if (option = 2) {
         //Mortgage property
            mortgage(property);
        }
    }
    
   /**
    *When AI is in jail it has to choose between paying the fine, using a card if it has one or stay in jail.
    *If jailTime is > than 3 AI is moved to just visiting
    *Chekcs if AI has GooJFCard
    */
    public void aiInJail() {
        if (jailTime>3)
        {
         //Get out of jail   
        }
        if (//Checks for card){
     int option = random.nextInt(3);
        if (option = 0) 
        {
         //Pay the fine 
        }
        if (option = 1) 
        {
         //Use GetOutOfJaileFree Card 
        }
        if (option = 2) 
        {
         //Stay in jail and give up their turn for the next 2 rounds         
        }
            }
            else {
                int option = random.nextInt3);
        if (option = 0) 
        {
         //Pay the fine 
        }
        if (option = 1) 
        {
         //Stay in jail and give up their turn for the next 2 rounds         
        }
            }          
    }
    
}
