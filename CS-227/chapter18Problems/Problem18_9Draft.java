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
 *  edcba
 *  sdrawkcaB
 */

package chapter18Problems;

public class Problem18_9Draft {
    
    public static void main (String[] args) {
        
        String valueOne = "abcde";
        reverseDisplay(valueOne);
        System.out.println();
        
        String valueTwo = "Backwards";
        reverseDisplay(valueTwo);
    }//end main
    
    public static void reverseDisplay(String value) {
        
        int count = value.length()-1;
        reverseDisplay(value, count);//calls helper method
        return;
        
    }//end reverseDisplay
    
    public static void reverseDisplay(String value, int count) {
        //This is a helper method for reverseDisplay
        
        if (count < 0) {
            return;
        }//Base case
        System.out.print(value.charAt(count));
        reverseDisplay(value, count-1);//Recursive call that approaches the base case
        
    }//end reverseDisplay

}//end class
