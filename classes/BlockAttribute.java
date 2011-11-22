/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author rrd
 */
public class BlockAttribute {
    
    protected String name;

    public BlockAttribute() {
    }

    public BlockAttribute(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String returnString = ":";
        
        returnString = returnString.concat(name);
        
        return returnString;
    }
}
