/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FieldPanel.java
 *
 * Created on 20.11.2011, 10:29:44
 */

package stargate;

import classes.AirBlock;
import classes.BlockElement;
import classes.Field;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Christopher
 */
public class FieldPanel extends javax.swing.JPanel {

    /** Creates new form FieldPanel */
    public FieldPanel() {
        initComponents();
        field = new Field();
        initFieldElements();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);

        /*
         * Berechnung der Groesse der Blockelemente. Die Groesse ist abhaengig
         * von der Anzahl der Spalten und Zeilen und der jeweils verfuegbaren
         * Hoehe und Breite des Panels.
         */
        int heightBlockSize = this.getHeight() / field.getRows();
        int widthBlockSize = this.getWidth() / field.getColumns();

        int blockSize = (heightBlockSize * field.getColumns() > getWidth())
                ? widthBlockSize : heightBlockSize;

        setBlocksize(blockSize);

        Point startPoint = new Point(0, 0);


        for(int i = 0; i < field.getRows(); i++) {

            startPoint.x = 0;

            for(int j = 0; j < field.getColumns(); j++) {
                BlockElement block = field.getBlockElement(j, i);
                graphics.setColor(block.getColor());
                graphics.fillRect(startPoint.x, startPoint.y,
                        blockSize, blockSize);
                graphics.setColor(block.getBorderColor());
                graphics.drawRect(startPoint.x, startPoint.y,
                        blockSize, blockSize);


                startPoint.x += blockSize;
            }

            startPoint.y += blockSize;
        }
    }

    public void initFieldElements(int columns, int rows) {
        field.setRows(rows);
        field.setColumns(columns);
        field.initBlocks();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                field.setBlockElement(new AirBlock(), j, i);
            }
        }
        repaint();
    }

    private void initFieldElements() {
        initFieldElements(Field.STANDARDCOLUMNS, Field.STANDARDROWS);
    }


    private Field field;
    private int blocksize;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void setBlocksize(int blocksize) {
        this.blocksize = blocksize;
    }

    public int getBlocksize() {
        return blocksize;
    }
    
    public void setBlockElement(BlockElement blockelement, int column, int row) {
        field.setBlockElement(blockelement, column, row);
        repaint();
    }

    public BlockElement getBlockElement(int column, int row) {
        return field.getBlockElement(column, row);
    }

    public void setBlockElementBorderColor() {
        
    }
}
