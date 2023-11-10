/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 11/5/2022
 *  Last Updated: 11/5/2022
 *  
 *  Compilation: javac Problems21_6.java
 *  Execution: java Problems21_6
 *  
 *  Sample Output:
 *  1
 *  2
 *  2
 *  3
 *  3
 *  4
 *  5
 *  0
 *  The most common number(s) in that list are: [2, 3]
 *  They occur 2 times.
 *---------------------------------------------------*/

package chapter21Problems;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;

public class Problem21_6 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        // Creates a TreeMap with default capacity & load value
        TreeMap<Integer, Integer> map1 = new TreeMap<Integer, Integer>();
        
        while (input.hasNextInt()) {
            @SuppressWarnings("removal")
            Integer temp = new Integer(input.nextInt());
            
            // If 0 is entered, ends entering loop
            if (temp == 0) {
                break;
            }
            
            /* In this map, the Key represents the number and the Value represents how many times it occurs
             * If the list already contains the Key, increments the Value of it by one
             * Otherwise, it adds the Key with a default Value of 1*/
            if (map1.containsKey(temp)) {
                map1.put(temp, map1.get(temp) + 1);
            } else {
                map1.put(temp, 1);
            }
            
        }
        
        Integer highest = 0;
        ArrayList<Integer> answers = new ArrayList<Integer>(); // This is the list of all answers

        //This for loop compares the Values of all Keys in the array. It adds the largest to the answers ArrayList
        for (int count = map1.firstKey(); count <= map1.lastKey(); count++) {
            if (map1.containsKey(count)) {
                if (map1.get(count) > highest) {
                    answers.clear();
                    answers.add(count);
                    highest = map1.get(count);
                } else if (map1.get(count) == highest) {
                    answers.add(count);
                }
            }
        }
        
        // Prints out the answer
        System.out.println("The most common number(s) in that list are: " + answers.toString());
        System.out.println("They occur " + highest + " times.");
        
        input.close();
    }// end main
} // end Problem21_6
