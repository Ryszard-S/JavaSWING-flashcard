
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileNotFoundException;

public class Main {
    public static setGetPath p = new setGetPath();

    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser file = new JFileChooser(".");
        file.setFileFilter(new FileNameExtensionFilter("*.txt","txt"));
        file.setMultiSelectionEnabled(false);
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.setFileHidingEnabled(false);
        if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            java.io.File f = file.getSelectedFile();
            p.setPath(f.getPath());
        }
        new GUI();
    }

}
