
import java.util.Scanner;

public class PalindromeNumbers {
	public static void main(String[] args) {
	//Code created by Jeremy Wallace 9/24/21 CS190 Araujo

//Prompts the user to enter a 3 digit number
System.out.println("Please enter a three digit number. The program will test if it is a palindrome.");
Scanner input = new Scanner(System.in);
int inputNumber = input.nextInt();
	
//Finds the individual place values then combines them into a reverse number
int onesDigit = (inputNumber % 10);
int tensDigit = (inputNumber % 100)/10;
int hundredsDigit = (inputNumber % 1000)/100;

//Compares the reverse number with the input number to determine if it is a palindrome
int reverseNumber = ((onesDigit*100)+(tensDigit*10)+(hundredsDigit));
if (reverseNumber == inputNumber) {
	System.out.println(inputNumber + " is a palindrome number.");
}	
else {	
	System.out.println(inputNumber + " is not a palindrome number.");
}


}
}