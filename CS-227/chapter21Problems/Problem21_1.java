/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 11/5/2022
 *  Last Updated: 11/5/2022
 *  
 *  Compilation: javac Problems21_2.java
 *  Execution: java Problems21_2
 *  
 *  Sample Output:
 *  Union
 *  George Jim John Blake Kevin Michael Katie Michelle Ryan 
 *  
 *  Difference (Set1 - Set2)
 *  Jim John Blake Michael 
 *  
 *  Difference (Set2 - Set1)
 *  Katie Michelle Ryan 
 *  
 *  Intersection
 *  George Kevin 
 *  
 *---------------------------------------------------*/

package chapter21Problems;
import java.util.*;

public class Problem21_1 {
    public static void main(String[] args) {
        // Creates 2 LinkedHashSets with default capacity & load factor and adds values to them
        LinkedHashSet<String> set1 = new LinkedHashSet<String>(); 
        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");
        LinkedHashSet<String> set2 = new LinkedHashSet<String>();
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");
        
        //Prints the union of the two sets
        System.out.println("Union");
        printOut(union(set1, set2));
        System.out.println();
        
        // Prints the difference of set1 - set2
        System.out.println("Difference (Set1 - Set2)");
        printOut(difference(set1, set2));
        System.out.println();
        
        // Prints the difference of set2 - set1
        System.out.println("Difference (Set2 - Set1)");
        printOut(difference(set2, set1));
        System.out.println();
        
        // Prints the intersection of the two sets
        System.out.println("Intersection");
        printOut(intersection(set1, set2));
        System.out.println();
        
    } // end main
    
    public static <T> LinkedHashSet<T> union(LinkedHashSet<T> set1, LinkedHashSet<T> set2){
        // Creates a union of the two sets by combining them
        LinkedHashSet<T> union = new LinkedHashSet<T>();
        union.addAll(set1);
        union.addAll(set2);
        return union;
    } // end union
    
    @SuppressWarnings("unchecked")
    public static <T> LinkedHashSet<T> difference(LinkedHashSet<T> set1, LinkedHashSet<T> set2){
        LinkedHashSet<T> difference = new LinkedHashSet<T>();
        Object[] set1Array = new Object[set1.size()];
        set1.toArray(set1Array);
        
        /* For each element in set1, checks if it can be found it set2
         * If it cannot be found, it is added to the difference*/
        for (int count = 0; count < set1Array.length; count++) {
            if (set2.contains(set1Array[count])) {
                continue;
            } else {
                difference.add((T)set1Array[count]);
            }
        }
        return difference;
    } // end difference
    
    @SuppressWarnings("unchecked")
    public static <T> LinkedHashSet<T> intersection(LinkedHashSet<T> set1, LinkedHashSet<T> set2){
        LinkedHashSet<T> intersection = new LinkedHashSet<T>();
        Object[] set1Array = new Object[set1.size()];
        
        /* For each element in set1, checks if it can be found it set2
         * If it can be found, adds it to the intersection*/
        set1.toArray(set1Array);
        for (int count = 0; count < set1Array.length; count++) {
            if (set2.contains(set1Array[count])) {
                intersection.add((T)set1Array[count]);
            } else {
                continue;
            }
        }
        return intersection;
    } // end intersection
    
    public static <T> void printOut(LinkedHashSet<T> set) {
        // Prints all of the elements in the set
        for (T element: set) {
            System.out.print(element.toString() + " ");
        }      
        System.out.println();
    } // end printOut
    
} // end Problem19_1
