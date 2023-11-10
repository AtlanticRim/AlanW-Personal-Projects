/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 9/3/2022
 *  Last Updated: 9/3/2022
 *  
 *  Compilation: javac Problem18_10.java
 *  Execution: java Problem18_10
 *  
 *  Solution to Problem 18.10 in the textbook. Takes in a String and counts how many times a char appears in it, utilizing a recursive method call.
 *  
 *  Sample Output:
 *  Enter a string.
 *  Welcome
 *  Enter a character.
 *  e
 *  The character e occurs in the string Welcome 2 times.
 ---------------------------------------------------*/
package chapter18Problems;
import java.util.Scanner;

public class Problem18_10 {
   
    public static void main (String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a string.");          //Prompts the user for a String
        String strOne = input.nextLine();
        
        System.out.println("Enter a character.");
        char charOne = input.nextLine().charAt(0);      //Prompts the user for a character
        
        System.out.println("The character " + charOne + " occurs in the string " + strOne + " " +  count(strOne, charOne) + " times.");
                                                        //Returns how many times that character appears in the string.
    }//end main

    public static int count(String str, char a) {
        
        if (str.length() <= 0) {
            return 0;
        }                                               //Base case
        
        String newStr = str.substring(0,str.length()-1);//Creates a substring to be passed in the recursive call
        int runningTotal = 0;
        
        /* This if statement takes advantage of the fact that the count method returns an int to count how many time a char occurs in a String
         * runningTotal equals the sum of all of the calls before it, plus 0 or 1 depending on if the current char equals the key char
         */
        
        if(str.charAt(str.length()-1) == a) {           
            runningTotal = 1 + count(newStr, a);        //If a matches the key char, adds 1 to runningTotal and calls recursively
        }
        else {
            runningTotal = 0 + count(newStr, a);        //If a does not match the key char, adds nothing to runningTotal and calls recursively
        }
        
        return runningTotal;

    }//end count
    
}//end class
