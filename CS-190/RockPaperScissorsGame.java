
import java.util.Scanner;

public class RockPaperScissorsGame {
public static void main(String[] args) {
//Code created by Jeremy Wallace, 9/17/2021, CS-190L
	
//Asks the user to input either R, P, or C
System.out.println("Choose Rock, Paper, or Scissors. Enter R for Rock, P for Paper, or S for Scissors.");
Scanner input = new Scanner(System.in);	
String userInput = input.nextLine();
String result = "";

//Randomly generate a number, make it an int, then get either R, P, or S from it
double randomNumber = 10*(Math.random());
int randomInt = (int)randomNumber;
String cpuInput = "";

switch(randomInt) {
case 0: cpuInput="R"; break;
case 1: cpuInput="R"; break;
case 2: cpuInput="R"; break;
case 3: cpuInput="R"; break;
case 4: cpuInput="P"; break;
case 5: cpuInput="P"; break;
case 6: cpuInput="P"; break;
case 7: cpuInput="S"; break;
case 8: cpuInput="S"; break;
case 9: cpuInput="S"; break;
}

//Compare userInput and cpuInput to decide a winner
if(userInput .equals("R")) {
	switch(cpuInput) {
	case "R": result="Tie - Rock Ties With Rock"; break;
	case "P": result="CPU Wins - Paper Beats Rock"; break;
	case "S": result="You Win - Rock Beats Scissors"; break;
	}
}


if(userInput .equals("P")) {
	switch(cpuInput) {
	case "R": result="You Win - Paper Beats Rock"; break;
	case "P": result="Tie - Paper Ties With Paper"; break;
	case "S": result="CPU Wins - Scissors Beats Paper"; break;
	}
}


if(userInput .equals("S")) {
	switch(cpuInput) {
	case "R": result="CPU Wins - Rock Beats Scissors"; break;
	case "P": result="You Win - Scissors Beats Paper"; break;
	case "S": result="Tie - Scissors Ties With Scissors"; break;
	}
}


//Print result statements
System.out.println("Your move was: " + userInput);
System.out.println("The CPU's move was: " + cpuInput);
System.out.println("The result is: " + result);

}
}
