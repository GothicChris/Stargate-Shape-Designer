/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stargate;

import java.util.TreeMap;

/**
 *
 * @author Christopher
 */
public class Settings {
    
    private String gatename = "";

    private String portal_material = "STATIONARY_WATER";

    private static String PORTALMATERIAL[] = new String[] {
                                            "STATIONARY_WATER",
                                            "STATIONARY_LAVA",
                                            "PORTAL",
                                            "AIR" };

    private String iris_material = "STONE";

    private static String IRISMATERIAL[] = new String[] {
                                            "STONE",
                                            "DIAMOND_BLOCK",
                                            "GLASS",
                                            "IRON_BLOCK",
                                            "BEDROCK",
                                            "OBSIDIAN",
                                            "GLOWSTONE",
                                            "LAPIS_BLOCK" };

    private String stargate_material = "OBSIDIAN";

    private static String STARGATEMATERIAL[] = new String[] {
                                                "STONE",
                                                "DIAMOND_BLOCK",
                                                "GLASS",
                                                "IRON_BLOCK",
                                                "BEDROCK",
                                                "OBSIDIAN",
                                                "GLOWSTONE",
                                                "LAPIS_BLOCK" };

    private String active_material = "GLOWSTONE";

    private static String ACTIVEMATERIAL[] = new String[] {
                                            "GLOWSTONE",
                                            "GLOWING_REDSTONE_ORE" };

    private boolean is_redstone = false;

    private int woosh_ticks = 3;

    private int light_ticks = 2;

//    private TreeMap<String, String> layer = new TreeMap<String, String>();

    public void setGateName(String s) {
        gatename = s;
    }

    public void setPortalMaterial(int i) {
        portal_material = PORTALMATERIAL[i];    
    }

    public void setIrisMaterial(int i) {
        iris_material = IRISMATERIAL[i];
    }

    public void setStargateMaterial(int i) {
        stargate_material = STARGATEMATERIAL[i];
    }

    public void setActiveMaterial(int i) {
        active_material = ACTIVEMATERIAL[i];
    }

    public void setRedstone(boolean b) {
        is_redstone = b;
    }

    public void setWooshTicks(int i) {
        woosh_ticks = i;
    }

    public void setLightTicks(int i) {
        light_ticks = i;
    }

//    public void setLayers(TreeMap<String, String> l) {
//        layer = l;
//    }

    public String getActive_material() {
        return active_material;
    }

    public String getGatename() {
        return gatename;
    }

    public String getIris_material() {
        return iris_material;
    }

    public int getLight_ticks() {
        return light_ticks;
    }

    public String getPortal_material() {
        return portal_material;
    }

    public String getStargate_material() {
        return stargate_material;
    }

    public int getWoosh_ticks() {
        return woosh_ticks;
    }

    public boolean isIs_redstone() {
        return is_redstone;
    }

    /**
     * Setzt alle Optionen eines Stargates.
     * @param gn Gatename.
     * @param pm Portal Material.
     * @param im Iris Material.
     * @param sm Stargate Material.
     * @param am Active Material.
     * @param r Redstone aktivierbar.
     * @param wt Woosh Ticks.
     * @param lt Light Ticks.
     */
    public void setOptions(String gn, int pm, int im, int sm,
                           int am, boolean r, int wt, int lt) {
        setGateName(gn);
        setPortalMaterial(pm);
        setIrisMaterial(im);
        setStargateMaterial(sm);
        setActiveMaterial(am);
        setRedstone(r);
        setWooshTicks(wt);
        setLightTicks(lt);
    }

    /**
     * Gibt einen Einstellungstext zurück, in der Form für eine Stargate Shape
     * Datei.
     * @return Einstellungstext einer Stargate Shape Datei.
     */
    @Override
    public String toString() {

        String returnString = "Name=" + gatename + "\n";
        returnString = returnString.concat("Version=2\n\n");
        returnString = returnString.concat("WOOSH_TICKS=" + woosh_ticks + "\n");
        returnString = returnString.concat("LIGHT_TICKS=" + light_ticks + "\n");
        returnString = returnString.concat("PORTAL_MATERIAL=" + portal_material + "\n");
        returnString = returnString.concat("IRIS_MATERIAL=" + iris_material + "\n");
        returnString = returnString.concat("STARGATE_MATERIAL=" + stargate_material + "\n");
        returnString = returnString.concat("ACTIVE_MATERIAL=" + active_material + "\n");
        if(is_redstone) {
            returnString = returnString.concat("REDSTONE_ACTIVATED=TRUE\n");
        } else {
            returnString = returnString.concat("REDSTONE_ACTIVATED=FALSE\n");
        }
        
        return returnString;
    }

}
