/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 9/17/2022
 *  Last Updated: 9/20/2022
 *  
 *  Compilation: javac Problem119_1.java
 *  Execution: java Problem19_1
 *  
 *  Solution to Problem 19_1 in the textbook. Utilizes an array to create a generic stack.
 *  
 *  Sample Output:
 * Created an empty new stack
 * Is the stack empty? true
 * 
 * Added 3 items. Stack size is: 3
 * [Hello, Konnichiwa, Hola, ]
 * Is the stack empty? false
 * The new first item is: Hola
 * 
 * Removed: Hola
 * Stack size is: 2
 * [Hello, Konnichiwa, ]
 * The new first item is: Konnichiwa
 ---------------------------------------------------*/

package chapter19Problems;

public class Problem19_1 {

   public static void main(String[] args) {
        
       /* Creates a GenericStack of Strings, then adds values and
        * tests out all the methods present in the GenericString class*/
       
        GenericStack<String> strList = new GenericStack<>();
        System.out.println("Created an empty new stack");
        System.out.println("Is the stack empty? " + strList.isEmpty());
        System.out.println();
        
        strList.push("Hello");
        strList.push("Konnichiwa");
        strList.push("Hola");
        
        System.out.println("Added 3 items. Stack size is: " + strList.getSize());
        System.out.println(strList.toString());
        System.out.println("Is the stack empty? " + strList.isEmpty());
        System.out.println("The new first item is: " + strList.peek());
        
        System.out.println();
        System.out.println("Removed: " + strList.pop());
        System.out.println("Stack size is: " + strList.getSize());
        System.out.println(strList.toString());
        
        System.out.println("The new first item is: " + strList.peek());
    }//end main
    
}

class GenericStack<E> {
    private E[] list = (E[]) new Object[1];
    
    public int getSize() {
        
        /* Counts all non-null items in the list, 
         which is therefore the list size.*/
        int items = 0;
        for (int count = 0; count < list.length; count++) {
            if (list[count] != null) {
                items++;
            }
        }
        return items;
    }//end getSize
    
    public E peek() {

        for (int count = list.length - 1; count > 0; count--) {
            if (list[count] != null) {
                return list[count];
            } else continue; // Returns the first non-null element in the stack
        }
        return null;// Only returns null of no other non-null elements can be found
    }//end peek
    
    public void push(E o) {
        /* Adds a value to the top of the stack. If the array can hold no more
         * values, creates a new array with double the length and copies the values*/
        
        if (list[list.length - 1] != null) {
            E[] tempList = (E[]) new Object[(list.length * 2)];
            tempList = java.util.Arrays.copyOf(list, (list.length * 2));
            list = tempList;
        }
        for (int index = 0; index < list.length; index++) {
            if (list[index] == null) {
                list[index] = o;
                break;
            }else {
                continue;
            }
        }
    }//end push
    
    public E pop() {
        /* Finds the first non-null element in the array and
         * removes it from the stack*/
        
        E o = null;
        for (int count = list.length - 1; count >= 0; count--) {
            if (list[count] != null) {
                o = list[count];
                list[count] = null;
                return o;
            } else continue;
        }
        return null;// Only returns null if it cannot pop any objects.
    }
    
    public boolean isEmpty() {
        // If the first element in the stack is null, the stack is empty.
        return list[0] == null? true: false;
    }//end pop
    
    @Override
    public String toString() {
        
        /* Prints out all of the elements in the array.
         * Each one is separated by a comma and space.*/
        StringBuilder str = new StringBuilder("[");
        for (int index = 0; index < list.length; index++) {
            
            if (list[index] == null) {
                continue;
            } else {
            str.append(String.valueOf(list[index]));
            str.append(", "); 
            }
        }
        str.append("]");
        String toReturn = str.toString();
        return toReturn;
    }//end toString
    
}//end GenericStack