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

    private TreeMap<String, String> layer;

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

    public void setLayers(TreeMap<String, String> l) {
        layer = l;
    }

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

        String returnString = "# The name for this shape\n"
                            + "Name=" + gatename + "\n";
        returnString = returnString.concat("# Version 2 of shape files allows for many new things.\n"
                                         + "# 3D gates, new format for blocks, woosh and light order etc.\n");
        returnString = returnString.concat("Version=2\n\n");
        returnString = returnString.concat("# GateShape now needs 'Layer' lines\n"
                    + "# Each Layer requires a #number= and then a newline.\n"
                    + "# Blocks can only be placed into layers.\n"
                    + "# a 2D gate would have only 1 layer.\n"
                    + "# Acceptable blocks are:\n"
                    + "#    [I] = Ignored\n"
                    + "#    [S] = Stargate Material\n"
                    + "#    [P] = Air blocks that will turn into the portal material when activated.\n"
                    + "\n"
                    + "#    Extra parameters:\n"
                    + "#	--- These parameters are 1 of each per gate ---\n"
                    + "#    :N = Block where the name sign will be created. This is optional.\n"
                    + "#    :EP = Block where players teleport in at. The players feet will be on this block.\n"
                    + "#    :EM = Block where minecarts teleport in at. The minecart wheels will be on this block.\n"
                    + "#    :A = Block where the activation switch is attached to. 1 per gate!\n"
                    + "#			The only restriction is that the block that faces it must be 'I' (so nothing is in the way)\n"
                    + "#			The switch will face in the positive layer direction.\n"
                    + "#			In this example the switch will face towards where layer 3 would be (if there was a 3rd layer)\n"
                    + "#    :D = Block the sign dialer hangs from. Only 1 per gate!\n"
                    + "#			The only restriction is that the block that faces it must be 'I' (so nothing is in the way)\n"
                    + "#			This block is not required, so shapes with this block can be either type. (sign or dial)\n"
                    + "#			Without this block a gateshape can only be /dial gate.\n"
                    + "#    :IA = Iris Activation Switch - Not required unless you want to be able to place an Iris on the gate.\n"
                    + "#\n"
                    + "#    IA, D, N, and A cannot be the same block, and none of those can contain W\n"
                    + "#\n"
                    + "#	--- There can be many of these per gate -- (Currently no restriction)\n"
                    + "#    :L = Blocks that will light when gate is activated\n"
                    + "#		Optionally you may add a #number after L to indicate the order it lights.\n"
                    + "#		Defaults to 1 if there is no #\n"
                    + "#    :W = Blocks that will woosh when gate is activated\n"
                    + "#		Optionally you may add a #number after W to indicate the order it wooshes in.\n"
                    + "#		Defaults to 1 if there is no # and the wait between numbers is configurable below.\n"
                    + "#		After all #s are active it removes them in reverse order but\n"
                    + "#		if a block is [P:W]	the block will stay as portal material until gate is shutdown.\n"
                    + "#\n"
                    + "#    Redstone Blocks:\n"
                    + "#   --- There can only be 1 of each of these per gate, and they can-not occupy the same block as anything else ---\n"
                    + "#    [RD] = Redstone activation block. A redstone charge next to this block will activate the gate.\n"
                    + "#			This block requires a :D block for targetting. This block should be on top of a [S] block.\n"
                    + "#    [RS] = Redstone sign dialer cycle block. A redstone charge next to this block will cycle sign targets.\n"
                    + "#			This block requires a :D block for targetting. This block should be on top of a [S] block.\n"
                    + "#    [RA] = Redstone gate Activated block. This block will provide redstone charge when the gate is activated.\n"
                    + "#           This block should be on top of a [S] block.\n\n");

        returnString = returnString.concat("Gateshape=\n");
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
