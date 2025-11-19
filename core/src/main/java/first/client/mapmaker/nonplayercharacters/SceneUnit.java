package first.client.mapmaker.nonplayercharacters;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g3d.ModelInstance;

import first.client.mapmaker.areasections.firstareasection.areas.ObjectInTile;
import first.client.mapmaker.areasections.firstareasection.areas.Tile;

public class SceneUnit implements ObjectInTile {


    private String name;
    private int[][] chunkPosition;
    private int[][] tilePosition;
    private final ModelInstance modelInstance;

    SceneUnit(String name, int[][] chunkPosition, int[][] tilePosition, ModelInstance modelInstance) {
        this.name = name;
        this.chunkPosition = chunkPosition;
        this.tilePosition = tilePosition;
        this.modelInstance = modelInstance;
    }

    
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[][] getChunkPosition() {
        return chunkPosition;
    }

    
    public void setChunkPosition(int[][] chunkPosition) {
        this.chunkPosition = chunkPosition;
    }

    public int[][] getTilePosition() {
        return tilePosition;
    }

    public void setTilePosition(int[][] tilePosition) {
        this.tilePosition = tilePosition;
    }

    public ModelInstance getModelInstance() {
        return modelInstance;
    }

    @Override
    public ArrayList getObjectInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getObjectInfo'");
    }

    @Override
    public void removeObjectFromTile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeObjectFromTile'");
    }

    @Override
    public void addObjectToTile(String tileName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addObjectToTile'");
    }

    @Override
    public void interactWithObject(String action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interactWithObject'");
    }

    @Override
    public void setCurrentTile(Tile tile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCurrentTile'");
    }




    @Override
    public String getObjectName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getObjectName'");
    }

    

}
