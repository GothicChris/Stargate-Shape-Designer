/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.vector;

/**
 *
 * @author RRD
 */
public class Matrix {
    
    public final int STANDARDSIZE = 3;
    
    private int size;
    
    private double[][] values;

    public Matrix() {
        values = new double[STANDARDSIZE][STANDARDSIZE];
    }

    public Matrix(double[][] values) {
        
        if(values != null && values.length >= 1
                && values.length == values[0].length) {
            size = values.length;
            this.values = values;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public Matrix(int size) {
        
        this.size = size;
        
        if(size <= 0) {
            throw new IllegalArgumentException("Size \""
                    + size
                    + "\" not allowed");
        } else {
            values = new double[size][size];
        }
    }
    
    public Double getDeterminant() {
        
        Double determinant = null;
        
        Matrix submatrix = null;
            
        if(size == 1) {

            determinant = values[0][0];
        } else {

            determinant = 0.0;

            for(int columns = 0;
                    columns < size;
                    columns++) {
            
                submatrix = getSubmatrix(this, columns);
                
                determinant += (((columns % 2 == 0) ? 1 : -1)
                        * values[0][columns]
                        * submatrix.getDeterminant());
            }
        }
        
        return determinant;
    }

    private Matrix getSubmatrix(Matrix matrix, int currentLine) {
        
        Matrix subMatrix = new Matrix(matrix.size - 1);
        
        for(int rows = 0; rows < subMatrix.size; rows++) {
            for(int columns = 0; columns < subMatrix.size; columns++) {
                subMatrix.setValue(rows, columns,
                        matrix.getValue(rows + 1, (columns >= currentLine)
                        ? columns + 1 : columns));
            }
        }
        
        return subMatrix;
    }

    public double getValue(int x, int y) {
        return values[x][y];
    }

    public void setValue(int x, int y, double value) {
        this.values[x][y] = value;
    }

    @Override
    public String toString() {
        
        String returnString = "";
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                returnString += (values[i][j] + ", ");
            }
            returnString += "\n";
        }
        
        return returnString;
    }
}
