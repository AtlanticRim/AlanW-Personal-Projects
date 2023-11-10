/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 9/3/2022
 *  Last Updated: 9/3/2022
 *  
 *  Compilation: javac Problem18_9.java
 *  Execution: java Problem18_9
 *  
 *  Solution to Problem 18.9 in the textbook. Takes in a String and prints it out to the console using a recursive method call.
 *  
 *  Sample Output:
 *  Enter a string:
 *  Backwards
 *  sdrawkcaB
 ---------------------------------------------------*/

package chapter18Problems;
import java.util.Scanner;

public class Problem18_9 {
    
    public static void main (String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a string:");
        String valueOne = input.nextLine();
        reverseDisplay(valueOne);
        
    }//end main
    
    public static void reverseDisplay(String value) {
        
        if (value.length() <= 0) {
            return;
        }                                                      //Base case
        System.out.print(value.charAt(value.length()-1));
        String newString = value.substring(0,value.length()-1);//Creates a new substring with one character less than value, this apporaces the base case
        reverseDisplay(newString);                             //Recursive method call

    }//end reverseDisplay

}//end class
