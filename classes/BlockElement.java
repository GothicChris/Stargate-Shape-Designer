/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;

/**
 *
 * @author rrd
 */
public class BlockElement {
    
    protected String name;
    
    protected Color color;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    @Override
    public String toString() {
        
        return "[".concat(name).concat("]");
    }
}
