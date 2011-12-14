/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.vector;


/**
 *
 * @author RRD
 */
public class Vector3D {
    
    public double x;
    public double y;
    public double z;
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
         Vector3D vector1 = new Vector3D(1.0, 0.0, 0.0);
         Vector3D vector2 = new Vector3D(0.0, 1.0, 0.0);
         
         System.out.println(Vector3D.crossProduct(vector1, vector2));
         System.out.println(Vector3D.crossProduct(vector2, vector1));
         
         vector1.normalize();
         vector2.normalize();
         
         
         System.out.println(vector2.length());
         System.out.println(vector1.length());
    }
    
    /**
     * Creates a new new vector with the standard dimensions size of 3. All
     * coordinates are initialized with 0.0.
     */
    public Vector3D() {
        
        initCoordinates();
    }

    /**
     * 
     * @param x
     * @param y
     * @param z 
     */
    public Vector3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 
     * @param x
     * @param y
     * @param z 
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * 
     */
    private void initCoordinates() {
        
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }
    
    /**
     * 
     * @param summand 
     */
    public Vector3D linearCombination(Vector3D summand) {
        
        if(summand != null) {
            this.x += summand.x;
            this.y += summand.y;
            this.z += summand.z;
        }
        return new Vector3D(x + summand.x, y + summand.y, z + summand.z);
    }
    
    /**
     * 
     * @param scalar 
     */
    public Vector3D scalarMultiplication(double scalar) {
        
        return new Vector3D(x * scalar, y * scalar, z * scalar);
    }
    
    /**
     * 
     * @param coefficient
     * @return 
     */
    public double scalarProduct(Vector3D coefficient) {
        
        double sum = 0;
        
        sum += (this.x * coefficient.x);
        sum += (this.y * coefficient.y);
        sum += (this.z * coefficient.z);
        
        return Math.cbrt(sum);
    }
    
    /**
     * 
     * @return 
     */
    public double length() {
        
        double sum = 0;
        
        sum += (this.x * this.x);
        sum += (this.y * this.y);
        sum += (this.z * this.z);
        
        return Math.sqrt(sum);
    }
    
    /**
     * 
     * @param vector
     * @return
     * @throws WrongDimensionsException 
     */
    public static Vector3D crossProduct(Vector3D vector1, Vector3D vector2) {

        return new Vector3D(vector1.y * vector2.z - vector1.z * vector2.y,
                vector1.z * vector2.x - vector1.x * vector2.z,
                vector1.x * vector2.y - vector1.y * vector2.x);
    }

    /**
     * 
     */
    public void normalize() {
        
        scalarMultiplication(1.0 / length());
    }
    
    /**
     * 
     * @param scalar 
     */
    public void scale(double scalar) {
        
        normalize();
        x *= scalar;
        y *= scalar;
        z *= scalar;
    }
    
    /**
     * 
     * @param vector
     * @return 
     */
    public double distanceTo(Vector3D vector) {
        
        return (vector == null)
                ? -1.0
                : this.linearCombination(vector.negate()).length();
    }
    
    public Vector3D negate() {
        
        return scalarMultiplication(-1.0);
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
