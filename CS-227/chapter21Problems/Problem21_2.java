/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 11/5/2022
 *  Last Updated: 11/5/2022
 *  
 *  Compilation: javac Problems21_2.java
 *  Execution: java Problems21_2
 *  
 *  Sample Output:
 *  begin
 *  daughter
 *  discreet
 *  ensure
 *  fluctuation
 *  forecast
 *  hip
 *  injury
 *  lead
 *  mole
 *  notice
 *  reputation
 *  restrict
 *  twitch
 *  wrong
 *---------------------------------------------------*/

package chapter21Problems;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem21_2 {
    public static void main(String[] args) throws FileNotFoundException {
        
        /* Contents of the file (there are 20 words total, 5 of which are duplicates)
         * fluctuation
         * reputation
         * lead
         * notice
         * restrict
         * discreet
         * begin
         * injury
         * hip
         * twitch
         * daughter
         * wrong
         * ensure
         * restrict
         * forecast
         * notice
         * twitch
         * discreet
         * mole
         * fluctuation
         */
        
        //Reads in the file that contains the words above
        File file = new File("C:\\Users\\Public\\Documents\\Problem19_2WordList.txt");
        Scanner scan = new Scanner(file);
        
        TreeSet<String> set1 = new TreeSet<String>();
        while(scan.hasNext()) {
            set1.add(scan.nextLine());
        }
        for (String element: set1) {
            System.out.println(element.toString());
        }      
        System.out.println();
        scan.close();
    }// end main
} // end Problem21_2