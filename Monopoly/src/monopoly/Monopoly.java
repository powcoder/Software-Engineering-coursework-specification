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

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jack
 */
public class Monopoly {

    private int turns;
    private ArrayList<Player> players;
    private ArrayList<Tile> board;
    
    public static void main(String[] args) {
        Monopoly monopoly = new Monopoly();
        monopoly.players = new ArrayList<Player>();
        monopoly.board = new ArrayList<Tile>();
        monopoly.menu();
    }
    
    //run by main
    private void menu(){
        //stores an option read from user
        String option;
        //used to read the input from user
        Scanner scanner = new Scanner(System.in);
        
        //prints out the title
        System.out.print("Monopoly\n\n\n");
        
        //runs a menu indefinately
        while(1 != 0){
            //prints out user options
            System.out.print("Enter 1 to play\n");
            System.out.print("Enter 2 for to exit\n\n");
            //reads the selected input
            option = scanner.nextLine();
            
            //runs method associated with input
            switch(option){
                case "1":
                    //will run a game and afterwards go back to the menu
                    createGame();
                    break;
                case "2":
                    //will close the program
                    System.exit(0);
                    break;
                default:
                    // will re-run the menu
                    System.out.print("Please enter a valid input\n\n\n");
                    break;              
            }
        }
    }
    
    //run by menu
    private void createGame(){
        int noOfPlayers = 0;
        String option;
        Scanner scanner = new Scanner(System.in);
        
        // fills up the board array
        makeBoard();
        
        System.out.print("--------------------------------\n");
        //gets 2 to 6 players
        while(noOfPlayers > 6 || noOfPlayers < 2){
            System.out.print("Enter the number of players (2-6):");
            option = scanner.nextLine();
            
            try{
                noOfPlayers = parseInt(option);
            }catch(NumberFormatException e){
                System.out.print("Please enter a number between 2 and 6\n");
            }
        }
        
        //gets a list of unused tokens
        ArrayList<Token> unusedTokens = new ArrayList<Token>();
        for (Token tok : Token.values()) {
            unusedTokens.add(tok);
        }
        
        //gets a name, ai status and token for each player
        for(int i = 0; i < noOfPlayers; i++){
            String name;
            Token token = null;
            Boolean ai = null;
            //gets name
            System.out.print("Please enter the name of player " + (i + 1) + ":");
            name = scanner.nextLine();
            
            //gets ai status
            while(ai == null){
                System.out.print("Enter \"ai\" or \"human\" for " + name );
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("ai")){
                    ai = true;
                } else if (input.equals("human")){
                    ai = false;
                }
            }
            
            //gets token
            while(token == null){
                System.out.print("Please enter the token for " + name + " from ");
                for(Token tok : unusedTokens){
                    System.out.print(tok + ",");
                }
                System.out.print(":");
                try{
                    token = Token.valueOf(scanner.nextLine().toLowerCase());
                    if(!unusedTokens.contains(token)){
                        throw new IllegalArgumentException();
                    }
                    unusedTokens.remove(token);
                }catch(IllegalArgumentException e){
                    System.out.print("Please enter a token\n");
                }
            }
            //creates the new player
            if(ai){
                players.add(new Player(name, token));
            } else {
                players.add(new AI(name, token));
            }
            
        }
        
        //run the game
        playGame();
    }
    
    //run by createGame
    private void playGame(){
        int playerCount = 0;
        Scanner scanner = new Scanner(System.in);
        //game loop
        while(players.size() > 1){
            String input = "";
            boolean turnDone = false;
            boolean subTurnDone = false;
            //get the player whose turn it is
            Player current = players.get(playerCount);
            //roll the dice and move
            System.out.print(current.getName() + " is at " + board.get(current.getPosition()));
            System.out.print(current.getName() + " rolls a " + current.roll());
            System.out.print(current.getName() + " is at "  + board.get(current.getPosition()));
            //run the auction
            board.get(current.getPosition()).action(current);
            
            //run additional actions
            System.out.print("Does " + current.getName() + "want to perform additional actions? y/n");        
            while(!turnDone){
                input = scanner.nextLine().toLowerCase();
                if (input.equals("y")){
                    //run submenu      
                    while(!subTurnDone){
                        System.out.print("Enter \"build\" to build a development, \"trade\" to trade with another player, \"mortage\" to mortgage a property or \"done\" to exit");
                        input = scanner.nextLine().toLowerCase();
                        if (input.equals("build")){    
                            //improves a property
                            System.out.print("Enter a property number to improve or x to exit");
                            for (Property owned : current.getProperties()) {                               
                                System.out.print(owned.getPosition() + " - " + owned.getName() + "\n");
                            }
                            input = scanner.nextLine().toLowerCase();
                            if (input.equals("x")){
                                subTurnDone = true;
                            }
                            for (Property owned : current.getProperties()) {                               
                                if(input.equals(owned.getPosition())){
                                    current.build(owned);
                                    subTurnDone = true;
                                    System.out.print(owned + " improved");
                                }
                            }
                        } else if (input.equals("trade")){ 
                            // ToDo trades a property
                            subTurnDone = true;
                        } else if (input.equals("mortgage")){ 
                            //mortgages a property
                            System.out.print("Enter a property number to mortgage or x to exit");
                            for (Property owned : current.getProperties()) {                               
                                System.out.print(owned.getPosition() + " - " + owned.getName() + "\n");
                            }
                            input = scanner.nextLine().toLowerCase();
                            if (input.equals("x")){
                                subTurnDone = true;
                            }
                            for (Property owned : current.getProperties()) {                               
                                if(input.equals(owned.getPosition())){
                                    current.mortgage(owned);
                                    subTurnDone = true;
                                    System.out.print(owned + " mortgaged");
                                }
                            }                                
                        } else if (input.equals("done")){    
                            subTurnDone = true;
                        }
                    }
                } else if (input.equals("n")){
                    turnDone = true;
                }
                //remove brankrupt players
                for(Player loser : players){
                    if(loser.getCash() < 0){
                        //ToDo - set losers out of game
                        players.remove(loser);
                    }
                }
            }
            playerCount = (playerCount++)%players.size();
        }
        // last remaining player wins
        System.out.print(players.get(0) + " wins");
    }

    //makes the board from board.csv
    private void makeBoard() {
        String fileName = "boardData.csv";
        File file = new File(fileName);
        
        try{
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String data = inputStream.next();
                //split the csv into attributes
                //0 if id
                //1 is name
                //remaining are dependant on tile type
                String[] tile = data.split(",");
                if(tile[1].equals("Go")){
                    board.add(new Go(tile[0]));
                } else if (tile[1].equals("Pot Luck")){
                    board.add(new Chance(tile[0]));
                } else if (tile[1].equals("Opportunity Knocks")){
                    board.add(new Chest(tile[0]));
                } else if (tile[1].equals("Income Tax")){
                    board.add(new Tax(tile[0], 200));
                } else if (tile[1].equals("Jail/Just visiting")){
                    //remove just visiting class
                    board.add(new Jail(tile[0]));
                } else if (tile[1].equals("Free Parking")){
                    board.add(new FreeParking(tile[0]));
                } else if (tile[1].equals("Go to Jail")){
                    board.add(new GoToJail(tile[0]));
                } else if (tile[1].equals("Super Tax")){
                    board.add(new Tax(tile[0], 100));
                } else {
                    if(tile[2].equals("Station")){
                        board.add(new Station(tile[0], tile[1], tile[3]));
                    } else if(tile[2].equals("Utilities")){
                        board.add(new Utility(tile[0], tile[1], tile[3]));
                    } else {
                        //for properties
                        board.add(new Property(tile[0], tile[1], tile[2],tile[3],tile[4],tile[5],tile[6],tile[7],tile[8],tile[9]));
                    }
                }
            }
        } catch (FileNotFoundException e){
            System.out.print("bad input file");
            System.exit(0);
        }
    }
    
}
