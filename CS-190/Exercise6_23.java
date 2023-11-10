import java.util.Scanner;

public class Exercise6_23 {
public static void main(String[] args) {
//Code created by Jeremy Wallace 10/20/2021 CS-190	

Scanner input = new Scanner(System.in);	//Prompts the user to enter a String and a char
System.out.println("Enter a word or phrase, then a single character. The program will determine how many times that character appears in the word or phrase.");
String str = input.nextLine();
char a = (input.nextLine().charAt(0));
System.out.println(a + " appears in " + str + " " +count(str, a) + " times.");

}//End main method
	
public static int count(String str, char a) {	
int indexPosition = 0;
char charFromString;
int occurrence = 0;
str = str.toUpperCase();
a = Character.toUpperCase(a);//Converts the string and char to uppercase to compare regardless of case

for (int loopControl = str.length(); loopControl > 0; loopControl--) {
	//Compares each character pulled from str to a. Adds 1 to occurrence if true
	charFromString = str.charAt(indexPosition);
	if(charFromString == a) {
		occurrence++;
	}//End if statement
	indexPosition++;
}//End for loop
	
return occurrence;	
	
	
	
	
}//End count method	
	
	
}
