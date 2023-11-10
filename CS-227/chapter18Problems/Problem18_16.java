/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 9/3/2022
 *  Last Updated: 9/3/2022
 *  
 *  Compilation: javac Problem18_16.java
 *  Execution: java Problem18_16
 *  
 *  Solution to Problem 18.16 in the textbook. Takes in a line of input and counts how many uppercase characters there are in that line.
 *  
 *  Sample Output:
 *  AbCdE
 *  There are 3 uppercase letters in this line.
 ---------------------------------------------------*/

package chapter18Problems;
import java.util.Scanner;

public class Problem18_16 {
   
    public static void main (String[] args) {
        
        Scanner input = new Scanner(System.in);
        char[] chars = input.nextLine().toCharArray();
        System.out.println("There are " + count(chars) + " uppercase letters in this line.");
        
    }//end main

    public static int count(char[] chars) {
        //Calls the helper method
        return count(chars, chars.length-1);
    }//End count
    
    public static int count(char[] chars, int high) {
        
        if(high < 0) {
            return 0;
        }                                           //Base case
        
        int total = 0;
        if(chars[high] >= 65 && chars[high] <= 90){ 
            total = 1 + count(chars, high-1);       //If the selected char is between unicode values 65 ('A') and 90 ('Z'), adds one to the running total.
        }
        else {
            total = 0 + count(chars, high-1);       //If the selected char is not, adds nothing to the running total.
        }
        
        return total;
        
    }//End count
    
}//End class
