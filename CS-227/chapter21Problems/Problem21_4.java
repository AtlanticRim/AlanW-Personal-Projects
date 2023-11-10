/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 11/5/2022
 *  Last Updated: 11/5/2022
 *  
 *  Compilation: javac Problems21_4.java
 *  Execution: java Problems21_4
 *  
 *  Sample Output:
 *  Total Number of Vowels: 52
 *  Total Number of Consonants: 85
 *---------------------------------------------------*/

package chapter21Problems;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem21_4 {
    public static void main(String[] args) throws FileNotFoundException {
        
        /* Contents of the file (there are 20 words total, 5 of which are duplicates). Total of 137 characters
         * fluctuation
         * reputation
         * lead
         * notice
         * restrict
         * discreet
         * begin
         * injury
         * hip
         * twitch
         * daughter
         * wrong
         * ensure
         * restrict
         * forecast
         * notice
         * twitch
         * discreet
         * mole
         * fluctuation
         */
        
        //Reads in the file that contains the words above
        File file = new File("C:\\Users\\Public\\Documents\\Problem19_2WordList.txt");
        Scanner scan = new Scanner(file);
        
        // These doubles store the total number of vowels and consonants so far.
        int vowels = 0;
        int consonants = 0;
        
        TreeSet<Character> vowelSet = new TreeSet<Character>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        
        // If the next character is a vowel, increments vowels, if a consonant, increments consonants
        while(scan.hasNext()) {
            String temp = scan.next().toLowerCase();
            for (int count = 0; count < temp.length(); count++) {
                if(vowelSet.contains(temp.charAt(count))) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        // Prints the results
        System.out.println("Total Number of Vowels: " + vowels);
        System.out.println("Total Number of Consonants: " + consonants);
        
    } // end main
} // end Problem21_4
