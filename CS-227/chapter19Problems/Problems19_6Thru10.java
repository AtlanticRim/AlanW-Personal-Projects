/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 9/23/2022
 *  Last Updated: 9/23/2022
 *  
 *  Compilation: javac Problems19_Thru10.java
 *  Execution: java Problems19_Thru10
 *  
 *  Solution to Problems 19.6, 19.7, 19.8, 19.9, and 19.10 in the textbook.
 *  Outlines 5 generic methods that will find the maximum value in a generic array, uses
 *  binary search to find a key in a generic ArrayList, shuffles a generic array,
 *  find the maximum value in an ArrayList, and sorts a generic ArrayList.
 *  
 *  Sample Output:
 *  The first array is: 
 *  1, 9, 7, 2, 5, 8, 4, 3, 6, 
 *  The maximum value in that array is: 9
 *  
 *  The second array is: A, B, C, 
 *  The letter C is found at index 2
 *  
 *  Enter 10 integer values to create the third array.
 *  1
 *  4
 *  7
 *  8
 *  5
 *  2
 *  3
 *  6
 *  9
 *  0
 *  Those numbers in order are: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
 *  The largest number you entered was: 9
 *  Those numbers shuffled are: [3, 7, 4, 9, 8, 2, 1, 6, 5, 0]
 ---------------------------------------------------*/

package chapter19Problems;
import java.util.ArrayList;
import java.util.Scanner;

public class Problems19_6Thru10 {

    public static void main(String[] args) {

        /* The main method has three sections.
         * The first creates a multidimensional array of Integers and finds the max value.
         * The second creates an array of Strings and utilizes binary search to find C.
         * The third creates an ArrayList, prompts the user for values, sorts those values,
         * finds the biggest value you entered, and then shuffles it.*/
        
        Integer[][] matrix = {{new Integer(1), new Integer(9), new Integer(7)}, {new Integer(2), 
            new Integer(5), new Integer(8)}, {new Integer(4), new Integer(3), new Integer(6)}};
        System.out.println("The first array is: ");
        // For loop to print the array
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + ", ");
            }
        }
        System.out.println();
        System.out.println("The maximum value in that array is: " + max(matrix));
        System.out.println();
        
        String[] strList = {"A", "B", "C", "D"};
        System.out.print("The second array is: ");
        // For loop to print the array
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(strList[row] + ", ");
        }
        System.out.println();
        System.out.println("The letter C is found at index " + binarySearch(strList, "C"));
        System.out.println();
        
        
        ArrayList<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 10 integer values to create the third array.");
        for (int count = 0; count < 10; count++) {
            list.add((new Integer(input.nextInt())));
        }
        sort(list);
        System.out.println("Those numbers in order are: " + list.toString());
        System.out.println("The largest number you entered was: " + max(list));
        
        shuffle(list);
        System.out.println("Those numbers shuffled are: " + list.toString());
    }// end main
    
    static <E extends Comparable<E>> E max(E[][] list) {
        /* Method header defined by the textbook.
         * This method finds the maximum value in a generic
         * two dimensional array.*/
        
        E max = list[0][0];
        for (int row = 0; row < list.length; row++) {
            for (int column = 0; column < list[row].length; column++) {
              if (max.compareTo(list[row][column]) == -1) {
                  max = list[row][column];
              }
            }
          }
        return max;
        
    }// End max
    
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        /* Method header defined by the textbook.
         * This method utilizes binary search to search
         * an array for a key.*/
        
        int low = 0;
        int high = list.length-1;
        
        while (high >= low) {
            
            int mid = (high + low) / 2;
            
            if (key.compareTo(list[mid]) == 0) {
                return mid;
            } else if (key.compareTo(list[mid]) == -1) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
            
        }
        return -1;
        
    }// end binarySearch
    
    public static <E> void shuffle(ArrayList<E> list) {
        /* Method header defined by the textbook.
         * This method shuffles the values in an ArrayList*/
        
        E temp1 = null;
        E temp2 = null;
        
        for (int count = list.size()-1; count >= 0; count--) {
            int randomPosition = (int)(Math.random()*list.size());
            temp1 = list.get(count);
            temp2 = list.get(randomPosition);
            list.set(count, temp2);
            list.set(randomPosition, temp1);
        }        
    }// End shuffle
    
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        /* Method header defined by the textbook.
         * This method sorts a generic ArrayList
         * utilizing selection sorting*/
        
        for (int count = 0; count < list.size() - 1; count++) {
            
            E min = list.get(count);
            int minIndex = count;
            
            for (int countTwo = count + 1; countTwo < list.size(); countTwo++) {
                if (min.compareTo(list.get(countTwo)) == 1) {
                    min = list.get(countTwo);
                    minIndex = countTwo;
                }
            }
            
            // Swaps the values if needed
            if (minIndex != count) {
                list.set(minIndex, list.get(count));
                list.set(count, min);
            }         
        }
    }// End sort
    
    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        /* Method header defined by the textbook.
         * This method finds the maximum value in
         * a generic ArrayList*/
        E max = list.get(0);
        
        for (int count = 1; count < list.size(); count++) {
            if (max.compareTo(list.get(count)) == -1) {
                max = list.get(count);
            }
        }
        return max;
        
    }// End max
}
