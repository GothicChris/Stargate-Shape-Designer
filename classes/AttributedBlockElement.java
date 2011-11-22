/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author RRD
 */
public class AttributedBlockElement extends BlockElement {
    
    private BlockAttribute singleAttribute;
    
    private ArrayList<BlockAttribute> attributeList;

    public AttributedBlockElement() {
        attributeList = new ArrayList<BlockAttribute>();
    }

    public ArrayList<BlockAttribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(BlockAttribute blockattribut) {
        this.attributeList.add(blockattribut);
    }
    
    
    
    @Override
    public String toString() {
        String returnString = "[";
        returnString = returnString.concat(name);
        
        Iterator<BlockAttribute> attributeIterator = attributeList.iterator();
        
        while(attributeIterator.hasNext()) {
            returnString = returnString.concat(attributeIterator.next().toString());
        }
        returnString = returnString.concat("]");
        
        return returnString;
    }
}
