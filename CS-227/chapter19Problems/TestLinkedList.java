/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 10/15/2022
 *  Last Updated: 10/18/2022
 *  
 *  Compilation: javac TestLinkedList.java
 *  Execution: java TestLinkedList.java
 *  
 *  Implements a LinkedList class and a class to test it
 *  
 *  Sample Output:
 *  Is the list currently empty: true
 *  [Me, Myself, I]
 *  
 *  Is the list empty now: false
 *  Element at index 2 is: I
 *  Size is: 3
 *  [Me, You, Myself, I]
 *  'You' can be found at position: 1
 *  [Me, Myself, I]
 *  
 *  Trying to get an invalid index: Index Out of Bounds
 *  [Me, Myself]
 *  'I' can be found at position (-1 means it cannot be found): -1
 *  List has been cleared.
 *  
 *  [We, Us]
 *  The tail of that list is: Us
 *  [They, We]
 *  The tail of that list is: We
 *  [They, Them]
 *  The tail of that list is: Them
 *  
 *  Trying to delete an invalid index: Index Out of Bounds
 *  Trying to get an element from an empty list: Index Out of Bounds
 *  Trying to get the tail of an empty list: List is Empty
 ---------------------------------------------------*/

package chapter19Problems;

public class TestLinkedList {
    public static void main(String[] args) throws Exception {
        /* This creates a LinkedList and tests all of the methods
         * available for that class.*/
        
        LinkedList<String> list = new LinkedList<>();
         
        System.out.println("Is the list currently empty: " + list.isEmpty()); // Tests isEmpty
        list.prepend(new Node<String>("Me")); // Tests prepend
        list.append(new Node<String>("Myself"));
        list.append(new Node<String>("I")); // Tests append
        System.out.println(list.toString());
        System.out.println();
        
        System.out.println("Is the list empty now: " + list.isEmpty());
        System.out.println("Element at index 2 is: " + list.get(2)); // Tests get
        System.out.println("Size is: " + list.getSize()); //Tests getSize
        list.insert(1, "You"); // Tests insert
        System.out.println(list.toString());
        
        System.out.println("'You' can be found at position: " + list.linearSearch("You")); // Tests linearSearch
        list.delete(1); // Tests delete
        System.out.println(list.toString());
        System.out.println();

        try {
            System.out.print("Trying to get an invalid index: ");
            list.get(100);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        list.delete(2);
        System.out.println(list.toString());
        
        System.out.println("'I' can be found at position (-1 means it cannot be found): " + list.linearSearch("I"));
        list.clear();
        System.out.println("List has been cleared.");
        System.out.println();

        list.append(new Node<String>("We"));
        list.append(new Node<String>("Us"));
        System.out.println(list.toString());
        System.out.println("The tail of that list is: " + list.getTail()); // Tests getTail
        
        list.delete(1);
        list.prepend(new Node<String>("They"));
        System.out.println(list.toString());
        System.out.println("The tail of that list is: " + list.getTail());

        list.delete(1);
        list.append(new Node<String>("Them"));
        System.out.println(list.toString());
        System.out.println("The tail of that list is: " + list.getTail());
        System.out.println();

        try {
            System.out.print("Trying to delete an invalid index: ");
            list.clear();
            list.delete(1);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.print("Trying to get an element from an empty list: ");
            list.get(5);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.print("Trying to get the tail of an empty list: ");
            list.getTail();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }  // end main
} // end TestLinkedList

class LinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    public LinkedList(){
    } // end default constructor
    
    public LinkedList(E[] elements) throws Exception {
        // Creates a linked list based on a predefined array of objects E
        
        for (int i = 0; i < elements.length; i++) {
            insert(i, elements[i]);
            this.size++;
        }
        
    } // end constructor
    
    public E get(int index) throws Exception{
        
        if (index < 0 || index >= size) {
            throw new Exception("Index Out of Bounds");
        }
        
        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    } // end get
    
    public void insert(int index, E e) throws Exception {
        /* Inserts an element into a specified index.
         * If the element is to be inserted in the first or last index,
         * it calls the appropriate methods. If not, inserts the element*/
        
        if (index < 0 || index >= size) {
            throw new Exception("Index Out of Bounds");
        } // Checks if the index is within bounds
        
        if (index == 0) prepend(new Node<E>(e)); // Checks if the element should be prepended
        else if (index >= size-1) append(new Node<E>(e)); // Checks if the element should be appended
        

        Node<E> current = this.head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        Node<E> temp = current.next;
        current.next = new Node<>(e);
        (current.next).next = temp;
        size++;
    }
    
    public void delete(int index) throws Exception {
        // Deletes an element at an index
        
        if (index < 0 || index >= size) {
            throw new Exception("Index Out of Bounds");
        } // Checks if the index is within bounds
        
        if (index == 0) {
            // Does this if the element to be deleted is the head
            this.head = head.next;
            this.size--;
            if (this.head == null) this.tail = null;
        } else if (index == this.size-1) {
            // Does this if the element to be deleted is the tail
            Node<E> current = this.head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            this.tail = current;
            this.tail.next = null;
            this.size--;
        } else {
            // Does this if the element to be deleted is anything else
            Node<E> current = this.head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            current.next = (current.next).next;
            this.size--;
        }
    } // end delete
    
    public int getSize() {
        // returns the total size of the array
        return this.size;
    } // end getSize
    
    public int linearSearch(E key) {
        // Utilizes a linear search to find a key
        
        Node<E> current = this.head;
        for (int i = 0; i < this.size; i++) {
            
            if ((current.element).compareTo(key) == 0) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        /* Checks if the list is empty and 
         * returns true if it is*/
        if ((this.size == 0) && (this.head == null) && (this.tail == null)) {
            return true;
        } else {
            return false;
        }
    } // end isEmpty
    
    public void append(Node<E> e) {
        // Inserts an element at the last position in the list
        if (isEmpty()) {
            this.head = this.tail = e;
        } else {
            /*Links the new node with the last node, 
            *then makes the new last node the tail.*/
            this.tail.next = e;
            this.tail = e;
        }
        this.size++;
    } // end append
    
    public void prepend(Node<E> e) {
        if (isEmpty()) {
            this.tail = this.head = e;
        } 
        
        // Inserts a node at the beginning of the list
        e.next = this.head;
        this.head = e;
        this.size++;
    } // end prepend
    
    public void clear() {
        // Removes all elements in the list
        this.size = 0;
        this.head = this.tail = null;
    }
    
    public E getTail() throws Exception {
        // If there is a tail, returns the tail
        if (!isEmpty()) {
            return this.tail.element;
        } else {
            throw new Exception("List is Empty");
        }
    } // end getTail
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        
        Node<E> current = this.head;
            for (int i = 0; i < size; i++) {
                result.append(current.element);
                current = current.next;
                if (current != null) {
                   result.append(", "); // Separates two elements with a comma
                }
                else {
                   result.append("]"); // Inserts the closing ] in the string
                }
            }
        
              return result.toString();
        }// end toString
    
    
} // end LinkedList
    

class Node<E> {
    protected E element;
    protected Node<E> next;
    
    Node(){
        
    }// end default constructor
    
    Node(E e){
        element = e;
    }// end constructor
    
} // end node