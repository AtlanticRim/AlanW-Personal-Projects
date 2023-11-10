
import java.util.Scanner;

public class RewriteLoops5_8 {
 public static void main(String[] args) {
Scanner input = new Scanner(System.in);
//Code retooled by Jeremy Wallace 10/6/2021
//To be turned in with lab

// Prompt the user to enter the number of students
System.out.print("Enter the number of students: ");
int numOfStudents = input.nextInt();
System.out.print("Enter a student name: ");
String student1 = input.next();
System.out.print("Enter a student score: ");
double score1 = input.nextDouble();

int i = 0;
while (i < numOfStudents - 1) {
System.out.print("Enter a student name: ");
String student = input.next();

System.out.print("Enter a student score: ");
double score = input.nextDouble();

if (score > score1) {
student1 = student;
score1 = score;
   }

++i;
}

System.out.println("Top student " +
student1 + "'s score is " + score1);

}
}
