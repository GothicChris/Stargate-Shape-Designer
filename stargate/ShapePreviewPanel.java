/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ShapePreviewPanel.java
 *
 * Created on 01.12.2011, 12:33:54
 */
package stargate;

import classes.AirBlock;
import classes.BlockElement;
import classes.Field;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author rrd
 */
public class ShapePreviewPanel extends javax.swing.JPanel {
    
    private Field[] field;
    
    private Point rechts;       /* x-achse nach rechts */
    private Point oben;         /* y-achse nach oben */
    private Point rechtsOben;   /* z-achse nach rechts-oben */

    /** Creates new form ShapePreviewPanel */
    public ShapePreviewPanel() {
        initComponents();
    }

    ShapePreviewPanel(Field[] field) {
        this.field = field;
    }

    public Field[] getField() {
        return field;
    }

    public void setField(Field[] field) {
        this.field = field;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);
        
        drawPreview(graphics);
    }
    
    private void drawPreview(Graphics2D graphics) {

        /*
         * Berechnung der Groesse der Blockelemente. Die Groesse ist abhaengig
         * von der Anzahl der Spalten und Zeilen und der jeweils verfuegbaren
         * Hoehe und Breite des Panels.
         */
        int heightBlockSize = this.getHeight() / Field.rows;
        int widthBlockSize = this.getWidth() / Field.columns;

        int blockSize = (heightBlockSize * Field.columns > this.getWidth())
                ? widthBlockSize : heightBlockSize;
        
        blockSize = blockSize * 200 / 300;
        
        calculateVektors(blockSize);
        
        if(field != null) {
            /*
             * TODO: Add Comment
             */
            for(int index = 0; index < field.length; index++) {
                
                Point layerFlow = new Point(blockSize * index, getHeight());
                
                /*
                 * TODO: Add Comment
                 */
                for(int rows = Field.rows - 1; rows >= 0; rows--) {
                    
                    Point rowFlow = new Point(layerFlow.x , layerFlow.y);
                    rowFlow.translate(oben.x * (Field.rows - 1 - rows), oben.y * (Field.rows - 1 - rows));
                    
                    /*
                     * TODO: Add Comment
                     */
                    for(int columns = Field.columns - 1; columns >= 0; columns--) {
                        
                        Point columnFlow = new Point(rowFlow.x, rowFlow.y);
                        columnFlow.translate(rechtsOben.x * columns, rechtsOben.y * columns);
                        
                        BlockElement currentBlock = field[index].getBlockElement(columns, rows);
                        
                        try {
                            AirBlock testBlock = (AirBlock) currentBlock;
                        } catch(ClassCastException ccE) {
                            drawCube(graphics, currentBlock.getColor(), columnFlow);
                        }
                    }
                }
            }
        }
    }
    
    private void drawCube(Graphics2D graphics, Color color, Point startPoint) {
        Polygon front = new Polygon();
        Polygon oberSeite = new Polygon();
        Polygon rechteSeite = new Polygon();
        
        /*
         * Front
         */
        Point a = new Point(startPoint);
        Point b = new Point(a.x + rechts.x, a.y + rechts.y);
        Point c = new Point(a.x + oben.x, a.y + oben.y);
        Point d = new Point(b.x + oben.x, b.y + oben.y);
        
        /*
         * Obere Seite
         */
        Point g = new Point(d.x + rechtsOben.x, d.y + rechtsOben.y);
        Point h = new Point(c.x + rechtsOben.x, c.y + rechtsOben.y);
        
        /*
         * Rechte Seite
         */
        Point f = new Point(b.x + rechtsOben.x, b.y + rechtsOben.y);
        
        front.addPoint(a.x, a.y);
        front.addPoint(b.x, b.y);
        front.addPoint(d.x, d.y);
        front.addPoint(c.x, c.y);
        
        oberSeite.addPoint(c.x, c.y);
        oberSeite.addPoint(d.x, d.y);
        oberSeite.addPoint(g.x, g.y);
        oberSeite.addPoint(h.x, h.y);
        
        rechteSeite.addPoint(d.x, d.y);
        rechteSeite.addPoint(b.x, b.y);
        rechteSeite.addPoint(f.x, f.y);
        rechteSeite.addPoint(g.x, g.y);
        
        graphics.setColor(color);
        graphics.fillPolygon(oberSeite);
        graphics.fillPolygon(rechteSeite);
        graphics.fillPolygon(front);
        
        graphics.setColor(Color.BLACK);
        graphics.drawPolygon(oberSeite);
        graphics.drawPolygon(rechteSeite);
        graphics.drawPolygon(front);
    }
    
    private void calculateVektors(int blockSize) {
        
        rechts = new Point(blockSize, 0);
        oben = new Point(0, -blockSize);
        rechtsOben = new Point( blockSize / 2, -blockSize / 2);
        
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
