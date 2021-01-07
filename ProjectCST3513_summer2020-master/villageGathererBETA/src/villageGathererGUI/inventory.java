import java.awt.*;// importing the required packages
import java.awt.event.*;

import javax.swing.*;

import villageGathererClasses.Player;
import villageGathererClasses.T1Item;

public class inventory extends villageMainMenu//Extending to the villageMainMenu class
{
	//Creating these public fields
	public JFrame frame;
	public Container con;
	public JPanel infoFrame;
	public JPanel buttonPanel;
	public JPanel topHUD;
	public JButton goBack, search;
	public JLabel importantMessages, topHUDinfo;
	public int itemListSize = T1Item.allItemsSize();
	public String format = "<html>Sticks: " + T1Item.stickCount//Created a String format consisted of all the objects that can searched and crafted into the game.
						 + "<br/>Stones: " + T1Item.stoneCount + 
						  "<br/>Fish: " + T1Item.fishCount +
						   "<br/>Axe(s): "+ T1Item.axeCount + 
						   "<br/>Fishing Rod(s): "+T1Item.fishingrodCount+
						   "<br/>Hammer(s): "+T1Item.hammerCount+"</html>";
	
	//Making a constructor wth no args
	public inventory() 
	{
	
	frame = new JFrame("Inventory");//Creating new JFrame
	frame.setLocationRelativeTo(null);//Setting the LocationRealtive, DefaultCloseOperation, and layout.
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new GridLayout(3,1));
	con = frame.getContentPane();
	
	topHUD = new JPanel();//Create the new JPanel and settin gthe background to black.
	topHUD.setBackground(Color.black);
	
	topHUDinfo = new JLabel("Username: "+ Player.userName + " Energy: " + Player.getEnergyLevel());//Create new JLabel and settin ghte foreground to newOrange.
	topHUDinfo.setForeground(newOrange);
	
	infoFrame = new JPanel();//Creating a new JPanel and setting the background to the Color.gray.
	infoFrame.setBackground(Color.gray);
	
	importantMessages = new JLabel();//Create a new JLabel and adding the importantMessages in the infoFrame.
	infoFrame.add(importantMessages);
		
	if(itemListSize != 0) //Create an if statement if the list isn't 0 then will display the text String fromat.
	{
		
		importantMessages.setText(format);
	}

	
	topHUD.add(topHUDinfo);//Added the topHUDinfo.

	
	buttonPanel = new JPanel();//Creating a new JPanel and setting the background to the Color.black.
	buttonPanel.setBackground(Color.black);

	
	goBack = new JButton("Go Back");
	
	buttonPanel.add(goBack);//Added goBack to the panel.
	frame.add(topHUD);//Added frames of topHUD, infoFrame, and buttonPanel.
	frame.add(infoFrame);
	frame.add(buttonPanel);
	
	goBack.addActionListener(new ActionListener()//Create the goBack method with addition to the addActionListener event.
	{
		@Override
		public void actionPerformed(ActionEvent e)//Create the actionPerformed method to setting the frame.setVisible to be false. 
		{
			frame.setVisible(false);
		}
	});
	
	frame.pack();
	
}

}
