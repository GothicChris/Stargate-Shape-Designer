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
public class ShapeFileFilter extends FileFilter{

    @Override
    public boolean accept(File f) {

        if(f.isDirectory()) {
            return true;
        }
        String fileName = f.getName().toUpperCase();
        return fileName.endsWith(".SHAPE");
    }

    @Override
    public String getDescription() {
        return "Wormhole X-Treme Shape File (*.shape)";
    }
    
    
}
