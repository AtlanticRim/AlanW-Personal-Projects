

import java.util.Scanner;

public class DigitParserNew {
	public static void main (String[] args){
		
//Made by Alan Wallace, CS-190 Lab, Araujo, Lab Assignment 2

System.out.println("Enter a number between 0 and ten thousand");
Scanner input = new Scanner(System.in);
int inputNumber = input.nextInt();
System.out.println("Your number is " + inputNumber); //This section prompts the user for a number, stores it as inputNumber, and prints it to the console.
	
int onesValue = (inputNumber % 10);
System.out.println("Ones Digit: " + onesValue);

int tensValue = (inputNumber % 100)/10;
System.out.println("Tens Digit: " + tensValue);

int hundredsValue = (inputNumber % 1000)/100;
System.out.println("Hundreds Digit: " + hundredsValue);

int thousandsValue = (inputNumber % 10000)/1000;
System.out.println("Thousands Digit: " + thousandsValue);

int tenThousandsValue = (inputNumber % 100000)/10000;
System.out.println("Tens Thousands Digit: " + tenThousandsValue);
	
	}}