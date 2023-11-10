/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 9/10/2022
 *  Last Updated: 9/10/2022
 *  
 *  Compilation: javac Problem18_25.java
 *  Execution: java Problem18_25
 *  
 *  Solution to Problem 18.25 in the textbook. 
 *  Uses recursion and a loop to display all permutations of a string.
 *  
 *  Sample Output:
 *  Enter a string: abc
 *  abc
 *  acb
 *  bac
 *  bca
 *  cab
 *  cba
 ---------------------------------------------------*/

package chapter18Problems;
import java.util.Scanner;

public class Problem18_25 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //Prompts the user for a String
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        
        displayPermutation(str);
        
    }//end main
    
    public static void displayPermutation(String s) {
        
        displayPermutation("", s);
        
    }//end displayPermutation
    
    public static void displayPermutation(String s1, String s2) {
         
        if (s2.isEmpty()) {
            System.out.println(s1);
        }//Base case
        
        /* Utilizes a recursive call and a loop to cycle through the permutations of s1 and s2
         * The loop goes through each letter of the String, making a recursive call each time.
         * Each time a letter is taken into s1 and the other two letters are switched around until there are no more letters left in s2
         */
        for(int count = 0; count < s2.length(); count++) {
            displayPermutation(s1 + s2.charAt(count) , s2.substring(0, count) + s2.substring(count + 1, s2.length()));
        }
        
    }//end displayPermutation

}//end class