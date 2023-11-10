//package chapter18Problems;
//import java.util.*;
//
//public class Problem18_34DRAFT {
//    
//    public static void main(String[] args) {
//        
//        int[][] board = new int[8][8];
//        placeQueens(board, 8);
//
//    }//end main
//    
//    
//    public static void placeQueens(int[][] matrix, int n) {
//        System.out.println("Called 1st method");//DEBUG        
//        int[][] matrixCopy = matrix.clone();
//        if (placeQueens(matrixCopy, n) == true) {
//            placeQueens(matrix, n);
//            printArray(matrix);
//        }else {
//            clearArray(matrix);
//            placeQueens(matrix, n);
//        }
//        
//    }// end placeQueens
//    
//    
//    
////     public static boolean placeQueens(int[][] matrix, int n, int triesLeft) {
////         System.out.println("Called 2nd method, n is " + n);//DEBUG 
////         
////         //Generate a random position for the queen
////         int xVal = (int)(Math.random()*8);
////         int yVal = (int)(Math.random()*8);
////         
////         if (n <= 0) {
////             System.out.println("Returned true because 0");
////             return true;
////         }// If n is 0, there are no more queens to place
////         
////         if (triesLeft <= 0) {
////             return false;
////         }// If there are no more tries, the method has failed
////         
////         if(placeQueens(matrix, n-1, triesLeft) == false) {
////             System.out.println("Attempt failed");//DEBUG
////             placeAttack(matrix, yVal, xVal, 0);// This line effectively undoes the last step
////             return false;
////             // This prevents an unsolvable board.
////         }else { 
////             if(isValidPlacement(matrix, yVal, xVal) == true) {
////                 
////                 //If the program finds a successful placement
////                 matrix[xVal][yVal] = 1;
////                 placeAttack(matrix, yVal, xVal, 2);
////                 System.out.println("Returned true because successfull placement");//DEBUG
////                 return true;
////    
////             } else {
////                 return false;
////             }
////         }
////     }//End placeQueens
//         
//         public static boolean isValidPlacement(int[][] matrix, int col, int row) {
//             
//             for (int count = 7; count >= 0; count--) {
//                         
//                         if(matrix[row][count] == 1) {
//                             return false;
//                         }// Checks horizontally
//                         
//                         if(matrix[count][col] == 1) {
//                             return false;
//                         }// Checks vertically
//                         
//                         try {
//                             if(matrix[row-count][col-count] == 1) {
//                                 return false;
//                             }// Checks left upward diagonal
//                         } catch (IndexOutOfBoundsException e) {}
//             
//                         try {
//                             if(matrix[row+count][col+count] == 1) {
//                                 return false;
//                             }// Checks right downward diagonal
//                         } catch (IndexOutOfBoundsException e) {}
//                         
//                         try {
//                             if(matrix[row-count][col+count] == 1) {
//                                 return false;
//                             }// Checks right upward diagonal
//                         } catch (IndexOutOfBoundsException e) {}
//                         
//                          try {
//                              if(matrix[row+count][col-count] == 1) {
//                                  return false;
//                              }// Checks left downward diagonal
//                          } catch (IndexOutOfBoundsException e) {}
//                 }
//             return true;
//         }// End isValidPlacement
//         
//         public static void placeAttack(int[][] matrix, int col, int row, int num) {
//             
//             for (int count = 7; count >= 0; count--) {
//                 
//                 if(matrix[row][count] == 0) {
//                     matrix[row][count] = num;
//                 }// Places horizontally
//                 
//                 if(matrix[count][col] == 0) {
//                     matrix[count][col] = num;
//                 }// Places vertically
//                 
//                 
//                 try {
//                     if(matrix[row-count][col-count] == 0) {
//                         matrix[row-count][col-count] = num;
//                     }// places left upward diagonal
//                 } catch (IndexOutOfBoundsException e) {}
//
//                 try {
//                     if(matrix[row+count][col+count] == 0) {
//                         matrix[row+count][col+count] = num;
//                     }// places right downward diagonal
//                 } catch (IndexOutOfBoundsException e) {}
//                 
//                 try {
//                     if(matrix[row-count][col+count] == 0) {
//                         matrix[row-count][col+count] = num;
//                     }// places right upward diagonal
//                 } catch (IndexOutOfBoundsException e) {}
//                 
//                  try {
//                      if(matrix[row+count][col-count] == 0) {
//                          matrix[row+count][col-count] = num;
//                      }//places left downward diagonal
//                  } catch (IndexOutOfBoundsException e) {}
//               
//             }
//             
//         }// End placeAttack
//         
//         /* 
//          * This method uses a loop to print the entire board array
//          */
//         public static void printArray(int[][] matrix) {
//             for (int row = 0; row < matrix.length; row++) {
//                 
//                 for (int column = 0; column < matrix[row].length; column++) {
//                     System.out.print(matrix[row][column] + " ");
//                 }
//                 
//                 System.out.println();
//             }
//             System.out.println();
//         }//end printArray
//    
//         public static void clearArray(int[][] matrix){
//             for (int row = 0; row < matrix.length; row++) {
//                 
//                 for (int column = 0; column < matrix[row].length; column++) {
//                     matrix[row][column] = 0;
//                 }
//             }
//         }// end clearArray
//         
//         public static void copyArray(int[][] m1, int[][] m2) {
//             for (int row = 0; row < m1.length; row++) {
//                 
//                 for (int column = 0; column < m1[row].length; column++) {
//                     
//                     m2[row][column] = m1[row][column];
//                 }
//                 
//                 System.out.println();
//             }
//             System.out.println();
//         }//end printArray
//         
//}//end class
