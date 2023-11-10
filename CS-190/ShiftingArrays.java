import java.util.Scanner;

public class ShiftingArrays {
public static void main(String[] args) {
//Code created by Jeremy Wallace 11/5/2021 CS-190L	

int arrayLength = 10;//Creates variable arrayLength to hold the length of the array
int[] list = randInts(arrayLength);
Scanner input = new Scanner(System.in);	
System.out.println("Your starting array is:");
printArrays(list);
System.out.println("Enter L to shift the array left.");
System.out.println("Enter R to shift the array right.");
System.out.println("Enter P to shift pairs in the array.");
System.out.println("Enter E to exit the program.");

while(true) {
char inputVar = Character.toUpperCase((input.next()).charAt(0));

switch(inputVar) {
	case 'L': shiftLeft(list); printArrays(list); break;
	case 'R': shiftRight(list); printArrays(list); break;
	case 'P': swapPairs(list); printArrays(list); break;
	case 'E': System.out.println("Goodbye!"); System.exit(0); break;
}
}//end while(true)

}//end main method

public static int[] randInts(int n) {
int[] randomList = new int[n];
int position = 0;
int randomInt;
for (int control = n; control > 0; control--) {
	randomInt = (int)(Math.random()*100);
	randomList[position] = randomInt;
	position++;
}//End for loop
return randomList;	
}//End randInts

public static void shiftLeft(int[] list) {
	int[] listCopy = new int[10];
	System.arraycopy(list, 1, listCopy, 0, 9);
	listCopy[9] = list[0];
	System.arraycopy(listCopy, 0, list, 0, 10);
}//End shiftLeft

public static void shiftRight(int[] list) {
	int[] listCopy = new int[10];
	System.arraycopy(list, 0, listCopy, 1, 9);
	listCopy[0] = list[9];
	System.arraycopy(listCopy, 0, list, 0, 10);
}//End shiftRight

public static void swapPairs(int[] list) {
	int[] listCopy = new int[10];
	int oneValInc = 0;
	int twoValInc = 1;
	
	while (twoValInc < list.length) {
		int oneValueTemp = list[oneValInc];
		int twoValueTemp = list[twoValInc];
		listCopy[twoValInc] = oneValueTemp;
		listCopy[oneValInc] = twoValueTemp;
		oneValInc += 2;
		twoValInc += 2;
	}
	System.arraycopy(listCopy, 0, list, 0, 10);
}//End swapPairs

public static void printArrays(int[] arrayToPrint) {
	for (int control = arrayToPrint.length, increment = 0; control > 0; control--,increment++) {
		System.out.print(arrayToPrint[increment] +" ");
	}
	System.out.println();
}//End printArrays

}//end class