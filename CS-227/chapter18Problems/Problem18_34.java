/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 9/12/2022
 *  Last Updated: 9/12/2022
 *  
 *  Compilation: javac Problem18_34.java
 *  Execution: java Problem18_34
 *  
 *  Solution to Problem 18.34 in the textbook. 
 *  Utilizes recursion and a for loop to place 8 Queens on a Chessboard,
 *  such that they will not conflict with one another.
 *  
 *  Sample Output:
 *  1 0 0 0 0 0 0 0 
 *  0 0 0 0 1 0 0 0 
 *  0 0 0 0 0 0 0 1 
 *  0 0 0 0 0 1 0 0 
 *  0 0 1 0 0 0 0 0 
 *  0 0 0 0 0 0 1 0 
 *  0 1 0 0 0 0 0 0 
 *  0 0 0 1 0 0 0 0 
 ---------------------------------------------------*/

package chapter18Problems;

public class Problem18_34 {
    final static int BOARD_SIZE = 8;
    
    public static void main(String[] args) {
        
        //Creates a board, calls the placeQueens method, and prints the results to console.
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        placeQueens(board, 8);
        printArray(board);
    
    }//end main
    
    public static boolean placeQueens(int[][] matrix, int n) {
        
        if (n <= 0) {
          return true;
        }// Base case. If n is 0, there are no more queens to place
        
        /* This for loop will navigate a column to find the first valid
         * placement for a queen, then checks if the rest of the queens
         * can be placed with the queen in that position. If all queens
         * cannot be placed, it then backtracks and then finds the next valid placement.
         * Returns TRUE if all queens can be placed validly, else returns FALSE and backtracks. */
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isValidPlacement(matrix, (BOARD_SIZE - n), col) == true) {
                matrix[BOARD_SIZE - n][col] = 1;
                
                if (placeQueens(matrix, n-1) == true) {
                    return true;
                }else {
                    matrix[BOARD_SIZE - n][col] = 0;
                    continue;
                }
            }
        }
        return false;
    }//end placeQueens
    
    public static boolean isValidPlacement(int[][] matrix, int row, int col) {
        
        /* This method checks if an index in the two-dimensional array 
         * can hold a queen. If the spot is valid, returns TRUE. If the
         * spot is not valid, returns FALSE.*/
        for (int count = 7; count >= 0; count--) {
                    
                    if(matrix[row][count] == 1) {
                        return false;
                    }// Checks horizontally
                    
                    if(matrix[count][col] == 1) {
                        return false;
                    }// Checks vertically
                    
                    try {
                        if(matrix[row-count][col-count] == 1) {
                            return false;
                        }// Checks left upward diagonal
                    } catch (IndexOutOfBoundsException e) {}
        
                    try {
                        if(matrix[row+count][col+count] == 1) {
                            return false;
                        }// Checks right downward diagonal
                    } catch (IndexOutOfBoundsException e) {}
                    
                    try {
                        if(matrix[row-count][col+count] == 1) {
                            return false;
                        }// Checks right upward diagonal
                    } catch (IndexOutOfBoundsException e) {}
                    
                     try {
                         if(matrix[row+count][col-count] == 1) {
                             return false;
                         }// Checks left downward diagonal
                     } catch (IndexOutOfBoundsException e) {}
            }
        return true;
    }// End isValidPlacement
    
    
    public static void printArray(int[][] matrix) {
        //A method that uses a loop to print a two-dimensional array.
        
        for (int row = 0; row < matrix.length; row++) {
            
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }//end printArray
    
}//end class
