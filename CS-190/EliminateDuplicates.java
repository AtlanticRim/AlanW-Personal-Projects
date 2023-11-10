import java.util.Scanner;

public class EliminateDuplicates {
public static void main(String[] args) {
//Code created by Jeremy Wallace 11/5/2021 CS-190L
	
Scanner input = new Scanner(System.in);
int[] numberArray = new int[10];
System.out.println("Enter 10 nonzero integer numbers. Separate each with a space.");
for (int control = numberArray.length, increment = 0; control > 0; control--,increment++)	{
	numberArray[increment] = input.nextInt();
}//end for loop
System.out.println("The numbers you entered were:");
printArrays(numberArray);
System.out.println("These are the numbers with all of the duplicates removed:");
eliminateDuplicates(numberArray);
printArrays(numberArray);	
	
	
}//end main method

public static int[] eliminateDuplicates(int[] list) {
int[] noDuplicateList = new int[10];//Initiates Dummy Array
int checkPosition = 0;
int valueToCheck, valueCheckAgainst, checkAgainstPosition;
int duplicateListIncrement = 0;
boolean isDuplicate = false;

for (int control = (list.length); control > 0; control--) {//This loop takes the value you want to compare
	valueToCheck = list[checkPosition];//Takes the compare value
	checkAgainstPosition = 0;//This needs to be here to reset the while loop
	isDuplicate = false;

	while (checkAgainstPosition < checkPosition+1) {//This loop compares each value to the valueToCheck to check for duplicates
		valueCheckAgainst = list[checkAgainstPosition];
		if (valueToCheck == valueCheckAgainst && valueCheckAgainst != 0 && checkPosition != checkAgainstPosition) {
			isDuplicate = true;
			}
	checkAgainstPosition++;
	}//end while loop
	
	if (isDuplicate == false) {
		noDuplicateList[duplicateListIncrement] = valueToCheck;
		duplicateListIncrement++;
	}
	
	checkPosition++;//Increments the value you want to compare
}//End for loop

	System.arraycopy(noDuplicateList, 0, list, 0, 10);
	return noDuplicateList;
}//end eliminateDuplicates

public static void printArrays(int[] arrayToPrint) {
	for (int control = arrayToPrint.length, increment = 0; control > 0; control--,increment++) {
		if (arrayToPrint[increment] != 0) {
		System.out.print(arrayToPrint[increment] + " ");
		}
	}
	System.out.println();
}//End printArrays

}//end class