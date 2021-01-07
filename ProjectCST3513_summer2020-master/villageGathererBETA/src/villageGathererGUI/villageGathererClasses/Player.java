/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package villageGathererClasses;

/**
 *
 * @author rifatbhuiyan
 */
public class Player {                      // superclass is T1Item and it is subclass 
    
    public String[] endMessage;
    public static String userName;
    public static int userEnergyLevel = 100;               // maybe we need this one the UMI 

                                              
    
    public Player(){
    	
        userName = "";
        userEnergyLevel = 100;
        System.out.println("Player with no name!");
    }
    
    public Player(String u) { //When Player is created. Player will be created in the game with a base value of 100 energy
    	
    	Player.userName = u;
        userEnergyLevel = 100;
        T1Item.fishCount = 5;
        System.out.println("Player new name!");
    	
    }
    
    public static void setUserName(String u){
        
    	Player.userName = u;   //instead of this we could use the class name because of static.
        
    }
    
    public static String getUserName(){ // Sends username when called.
        
        return Player.userName;
        
    }
    
    public static int getEnergyLevel() { //Sends energy level when called.
    	
		return Player.userEnergyLevel;
    	
    }
    
    
    public static void updateEnergyLevel(int e){
    	Player.userEnergyLevel = e;
        
    }
    
    public static void addEnergyLevel() { //adds energy when fish is eaten.
    	Player.userEnergyLevel += 25;
    }
    
    public void EnergylowAlert(){
        if (userEnergyLevel <25 ){
            System.out.println("Energy level at 25");
        }
   
    }   
}
