public class MPG
{
 public static void main( String [] args ) {
  // declare data
  double miles; // miles driven in car
  double gallons; // number of gallons used
  double mpg; // miles per gallon
  // initialize data
  miles = 341;
  gallons = 15.5;
  // calculate mpg
  mpg = miles / gallons;
  // output results
  System.out.print ( miles + " mi. / " );
  System.out.print ( gallons + " gal." );
  System.out.println( " = " + mpg + " mpg" );
 }
}