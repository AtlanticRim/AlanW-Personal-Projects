/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 2/23/2023
 *  Last Updated: 2/20/2023
 *  
 *  Compilation: javac UnixFileNameChecker.java
 *  Execution: java UnixFileNameChecker
 *  
 *  Description
 *  A short program that uses regular expressions to check if a user-input
 *  filename is in a valid format for Unix
 *  
 *  Sample Output:
 *  cs340.exe
 *  cs340.exe is a valid Unix File Name.
 *  
 *  abc!&[].tx!
 *  abc!&[].tx! is not a valid Unix File Name.
 *---------------------------------------------------*/

package homework;
import java.util.regex.*;
import java.util.Scanner;

public class UnixFileNameChecker {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        
        boolean isValid = checkFileName(fileName);
        if (isValid) {
            System.out.println(fileName + " is a valid Unix File Name.");
        } else {
            System.out.println(fileName + " is not a valid Unix File Name.");
        }
        
        input.close();
    }
 
    public static boolean checkFileName(String fileName) {
        
        /* Checks a given file name against a pattern. Unix filenames can only
         * contain a-z,A-Z, or _,.
         * Filenames cannot also be . or .. (. is unicode character u002E)*/
        
        String regEx1 = "[\\w_,. ]+";
        Pattern pattern1 = Pattern.compile(regEx1);
        Matcher matcher1 = pattern1.matcher(fileName);
        
        String regEx2 = "^[\\u002E]|^[\\u002E]{2}";
        Pattern pattern2 = Pattern.compile(regEx2);
        Matcher matcher2 = pattern2.matcher(fileName);
        
        if (matcher1.matches() && !matcher2.matches()) {
            return true;
        } else {
            return false;
        }
    } // end checkFileName
    
} // end UnixFileNameChecker