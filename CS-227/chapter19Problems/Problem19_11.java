/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 10/1/2022
 *  Last Updated: 10/1/2022
 *  
 *  Compilation: javac Problem19_11.java
 *  Execution: java Problem19_11
 *  
 *  Solution to Problem 19_11 in the textbook.
 *  Uses the Complex class and GenericMatrix class to create a ComplexMatrix class
 *  that can add and multiply complex matrices
 *  
 *  Sample Output:
 *   
 *  m1 + m2 is 
 *  (1.0 + 1.0i) (2.0 + 2.0i)      (1.0 + 1.0i) (2.0 + 2.0i)     (2.0 + 2.0i) (4.0 + 4.0i) 
 *  (3.0 + 3.0i) (4.0 + 4.0i)  +   (3.0 + 3.0i) (4.0 + 4.0i)  =  (6.0 + 6.0i) (8.0 + 8.0i) 
 *  
 *  m1 * m2 is 
 *  (1.0 + 1.0i) (2.0 + 2.0i)      (1.0 + 1.0i) (2.0 + 2.0i)     (0.0 + 2.0i) (0.0 + 8.0i) 
 *  (3.0 + 3.0i) (4.0 + 4.0i)  *   (3.0 + 3.0i) (4.0 + 4.0i)  =  (0.0 + 18.0i) (0.0 + 32.0i) 
 ---------------------------------------------------*/

package chapter19Problems;

public class Problem19_11 {
    
    public static void main(String[] args) {
        
        // Creates two Complex arrays
        Complex[][] m1 = new Complex[][]{{new Complex(1, 1), new Complex(2, 2), }, {new Complex(3, 3), new Complex(4, 4)}};
        Complex[][] m2 = new Complex[][]{{new Complex(1, 1), new Complex(2, 2), }, {new Complex(3, 3), new Complex(4, 4)}};
        
        // Creates an instance of ComplexMatrix
        ComplexMatrix compMatrix = new ComplexMatrix();
        
        // Adds and multiplies m1 and m2
        System.out.println("\nm1 + m2 is ");
        GenericMatrix.printResult(m1, m2, compMatrix.addMatrix(m1, m2), '+');
        System.out.println("\nm1 * m2 is ");
        GenericMatrix.printResult(m1, m2, compMatrix.multiplyMatrix(m1, m2), '*');
        
    } //end main
}


class ComplexMatrix extends GenericMatrix<Complex> {
    
    @Override // Adds two complex numbers
    protected Complex add(Complex c1, Complex c2) {
        return c1.add(c2);
    }// end add
    
    @Override // Multiplies two complex numbers
    protected Complex multiply(Complex c1, Complex c2) {
        return c1.multiply(c2);
    }// end multiply
    
    @Override // Specifies zero
    protected Complex zero() {
        // Creates a complex number with the values a = 0 and b = 0
        return new Complex(0, 0);
    }// end zero
    
} // end GenericMatrix


/* This GenericMatrix class was taken from
 * Listing 19.10 in the textbook. It was slightly modified
 * by me to work with Objects instead of Integers */
abstract class GenericMatrix<E extends Object> {
    //Abstract method for adding 2 elements of the matrices.
    protected abstract E add(E o1, E o2);
    
    //Abstract method for multiplying two elements of the matrices
    protected abstract E multiply(E o1, E o2);
    
    //Abstract method for defining zero for the matrix element
    protected abstract E zero();
    
    //Add two matrices
    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
        //Check bounds of the two matrices
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
            throw new RuntimeException("The matrices do not have the same size.");
        }
        
        E[][] result = (E[][]) new Object[matrix1.length][matrix1[0].length];
        
        //Perform addition
        for (int i = 0; i < result.length; i++) 
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        return result;
    } //end addMatrix
    
    // Multiply two matrices
    public E[][] multiplyMatrix(E [][] matrix1, E[][] matrix2) {
        // Check bounds
        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException("The matrices do not have compatible size.");
        }
        
        // Create result matrix
        E[][] result = (E[][]) new Object[matrix1.length][matrix2[0].length];
        
        // Perform multiplication of two matrices
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();

                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = multiply(matrix1[i][j], matrix2[i][j]);
                }
            }
        }
        
        return result;
    }// end multiplyMatrix

    public static void printResult(Object[][] m1, Object[][] m2, Object[][] m3, char op) {
        
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                
                System.out.print(" (" + m1[i][j].toString() + ")");
            }
            if (i == m1.length / 2) System.out.print("  " + op + "  ");
            else System.out.print("     ");
                
            for (int j = 0; j < m2.length; j++) {
                System.out.print(" (" + m2[i][j].toString() + ")");
            }
            if (i == m1.length / 2) System.out.print("  =  ");
            else System.out.print("     ");
            
            for (int j = 0; j < m3.length; j++) {
                System.out.print("(" + m3[i][j].toString() + ") ");
            }
            
            System.out.println();
        }
    } // end printResults
    
} // end GenericMatrix


/* The Complex class was originally written for 
 * an assignment in CS-226 and is reused here. 
 * I am the original author of all code*/
  class Complex extends Object implements Cloneable, Comparable<Complex>{
    private double a;
    private double b;
    
    Complex(){
        a = 0;
        b = 0;
    }//End no arg constructor
    
    Complex(double a){
       this.a = a;
       b = 0;
    }//End constructor
  
    Complex(double a, double b){
        this.a = a;
        this.b = b;
    }//End constructor
  
    public void setRealPart(double newA) {
        a = newA;
    }//End setA
  
    public double getRealPart() {
        return a;
    }//End getA
  
    public void setImaginaryPart(double newB) {
        b = newB;
    }//End setB
  
    public double getImaginaryPart() {
        return b;
    }//End getB
  
    @Override
    public String toString() {
       if(b == 0) {
           return a + "";
       }else return a + " + " + b + "i";
    }//End toString
  
    @Override
    public int compareTo(Complex other) {
       if(this.abs() > other.abs()) {
           return 1;
       }else if(this.abs() < other.abs()) {
           return -1;
       }else {
           return 0;
       }
    }//End compareTo
  
    public Complex add(Complex one) {
       double a = this.getRealPart();
       double b = this.getImaginaryPart();
       double c = one.getRealPart();
       double d = one.getImaginaryPart();
       Complex answer = new Complex (a+c, b+d);
       return answer;
    }//End add
  
    public Complex subtract(Complex one) {
       double a = this.getRealPart();
       double b = this.getImaginaryPart();
       double c = one.getRealPart();
       double d = one.getImaginaryPart();
       Complex answer = new Complex(a-c, b-d);
       return answer;
    }//End subtract
  
    public Complex multiply(Complex one) {
       double a = this.getRealPart();
       double b = this.getImaginaryPart();
       double c = one.getRealPart();
       double d = one.getImaginaryPart();
       Complex answer = new Complex( ((a*c) - (b*d) ), ( (b*c) + (a*d) ));
       return answer;
    }//End multiply
  
    public Complex divide(Complex one) {
       double a = this.getRealPart();
       double b = this.getImaginaryPart();
       double c = one.getRealPart();
       double d = one.getImaginaryPart();
       Complex answer = new Complex( ((a*c)+(b*d))/((Math.pow(c, 2))+(Math.pow(d, 2))), (((b*c)-(a*d))/ ((Math.pow(c, 2))+(Math.pow(d, 2)))));
       return answer;
    }//End divide
  
    public double abs() {
       double a = this.getRealPart();
       double b = this.getImaginaryPart();
       return Math.sqrt(((Math.pow(a, 2))+(Math.pow(b, 2))));
    }//End abs
  
    @Override
    public Object clone() {
       try {
           return super.clone();
       }catch(CloneNotSupportedException e) {
           return null;
       }
    }//End clone
  
}//End Complex