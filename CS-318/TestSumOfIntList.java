/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 3/3/2023
 *  Last Updated: 3/5/2023
 *  
 *  Compilation: javac TestSumOfIntList.java
 *  Execution: java TestSumOfIntList
 *  
 *  Description
 *  A unit test for SumOfIntList class.
 *---------------------------------------------------*/
package homework;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestSumOfIntList {

    @Test
    public void simpleAddTest() {
        // This tests simple addition of positive integers
        
        // Arrange
        int[] list = {1, 2, 3, 4, 5};
        
        // Action
        int result = SumOfIntList.sumOfIntList(list);
        
        // Assert
        assertEquals(15, result);
        
    } // end simpleAddTest

    @Test
    public void negativeTest() {
        // This tests addition with negative integers
        
        // Arrange
        int [] list = {10, -100, -20, -5, 25, 10, -20};
        
        // Action
        int result = SumOfIntList.sumOfIntList(list);
        
        // Assert
        assertEquals(-100, result);
        
    } // end negativeTest
    
    @Test
    public void overflowTest() {
        
        // Arrange
        /* This array holds two values, one is the maximum value
         * that an int can hold, the second is 1. This is to test
         * what happens when there is an int value overflow.
         */
        int[] list = {2147483647, 1};
        
        // Action
        int result = SumOfIntList.sumOfIntList(list);
        
        // Assert
        assertEquals(-2147483648, result);
        
    } // end overflowTest
    
    @Test
    public void emptyArrayTest() {
        // This test passes an empty array
        
        // Arrange
        int[] list = new int[0];
        
        // Action
        int result = SumOfIntList.sumOfIntList(list);
        
        // Assert
        assertEquals(0, result);
        
    } // end emptyArrayTest
    
    @Test
    public void nullListTest() {
        // This test passes a null array

        // Arrange
        int[] list = null;
        
        // Action
        int result = SumOfIntList.sumOfIntList(list);
        
        // Assert
        assertEquals(0, result);
        
    }
} // end TestSumOfIntList
