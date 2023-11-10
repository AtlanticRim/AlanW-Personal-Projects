//Code created by J. Alan Wallace 4/1/2022 CS-226
import java.io.File; import java.util.Scanner;

public class TestInventory {
	public static void main(String[] args) {

	//Creates and fills an array with values from inventory.txt
	File inventoryFile = new File("inventory.txt");
	InventoryItem[] itemsList = new InventoryItem[8];
	Scanner readFile = null;
	try {
		int i = 0;
		readFile = new Scanner(inventoryFile);
		while(readFile.hasNext()) {
			String newItemName = readFile.next();
			int newItemNum = Integer.parseInt((readFile.next()));
			itemsList[i] = new InventoryItem(newItemName, newItemNum);
			i++;
		}
	}catch(Exception e) {
		System.out.println("Exception Occured. Ending Program. Message: " + e.getMessage());
		System.exit(1);
	}//End try-catch block
	
	//Sorts the array by item id and then prints it out
	java.util.Arrays.sort(itemsList);
	for(int count = 0; count <= itemsList.length-1; count++) {
		System.out.println(itemsList[count].toString());
	}
}//End main		
}//End TestInventory

class InventoryItem implements Comparable<InventoryItem>{
	private String itemName;
	private int itemID;
	
	InventoryItem(){
		
	}//End default constructor
	
	InventoryItem(String itemName, int itemID){
		this.itemName = itemName;
		this.itemID = itemID;
	}//End constructor
	
	public String getItemName() {
		return itemName;
	}//End getItemName
	
	public void setItemName(String newName) {
		itemName = newName;
	}//End setItemName
	
	public int getItemID() {
		return itemID;
	}//End getItemID
	
	public void setItemID(int newID) {
		itemID = newID;
	}//End setItemID
	
	@Override //Overrides compareTo in the Comparable interface
	public int compareTo(InventoryItem other) {
		if (this.itemID > other.itemID){
			return 1;
		}else if(this.itemID < other.itemID){
			return -1;
		}else {
			return 0;
		}
	}//End compareTo
	
	@Override //Overrides toString in Object class
	public String toString() {
		return itemName + " " + itemID;
	}
}//End InventoryItem

/*
Sample Output
vacuum 226
clock 251
oven 645
dryer 875
washer 1296
refrigerator 1585
dishwasher 7200
microwave 7734
*/