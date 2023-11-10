
import java.util.Scanner;

public class LetterGuesser {
public static void main(String[] args) {
	//Code created by Jeremy Wallace 10/8/2021 CS-190L

//Generates a random uppercase character	
char cpuLetter = (char)((int)(65+Math.random()*26));	

//Gives the player 5 guesses each time
Scanner input = new Scanner (System.in);
System.out.println("Try to guess the computer's random letter!");
char playerLetter = 0;	
int attemptsLeft = 5;

while(true) {

	while (attemptsLeft > 0) {	
		System.out.print("Enter your guess: ");
		playerLetter = (input.next()).charAt(0);
		playerLetter = Character.toUpperCase(playerLetter);

		if(playerLetter == cpuLetter) {
			System.out.println("You got it right! The letter was " + cpuLetter + ".");
			System.out.println("You guessed the letter correctly in "+ (6-attemptsLeft) + " guesses.");
			break;
		}
		else {
			System.out.println("Your guess was incorrect. Try again.");
			attemptsLeft--;
		}
	}//End attemptsLeft loop

	if (attemptsLeft == 0) {
		System.out.println("You have no guesses remaining.");
		System.out.println("The letter was " + cpuLetter + ".");
	}	
	
	System.out.print("Would you like to play again? Type Y for yes or N for no: ");
	char playAgain = (input.next()).charAt(0);
	playAgain = Character.toUpperCase(playAgain);
	if (playAgain == 89) {
		cpuLetter = (char)((int)(65+Math.random()*26));
		playerLetter = 0;
		attemptsLeft = 5;
		continue;
	}
	else {break;}

}//End while(true) loop
System.out.println("Thanks for playing!");

}
}