/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author RRD
 */
public class AttributedBlockElement extends BlockElement {
    
    private HashMap<String, BlockAttribute> attributeMap;

    public AttributedBlockElement() {
        attributeMap = new HashMap<String, BlockAttribute>();
    }

    public HashMap<String, BlockAttribute> getAttributeMap() {
        return attributeMap;
    }

    public void putAttribute(BlockAttribute blockattribut) {
        this.attributeMap.put(blockattribut.name, blockattribut);
    }
    
    public void removeAttribute(String name) {
        this.attributeMap.remove(name);
    }
    
    @Override
    public String toString() {
        String returnString = "[";
        returnString = returnString.concat(name);
        
        Iterator<String> attributeIterator = attributeMap.keySet().iterator();
        
        while(attributeIterator.hasNext()) {
            returnString = returnString.concat(attributeMap.get(attributeIterator.next()).toString());
        }
        returnString = returnString.concat("]");
        
        return returnString;
    }
}
