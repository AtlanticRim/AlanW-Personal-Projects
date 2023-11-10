public class SortStrings {
public static void main(String[] args) {
char[] charFromString = args[0].toCharArray(); 
java.util.Arrays.sort(charFromString);	
System.out.print("The sorted string is: ");	
for (int control = 0; control < charFromString.length; control++) {
	System.out.print(charFromString[control]);
}
System.out.printf("\n");
}
}//End class