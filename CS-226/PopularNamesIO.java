//Code edited by J. Alan Wallace 3/23/2022 CS-226
import java.io.File;
import java.util.Scanner;
public class PopularNamesIO{
 public static void main(String[] args){
  File boyfile = new File("boynames.txt");
  File girlfile = new File("girlnames.txt");
  Scanner keyboard = new Scanner(System.in);
  Scanner readBoys = null;
  Scanner readGirls = null;
  String[][] boyData = null;
  String[][] girlData = null;
  System.out.print("Enter a first name: ");
  String firstname = keyboard.nextLine();
  System.out.println("You entered: " + firstname);

  try{
      boyData = fillArray(new Scanner(boyfile));
	//verify file read - then remove
	for(int k=0;k<boyData.length;k++);
      girlData = fillArray(new Scanner(girlfile));
	//verify file read - then remove
	for(int k=0;k<girlData.length;k++);
     }
  catch(Exception e){
      System.out.println(e.getClass().getCanonicalName() + " Exception occured");
     }

  searchName(firstname, boyData, girlData);
 }//end main

 static String[][] fillArray(Scanner fileScan){
   int i=0;
   String[][] theArray = new String[1000][2];
     while(fileScan.hasNext()){
       String name = fileScan.next();
       String namings = fileScan.next();
       theArray[i][0] = name;
       theArray[i][1] = namings;
       i++;	
     }
    fileScan.close();
    return theArray;
   }
 
 static void searchName(String name, String[][] boyData, String[][] girlData) {
	 int boyPosition = -1, girlPosition = -1;
	 for (int control = 0; control < boyData.length; control++) {
		 if (name.equals(boyData[control][0])) {
			 boyPosition = control; break;
		 }
	 }
	 for (int control = 0; control < girlData.length; control++) {
		 if (name.equals(girlData[control][0])) {
			 girlPosition = control; break;
		 }
	 }
	 if(boyPosition > -1) {
		 System.out.println(name + " is ranked " + (boyPosition+1) + " in popularity among boys with " + boyData[boyPosition][1] + " namings.");
	 }else System.out.println(name + " is not ranked among the top 1000 boy names.");
	 
	 if(girlPosition >-1) {
		 System.out.println(name + " is ranked " + (girlPosition+1) + " in popularity among girls with " + girlData[girlPosition][1] + " namings.");
	 }else System.out.println(name + " is not ranked among the top 1000 girl names.");
}//End searchName
}//end class
