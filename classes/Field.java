package classes;

/**
 * Diese Klasse repräsentiert das Feld indem ein neues Layout für ein
 * Stargate erstellt werden kann.
 * 
 * @author ruffy & Gothic
 */
public class Field {
    
    public static final int STANDARDCOLUMNS = 10;
    public static final int STANDARDROWS = 10;
    
    /**
     * Anzahl Spalten.
     */
    private int columns;
    
    /**
     * Anzahl Zeilen.
     */
    private int rows;
    
    /**
     * Alle Blöcke auf dem Feld.
     */
    private BlockElement blockElement[][];
    
    /**
     * Pixelgröße eines Blockes.
     */
    private int blockSize;

    /**
     * Erzeugt ein neues Feld mit der Standardgroesse.
     */
    public Field() {
        columns = STANDARDCOLUMNS;
        rows = STANDARDROWS;
        
        blockElement = new BlockElement[rows][columns];
    }

    /**
     * Neues Feld erzeugen mit einer gegebenen Breite und Höhe.
     * @param columns Anzahl Spalten.
     * @param rows Anzahl Zeilen.
     */
    public Field(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        
        blockElement =  new BlockElement[rows][columns];
    }

    /**
     * Setzt die Anzahl der Spalten neu.
     * @param columns Anzahl Spalten.
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * Gibt die Anzahl der Spalten zurück.
     * @return Anzahl Spalten.
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Setzt die Anzahl der Zeilen neu.
     * @param rows Anzahl Zeilen.
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Gibt die Anzahl der Reihen zurück.
     * @return Anzahl Zeilen.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Gibt einen Block an einer bestimmten Position zurück.
     * @param column Spaltenindex.
     * @param row Zeilenindex.
     * @return BlockElement.
     */
    public BlockElement getBlockElement(int column, int row) {
        return blockElement[row][column];
    }

    /**
     * Setzt ein Blockelement an einer bestimmten Position neu.
     * @param blockElement Das neue Blockelement.
     * @param column Spaltenindex.
     * @param row Zeilenindex.
     */
    public void setBlockElement(BlockElement blockElement,
            int column, int row) {
        this.blockElement[row][column] = blockElement;
    }

    /**
     * Gibt die Blockgröße zurück.
     * @return Blockgröße.
     */
    public int getBlockSize() {
        return blockSize;
    }

    /**
     * Setzt die Blockgröße neu.
     * @param blockSize Neue Blockgröße.
     */
    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }
    
    public void initBlocks() {
        blockElement = new BlockElement[rows][columns];
    }
}
