/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author RRD
 */
public class NumerableBlockAttribute extends BlockAttribute {
    
    private Integer number;

    public NumerableBlockAttribute() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String returnString = ":";
        
        returnString = returnString.concat(name);
        
        if(number != null) {
            returnString = returnString.concat("#".concat(number.toString()));
        }
        
        return returnString;
    }
}
