/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 9/9/2022
 *  Last Updated: 9/9/2022
 *  
 *  Compilation: javac Problem18_21.java
 *  Execution: java Problem18_21
 *  
 *  Solution to Problem 18.21 in the textbook. 
 *  The program converts an integer into binary using a recursive method call.
 *  
 *  Sample Output:
 *  Enter an integer: 432
 *  That number in binary is: 110110000
 ---------------------------------------------------*/

package chapter18Problems;
import java.util.Scanner;

public class Problem18_21 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //Prompts the user for an integer
        System.out.print("Enter an integer: ");
        int decValue = input.nextInt();
        
        System.out.println("That number in binary is: " + dec2Bin(decValue));
        
    }//end main
    
    
    public static String dec2Bin(int value) {
        
        /* Creates a string containing either 1 or 0
         * The string contains 1 if value is not evenly divisible by 2,
         * and contains 0 if it is evenly divisible by 2.
         */
        
        String binary = Integer.toString(value % 2);
        
        //Base case
        if (value < 1) {
            return "";
        }
        
        //Makes a recursive call
        return dec2Bin(value / 2) + binary;
        
    }//end dec2Bin
    
}//end class
