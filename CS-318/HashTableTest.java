/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 2/4/2023
 *  Last Updated: 2/6/2023
 *  
 *  Compilation: javac HashTableTest.java
 *  Execution: java HashTableTest
 *  
 *  Description:
 *  A program that impleiments a hashtable using two arrays. Implements the methods:
 *  hash,toString, put, contains, delete, and resize.
 *  
 *  Sample Output:
 *  Enter some lowercase characters to store as keys in the hash table 
 *  (Their uppercase equivalents will be used as the corresponding values):
 *  quadratic
 *  
 *  0 : null/null
 *  1 : q/Q
 *  2 : r/R
 *  3 : c/C
 *  4 : a/A
 *  5 : u/U
 *  6 : null/null
 *  7 : d/D
 *  8 : null/null
 *  9 : t/T
 *  10 : null/null
 *  11 : null/null
 *  12 : i/I
 *  13 : null/null
 *  14 : null/null
 *  15 : null/null
 *  
 *  Testing retrieval:
 *  QUADRATIC
 *  
 *  Now enter one or more lowercase character keys to delete from the hash table: 
 *  qr
 *  
 *  Testing retrieval after deletion:
 *  -UAD-ATIC
 *---------------------------------------------------*/

package homework;

import java.util.Scanner;

public class HashTableTest {
    
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter some lowercase characters to store as keys in the hash table ");
       System.out.println("(Their uppercase equivalents will be used as the corresponding values):");
       String charsToHash = scanner.nextLine();
       System.out.println();
       
       HashTable<Character,Character> ht = new HashTable<Character,Character>();

       for (int i = 0; i < charsToHash.length(); i++) {
           ht.put(charsToHash.charAt(i), charsToHash.toUpperCase().charAt(i));
       }
       
       System.out.println(ht);
       
       System.out.println("Testing retrieval:");
       for (int i = 0; i < charsToHash.length(); i++) {
           System.out.print(ht.get(charsToHash.charAt(i)));
       }
       System.out.println("\n");
       
       System.out.println("Now enter one or more lowercase character keys to delete from the hash table: ");
       String charsToDelete = scanner.nextLine();
       scanner.close();
       for (int i = 0; i < charsToDelete.length(); i++) {
           ht.delete(charsToDelete.charAt(i));
       }
       System.out.println();
       
       System.out.println("Testing retrieval after deletion:");
       for (int i = 0; i < charsToHash.length(); i++) {
           Character v = ht.get(charsToHash.charAt(i));
           System.out.print(v != null ? v : '-');
       }
   }
}


class HashTable<Key, Value> {
   private int size;              // how many key/value pairs are stored
   private int arrayLength;       // size of the array (and consequently, the mod)
   private Key[] keys;
   private Value[] vals;
   private boolean[] tombstones;  // true if element at this index has been deleted, false otherwise

   public HashTable() {  
       this(1);  // chains to the other constructor with 1 specified as capacity.
   }

   @SuppressWarnings("unchecked")
   public HashTable(int capacity) {
      // This parameterized constructor sets the capacity of the array as a power of two.
       
       // The capacity is invalid if it is less than 1 or greater than the max value of an int
       if (capacity < 1 || capacity > Integer.MAX_VALUE) return;
      
       // Default capacity of 2
       int powOfTwo = 1;
       do {
           powOfTwo = powOfTwo*2;
           this.arrayLength = powOfTwo;
       } while (powOfTwo <= capacity);  
       
       this.size = 0;
       this.keys = (Key[]) new Object[this.arrayLength];
       this.vals = (Value[]) new Object[this.arrayLength];
       this.tombstones = new boolean[this.arrayLength];
       
   } // end parameterized constructor

   private int hash(Key key) {
      return (key.hashCode() & 0x7fffffff) % arrayLength;
   } // end hash
   
   public String toString() { 
       String s = "";
       for (int i = 0; i < arrayLength; i++) {
           s += i + " : " + keys[i] + "/" + vals[i] + "\n";
       }
       return s;
   }

   public void put(Key key, Value val) {

       // insert or update the value associated with the given key 
       // in the array by hashing and handling any collisions
       
       // Fails if the key is already in the map.
       if (this.contains(key)) return;
       
       int hashed = hash(key);
       if (this.keys[hashed] == null) {
           // If the expected spot is empty, simply inserts the key and value at that index.
           this.keys[hashed] = key;
           this.vals[hashed] = val;
           
           // Resets any tombstones at that position, and increments the size.
           this.tombstones[hashed] = false;
           // Increments size
           this.size++;
           // Checks if the hash table needs to be enlarged (if over 1/2 full)
           if (this.size*2 > this.arrayLength) resize(arrayLength*2);
           
           return;
           
       } else {
           
           for (int count = 1; count < 9999; count++) {
               int quadIndex = (hashed + (count/2) + ((count*count)/2)) % this.arrayLength;
               if (this.keys[quadIndex] == null) {
                   this.keys[quadIndex] = key;
                   this.vals[quadIndex] = val;
                   
                   // Resets any tombstones at that position
                   this.tombstones[quadIndex] = false;
                   // Increments size
                   this.size++;
                   // Checks if the hash table needs to be enlarged (if over 1/2 full)
                   if (this.size*2 > this.arrayLength) resize(arrayLength*2);
                   
                   return;
               }
           }
           //System.out.println("Failed"); // DEBUG
       }
       
   } // end put

   public Value get(Key key) {
       // get the value associated with a given key
      
       int hashed = hash(key);
       
       if (this.keys[hashed] == key) {
           // If the key is at the expected index, return the value associated with it.
           return this.vals[hashed];
       } else {
           
           for (int count = 0; count < 9999; count++) {
               // quadIndex is for the quadratic probing
               int quadIndex = (hashed + (count/2) + ((count*count)/2)) % this.arrayLength;
               
               // If the key is at the probed index, return the value associated with it.
               if (this.keys[quadIndex] == key) return this.vals[quadIndex];
               
               // If the current index being probed is empty and there is not a tombstone, the element is not present.
               if (this.keys[quadIndex] == null && (quadIndex > this.tombstones.length || this.tombstones[quadIndex] == false)) return null;
           }
           // If the value cannot be found, return null
           return null;
       }
       
   } // end get
   
   public boolean contains(Key key) {
   /* Checks if a key is in the hash table.
    * Returns true if it is.*/
       if (get(key) != null) {
           return true;
       } else {
           return false;
       }
       
   } // end contains

   public void delete(Key key) {
       // Deletes the specified key, placing a tombstone in the tombstone array
       
       int hashed = hash(key);
       if (this.keys[hashed] == key) {
           // If the key is at its expected spot
           
           this.keys[hashed] = null;
           this.vals[hashed] = null;
           this.tombstones[hashed] = true;
           
       } else {
           /* If the key is not at it's expected spot, uses
            * quadratic probing to search for it.*/
           
           for (int count = 1; count < 9999; count++) {
               
               int quadIndex = (hashed + (count/2) + ((count*count)/2)) % this.arrayLength;
               if (this.keys[quadIndex] == key) {
                   this.keys[quadIndex] = null;
                   this.vals[quadIndex] = null;
                   this.tombstones[quadIndex] = true;
                   break;
               }
           }
       }
       
       // Decrements size
       size--;
       // Checks if the arrays need to be resized (less than 1/8 full)
       if (this.size*8 < this.arrayLength) resize(this.arrayLength/2);
       
       return;
   } // end delete

   @SuppressWarnings("unchecked")
   private void resize(int capacity) {
       // resize the array to have the given capacity 
       // (requires a rehashing of all items).
            
       this.size = 0;
       this.arrayLength = capacity;
       Key[] oldKeys = this.keys.clone();
       Value[] oldVals = this.vals.clone();
       this.keys = (Key[]) new Object[capacity];
       this.vals = (Value[]) new Object[capacity];
       this.tombstones = new boolean[capacity];
       
       for (int index = 0; index < oldKeys.length; index++) {
           if (oldKeys[index] != null) put(oldKeys[index], oldVals[index]);
       }     
   } // end resize
   
} // end HashTable