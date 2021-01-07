import villageGathererClasses.NPC;
import villageGathererClasses.Player;
import villageGathererClasses.T1Item; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class blackSmith extends villageMainMenu implements ItemListener{
	
	public JFrame frame;
	public Container con;
	public JPanel buttonPanel, infoFrame,topHUD;
	public JButton goBack, Combine;
	public JLabel importantMessages, topHUDinfo, blackSmithChoices, BSchat,importantMessages1,importantMessages2;
	public JComboBox blackSmithItems;
	private Button btnCountUp;
	private Button btnCountDown;
	private Button btnReset;
	private JPanel quantityBar;
	public TextField tfCount;
	private String[] blackSmithItemOptions = {"Axe", "Hammer", "Fishing Rod"}; //Sets the dropdown options.
	private JPanel infoFrame2;
	private JPanel infoFrame3;
	
	
	public blackSmith() {
		
		frame = new JFrame("Welcome to the Blacksmith");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //If Player hits red X, programs closes.
		frame.setLayout(new GridLayout(6,1));
		con = frame.getContentPane();
		
		topHUD = new JPanel();
		topHUD.setBackground(Color.black);
		
		topHUDinfo = new JLabel("Username: "+Player.userName + " Energy: " + Player.getEnergyLevel()); //Displays the Player's name and his energy level.
		topHUDinfo.setForeground(Color.ORANGE);
		topHUD.add(topHUDinfo);

		infoFrame3 = new JPanel();
		infoFrame3.setBackground(Color.black);
		BSchat = new JLabel(NPC.Blacksmith()); // Dialog box now works. NPC Class finally sees the light! Displays dialogue from the Blacksmith
		BSchat.setForeground(Color.white);
		infoFrame3.add(BSchat);
		
		infoFrame2 = new JPanel();
		infoFrame2.setBackground(Color.black);
		importantMessages = new JLabel("<html>Axe: Allows you to cut down trees for triple the sticks<br/> 30 sticks & 20 stones needed. </html>"); //Default text for Label
		importantMessages.setForeground(Color.white);
		infoFrame2.add(importantMessages);
		
		
		infoFrame = new JPanel();
		infoFrame.setBackground(Color.black);
		blackSmithChoices = new JLabel("Blacksmith items:");
		blackSmithItems = new JComboBox(blackSmithItemOptions);
		String bsItem = blackSmithItems.getSelectedItem().toString();
		infoFrame.add(blackSmithChoices);
		infoFrame.add(blackSmithItems);
		blackSmithItems.addItemListener(this); //Refreshes the window each time a new option is selected. Calls method in Line 167
		
		
		quantityBar = new JPanel();
		quantityBar.setBackground(Color.gray);
		quantityBar.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		
        tfCount = new TextField("1", 2);
        tfCount.setEditable(false);
		c.gridx=1;
		c.gridwidth = 1;
		c.gridy= 0;
		quantityBar.add(tfCount, c);
		
		btnCountUp = new Button("+");
		c.gridx=2;
		c.gridwidth = 1;
		c.gridy= 0;
		quantityBar.add(btnCountUp, c);
		
        btnCountDown = new Button("-");
		c.gridx=4;
		c.gridwidth = 1;
		c.gridy= 0;
		quantityBar.add(btnCountDown, c);

        btnReset = new Button("Reset");
		c.gridx=6;
		c.gridwidth = 2;
		c.gridy= 0;
		quantityBar.add(btnReset, c);
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.black);
		
		Combine = new JButton("Combine");
		goBack = new JButton("Go Back");
		
		
		buttonPanel.add(Combine);
		buttonPanel.add(goBack);
		frame.add(topHUD);
		frame.add(infoFrame3);
		frame.add(infoFrame2);
		frame.add(infoFrame);
		frame.add(quantityBar);
		frame.add(buttonPanel);
		Combine.setEnabled(false);

		
	    BtnListener listener = new BtnListener();
	    btnCountUp.addActionListener(listener);
	    btnCountDown.addActionListener(listener);
	    btnReset.addActionListener(listener);
		
		//Must figure out how to read which Option is selected from the comboBox
		//Currently 'Combine' button makes an Axe regardless of selection.
		
		Combine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				

				if((T1Item.getRequirements(blackSmithItems.getSelectedItem().toString(), Integer.parseInt(tfCount.getText())) == true) && (blackSmithItems.getSelectedItem().toString().equals("Axe"))){
					for(int i = 0; i < Integer.parseInt(tfCount.getText()); i++){
						int sticks = 20; //Sets the stick cost of the Axe to be deducted in T1Item.craft()
						int stones = 10; //Sets the stone cost of the Axe to be deducted in T1Item.craft()
						T1Item axe = new T1Item("Axe"); //Adds an Axe as per the T1Item constructor.

						T1Item.craft(sticks,stones,axe); //Will subtract 20 sticks and 10 stones from the Player to provide an Axe.
					}
				}
				else if((T1Item.getRequirements(blackSmithItems.getSelectedItem().toString(), Integer.parseInt(tfCount.getText())) == true) && (blackSmithItems.getSelectedItem().toString().equals("Fishing Rod"))){
					for(int i = 0; i< Integer.parseInt(tfCount.getText()); i++){
						int sticks = 6; //Sets the stick cost of Fishing Rod
						int stones = 0;
						T1Item fishingRod = new T1Item("Fishing Rod");
	
						T1Item.craft(sticks,stones,fishingRod); //Subtracts 6 sticks to create a Fishing Rod
					}	
				}
				else if ((T1Item.getRequirements(blackSmithItems.getSelectedItem().toString(), Integer.parseInt(tfCount.getText())) == true) && (blackSmithItems.getSelectedItem().toString().equals("Hammer"))){
					for(int i = 0; i< Integer.parseInt(tfCount.getText()); i++){
						int sticks = 10;
						int stones = 20;
						T1Item hammer = new T1Item("Hammer");

						T1Item.craft(sticks,stones,hammer); //Subtracts 10 sticks and 20 stones from Player to create a hammer
					}
					
				}
				
				if(T1Item.getRequirements(blackSmithItems.getSelectedItem().toString(), Integer.parseInt(tfCount.getText())) == false){
					Combine.setEnabled(false);
				}
			}
		});
		
		goBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); //"Closes" the Blacksmith frame
				
				createVillageMainMenu(); //Calls village mainmenu to open
			}
		});
		
		frame.pack();
	}
	public void itemStateChanged(ItemEvent e){
		if(e.getSource() == blackSmithItems){

			//Changes the JLabel 'importantMessages' to appropriate selected option in the comboBox
			if (blackSmithItems.getSelectedItem().toString() == "Axe"){
				importantMessages.setText("<html>Axe: Allows you to cut down trees for triple the sticks<br/> 20 sticks & 10 stones needed. </html>");
			}
			else if(blackSmithItems.getSelectedItem().toString() == "Hammer"){
				importantMessages.setText("<html>Hammer: Allows you to crush rocks<br/> for double the stones<br/> 10 sticks & 20 stones needed!</html>");
			}
			else if(blackSmithItems.getSelectedItem().toString() == "Fishing Rod"){
				importantMessages.setText("<html>Fishing Rod: Allows you to fish<br/> 6 sticks needed!</html>");
			}

		}
		
		if(T1Item.getRequirements(blackSmithItems.getSelectedItem().toString(),Integer.parseInt(tfCount.getText())) == true){//If the user does not have enough materials to craft, Combine button is disabled.
			Combine.setEnabled(true);
		} else{
			Combine.setEnabled(false);
		}
	}
	
	   private class BtnListener implements ActionListener {
		      private int count;

			@Override
		      public void actionPerformed(ActionEvent evt) {
		         // Need to determine which button has fired the event.
		         Button source = (Button)evt.getSource();
		               // Get a reference of the source that has fired the event.
		               // getSource() returns a java.lang.Object. Downcast back to Button.
		         if (source == btnCountUp) {
					++count;
					 if(Integer.parseInt(tfCount.getText())> 0)
					 {btnCountDown.setEnabled(true);}
		            
		         } else if (source == btnCountDown) {
					--count;
					 if(Integer.parseInt(tfCount.getText()) < 3){
						btnCountDown.setEnabled(false);
					 }else{
						 btnCountDown.setEnabled(true);
					 }
		            
		         } else {
		            count = 1;
		         }
		         tfCount.setText(count + "");
		      }
		   }

}
