package first.client.mapmaker.areasections.firstareasection.areas;

import java.util.ArrayList;

public interface ObjectInTile {

    // Define methods that all objects in a tile must implement
    ArrayList<String> getObjectInfo();
    void removeObjectFromTile();
    void addObjectToTile(String tileName);
    void interactWithObject(String action);
    void setCurrentTile(Tile tile);
        //placeholder until I settle on a record for this
        //dependent on me finishing the game world coordinate system
    public String getObjectName();
    
}
