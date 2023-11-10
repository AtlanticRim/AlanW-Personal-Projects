//Code created by J. Alan Wallace 2/25/2022 CS-226
public class TestMovie {
	public static void main(String[] args) {
		Action actionMovie = new Action("M", 1, "Pacific Rim");
		Comedy comedyMovie = new Comedy("PG-13", 2, "Madea's Family Reunion");
		Drama dramaMovie = new Drama("PG", 3, "Goodfellas");
		System.out.println(actionMovie.toString());
		System.out.println("This movie is 3 days late. The fee is " + actionMovie.calcLateFees(3) + "\n");
		System.out.println(comedyMovie.toString());
		System.out.println("This movie is 5 days late. The fee is " + comedyMovie.calcLateFees(5) + "\n");
		System.out.println(dramaMovie.toString());
		System.out.println("This movie is 14 days late. The fee is " + dramaMovie.calcLateFees(14) + "\n");
	}//End main
}//End TestMovie

class Movie{
	String rating;
	int id;
	String title;
	
	Movie(){
		
	}//End no-arg constructor
	
	Movie(String rating, int id, String title){
		this.rating = rating;
		this.id = id;
		this.title = title;
	}//End constructor
	
	public void setRating(String newRating){
		rating = newRating;
	}//End setRating
	
	public String getRating(){
		return rating;
	}//End getRating
	
	public void setID(int newID){
		id = newID;
	}//End setID
	
	public int getID(){
		return id;
	}//End getID
	
	public void setTitle(String newTitle){
		title = newTitle;
	}//End setTitle
	
	public String getTitle(){
		return title;
	}//End getTitle
	
	public boolean equals(Movie otherMovie) {
		if(this.id == otherMovie.id) {
			return true;
		}else {
			return false;
		}//End if-else
	}//End equals
	
	public double calcLateFees(int daysLate) {
		double lateFee = 2.00;
		return (lateFee * daysLate);
	}//End calcLateFees
	
	public String toString() {
		return "Title: " + title + " Rating: " + rating + " ID Number: " + id;
	}
	
}//End class Movie

class Action extends Movie{
	
	Action(){
		
	}//End no-arg constructor
	
	Action(String rating, int id, String title){
		this.rating = rating;
		this.id = id;
		this.title = title;
	}//End constructor
	
	public double calcLateFees(int daysLate) {
		double lateFee = 3.00;
		return (lateFee * daysLate);
	}//End calcLateFees
	
}//End Action

class Comedy extends Movie{
	
	Comedy(){
		
	}//End no-arg constructor
	
	Comedy(String rating, int id, String title){
		this.rating = rating;
		this.id = id;
		this.title = title;
	}//End constructor
	
	public double calcLateFees(int daysLate) {
		double lateFee = 2.50;
		return (lateFee * daysLate);
	}//End calcLateFees
	
}//End Comedy

class Drama extends Movie{
	
	Drama(){
		
	}//End no-arg constructor
	
	Drama(String rating, int id, String title){
		this.rating = rating;
		this.id = id;
		this.title = title;
	}//End constructor
	
	public double calcLateFees(int daysLate) {
		double lateFee = 2.00;
		return (lateFee * daysLate);
	}//End calcLateFees
	
}//End Drama

/*
Sample Output:
Title: Pacific Rim Rating: M ID Number: 1
This movie is 3 days late. The fee is 9.0

Title: Madea's Family Reunion Rating: PG-13 ID Number: 2
This movie is 5 days late. The fee is 12.5

Title: Goodfellas Rating: PG ID Number: 3
This movie is 14 days late. The fee is 28.0
*/
