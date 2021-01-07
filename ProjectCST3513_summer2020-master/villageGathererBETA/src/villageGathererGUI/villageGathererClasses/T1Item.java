package villageGathererClasses;
import java.util.*;


public class T1Item {
	
	public int count;
	public static int stickCount,stoneCount,axeCount,fishCount,fishingrodCount,hammerCount;
	public String description, item;
	public static String[] itemListString;
	public static ArrayList<String> itemList = new ArrayList<>();
	
	public T1Item(){ //T1Item constructor
		item = "";
		count = 0;
		stickCount = 0;
		stoneCount = 0;
		fishCount = 0;
		description = "";
		System.out.println("No item made");
	}
	
	public T1Item(String itemName){
		this.item = itemName;
		this.count ++;
		this.description = "";
		T1Item.itemList.add(itemName);
//		or switch case can be used here for multiple items, 
//		or even a loop of items can be placed here
		if(itemName == "Stick") { //adds stick to inventory to save
			if(axeCount > 0){
				stickCount += (1+axeCount);
			}else{
			stickCount++;
			}	
		}
		else if (itemName == "Stone") { //adds stone to inventory to save
			if(hammerCount > 0){
				stoneCount += (1+hammerCount);
			}
			stoneCount++;
		}
		else if (itemName == "Fish") { //adds fish to inventory to save
			fishCount++;
		}
		System.out.println(itemName + " was created"); //prompts the user when an item is added
	}
	
	public boolean isStick() { //ensures user has item stick
		if(this.item == "Stick") {
			return true;
		}
		return false;
	}
	
	public void setCount(int a) {
		count = a;
	}
		
	public int getCount() {
		return count;
	}
	
	public void setDescription(String a) {
		description = a;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean hasItem(T1Item a) { //ensures user has any item in inventory
		boolean hasItem = false;
		if (a.count>0) {
			hasItem = true;
		}
		return hasItem;
		
	}
	
	public static void craft(int a, int b, T1Item c) { //craft method which first two args are the needed mats and third is the crafted item
		
		if(c.item == "Axe"){ //creates axe
			
			stickCount -= a; 
			stoneCount -= b;
			axeCount++;
		}
		else if(c.item == "Hammer"){ //creates hammer
			
			stickCount -= a; 
			stoneCount -= b;
			hammerCount++;
		}
		else if(c.item == "Fishing Rod"){ //creates fishing rod
			
			stickCount -= a; 
			stoneCount -= b;
			fishingrodCount++;
		}
		
	}
	
	
	public static void eat(int i, int fishCount) { //allows user to eat a fish, checks ensures a fish is located in inventory
		if(fishCount <= 0) {
			System.out.println("No fish left"); //output if not enough fish
		}
		else {
		fishCount -=i; //reflect fish count change
		Player.addEnergyLevel(); //reflect energy level increase
		}
	}
	


	public static boolean getRequirements(String a,int x){ //ensures materials are present to create specific items
		if (a == "Axe"){
			if(stickCount >=(20*x) && stoneCount >= (10*x)){ //esnure requirements for axe is met
				return true;
			}else{
				return false;
			}
		}
		else if(a == "Fishing Rod"){ //ensures requirements for fishing rod is met
			if(stickCount >= (6*x)){
				return true;
			}else{
				return false;
			}
		}
		else if(a == "Hammer"){
			if(stickCount >=(10*x) && stoneCount >= (20*x)){ //ensures requirement for hammer is met
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	
	public static Integer allItemsSize() {
		
		int temp = 0;
		
		temp = itemList.size();
		
		return temp;
	}

	
}
