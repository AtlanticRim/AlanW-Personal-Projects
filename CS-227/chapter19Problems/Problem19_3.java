/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 9/17/2022
 *  Last Updated: 9/17/2022
 *  
 *  Compilation: javac Problem119_3.java
 *  Execution: java Problem19_3
 *  
 *  Solution to Problem 19_3 in the textbook. Removes duplicates from a generic ArrayList.
 *  
 *  Sample Output:
 * Before Removing Duplicates: [Thank You, Gracias, Gracias, Danke, Spasibo, Gracias, Obrigado]
 * After Removing Duplicates: [Thank You, Gracias, Danke, Spasibo, Obrigado]
 ---------------------------------------------------*/

package chapter19Problems;
import java.util.*;

public class Problem19_3 {

    public static void main(String[] args) {
        
        /* The main method creates an ArrayList of Strings, 
         * adds some values, prints out the ArrayList
           And then removes duplicates and prints the results.*/
        
        ArrayList<String> strList = new ArrayList<>();
        strList.add("Thank You");
        strList.add("Gracias");
        strList.add("Gracias");
        strList.add("Danke");
        strList.add("Spasibo");
        strList.add("Gracias");
        strList.add("Obrigado");
        System.out.print("Before Removing Duplicates: ");
        System.out.println(strList.toString());
        
        strList = removeDuplicates(strList);
        System.out.println("After Removing Duplicates: " + strList);
        
        
    }//end main
    
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        
        ArrayList<E> tempList = new ArrayList<>();
        for (int count = 0; count <= list.size() - 1; count++) {
            
            /* If the element is not already present in the new array
             * (i.e. it isn't a duplicate of an element), it adds it to 
               the new non-duplicate array. Then it returns the non-duplicate array.*/
            
            if (tempList.contains(list.get(count))) {
                continue;
            } else {
                tempList.add(list.get(count));
            }
        }
        list = tempList;
        return list;
    }//end removeDuplicates
    
}//end Problem19_3


