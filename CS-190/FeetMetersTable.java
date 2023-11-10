

public class FeetMetersTable {
public static void main(String[] args) {	
//Code created by Jeremy Wallace 10/27/2021 CS-190
	
double footInput = 1;
double meterInput = 20.0;
double inchesInput = 10.0;
System.out.printf("\n%-10s%-11s|%10s%10s%7s%11s%14s\n","Feet","Meters","Meters","Feet","|","Inches","Centimeters");
System.out.printf("%-40s\n","------------------------------------------------------------------------");
for (int control = 0; control < 10; control++) {
System.out.printf("%4.1f     ", footInput);
System.out.printf("%7.3f", footToMeter(footInput));
System.out.printf("     |     ");
System.out.printf("%4.1f     ", meterInput);
System.out.printf("%7.3f", meterToFoot(meterInput));
System.out.printf("     |     ");
System.out.printf("%5.1f     ", inchesInput);
System.out.printf("%7.3f\n", inchesToCenti(inchesInput));
footInput++;
meterInput = meterInput + 5.0;
inchesInput = inchesInput + 10.0;
}	
	
}//end main method	
	
public static double footToMeter(double foot) {	
double meter = 0.305 * foot;
return meter;
}//end footToMeter	
	
public static double meterToFoot(double meter) {
double foot = 3.279 * meter;
return foot;
}//end meterToFoot

public static double inchesToCenti(double inches) {
double centi = inches * 0.3937008;
return centi;
}//end inchestoCenti

}
