//NOTE: The program checks the length, then that all of the characters are numbers, then if the card is a valid card code. If any of these fails, it prints out an error statement then exits.
//Therefore, if the length is incorrect, it will not check if the characters are numbers, or if it is a valid code. 

import java.util.Scanner;

public class CardValidation {
public static void main(String[] args) {
//Code created by Jeremy Wallace 10/22/2021 CS-190L
	
Scanner input = new Scanner(System.in);
String creditCard = input.nextLine();	

if (lengthCheck(creditCard) == true) {
	System.out.println("Length is correct.");
}
else {
	System.out.println("ERROR: The length of the card number is incorrect. Credit card numbers should have 14 digits."); 
	System.exit(0);
}

if (noLetterCheck(creditCard) == true) {
	System.out.println("Characters are correct.");
}
else {
	System.out.println("ERROR: The card number you entered contains a letter. Credit card numbers should not contain a letter.");	
	System.exit(0);
}

if(errorCheck(creditCard) == true) {
	System.out.println("Card Number is Valid.");
}
else {
	System.out.println("ERROR: The card number is invalid."); 
	System.exit(0);
}

}//end main method

public static boolean lengthCheck(String card) {
return (card.length() == 14) ? true:false;//Returns true if the inputted code is equal to 14, else returns false
}//end lengthCheck method

public static boolean noLetterCheck(String card) {
int position = 13;
boolean noLetters = true;
for (int control = 14; control > 0; control--) {
	int numberAt = (int)(card.charAt(position));//Takes one character, converts it to an int
	if(numberAt < 48 || numberAt > 57) {
		noLetters = false;	
	}
	position--;
}//End for loop
return noLetters;//Returns true only if all of the letters are numbers
}//End noLetterCheck method
	
public static boolean errorCheck(String card) {	
int position = 0;
int evenSum = 0;
int oddSum = 0;
int totalSum = 0;

for (int control = 14; control > 0; control--) {
	int charAt = (((int)(card.charAt(position)))-48);
	if ((position+1) % 2 == 0) {
		evenSum = evenSum + charAt;
		position++;
	}
	else {
	charAt = charAt * 2;
	charAt = (charAt > 9) ? charAt-9:charAt;
	oddSum = oddSum + charAt;
	position++;
	}
}//End for loop
totalSum = evenSum + oddSum;
System.out.println("Odd Sum: " + oddSum);//Debug
System.out.println("Even Sum: " + evenSum);//Debug
if (totalSum % 10 == 0) {
	return true;//Returns true if the card is a valid credit card code
}
else {
	return false;
}
}//End errorCheck method	
	
}