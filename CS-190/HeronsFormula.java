
import java.util.Scanner;

//Code written by Jeremy Wallace on 9/10/2021 for Lab Assignment 3, Araujo
public class HeronsFormula {
	public static void main (String[] args){

//Prompts user to enter 6 coordinates	
System.out.println("Enter the coordinates of the three points separated by spaces: x1 y1 x2 y2 x3 y3");
Scanner input = new Scanner(System.in);

//Declaring and initializing the 6 points
int xOne = input.nextInt();
int yOne = input.nextInt();
int xTwo = input.nextInt();
int yTwo = input.nextInt();
int xThree = input.nextInt();
int yThree = input.nextInt();

//Calculating Side Lengths
double sideOne = Math.sqrt(Math.pow((xTwo-xOne),2)+Math.pow((yTwo-yOne),2));
double sideTwo = Math.sqrt(Math.pow((xThree-xTwo),2)+Math.pow((yThree-yTwo),2));
double sideThree = Math.sqrt(Math.pow((xThree-xOne),2)+Math.pow((yThree-yOne),2));

//Calculating "s" which is half of the triangle's total perimeter
double halfPerimeter = (sideOne + sideTwo + sideThree)/2;

//Computing area based on s and the three sides
double area = Math.sqrt((halfPerimeter)*(halfPerimeter-sideOne)*(halfPerimeter-sideTwo)*(halfPerimeter-sideThree));
System.out.println("The area of your triangle is: " + area);

}
}