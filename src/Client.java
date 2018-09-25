
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * Options system that will allow a user to select different operations that
 * can be performed. Operations include Isabel's sum, Harmonic calculator, and
 * printing system directory.
 * @author Graham Thompson
 * @version
 */
public class Client {

    /**
     * Its the default case for the switch inside menuSelector which pops up a
     * window saying nothing was selected.  
     */
    public static void noOptionSelected(){
        JOptionPane.showMessageDialog(null, "No value selected please enter in a value");
    }
    
    /**
     * When the user selects to exit prompts for additional confirmation.
     * @return 
     */
    public static boolean confirmExit(){
        int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","exit", JOptionPane.YES_NO_OPTION);
        return JOptionPane.YES_OPTION == option;
    }
    
    /**
     * If harmonic calculator selected, prompts user for value and ensure it is 
     * type safe
     */
    public static void runHarmonic(){
        System.out.println("Testing Harmonic calculator");
        boolean statusCheck = true;
        int result = 0;
        while(statusCheck){
            String input = JOptionPane.showInputDialog(null,"Please enter in a integer number");
            if(input == null)
                break;
            try{
                result = Integer.parseInt(input);
            }
            catch (NumberFormatException e){
                System.out.println("Invalid parameter: " + input);
                JOptionPane.showMessageDialog(null, "Not an integer value, please enter integer");
                runHarmonic();
            }
            System.out.println("Valid parameter: " + result);
            double harmonic = Recursion.harmonic(result);
            System.out.println("Output: "+ harmonic);
            JOptionPane.showMessageDialog(null, Double.toString(harmonic));
            statusCheck = false;
        }
        
    }
    /**
     * Checks to ensure a number is the power of two
     * @param number
     * @return 
     */
    public static boolean isPowerOfTwo(int number) {

        if (number % 2 != 0) 
            return false;
    
        else {
            for (int i = 0; i <= number; i++) {
                if (Math.pow(2, i) == number) 
                    return true;
            }
        }
        return false;
    }
    
    
    /**
     * If Isabel selected it ensures a file path is valid, then overlooks
     * if any non int value is present.  Then checks to see if the length is
     * a power of two.  Finally will call Isabel's recursion method and prints
     * out the result
     */
    public static void runIsabel(){
        System.out.println("Isabel sum");
        boolean statusCheck = true;
        String path;
        ArrayBag<Integer> integers = new ArrayBag();
        while(statusCheck){
            path = JOptionPane.showInputDialog(null,"Please enter file path");
            if(path == null)
                break;
            File file;
            Scanner scan = null;
            try {
                file = new File(path);
                scan = new Scanner(file).useDelimiter(" ");
                
            }
            catch(FileNotFoundException e){
                System.out.println("Invalid path: " + path);
                JOptionPane.showMessageDialog(null, "Not a valid file location, please enter valid path");
                runIsabel();
            }
            while(scan.hasNext()){
                    try {
                        integers.add(Integer.parseInt(scan.next()));
                    }
                    catch (NumberFormatException e){
                        
                    }
            }
            if(!(isPowerOfTwo(integers.getCurrentSize()))){
                System.out.println("Array not a power of two: " + integers.getCurrentSize());
                JOptionPane.showMessageDialog(null, "Array is not a power of two, please enter valid path of int array that contains length that is power of two");
                runIsabel();
            }
            System.out.println("input: "+ integers.toString());
            int[] B = new int[integers.getCurrentSize()/2];
            int[] C = Recursion.isabel(integers.getCurrentSize()/2-1, integers.getIntArray(), B);
            String output = "";
            for(int i = 0; C.length-1> i; i++){
                output+= C[i] + ", ";
            }
            output+= C[C.length-1];
            System.out.println("Output: " + output);
            statusCheck = false;
            
        }
    }
    
    /**
     * Will print out a valid file path directory.  Checks for valid file path 
     * and makes sure its a directory.  
     */
    public static void runPrintTree(){
        System.out.println("Print tree");
        boolean statusCheck = true;
        String path;
        while(statusCheck){
            path = JOptionPane.showInputDialog(null,"Please enter file path");
            if(null == path)
                break;
            File file = new File(path);
                if(!(file.isDirectory())){
                    System.out.println("Invalid path: " + path);
                    JOptionPane.showMessageDialog(null, "This is not a valid, please enter valid path to directory");
                    runPrintTree();
                }
                System.out.println("Path: " + path);
                Recursion.printTree(file);
                statusCheck = false;
            }
            
    }
    
   /**
    * The menu system that prompts user to select an operation or exit the 
    * program
    */
    public static void menuSelector(){
        boolean statusCheck = false;
        while(!(statusCheck)){
            String optionString = "A to run harmonic calculator\nB to run Isabel's sum\nC to run print out file directory\nD to exit"; 
            String response = JOptionPane.showInputDialog(null,optionString);
            if(null == response){
                statusCheck = confirmExit();
                if(statusCheck)
                    break;
                else 
                    continue;
            }
            
            switch ( response ) 
            {
                case "a" :
                case "A" :
                    runHarmonic();
                    break;
                case "b" :
                case "B" :
                    runIsabel();
                    break;
                case "c" :
                case "C" :    
                    runPrintTree();
                    break;
                case "d":
                case "D":
                    statusCheck = confirmExit();
                    break;
                default :
                    noOptionSelected();
                    break;
            }    
        }
    }
    
    /**
     * Starts the menu system and the menu system will end itself.  
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menuSelector();
        
    }
    
}
