
import javax.swing.JFileChooser; 
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    
    public static void fecthDataFromPath(){
        
        try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }catch(Exception ex) {
        ex.printStackTrace();
    }      
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF Images", "jpg", "gif");
        fileChooser.setFileFilter(filter);
        fileChooser.showOpenDialog(null);
        
//new java.awt.FileDialog((java.awt.Frame) null).setVisible(true);
    }
    
    public static void isabel(int[] A, int[] B){
        
    }
}
