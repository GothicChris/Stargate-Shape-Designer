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
    public static int columns = STANDARDCOLUMNS;
    
    /**
     * Anzahl Zeilen.
     */
    public static int rows = STANDARDROWS;
    
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
        
        blockElement = new BlockElement[rows][columns];     
    }


    /**
     * Setzt die Anzahl der Spalten neu.
     * @param columns Anzahl Spalten.
     */
    public static void setColumns(int columns) {
        Field.columns = columns;
    }

    /**
     * Gibt die Anzahl der Spalten zurück.
     * @return Anzahl Spalten.
     */
    public static int getColumns() {
        return columns;
    }

    /**
     * Setzt die Anzahl der Zeilen neu.
     * @param rows Anzahl Zeilen.
     */
    public static void setRows(int rows) {
        Field.rows = rows;
    }

    /**
     * Gibt die Anzahl der Reihen zurück.
     * @return Anzahl Zeilen.
     */
    public static int getRows() {
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

    @Override
    public String toString() {
        String returnString = "";
        for(int y = 0; y < rows; y++) {
            for(int x = 0; x < columns; x++) {
                returnString = returnString.concat(blockElement[y][x].toString());
            }
            returnString = returnString.concat("\n");
        }
        
        return returnString;
    }
    
    
}
