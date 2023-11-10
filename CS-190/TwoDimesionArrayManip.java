import java.util.Scanner;

public class TwoDimesionArrayManip {
public static void main(String[] args) {
//Code created by Jeremy Wallace 11/12/2021 CS-190L	

int[][] matrix = arrayCreate();
printArrays(matrix);
while(true){
	int option = menu();
	switch(option){
	case 1:   printArrays(rowSwap(matrix));	break;
	case 2:   printArrays(columnSwap(matrix)); break;
	case 3:   int[][] newMatrix = transpose(matrix);
			  matrix = new int[newMatrix.length][newMatrix[0].length]; 
			  for (int copyControl = 0; copyControl < matrix.length; copyControl++) {
				  	System.arraycopy(newMatrix[copyControl], 0, matrix[copyControl], 0, newMatrix[copyControl].length);
			  }
			  printArrays(matrix); 
			  break;
	case 4:   System.out.println("Goodbye!"); System.exit(0); break;
	default: System.out.println("Invalid choice. Please try again."); break;
	}//end switch
}//end while
}//end main
	
public static int menu(){
 Scanner input = new Scanner(System.in);
 System.out.println("Select an option");
 System.out.println("1. Swap Two Random Rows");
 System.out.println("2. Swap Two Random Columns");
 System.out.println("3. Form Array Transpose");
 System.out.println("4. Exit");
  return input.nextInt();
}//end menu	
	
public static int[][] arrayCreate() {
java.util.Scanner input = new Scanner(System.in);
System.out.print("Enter the number of rows and columns in the array: ");
int rowsNum = input.nextInt(); 
int columnsNum = input.nextInt();
int[][] matrix = new int[rowsNum][columnsNum];
System.out.println("Your starting matrix is:");
for (int row = 0; row < matrix.length; row++) {
  for (int column = 0; column < matrix[row].length; column++) {
    matrix[row][column] = (int)(Math.random()*100); 
  }
}
return matrix;
}//end arrayCreate	
	
public static void printArrays(int[][] arrayToPrint) {
int rowIncrement = 0;
for (int row = 0; row < arrayToPrint.length; row++) {
	 for (int column = 0; column < arrayToPrint[row].length; column++) {
	   System.out.print(arrayToPrint[rowIncrement][column]); 
	   System.out.print(" ");
	 }
	 System.out.printf("\n");
	 rowIncrement++;
}
}//End printArrays	

public static int[][] rowSwap(int[][] startMatrix){
int rowToSwap1 = (int)(Math.random()*startMatrix.length);
int rowToSwap2 = (int)(Math.random()*startMatrix.length);
System.out.println("Swapping rows " + rowToSwap1 + " and " + rowToSwap2);
int[] holderArray = new  int[startMatrix[0].length];
System.arraycopy(startMatrix[rowToSwap1], 0, holderArray, 0,startMatrix[rowToSwap1].length);
System.arraycopy(startMatrix[rowToSwap2], 0, startMatrix[rowToSwap1], 0, startMatrix[rowToSwap2].length);//Copies rowToSwap2 into rowToSwap1
System.arraycopy(holderArray, 0, startMatrix[rowToSwap2], 0, holderArray.length);//Copies the previous value of startMatrix rowToSwap 1 into rowToSwap2
return startMatrix;	
}//end rowSwap

public static int[][] columnSwap(int[][] startMatrix){
int colToSwap1 = (int)(Math.random()*startMatrix[0].length);
int colToSwap2 = (int)(Math.random()*startMatrix[0].length);
System.out.println("Swapping columns " + colToSwap1 + " and " + colToSwap2);
int[] holderArray = new int[startMatrix.length];
for (int control = 0; control < startMatrix.length; control++) {
	int holderNum = startMatrix[control][colToSwap1];
	holderArray[control] = holderNum;//Uses an int to "snapshot" the value of the position, then assigns that value to holderArray
}
for (int control2 = 0; control2 < startMatrix.length; control2++) {
	int holderNum = startMatrix[control2][colToSwap2];
	startMatrix[control2][colToSwap1] = holderNum;//Takes the values of colToSwap2 and puts them into colToSwap1
}
for (int control3 = 0; control3 < startMatrix.length; control3++) {
	int holderNum = holderArray[control3];
	startMatrix[control3][colToSwap2] = holderNum;//Takes the values in the holderArray and assigns them to colToSwap2
}
return startMatrix;
}//end columnSwap

public static int[][] transpose(int[][] startMatrix){
int[][] newMatrix = new int[startMatrix[0].length][startMatrix.length];
int[] holderArray = new int[startMatrix.length];
for (int controlCol = 0; controlCol < startMatrix[0].length; controlCol++) {
	for (int control = 0; control < startMatrix.length; control++) {
		int holderNum = startMatrix[control][controlCol];
		holderArray[control] = holderNum;
	}
System.arraycopy(holderArray, 0, newMatrix[controlCol], 0, holderArray.length);	
}
return newMatrix;
}//end transpose

}//end class
