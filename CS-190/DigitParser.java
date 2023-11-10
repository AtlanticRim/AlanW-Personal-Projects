
import java.util.Scanner; 

public class DigitParser{
  public static void main (String[] args){

//Made by Alan Wallace, CS-190 Lab, Araujo, Lab Assignment 2
//This was my first idea to solve the problem, but after I made it, I realized how clunky it was (Plus, it did not use many math operators, which was the assignment).
//I created another Java program that had a more elegant solution, but I also wanted to show this off.
	  
System.out.println("Enter a number between 0 and ten thousand");
Scanner input = new Scanner(System.in);
 int inputNumber = input.nextInt();
 System.out.println("Your number is " + inputNumber); //This section prompts the user for a number, stores it as inputNumber, and prints it to the console.

 //Ones Block
int numberWithoutOnes = (inputNumber/10);
int onesPlace = (inputNumber-(numberWithoutOnes*10));
System.out.println("Ones Digit: " + onesPlace);

//Tens Block
int numberWithoutTens = (numberWithoutOnes/10);
int tensPlace = (numberWithoutOnes-(numberWithoutTens*10));
System.out.println("Tens Digit: " + tensPlace);

//Hundreds Block
int numberWithoutHundreds  = (numberWithoutTens/10);
int hundredsPlace = (numberWithoutTens-(numberWithoutHundreds*10));
System.out.println("Hundreds Digit: " + hundredsPlace);

//Thousands Block
int numberWithoutThousands = (numberWithoutHundreds/10);
int thousandsPlace = (numberWithoutHundreds-(numberWithoutThousands*10));
System.out.println("Thousands Digit: " + thousandsPlace);

//Ten Thousands Block
int numberWithoutTenThousands = (numberWithoutThousands/10);
int tenThousandsPlace = (numberWithoutThousands-(numberWithoutTenThousands*10));
System.out.println("Ten Thousands Digit: " + tenThousandsPlace);

/*
Each block takes the entered number and divides it by 10. The limitation of the int data type means the decimal is cut off. The cut off number is then multiplied by 10,
leaving a 0 in a place, then subtracted from the original number.
For example, say a user enter 12345. 12345 is divided by 10 to get 1234.5, but the limitation of the int data type cuts it to 1234. 1234 is then multiplied by 10 to
get 12340. Then, 12345 - 12340 = 5, which is the 1s digit.
For every subsequent digit calculation, be previous numberWithoutPlace is used. For instace, to calculate the hundreds place, numberWithoutTens = 123, so 123 becomes
120, and 123 - 120 = 3, the hundreds digit.
 */

}
}