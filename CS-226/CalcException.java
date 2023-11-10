import java.util.*;

public class CalcException {
	public static void main(String[] args) {
		int num1 = 0, num2 = 0, result = 0;
		char operator = 0;
		Scanner input = new Scanner(System.in);
		//int[] mylist = new int[2];
		//System.out.println(mylist[5]);
		
		try {
		num1 = input.nextInt();
		operator = (input.next()).charAt(0);
		num2 = input.nextInt();
		
		
		switch (operator) {
		case '+': result = num1 + num2; break;
		case '-': result = num1 - num2; break;
		case '*': result = num1 * num2; break;
		case '/': result = num1 / num2; break;
		}
		}catch(ArithmeticException e) {
			System.out.println("Cannot Divide by Zero");
			System.exit(1);
		}catch(InputMismatchException e) {
			System.out.println("Both Inputs Must Be Integers");
			System.exit(2);
		}
		
		System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
		
	}//End main
}//End CommandCalculatorException
