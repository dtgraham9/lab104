
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Graham Thompson
 * @version
 */
public class Recursion {
    public static double harmonic(int harmonic){
        if(harmonic==0){
            return 0;
        }
        else{
            return 1/(double) harmonic + harmonic(harmonic-1);
        }
    }
    
    public static int[] isabel(int length,int[] a, int[] answer){
        if(length >=0){
            answer[length]= a[length+1]+a[length];
            return isabel(--length,a, answer);
        }
        else{
            return answer;
        }

    }
    
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
