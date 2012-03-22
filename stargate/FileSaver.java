/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stargate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher
 */
public class FileSaver {
    

    private File file;
    
    private FileWriter writer;

    public FileSaver(File file) {
        try {
            String filename = file.getAbsolutePath();
            if(!file.getName().toUpperCase().endsWith(".SSDF")) {
                filename += ".ssdf";
            }
            this.writer = new FileWriter(filename);
            this.file = file;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Fehler beim erstellen der Datei!",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean write(String str) throws IOException {
        writer.write(str);
        return true;
    }
    
    public boolean close() {
        try {
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
