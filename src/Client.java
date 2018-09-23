
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Graham
 */
public class Client {

    public static void noOptionSelected(){
        JOptionPane.showMessageDialog(null, "No value selected please enter in a value");
    }
    
    public static boolean confirmExit(){
        int option = JOptionPane.showConfirmDialog(null,null,"Are you sure you want to exit?", 0);
        return JOptionPane.YES_OPTION == option;
    }
    
    public static void runHarmonic(){
        boolean statusCheck = true;
        int result = 0;
        while(statusCheck){
            String input = JOptionPane.showInputDialog(null,"Please enter in a integer number", "Harmonic Calculator");
            try{
                result = Integer.parseInt(input);
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Not an integer value, please enter integer");
                runHarmonic();
            }
            double harmonic = Recursion.harmonic(result);
            JOptionPane.showMessageDialog(null, Double.toString(harmonic));
            statusCheck = false;
        }
        
    }
    
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
    
    
    
    public static void runIsabel(){
        boolean statusCheck = true;
        String path;
        ArrayBag<Integer> integers = new ArrayBag();
        while(statusCheck){
            path = JOptionPane.showInputDialog(null,"Please enter file path", "Isabel sum");
            File file;
            Scanner scan = null;
            try {
                file = new File(path);
                scan = new Scanner(file).useDelimiter(" ");
                
            }
            catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "Not a valid file location, please enter valid path");
                runIsabel();
            }
            while(scan.hasNext()){
                    integers.add(scan.nextInt());
            }
            if(!(isPowerOfTwo(integers.getCurrentSize()))){
                JOptionPane.showMessageDialog(null, "Array is not a power of two, please enter valid path of int array that contains length that is power of two");
                runIsabel();
            }
            int[] B = new int[integers.getCurrentSize()/2];
            int[] C = Recursion.isabel(integers.getCurrentSize()-1, integers.getIntArray(), B);
            String output = "";
            for(int i = 0; C.length-1> i; i++){
                output+= C[i] + ", ";
            }
            output+= C[C.length-1];
            JOptionPane.showMessageDialog(null, output);
            statusCheck = false;
            
        }
    }
    
    public static void runPrintTree(){
        boolean statusCheck = true;
        String path;
        while(statusCheck){
            path = JOptionPane.showInputDialog(null,"Please enter file path", "print directory tree");
            File file;
            Scanner scan;
            try{
                file = new File(path);
                scan = new Scanner(file);
            }
            catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "Not a valid file location, please enter valid path");
                runPrintTree();
            }
            file = new File(path);
            if(!(file.isDirectory())){
                JOptionPane.showMessageDialog(null, "That is a file, please enter valid path to directory");
                runPrintTree();
            }
            Recursion.printTree(file);
            statusCheck = false;
        }
    }
    
    public static void menuSelector(){
        boolean statusCheck = false;
        while(!(statusCheck)){
            String optionString = "A to run harmonic calculator\nB to run Isabel's sum\nC to run print out file directory\nD to exit"; 
            String response = JOptionPane.showInputDialog(null,optionString);
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
                
        }    
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menuSelector();
        
    }
    
}
