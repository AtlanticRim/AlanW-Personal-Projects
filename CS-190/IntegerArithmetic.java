
import java.util.Scanner;

public class IntegerArithmetic {
public static void main(String[] args) {
	//Code created by Jeremy Wallace 10/1/2021 CS-190L

//Prompts the user to enter an arithmetic operation, then stores those values
Scanner input = new Scanner(System.in);
System.out.println("Enter an arithmetic operation: ");
int input1 = input.nextInt();
char operator = input.next().charAt(0);
int input2 = input.nextInt();
int result = 0;
int remainder = 0;

//Determines which math operation to use depending on the operator inputed	
switch (operator) {
case '+': result = input1 + input2; break;
case '-': result = input1 - input2; break;
case '*': result = input1 * input2; break;
case '/': result = input1 / input2; remainder = input1 % input2; break;
}

//Prints out the final statement. If the operator is division, shows the remainder, otherwise, doesn't
if (operator == '/') {
System.out.println(input1 + " " + operator + " " + input2 + " = " + result + " (remainder of " + remainder + ")");
}
else {
System.out.println(input1 + " " + operator + " " + input2 + " = " + result);
}


}
}