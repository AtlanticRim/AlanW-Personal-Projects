import java.util.*;

public class TestQuadraticEquation {
public static void main(String[] args) {
	//Code by J. Alan Wallace 1/2/2022 CS226
	double a, b, c;
	Scanner input = new Scanner(System.in);
	System.out.print("Enter a, b, and c: ");
	a = input.nextDouble();
	b = input.nextDouble();
	c = input.nextDouble();//Allow the user to enter three double values, which are a, b, and c
	QuadraticEquation quad = new QuadraticEquation(a, b, c);
	if(quad.getDiscriminant() > 0) {
		System.out.println("The equation has two real roots: " + quad.getRoot1() + " and " + quad.getRoot2());
	}
	else {
		if(quad.getDiscriminant() == 0) {
			if(quad.getRoot1() == 0) {
				System.out.println("The equation has one real root: " + quad.getRoot2());
			}else {
				System.out.println("The equation has one real root: " + quad.getRoot1());
			}
		} else {
			System.out.println("This equation has no real roots.");
		}
	}//Based on the discriminant: If the equation has 2 real roots, displays both, if it has one real root, displays the one that is not 0, if it has no roots, tells the user so.

	}//End main
}//End TestQuadraticEquation

class QuadraticEquation{
	private double a;
	private double b;
	private double c;

	QuadraticEquation(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}//End QuadraticEquation constructor

	double getA(){
		return a;	
	}//End getA
	
	double getB(){
		return b;
	}//End getB
	
	double getC(){	
		return c;
	}//End getC
	
	double getDiscriminant(){
		double discriminant = ((b*b)-(4*a*c));
		return discriminant;
	}//End getDiscriminant
	
	double getRoot1() {
		if(getDiscriminant() <= 0) {
			return 0;
		}//If the discriminant is 0, returns 0 to avoid taking the square root of a negative number
		double root = ((b*-1)+(Math.sqrt((b*b)-(4*a*c))))/(2*a);
		return root;
	}//End getRoot1
	
	double getRoot2() {
		if(getDiscriminant() <= 0) {
			return 0;
		}//If the discriminant is 0, returns 0 to avoid taking the square root of a negative number
		double root = ((b*-1)-(Math.sqrt((b*b)-(4*a*c))))/(2*a);
		return root;
	}//End getRoot2
}//End Quadratic Equation
