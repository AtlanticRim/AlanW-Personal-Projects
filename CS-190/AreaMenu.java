import java.util.Scanner;

public class AreaMenu{
	public static void main(String[] args){
 //Code created by Jeremy Wallace 10/29/2021 CS-190L
		
while(true){
   int option = menu();
   switch(option){
    case 1:   circleArea();	break;
    case 2:   pentagonArea(); break;
    case 3:   polygonArea(); break;
    case 4:   System.exit(0);        
    }//end switch
   }//end while
  }//end main

 static int menu(){
  Scanner input = new Scanner(System.in);
  System.out.println("Select an option");
  System.out.println("1. Circle");
  System.out.println("2. Pentagon");
  System.out.println("3. Regular Polygon");
  System.out.println("4. Exit");
  return input.nextInt();
 }//end menu

 static void circleArea(){
   System.out.print("Enter the radius: ");
   Scanner input = new Scanner(System.in);
   double radius = input.nextDouble();
   double area = Math.PI*(radius*radius);
   System.out.printf("%25s%7.3f\n","The area of the circle is",area);
   System.out.println();
   
 }//end circleArea method
 static void pentagonArea(){
   System.out.print("Enter the length of a side: ");
   Scanner input = new Scanner(System.in);
   double sideLength = input.nextDouble();
   double area = (5*(sideLength*sideLength))/(4*(Math.tan(Math.PI/5)));
   System.out.printf("%25s%7.3f\n","The area of the pentagon is",area);
   System.out.println();
 }//end pentagonArea method
  
 static void polygonArea(){
   System.out.print("Enter the number of sides: ");
   Scanner input = new Scanner(System.in);
   int sides = input.nextInt();
   System.out.print("Enter the length of a side: ");
   double sideLength = input.nextDouble();
   double area = (sides*(sideLength*sideLength))/(4*(Math.tan(Math.PI/sides)));
   System.out.printf("%25s%7.3f\n","The area of the polygon is",area);
   System.out.println();
 }//end polygonArea method

}//end class
