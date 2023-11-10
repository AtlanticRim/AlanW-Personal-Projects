
import java.util.Scanner;

public class HexToBinary {
public static void main(String[] args) {
//Code created by Jeremy Wallace 9/29/2021 4.12 Assignment
//To be turned in with Friday's lab assignment
	
//Prompts the user for a hexadecimal input, and stores it
Scanner input = new Scanner(System.in);
System.out.println("Enter a hex digit: ");
char hexInput = input.nextLine().charAt(0);
hexInput = Character.toUpperCase(hexInput);
String output = "";

//Determines what the hex value is equal to in decimal
switch(hexInput) {
case '0': output = "0000"; break;
case '1': output = "0001"; break;
case '2': output = "0010"; break;
case '3': output = "0011"; break;
case '4': output = "0100"; break;
case '5': output = "0101"; break;
case '6': output = "0110"; break;
case '7': output = "0111"; break;
case '8': output = "1000"; break;
case '9': output = "1001"; break;
case 'A': output = "1010"; break;
case 'B': output = "1011"; break;
case 'C': output = "1100"; break;
case 'D': output = "1101"; break;
case 'E': output = "1110"; break;
case 'F': output = "1111"; break;
default: System.out.println(hexInput + " is an invalid hexadecimal input.");
		System.exit(1); break;
}

//Prints final result
System.out.println(hexInput + " in hexadecimal is equivalent to " + output + " in binary.");

}
}