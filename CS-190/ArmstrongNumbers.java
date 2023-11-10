
import java.util.Scanner;

public class ArmstrongNumbers {
public static void main(String[] args) {
//Code created by Jeremy Wallace 9/20/21 CS190 Araujo

//Prompts the user to enter a 3 digit number
System.out.println("Please enter a 3 digit number. The program will test if it is an Armstrong number.");
Scanner input = new Scanner(System.in);
int inputNumber = input.nextInt();

//Finds the individual place values then calculates the cubes of them.
int onesDigit = (inputNumber % 10);
int tensDigit = (inputNumber % 100)/10;
int hundredsDigit = (inputNumber % 1000)/100;
int onesCube = (int)Math.pow(onesDigit,3);
int tensCube = (int)Math.pow(tensDigit,3);
int hundredsCube = (int)Math.pow(hundredsDigit,3);
int cubeSums = (onesCube + tensCube + hundredsCube);

//Compares the inputNumber to the cubeSums
if(cubeSums==inputNumber) {
	System.out.println(inputNumber + " is an Armstrong number.");	
}
else {
	System.out.println(inputNumber + " is not an Armstrong number.");
}
		

}
}
