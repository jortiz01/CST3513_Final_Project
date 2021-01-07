package	villageGathererClasses;

import java.lang.Math;

public class NPC {
	

    public static String Villager(){

        int randy = ((int)(Math.random() * 5)); //Math.random allows for a random setText output when Villager() is called

        switch (randy){
            case 0:
            String x ="<html>Good day "+Player.userName+"!<br/></html>";
            return x; //x returns to villageMainMenu
            case 1:
            x = "<html>Did you know there's a blacksmith in town? He's located further up the road!<br/></html>";
            return x;
            case 2:
            x = "<html>This weather we're having is great, isn't it?<br/></html>";
            return x;
            case 3:
            x = "<html>Hi! I'm a villager here, what do you do?<br/></html>";
            return x;
            case 4:
            x= "<html>Hey, did you know that we're surrounded by forests?<br/>If you go out, you can gather sticks and stones there.<br/></html>";
            return x;
        }
        return null;
    }
    public static String Blacksmith(){

        int randy = ((int)(Math.random() * 3));
        //int x = 2; //Debug

        switch (randy){
            case 0:
            String x = "<html>Hello "+Player.userName+"! What can I do for you?</html>";
            return x; // x returns to blackSmith
            case 1:
            x = "<html>Hey "+Player.userName+"! What do you need?</html>";
            return x;
            case 2:
            int order = (int)(Math.random()*9002); 
            if(order > 9000){ //Over 9000 easter egg. If order is 9001, it triggers.
                String y,z;
               x = "<html>Villager! What does the scouter say about his order number?<br/>";
               y = "IT'S OVER 9000!!!!<br/>";
               z ="WHAT?! 9000</html>";
                return x + y + z;
            }
            if(order == 66){ //Star wars Order 66 easter egg.
                x ="<html>"+Player.userName+".. Execute order 66..</html>";
                return x;
            }else{
            x = "<html>Order number "+order+"! What can I do for you?</html>";
            return x;
            }
        }
        return null;






    }
    
}