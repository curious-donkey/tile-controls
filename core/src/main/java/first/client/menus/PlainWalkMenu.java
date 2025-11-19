package first.client.menus;

import java.util.ArrayList;

import first.client.mapmaker.areasections.firstareasection.areas.Tile;

public class PlainWalkMenu {


    ArrayList<String> tileRecord;

    

    //this class will handle the plain walk context menu
    //it will be used when the player right clicks on a plain walkable tile
    //it will provide options for walking to the tile, examining the tile, etc.

    public void setTileRecord(Tile tileToCheck) {
        this.tileRecord = tileToCheck.checkObjectsInTile();
    }

    public ArrayList<String> getTileRecord() {
        return tileRecord;
    }


    public GameContextMenu getMenuOptions() {
        //this method will return the menu options for the plain walk context menu
        //it will return a list of options that the player can choose from
        //e.g., "Walk here", "Examine", etc.
        return null; // Placeholder return value
    }


}
