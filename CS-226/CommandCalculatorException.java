//Code created by J. Alan Wallace 3/11/2022 CS-226
public class CommandCalculatorException {
	public static void main(String[] args) {
		int num1, num2, result = 0;
		
		try {
		//Takes in values in the command line from the args array
		num1 = Integer.parseInt(args[0]);
		num2 = Integer.parseInt(args[2]);
		
		switch (args[1].charAt(0)) {
		case '+': result = num1 + num2; break;
		case '-': result = num1 - num2; break;
		case '*': result = num1 * num2; break;
		case '/': result = num1 / num2; break;
		}//End switch case
		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("Equation Must Be Entered As Follows: Operand1 Operator Operand2");
			System.exit(1);
		}catch(ArithmeticException e) {
			System.out.println("Cannot Divide by Zero");
			System.exit(2);
		}catch(NumberFormatException e) {
			System.out.println("Both Inputs Must Be Integers");
			System.exit(3);
		}//End try-catch block
		
		System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
		
	}//End main
}//End CommandCalculatorException
