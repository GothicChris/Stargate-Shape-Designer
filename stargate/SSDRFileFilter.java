/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stargate;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Christopher
 */
public class SSDRFileFilter extends FileFilter{

    @Override
    public boolean accept(File f) {
        if(f.isDirectory()) {
            return true;
        }
        String filename = f.getName().toUpperCase();
        return filename.endsWith(".SSDF");
    }

    @Override
    public String getDescription() {
        return "Stargate Shape Designer File (*.ssdf)";
    }
    
}
