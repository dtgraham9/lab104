
import java.io.File;
import java.io.IOException;

/**
 * The Recursion class provides static methods that can calculate 
 * a harmonic number, half the size of an array of the power of two, and
 * prints the file directory of a given path
 * @author Graham Thompson
 * @version
 */
public class Recursion {
    /**
     * Given a int value it will calculate its harmonic value
     * @param harmonic
     * @return 
     */
    public static double harmonic(int harmonic){
        if(harmonic==0){
            return 0;
        }
        else{
            return 1/(double) harmonic + harmonic(harmonic-1);
        }
    }
    
    /**
     * Sums an array which sinks it down to half its size and stores the summed
     * value for each recursive call
     * @param length
     * @param a
     * @param answer
     * @return 
     */
    public static int[] isabel(int length,int[] a, int[] answer){
        if(length >=0){
            answer[length]= a[length*2+1]+a[length*2];
            return isabel(--length,a, answer);
        }
        else{
            return answer;
        }

    }
    /**
     * Prints the system's directory given a path
     * @param root 
     */
    public static void printTree(File root){
        try {
            File[] files = root.listFiles();
            for(File file: files){
                if(file.isDirectory()){
                    System.out.println(file.getCanonicalPath());
                    printTree(file);
                }
                else{
                    System.out.println(file.getCanonicalPath());
                }
            }
        }
        catch(IOException | NullPointerException e){
            
        }
    }
}
