

public class StudentGrades {
	public static void main(String[] args) {
	//Code created by Jeremy Wallace 9/24/21 CS190L Araujo

//Generates a random number between 60 and 99
int number = (int)(60+Math.random()*33);

char grade = ' ';
char gradeModifier = ' ';
int onesDigit = (number % 10);
int tensDigit = (number % 100)/10;
	
//Evaluates the tens digit to find the letter grade
switch (tensDigit) {
case 6: grade = 'D'; break;
case 7: grade = 'C'; break;
case 8: grade = 'B'; break;
case 9: grade = 'A'; break;
}
//Evaluates the ones digit to see if it is a +, -, or nothing
switch (onesDigit) {
case 0: gradeModifier = '-'; break;	
case 1:	gradeModifier = '-'; break;
case 8: gradeModifier = '+'; break;
case 9: gradeModifier = '+'; break;
}

//Final result printed to console
System.out.println("A number grade of " + number + " is a letter grade of: " + grade + gradeModifier);

}
}