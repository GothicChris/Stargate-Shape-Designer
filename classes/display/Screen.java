/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.display;

import classes.vector.Vector3D;
import java.awt.Point;

/**
 *
 * @author RRD
 */
public class Screen {
    
    Vector3D camera;

    public Screen(Vector3D camera) {
        this.camera = camera;
    }
    
    public Point map3Dto2D(Vector3D vector) {
        
        return new Point(0, 0);
    }
}
