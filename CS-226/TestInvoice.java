import java.util.*;

//Code written by J. Alan Wallace 3/4/22 CS226
public class TestInvoice {
	public static void main(String args[]) {
		Address wallaceAddress = new Address("Wallace Home Supplies", "200 Main Street", "Florence", "SC", "29506");
		Invoice wallaceInvoice = new Invoice(wallaceAddress);
		wallaceInvoice.addProduct(new Product("Doorknob", 5.00), 2);
		wallaceInvoice.addProduct(new Product("Microwave", 75.00), 1);
		wallaceInvoice.addProduct(new Product("Shelving Brackets", 0.50), 4);
		System.out.println(wallaceInvoice.toString());
	}//End main
}//End Test Invoice

class Invoice{
	private Address billingAddress;
	private ArrayList<LineItem> items = new ArrayList<LineItem>();
	/**
	 * @param billingAddress
	 * Uses an arrayList to store as many line items as the order demands
	 */
	
	Invoice(Address custAddress){
		this.billingAddress = custAddress;
	}//End constructor
	
	public void addProduct(Product product, int quantity) {
		/**
		 * Takes in a product description, price, and quantity and creates a LineItem, then adds it to the ArrayList of LineItems
		 */
		items.add(new LineItem(product, quantity));
	}//End addProduct
	
	public double getAmtDue() {
		/**
		 * Sums up the total bill by adding the total price of each line item
		 * @return The total
		 */
		double total = 0;
		for (int size = items.size(); size > 0; size--) {
			total = total + items.get(size-1).getTotalPrice();
		}
		return total;
	}//End getAmtDue
	
	public String toString() {
		/**
		 * Builds a string through 3 steps. First is to append the billing address. 
		 * Second is to append all of the line items. 
		 * Third is to append the total amount due.
		 * @return A completed Invoice
		 */
		StringBuilder toReturn = new StringBuilder(billingAddress.toString());
		toReturn.append(String.format("\n\n%-20s%-10s%-8s%-10s", "Description", "Price", "Qty", "Total"));
		for (int size = items.size(); size > 0; size--) {
			toReturn.append(items.get(size-1).toString());
		}
		toReturn.append(String.format("\n\n%18s%4.2f", "Total Amount Due: $", getAmtDue()));
		return toReturn.toString();
	}//End toString
}//End Invoice

class LineItem{
	private Product product;
	private int quantity;
	
	/**
	 * Describes a line item. This takes the product and the quantity desired and then figures the price.
	 * @param product
	 * @param quantity
	 */
	
	LineItem(Product product, int quantity){
		this.quantity = quantity;
		this.product = product;
	}//End constructor
	
	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}//End getTotal Price
	
	/**
	 * @return Description, Price, Quantity, and Total Price
	 */
	public String toString() {
		return String.format("\n%-20s%-10.2f%-8d%-10.2f", product.getDescription(), product.getPrice(), quantity, getTotalPrice());
	}//End toString
}//End LineItem

class Product{
	private String description;
	private double price;
	
	/**
	 * Describes a product including a brief description and price
	 * @param description
	 * @param price
	 * Also has two methods for returning:
	 * @return description
	 * @return price
	 */
	Product(String description, double price){
		this.description = description;
		this.price = price;
	}//End constructor
	
	public String getDescription(){
		return description;
	}//End getDescription
	
	public double getPrice() {
		return price;
	}//End getPrice
}//End Product

class Address{
	private String custName;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	/**
	 * Takes in information about the customer, including name and address information
	 * @param custName
	 * @param street
	 * @param city
	 * @param state
	 * @param zipcode
	 */
	
	Address(String custName, String street, String city, String state, String zipcode){
		this.custName = custName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}//End constructor
	
	public String getName(){
		return custName;
	}//End getName
	
	public String getStreet(){
		return street;
	}//End getStreet
	
	public String getCity(){
		return city;
	}//End getCity
	
	public String getState(){
		return state;
	}//End getState
	
	public String getZipcode(){
		return zipcode;
	}//End getZipcode
	
	public void setName(String name){
		custName = name;
	}//End setName
	
	public void setStreet(String newStreet){
		street = newStreet;
	}//End setStreet
	
	public void setCity(String newCity){
		city = newCity;
	}//End setCity
	
	public void setState(String newState){
		state = newState;
	}//End setState
	
	public void setZipcode(String newZipcode){
		zipcode = newZipcode;
	}//End setZipcode
	
	/**
	 * @return customer name and address information
	 */
	public String toString(){
		return custName + "\n" + street + " " + city + ", " + state + " " + zipcode;
	}//End toString
}//End Address

/*
Sample Output:
200 Main Street Florence, SC 29506

Description         Price     Qty     Total     
Shelving Brackets   0.50      4       2.00      
Microwave           75.00     1       75.00     
Doorknob            5.00      2       10.00     

Total Amount Due: $87.00
*/