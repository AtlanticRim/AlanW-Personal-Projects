
import java.util.Scanner;

public class Reverser {
public static void main(String[] args) {
//Code created by Jeremy Wallace 10/15/2021 CS-190L
	
System.out.println("Please enter a line of text.");
Scanner input = new Scanner (System.in);
String inputString = input.nextLine();
int stringLength = inputString.length();
String reverse = "";
int substringStart = stringLength-1;
int substringEnd = stringLength;


while(true) {
	
	//For loop to reverse letter by letter
	for (int repeat = stringLength; repeat > 0; repeat-- ) {

	String tempLetter = inputString.substring(substringStart, substringEnd);
	reverse = reverse.concat(tempLetter);
	substringStart--;
	substringEnd--;
	}
	System.out.println();
	System.out.println("Reversed Letter by Letter: ");
	System.out.println(inputString + " is turned into: ");
	System.out.println(reverse);	
		
	//Reverse word by word
	String reverseCopy = reverse;//IHG FED CBA Stores the value of reverse to break down when reversing word by word
	String reverseWord = "";//This will be the answer
	boolean control = true;//Creates the control variable for the while statement
	boolean ifControl = true;//Creates a variable to control the if statement that will determine if reverse copy is cut
	
while (control)	{
	int spaceIndex = reverseCopy.indexOf(' ');//Finds the first space in the word
	int spaceIndexCheck = spaceIndex;//Creates a copy in order to check it without changing it
	if (spaceIndexCheck < 0) {
		spaceIndex = reverseCopy.length();
		ifControl = false;
		control = false;
	}
	String wordSection = reverseCopy.substring(0, spaceIndex);//Takes all of the letters from the start of the string to the first space IHG
	if (ifControl) {
	reverseCopy = reverseCopy.substring(spaceIndex+1,reverseCopy.length());//Then cuts reverseCopy, starting after the first space and continuing to the end of the string
	}
	int wordSectionLength = wordSection.length();//Length of wordSection 3
	int wordSubstringStart = wordSectionLength-1;
	int wordSubstringEnd = wordSectionLength;//Both of these serve to decrement the substring to pull the last letter, then the second to last, then...
	
	for(int repeat = wordSectionLength; repeat > 0; repeat--) {
	String tempLetter = wordSection.substring(wordSubstringStart, wordSubstringEnd);
	reverseWord = reverseWord.concat(tempLetter);
	wordSubstringStart--;
	wordSubstringEnd--;
	//continue;
	}
	reverseWord = reverseWord.concat(" ");
}//End while(control)
	reverseWord = reverseWord.trim();//Trims the extra whitespace
	System.out.println();
	System.out.println("Reversed Word by Word:");
	System.out.println(inputString + " is turned into: ");
	System.out.println(reverseWord);//Prints the final reversed by word
		
//Resets to play again or breaks out of game loop		
System.out.print("Would you like to play again? Type Y for yes or N for no: ");
char playAgain = (input.nextLine()).charAt(0);//Changed from next to avoid blank issue
playAgain = Character.toUpperCase(playAgain);
if (playAgain == 89) {
	
	//Reseting variables from start
	//Letter loop
	inputString = input.nextLine();
	stringLength = inputString.length();
	reverse = "";
	substringStart = stringLength-1;
	substringEnd = stringLength;	
	continue;
	}
	else {break;}

}//End while(true) loop
System.out.println("Thanks for playing!");

}
}