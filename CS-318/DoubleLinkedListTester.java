/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 1/12/2023
 *  Last Updated: 1/12/2023
 *  
 *  Compilation: javac DoubleLinkedListTester.java
 *  Execution: java DoubleLinkedListTester
 *  
 *  Creates a Generic Double Linked List, which has both nextLink and prevLink properties.
 *  Also implements the following methods: goToNext, goToPrev, getDataAtCurrent, setDataAtCurrent, insertNodeAfterCurrent,
 *  deleteCurrentNode, showList, inList, equals, and toString.
 *  
 *  Sample Output:
 *  Double Linked List Tester
 *  Create, insert, and move test
 *  1
 *  2
 *  3
 *  4
 *  Previous and Deletion Test
 *  1
 *  2
 *  4
 *  In list test
 *  true
 *  false
 *  Test Done
 *---------------------------------------------------*/

package homework;

public class DoubleLinkedListTester {
    
    //Driver Code, provided in assignment description
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Double Linked List Tester");
        System.out.println("Create, insert, and move test");
        GenDoubleLinkedList<String> dList = new GenDoubleLinkedList<String>();
        dList.setDataAtCurrent("1");
        dList.insertNodeAfterCurrent("2");
        dList.goToNext();
        dList.insertNodeAfterCurrent("3");
        dList.goToNext();
        dList.insertNodeAfterCurrent("4");
        dList.goToNext();
        dList.showList();
        
        System.out.println("Previous and Deletion Test");
        dList.goToPrev();
        dList.deleteCurrentNode();
        dList.showList();
        
        System.out.println("In list test");
        System.out.println(dList.inList("2"));
        System.out.println(dList.inList("3"));
        
        System.out.println("Test Done");
    } // end main

} // end DoubleLinkedListTest
 
class GenDoubleLinkedList<T> {
    ListNode<T> head;
    ListNode<T> current;
    
    public GenDoubleLinkedList() {
        this.head = new ListNode<T>();
        this.current = this.head;
    } // default constructor
    
    public void goToNext() {
        // Traverses to the next node in the list
        if (this.current == null || this.current.nextLink == null) return;
        else this.current = this.current.nextLink;
    } // end goToNext
    
    public void goToPrev() {
        // Traverses to the previous node in the list
        if (this.current == null || this.current.prevLink == null) return;
        else this.current = this.current.prevLink;
    } // end goToPrev
    
    public T getDataAtCurrent() {
        // Returns the data at the current node
        if (this.current == null) return null;
        else return this.current.data;
    } // end getDataAtCurrent
    
    public boolean setDataAtCurrent(T data) {
        /* Overwrites the data at the current node
         * Returns true upon a successful change of data, else returns false*/
        if (this.current == null) return false;
        else {
            this.current.data = data;
            return true;
        }
    } // end setDataAtCurrent
    
    public boolean insertNodeAfterCurrent(T data) {
        /* Inserts a new node after the current node
         * Returns true upon a successful insertion, else returns false*/
        if (this.current == null) {
            return false;
        }
        else if (this.current.nextLink == null) {
            this.current.nextLink = new ListNode<T>(data, null, current);
            return true;
        }
        else {
            this.current.nextLink = new ListNode<T>(data, current.nextLink, current);
            this.current.nextLink.nextLink.prevLink = this.current.nextLink;
            return true;
        }
    } // end insertNodeAfterCurrent
    
    public boolean deleteCurrentNode() {
        /* Deletes the node at the current position
         * Returns true upon a successful deletion, else returns false*/
        if (current.data == null || this.current == null) {
            return false;
        } else if (this.current.prevLink == null) {
            // This should only trigger if the node to be deleted is the head
            if (this.current.nextLink == null) {
                // This should only trigger if the head node is the only node in the list
                this.current.data = null;
                return true;
            } else {
                // This should only trigger if the head node is the node to be deleted, but there are other nodes in the list
                this.current.nextLink.prevLink = null;
                this.head = this.current.nextLink;
                this.current = this.head;
                return true;
            }
        }else {
            // This triggers if a non-head node is the node to be deleted
            this.current.nextLink.prevLink = this.current.prevLink;
            this.current.prevLink.nextLink = this.current.nextLink;
            return true;
        }  
    } // end deleteCurrentNode
    
    public void showList() {
        // Prints the entire list, starting at the head
        if (this.head == null) {
            System.out.println("null");
            return;
        }
        else {
            ListNode<T> traverser = this.head;
            while (traverser != null) {
                System.out.println(traverser.data);
                traverser = traverser.nextLink;
            }
        }
    } // end showList
    
    public boolean inList(T key) {
        /* Uses linear search to search for a key
         * Returns true if the key can be found in the list, else returns false*/
        
        if (this.head == null) {
            System.out.println("null");
            return false;
        }
        else {
            ListNode<T> traverser = this.head;
            while (traverser != null) {
                if (traverser.data == key) return true;
                traverser = traverser.nextLink;
            }
            return false;
        }
    } // end inList
    
    public boolean equals(GenDoubleLinkedList<T> list) {
        /* This method compares this instance of GenDoubleLinkedList with another instance.
         * It uses the toString method to compare if they have the exact same elements and order.
         * Returns true if the two match, else returns false.*/
        return (this.toString().equals(list.toString()));
    }
    
    public String toString() {
        /* This method returns all the value in the Double Linked List as a single string
         * in the format [element, element, element, ...]*/
        StringBuilder str = new StringBuilder("[");
        ListNode<T> traverser = this.head;
        while (traverser != null) {
            str.append(traverser.data);
            str.append(", ");
            traverser = traverser.nextLink;
        }
        str.append("]");
        return str.toString();
    } // end toString
    
    class ListNode<T> {
        // ListNode class for the GenDoubleLinkedList class
        T data;
        ListNode<T> nextLink;
        ListNode<T> prevLink;
        
        public ListNode() {
            
        } // default constructor
        
        public ListNode(T data, ListNode<T> nextLink, ListNode<T> prevLink) {
            this.data = data;
            this.nextLink = nextLink;
            this.prevLink = prevLink;
        } // parameterized constructor
    } // end ListNode class
    
} // end GenDoubleLinkedList class
