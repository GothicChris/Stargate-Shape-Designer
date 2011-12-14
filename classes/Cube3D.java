/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.vector.Vector3D;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author RRD
 */
public class Cube3D {
    
    private Vector3D position;
    
    private Vector3D a;
    private Vector3D b;
    private Vector3D c;
    private Vector3D d;
    private Vector3D e;
    private Vector3D f;
    private Vector3D g;
    private Vector3D h;
    
    private double size;

    public Cube3D(Vector3D position, double size)
            throws IllegalArgumentException {
        
        if(position == null) {
            throw new IllegalArgumentException("null object not allowed");
        } else {
            this.position = position;
        }
        
        if(size <= 0) {
            throw new IllegalArgumentException("Size has to be greater than 0");
        } else {
            this.size = size;
        }
    }
    
    private void calculateEdges(Vector3D xAxis, Vector3D yAxis, Vector3D zAxis) {
        
        Vector3D tx = new Vector3D(xAxis.x, xAxis.y, xAxis.z);
        Vector3D ty = new Vector3D(yAxis.x, yAxis.y, yAxis.z);
        Vector3D tz = new Vector3D(zAxis.x, zAxis.y, zAxis.z);
        
        tx.scale(size / 2.0);
        ty.scale(size / 2.0);
        tz.scale(size / 2.0);
        
        a = new Vector3D(position.x, position.y, position.z);
        a = a.linearCombination(tx.negate());
        a = a.linearCombination(ty.negate());
        a = a.linearCombination(tz.negate());
        
        b = new Vector3D(position.x, position.y, position.z);
        b = b.linearCombination(tx.negate());
        b = b.linearCombination(ty);
        b = b.linearCombination(tz.negate());
        
        c = new Vector3D(position.x, position.y, position.z);
        c = c.linearCombination(tx);
        c = c.linearCombination(ty);
        c = c.linearCombination(tz.negate());
        
        d = new Vector3D(position.x, position.y, position.z);
        d = d.linearCombination(tx);
        d = d.linearCombination(ty.negate());
        d = d.linearCombination(tz.negate());
        
        e = new Vector3D(position.x, position.y, position.z);
        e = e.linearCombination(tx.negate());
        e = e.linearCombination(ty.negate());
        e = e.linearCombination(tz);
        
        f = new Vector3D(position.x, position.y, position.z);
        f = f.linearCombination(tx.negate());
        f = f.linearCombination(ty);
        f = f.linearCombination(tz);
        
        g = new Vector3D(position.x, position.y, position.z);
        g = g.linearCombination(tx);
        g = g.linearCombination(ty);
        g = g.linearCombination(tz);
        
        h = new Vector3D(position.x, position.y, position.z);
        h = h.linearCombination(tx);
        h = h.linearCombination(ty.negate());
        h = h.linearCombination(tz);
        
    }
    
    public void draw(Graphics2D g, Vector3D xAxis, Vector3D yAxis, Vector3D zAxis) {
        calculateEdges(xAxis, yAxis, zAxis);
        
        
    }

    @Override
    public String toString() {
        return "Cube3D{" + "position=" + position + ", a=" + a + ", b=" + b
                + ", c=" + c + ", d=" + d + ", e=" + e + ", f=" + f
                + ", g=" + g + ", h=" + h + ", size=" + size + '}';
    }
}
