
import java.util.Scanner;

public class IncomeTax {
	public static void main(String[] args) {
	//Code created by Jeremy Wallace 9/24/21 CS190L Araujo
		
//Prompts the user to enter their income
System.out.println("Enter your annual income rounded to the nearest dollar.");
Scanner input = new Scanner(System.in);	
int income = input.nextInt();
int taxCalcMethod = 0;
double taxToPay = 0;


//These if statements decide which method of computing tax the program will use, based on income.
if (income>=0) {
	taxCalcMethod = 1;
	if(income>=9_525) {
		taxCalcMethod = 2;
		if(income>=38_700) {
			taxCalcMethod = 3;
			if(income>=82_500) {
				taxCalcMethod = 4;
				if(income>=157_500) {
					taxCalcMethod = 5;
					if(income>=200_000) {
						taxCalcMethod = 6;
						if(income>=500_000) {
							taxCalcMethod = 7;
						}
					}
				}
			}
		}
	}
}


//These calculate the total tax one has to pay, based on which tax method was chosen above
switch(taxCalcMethod) {
case 1:taxToPay=(income*0.10); break;
case 2:taxToPay=952.50+(0.12*(income-9_525)); break;
case 3:taxToPay=4_453.50+(0.22*(income-38_700)); break;
case 4:taxToPay=14_089.50+(0.24*(income-82_500)); break;
case 5:taxToPay=32_089.50+(0.32*(income-157_500)); break;
case 6:taxToPay=45_689.50+(0.35*(income-200_000)); break;
case 7:taxToPay=150_689.50+(0.37*(income-500_000)); break;
}

//Prints out final result to console
System.out.println("For an income of "+income+" dollars, your due taxes are: "+taxToPay+" dollars.");

}
}