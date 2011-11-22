/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stargate;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Christopher
 */
public class txtFileGenerator {

    private Color[][] farben;

    private int x;

    private int y;

    private TreeMap<String, String> layer_texte = new TreeMap<String, String>();

    public String writeFile(Color[][] f, int x, int y, String path, String layer) throws IOException {
        initGenerator(f, x, y);

        FileWriter fw = new FileWriter(path);
        String text = "";
        for(int j = 0; j < y; j++) {
            for(int i = 0; i < x; i++) {
                if(Color.BLUE.equals(farben[i][j])) {
                   text = text.concat("[P]");
                } else if(Color.RED.equals(farben[i][j])) {
                   text = text.concat("[S]");
                } else if(Color.WHITE.equals(farben[i][j])) {
                    text = text.concat("[I]");
                }
            }
            text = text.concat("\n");
            fw.write(text);
        }
        fw.flush();
        fw.close();
        layer_texte.put(layer, text);
        return text;
    }

    private void initGenerator(Color[][] f, int x, int y) {
        farben = f;
        this.x = x;
        this.y = y;
    }

    public String gibText() {
        String text = "";
        Set s = layer_texte.keySet();
        Iterator it = s.iterator();

        while(it.hasNext()) {
            String layer = (String)it.next();
            text = text.concat(layer + "=\n");
            text = text.concat(layer_texte.get(layer) + "\n\n");
        }
        return text;
    }


}
