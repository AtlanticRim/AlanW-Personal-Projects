
import java.util.Scanner;

public class CheckSubstring4_22 {
public static void main(String[] args) {
//Code created by Jeremy Wallace 10/15/2021	CS-190L

System.out.println("Enter two strings. The program will check how many times the second string is a substring of the first string.");
Scanner input = new Scanner (System.in);
//Prompts for s1, then put it into s1Cut because the string will be manipulated later in the program
String s1 = input.next();
String s1Cut = s1;
//Prompts for s2
String s2 = input.next();
//checkFor checks for appearances of s2 in s1Cut. s2Length is used to manipulate the string later in the program. appearances keeps track of how many times s2 is in s1.

int s2Length = s2.length();
int appearances = 0;
	

while (true) {
int checkFor = s1Cut.indexOf(s2);

	if (checkFor >= 0) {
	appearances++;
	s1Cut = s1Cut.substring((checkFor + s2Length),s1Cut.length());
	}
	else { 
	
		if (appearances > 0) {
		System.out.println(s2 + " is a substring of " + s1);
		System.out.println(s2 + " appears " + appearances + " times in " + s1 + ".");
		}else {
		System.out.println(s2 + " is not a substring of " + s1);	
		}
	
	break;
	}
}//End while(true) loop

}
}