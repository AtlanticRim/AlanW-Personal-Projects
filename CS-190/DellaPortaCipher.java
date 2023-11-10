import java.util.Scanner;

public class DellaPortaCipher {
public static void main (String[] args) {
//Made by Jeremy Alan Wallace and Harrison Wade Daniels 11/19/2021 CS-190L
	
char[][] table = cipherTable();//Generates the table used for the Della Porta Cipher

//This block takes in a message and a key phrase from the user, then combines them into one char array
Scanner input = new Scanner(System.in);
System.out.print("Enter the Message: ");
String t = (input.nextLine()).toUpperCase();
System.out.print("Enter the Keyword: ");
String s = (input.nextLine()).toUpperCase();
char[][] keyMessage = keyAndMessage(t, s);

//Prints keyMessage
for (int row = 0; row < keyMessage.length; row++) {
for (int column = 0; column < keyMessage[row].length; column++) {
  System.out.print(keyMessage[row][column] + " ");
}
System.out.println();
}	

char[] answer = new char[keyMessage[1].length];//Creates an array that will be the answer
for (int control = 0; control < keyMessage[1].length; control++) {
	if (keyMessage[1][control] == ' ') {continue;}//This statement is to skip spaces
	char searchFor = keyMessage[1][control];//Creates the "key" for the linear search
	int searchIn = (keyMessage[0][control]-65)/2;//Determines which of the 13 rows in table to search in
	for (int searchControl = 0; searchControl < table[0].length; searchControl++) {
		if (table[searchIn][searchControl] == searchFor) {
			if (searchControl < 13) {//These if else statement "flips" the value to the correct encoded value
				answer[control] = table[searchIn][searchControl+13];
			}
			else {
				answer[control] = table[searchIn][searchControl-13];
			}
			break;
		}
	}
}

for(char each: answer) {//For each loop to print answer
	System.out.print(each + " ");
}
}//End main

public static char[][] cipherTable(){
char[][] table = new char[13][26];
char[] altAlphabet = {'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
char tempHolder;
for (int control = 0; control < table.length; control++) {//Positions 0-13 of each line are filled with A-M, the remaining 13 are filled with altAlphabet, then altAlphabet is shifted left one
	for (int colControl = 0; colControl < 13; colControl++) {
		table[control][colControl] = (char)(65+colControl);
	}
	for (int newColControl = 0; newColControl < (table[0].length-13); newColControl++) {
		table[control][newColControl+13] = altAlphabet[newColControl];
	}
	tempHolder = altAlphabet[0];
	for (int shiftControl = 1; shiftControl < altAlphabet.length; shiftControl++) {
	altAlphabet[shiftControl-1] = altAlphabet[shiftControl];	
	}
	altAlphabet[(altAlphabet.length-1)] = tempHolder;
}
return table;
}//End cipherTable class
	
public static char[][] keyAndMessage(String message, String keyPhrase){
char[] charFromString1 = message.toCharArray();
char[] charFromString2 = keyPhrase.toCharArray();
char[][] keyMessage = new char[2][charFromString1.length];
System.arraycopy(charFromString1, 0, keyMessage[1], 0, charFromString1.length);
for (int control = 0, keyControl = 0; control < keyMessage[1].length; control++) {
	if (keyMessage[1][control] != ' ') {
		keyMessage[0][control] = charFromString2[keyControl];
		keyControl++;
		if (keyControl >= charFromString2.length) {
			keyControl = 0;
		}
	}
	else {keyMessage[0][control] = ' ';}
}
return keyMessage;	
}//End keyAndMessage
	
}//End class