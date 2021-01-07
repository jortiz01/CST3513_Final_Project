import villageGathererClasses.Player;
import villageGathererClasses.T1Item;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class lakeRoom extends villageMainMenu {
	
	public JFrame frame;
	public Container con;
	public JPanel infoFrame;
	public JPanel buttonPanel;
	public JPanel topHUD;
	public JButton goBack, fish, eat;
	public JLabel importantMessages, topHUDinfo;
	
	public lakeRoom() {
		
		frame = new JFrame("Welcome to The Lake!");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(4,1));
		con = frame.getContentPane();
		
		topHUD = new JPanel();
		topHUD.setBackground(Color.blue);
		
		topHUDinfo = new JLabel("Username: "+ Player.getUserName() + " Energy: " + Player.getEnergyLevel());
		topHUDinfo.setForeground(newOrange);
		
		infoFrame = new JPanel();
		infoFrame.setBackground(Color.green);
		importantMessages = new JLabel("Go fishing!");
		
		topHUD.add(topHUDinfo);
		infoFrame.add(importantMessages);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.blue);
		
		fish = new JButton("Fish");
		fish.setEnabled(false); //To be edited to require fishing pole. Add craft fishing rod to Combine button in Blacksmith(line: 126 )

		if(T1Item.fishingrodCount != 0){
			fish.setEnabled(true);
		}


		eat = new JButton("Eat");

		
		goBack = new JButton("Go Back");
		
		buttonPanel.add(fish);
		buttonPanel.add(eat);
		buttonPanel.add(goBack);
		frame.add(topHUD);
		frame.add(infoFrame);
		frame.add(buttonPanel);
		
		fish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Random rand = new Random();
				int decision = rand.nextInt(1000);
				if(Player.userEnergyLevel != 0){
				if(decision % 2 != 0 ) {
					/*T1Item fish =*/ new T1Item("Fish"); //Commented fish out until there's a use for it -Patrick
					Player.updateEnergyLevel(Player.userEnergyLevel-= 5);
					System.out.println("You gained a fish.");
					importantMessages.setText("You gained a fish.");
					topHUDinfo.setText("Username: " + Player.getUserName() + " Energy: " + Player.getEnergyLevel());
					
				}
				else {
					Player.updateEnergyLevel(Player.userEnergyLevel-= 5);
					System.out.println("The fish got away! Better luck next time!");
					importantMessages.setText("The fish got away! Better luck next time!");
					topHUDinfo.setText("Username: " + Player.getUserName() + " Energy: " + Player.getEnergyLevel());
				}
			}
			else {
				System.out.println("Eat Fish to get Energy");
				importantMessages.setText("Eat Fish to Get Energy");
			}
				
			}
		});
		
		eat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(T1Item.fishCount == 0) {
					importantMessages.setText("<html>No Fish Available<br/>You need to Fish more! <html/>");
					}
				else {
				T1Item.eat(1, T1Item.fishCount);
				T1Item.fishCount--;
				System.out.println("You ate a fish.");
				importantMessages.setText("You gained energy.");
				topHUDinfo.setText("Username: " + Player.getUserName() + " Energy: " + Player.getEnergyLevel());				
				}
			}
		});
		
		goBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
				createVillageMainMenu();
//				villageMainMenu.topHUDinfo.setText(format);
			}
		});
		
		frame.pack();
		
	}
	
}
