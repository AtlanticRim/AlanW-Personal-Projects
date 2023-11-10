/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 1/28/2023
 *  Last Updated: 3/3/2023
 *  
 *  Compilation: javac BSTOfIntegersTester.java
 *  Execution: java BSTOfIntegersTester
 *  
 *  Description:
 *  A program that implements a binary search tree of integers using array implementation.
 *  The BSTOfIntegers class is tested in the main method.
 *  Implements the methods: Default and parameterized constructor, insert, delete,
 *  search, printInOrder, printPreOrder, printPostOrder, toString, and equals.
 *  
 *  Sample Output:
 *  bst1: [1, 0, 0, 0, 0, 0, 0, 0, ]
 *  bst2: [4, 2, 6, 1, 3, 0, 7, 0, ]
 *  
 *  Does bst1 equal bst2? false
 *  Updated bst2: [4, 2, 6, 1, 3, 5, 7, 0, ]
 *  Caught TreeAlreadyContainsElementException Runtime Exception
 *  Caught ElementNotFoundInTreeException Runtime Exception
 *  
 *  Can the element 7 be found in bst2? true
 *  Can the element 9 be found in bst2? false
 *  
 *  Print InOrder: 1, 2, 3, 4, 5, 6, 7, 
 *  Print PreOrder: 4, 2, 1, 3, 6, 5, 7, 
 *  Print PostOrder: 1, 3, 2, 5, 7, 6, 4, 
 *  
 *  bst2 after deleting 6: [4, 2, 5, 1, 3, 0, 7, 0, ]
 *  bst2 after deleting 5: [4, 2, 7, 1, 3, 0, 0, 0, ]
 *  bst2 after deleting 2: [4, 1, 7, 0, 3, 0, 0, 0, ]
 *---------------------------------------------------*/

package homework;
import java.util.Stack;

public class BSTOfIntegersTester {
    
    public static void main(String[] args) {
        
        BSTOfIntegers bst1 = new BSTOfIntegers();
        bst1.insert(1);
        
        int[] bst2Setup = {4, 2, 6, 1, 3, 7};
        BSTOfIntegers bst2 = new BSTOfIntegers(bst2Setup);
        
        // Testing toString method
        System.out.println("bst1: " + bst1.toString()); 
        System.out.println("bst2: " + bst2.toString());
        System.out.println();
        
        // Testing equals method
        System.out.print("Does bst1 equal bst2? ");
        System.out.println(bst1.equals(bst2));
        
        // Testing insert method
        bst2.insert(5);
        System.out.println("Updated bst2: " + bst2.toString());
        
        try {
            // Testing inserting a value already in the tree
            bst1.insert(1);                 
        } catch (TreeAlreadyContainsElementException e) {
            System.out.println("Caught TreeAlreadyContainsElementException Runtime Exception");
        }
        
        try {
            
            // Testing deleting a value not in the tree
            bst1.delete(9);
            
        } catch (ElementNotFoundInTreeException e) {
            System.out.println("Caught ElementNotFoundInTreeException Runtime Exception");
        }
        System.out.println();
        
        // Testing search method
        System.out.print("Can the element 7 be found in bst2? ");
        System.out.println(bst2.search(7, 0));
        System.out.print("Can the element 9 be found in bst2? ");
        System.out.println(bst2.search(9, 0));
        System.out.println();
        
        // Testing InOrder, PreOrder, and PostOrder Traversals
        System.out.print("Print InOrder: ");
        bst2.printInOrder(0);
        System.out.println();
        System.out.print("Print PreOrder: ");
        bst2.printPreOrder(0);
        System.out.println();
        System.out.print("Print PostOrder: ");
        bst2.printPostOrder(0);
        System.out.println();
        System.out.println();
        
        // Testing delete method
        bst2.delete(6);
        System.out.println("bst2 after deleting 6: " + bst2.toString());
        bst2.delete(5);
        System.out.println("bst2 after deleting 5: " + bst2.toString());
        bst2.delete(2);
        System.out.println("bst2 after deleting 2: " + bst2.toString());
        
    } // end main method
    
} // end class BSTOfIntegersTester

class BSTOfIntegers {

    private int[] list;
    /* The list is instantiated in the constructors.
     * Note that the default value is 0, thus if there is no value set at
     * a specific index, 0 will be there.*/
    
    public BSTOfIntegers() {
        /* Default constructor.
         * The default size of the array is 8.*/
        
        list = new int[8];
        
    } // end default constructor
    
    
    public BSTOfIntegers(int[] nodes) {
        /* Constructor that takes an array of nodes and copies them
         * to this.list. 
         * This assumes that the list of nodes are sorted and formatted as a BST array.*/
        
        this.list = new int[8];
        for (int count = 0; count < nodes.length; count++) {
            insert(nodes[count]);
        }
        
    } // end parameterized constructor
    
    public void insert(int e) {
        /* Inserts an element e into the BST*/
    
        int currentIndex = 0;
        while(currentIndex > this.list.length - 1 || this.list[currentIndex] != e) {
            
            /* If the this.list array is too small to hold the accurate representation of
             * the BST, this doubles the size.*/
            if (currentIndex > this.list.length - 1) {
                int[] temp = new int[this.list.length*2];
                for (int count = 0; count < this.list.length - 1; count++) {
                    temp[count] = this.list[count];
                    
                  }
                this.list = temp;
                continue;
            }
            
            /* Traverses the BST until the correct, empty spot is found.*/
            if (this.list[currentIndex] == 0) {
              this.list[currentIndex] = e;
              return;
            }
            
            if (e < this.list[currentIndex]) {
                currentIndex = (2*currentIndex) + 1;                // go left
                continue;
            }
            
            if (e > this.list[currentIndex]) {
                currentIndex = (2*currentIndex) + 2;                // go right
                continue;
            }
        }
        /* If the element aleady exists in the bst, throw an exception.*/
        throw new TreeAlreadyContainsElementException();

    } // end insert
    
    public void delete(int e) {
        /* Deletes a node with value e. Deletes the node differently
         * depending on if it has 0, 1,or 2 children.*/
        
        int currentIndex = 0;

        while (currentIndex < this.list.length) {
            /* This while loop navigates to the node to be deleted.*/
            
            if (this.list[currentIndex] == e) {
                // Test if the current node is the one to be deleted
                
                if ((2*currentIndex + 2 >= this.list.length) || (this.list[(2*currentIndex + 1)] == 0 && this.list[(2*currentIndex + 2)] == 0)) {
                    /* The above if statement translates to: if the currentIndex's two children do not exist in the array,
                     * or exist in the array and are both 0.
                     * If the value to be deleted has no children, simply overwrites the value at the current position with 0.*/
                    
                    this.list[currentIndex] = 0;
                    return;
                
                } else if (this.list[(2*currentIndex + 1)] == 0 ^ this.list[(2*currentIndex + 2)] == 0) {
                    /* If the value to be deleted has one child 
                     * Sets the deleted element to 0, then depending on if the right or left child is not 0, sets to that value.
                     * It then uses a stack to rearrange the subtree*/
                    
                    Stack<Integer> stack = new Stack<Integer>();
                    stack.push(currentIndex);
                    int currentPop = currentIndex;

                    
                    while (!stack.isEmpty()) {
                        
                        currentPop = stack.pop();
                        this.list[currentPop] = 0;
                        
                        if (2*currentPop+1 > this.list.length || 2*currentPop+2 > this.list.length) break;
                        
                        if (this.list[2*currentPop+1] == 0) this.list[currentPop] = this.list[2*currentPop+2];
                        if (this.list[2*currentPop+2] == 0) this.list[currentPop] = this.list[2*currentPop+1];
                        
                        if (this.list[2*currentPop+1] != 0) stack.push(2*currentPop+1);
                        if (this.list[2*currentPop+2] != 0) stack.push(2*currentPop+2);
                        
                    }
                    return;
                    
                } else if (this.list[(2*currentIndex + 1)] != 0 && this.list[(2*currentIndex + 2)] != 0) {
                    /* If the value to be deleted has two children
                     * This assumes that the left node will be moved into the spot
                     * of the deleted node. It then recursively calls delete on the left node.*/
                    
                    int temp = this.list[(2*currentIndex + 1)];
                    delete(this.list[((2*currentIndex) + 1)]);
                    this.list[currentIndex] = temp;
                    return;
                }
            }
            else currentIndex++;
        }
        /* If the node cannot be found in the while loop, throw new ElementNotFoundInTree Exception*/
        throw new ElementNotFoundInTreeException();
    } // end delete    
    
    public boolean search(int key, int i) {
        /* Searches for a key, starting at position i.
         * Utilizes a recursive call to search the left or right subtrees.
         * If the element can be found, returns true,
         * If the element cannot be located in the tree, returns false.*/
        
        if (i > this.list.length - 1 || this.list[i] == 0) return false;
        if (this.list[i] == key) return true;
        if (key > this.list[i]) return search(key, ((2*i) + 2));
        else return search(key, ((2*i) + 1));
        
    } // end search
    
    public void printInOrder(int index) {
        /* Recursively prints all of the values in the BSTOfIntegers
         * using in-order traversal.
         * Takes in an int index to traverse the tree recursively.*/
        
        if (index > this.list.length - 1) return;
        
        printInOrder((2*index) + 1);
        if (this.list[index] != 0) System.out.print(this.list[index] + ", ");
        printInOrder((2*index) + 2);
        
    } // end printInOrder
    
    public void printPreOrder(int index) {
        /* Recursively print all of the values in the BSTOfIntegers
         * using pre-order traversal.
         * Takes in an int index to traverse the tree recursively.*/
        
        if (index > this.list.length - 1) return;
        
        if (this.list[index] != 0) System.out.print(this.list[index] + ", ");
        printPreOrder((2*index) + 1);
        printPreOrder((2*index) + 2);
        
    } // end printPreOrder
    
    public void printPostOrder(int index) {
        /* Recursively print all of the values in the BSTofIntegers using
         * post-order traversal.
         * Takes in an int index to traverse the tree recursively.*/
        
        if (index > this.list.length - 1) return;
        
        printPostOrder((2*index) + 1);
        printPostOrder((2*index) + 2);
        if (this.list[index] != 0) System.out.print(this.list[index] + ", ");
        
    } // end printPostOrder
    
    public String toString() {
        /* Prints the this.list array, which contains all the values
         * of the BST and represents them in order.*/
        
        StringBuilder str = new StringBuilder("[");
        for (int count = 0; count < this.list.length; count++) {
            str.append(this.list[count]);
            str.append(", ");
        }
        str.append("]");
        return str.toString();
        
    } // end toString
    
    public boolean equals(BSTOfIntegers e) {
        /* If the toString printouts of both the BSTOfIntegers are true, returns true.
         * The two BSTOfIntegers are equal if the contents are order of their lists are the same.*/
        
        if (this.toString().equalsIgnoreCase(e.toString())) return true;
        else return false;
        
    } // end equals
    
} // end BSTOfIntegers class

class TreeAlreadyContainsElementException extends RuntimeException {
    /* Custom Exception that is thrown if a value is being inserted when
     * it already exists in the BSTOfIntegers*/
    
    public TreeAlreadyContainsElementException() {
        super("The specified BSTOfIntegers already contains that element.");
    } // end default constructor
    
} // end custom exception TreeAlreadyContainsElementException

class ElementNotFoundInTreeException extends RuntimeException {
    /* Custom RuntimeException that is thrown if a value is being deleted from
     * the BSTOfIntegers, but the BST does not contain that value.*/
    
    public ElementNotFoundInTreeException() {
        super("The specified BSTOfIntegers does not contain that element.");
    } // end default constructor
    
}// end custom exception ElementNotFoundInTreeException
