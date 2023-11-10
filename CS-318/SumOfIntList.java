/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 3/3/2023
 *  Last Updated: 3/5/2023
 *  
 *  Compilation: javac SumOfIntList.java
 *  Execution: java SumOfIntList
 *  
 *  Description
 *  A short program that sums up all of the numbers in an integer list.
 *  Unit tested in TestSumOfIntList.java
 *---------------------------------------------------*/
package homework;

public class SumOfIntList {
    
    public static int sumOfIntList (int[] list) {
        /* Takes in an array of integers and sums
         * all of the elements in the array.*/
        
        // If the array is null, immediately return 0
        if (list == null) return 0;
        
        int total = 0;
        for (int count = 0; count < list.length; count++) {
            
            // Add up all elements in the array
            total = total + list[count];
            
        }
        return total;
        
    } // end sumOfIntList
    
} // end SumOfIntList