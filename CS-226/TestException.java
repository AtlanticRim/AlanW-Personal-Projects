import java.util.Scanner;
//Code created by J. Alan Wallace 3/9/2022 CS-226

public class TestException {
	public static void main(String[] args) {
		System.out.print("Enter 1, 2, or 3 to throw the First, Second, or Third Exception: ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		try {
			switch(choice) {
				case 1: throw new FirstException();
				case 2: throw new SecondException();
				case 3: throw new ThirdException();
				default: System.out.println("No exception was thrown.");
			}//End switch case
		}catch(FirstException e) {
			System.out.println(e.getMessage());
		}
		catch (SecondException e) {
			System.out.println(e.getMessage());
		}
		catch (ThirdException e) {
			System.out.println(e.getMessage());
		}
	}//End main
}//End TestException

class FirstException extends Exception{
	
	public FirstException() {
		super("You have thrown the first exception.");
	}//End constructor
}//End FirstException

class SecondException extends Exception{
	public SecondException() {
		super("You have thrown the second exception.");
	}//End constructor
}//End SecondException

class ThirdException extends Exception{
	public ThirdException() {
		super("You have thrown the third exception.");
	}//End constructor
}//End Third Exception