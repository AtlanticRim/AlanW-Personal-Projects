import java.util.Scanner;

public class LocateElementsMultiArrays {
public static void main(String[] args) {
//Code created by Jeremy Wallace 11/10/2021 CS-190	
double[][] matrix = arrayCreate();
int[] answer = locateLargest(matrix);
System.out.println("The largest element is is located at (" + answer[0] + "," + answer[1] + ")");
	
}//end main
	
public static double[][] arrayCreate() {
java.util.Scanner input = new Scanner(System.in);
System.out.print("Enter the number of rows and columns in the array: ");
int rowsNum = input.nextInt(); 
int columnsNum = input.nextInt();
double[][] matrix = new double[rowsNum][columnsNum];
System.out.println("Enter " + matrix.length + " rows and " +
  matrix[0].length + " columns: ");
for (int row = 0; row < matrix.length; row++) {
  for (int column = 0; column < matrix[row].length; column++) {
    matrix[row][column] = input.nextDouble(); 
  }
}
return matrix;
}//end arrayCreate

public static int[] locateLargest (double[][] matrix) {
int[] answer = new int[3];
double compare = 0;
for (int row = 0; row < matrix.length; row++) {
	  for (int column = 0; column < matrix[row].length; column++) {
		  if (matrix[row][column] > compare) {
			  compare = matrix[row][column];
			  answer[0] = row;
			  answer [1] = column;
		  }
	  }
}
return answer;
}//end locateLargest


}//end class