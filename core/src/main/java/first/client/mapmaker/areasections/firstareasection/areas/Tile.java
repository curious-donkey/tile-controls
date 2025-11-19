package first.client.mapmaker.areasections.firstareasection.areas;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Vector3;

public class Tile {

    private String tileName;
    private final Node tilePosition;
    private final String chunkName;
    private TileCoordinatesInChunk tileCoordinates;
    private List<ObjectInTile> objectsInTile;
    private TileToWorldCoordinates worldCoordinates;
    private TileWithinChunkCoordinates tileWithinChunkCoordinates;
    
    
   
    public Tile(String tileName, Node tilePosition, String chunkName) {
        this.tileName = tileName;
        this.tilePosition = tilePosition;
        this.chunkName = chunkName;
        this.tileCoordinates = new TileCoordinatesInChunk(tilePosition);
        this.objectsInTile = new ArrayList<>();
        
    }

    public ArrayList<String> checkObjectsInTile() {
        ArrayList<String> namesOfObjectsInTile = new ArrayList<>();
        for (ObjectInTile object : objectsInTile) {
            String objectName = object.getObjectName();
            namesOfObjectsInTile.add(objectName);
        }

        //method to check and update objects in the tile
        //this method will be called whenever the tile is referenced for stuff like "getContextMenuOptions"
        //also for collision detection and pathfinding
        //this method will call a stream of objects in the tile
        return namesOfObjectsInTile;
    }

    public TileToWorldCoordinates addObjectToTile(ObjectInTile objectInTile) {
        this.objectsInTile.add(objectInTile);
        objectInTile.setCurrentTile(this);
        objectInTile.addObjectToTile(this.tileName);
        return worldCoordinates;
    }

   public void removeObjectFromTile(ObjectInTile objectInTile) {
       this.objectsInTile.remove(objectInTile);
   }

   public void setTileWithinChunkCoordinates(TileWithinChunkCoordinates tileWithinChunkCoordinates) {
       this.tileWithinChunkCoordinates = tileWithinChunkCoordinates;
   }
   public TileWithinChunkCoordinates getTileWithinChunkCoordinates() {
        return tileWithinChunkCoordinates;
    }

    public TileToWorldCoordinates getWorldCoordinates() {
        return worldCoordinates;
    }

    public void applyTransformToWorldCoordinates(Vector3 transformVector) {

        this.worldCoordinates = new TileToWorldCoordinates(
            tileCoordinates.getX() + transformVector.x,
            tileCoordinates.getY() + transformVector.y,
            tileCoordinates.getZ() + transformVector.z
        );
    }

   



    public String getTileName() {
        return tileName;
    }

    public void setTileName() {
        this.tileName = tilePosition.id;
    }

    public Node getTilePosition() {
        return tilePosition;
    }

   

    public String getChunkName() {
        return chunkName;
    }

    public void setTileCoordinates(TileCoordinatesInChunk tileCoordinates) {
        this.tileCoordinates = tileCoordinates;
    }
    public TileCoordinatesInChunk getTileCoordinates() {
        return tileCoordinates;
    }
    
    public void walkOnTile() {
        //method for when a character walks on the tile
        //this will trigger any events or actions associated with the tile

        //will need to check for impassable objects on the tile

    }


   
}
