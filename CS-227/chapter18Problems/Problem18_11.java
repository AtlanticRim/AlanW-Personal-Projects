/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 9/3/2022
 *  Last Updated: 9/3/2022
 *  
 *  Compilation: javac Problem18_11.java
 *  Execution: java Problem18_11
 *  
 *  Solution to Problem 18.11 in the textbook. Takes in a long and adds all the individual digits using a recursive method call.
 *  
 *  Sample Output:
 *  Enter a number: 1234
 *  The sum of all digits in that number is 10
 ---------------------------------------------------*/
package chapter18Problems;
import java.util.Scanner;

public class Problem18_11 {
   
    public static void main (String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");       //Prompts the user for a long
        long numOne = input.nextLong();
        System.out.println("The sum of all digits in that number is " + sumDigits(numOne));
        
    }//end main

    public static int sumDigits(long n) {
        
        if(n == 0) {
            return 0;
        }                                           //Base case
        
        int lastDigitOfN = (int)(n % 10);           //Gets the last digit of n
        int total = lastDigitOfN + sumDigits(n/10); //Adds all the digits of n using a recursive call.
        return total;
        
    }//end sumDigits
    
}//end class
