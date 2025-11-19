package first.client.mapmaker.areasections.firstareasection.areas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.badlogic.gdx.math.Vector3;

public class Chunk {

    private String chunkName;
    private String areaName;
    private String sectionName;
    
    
    private ArrayList<ObjectInTile> otherObjectsInChunk;

    private ArrayList<Tile> tilesThatAreNotActuallyTiles;
    private ArrayList<Tile> tilesThatAreActuallyTiles;
    private ArrayList<Tile> tilesInChunk;
    private Tile[][] tileGrid;
    private ChunkPositionInArea chunkPositionInArea;
    private ArrayList<Tile> topLevelTilesInChunk;
    private Vector3 chunkWorldCoordinates;
    private Float translateXVal;
    private Float translateYVal;
    private Float translateZVal;

    private HashMap<String, Object> nonTileAssetsInChunk;

    public Chunk(String chunkName, String areaName, String sectionName) {
        this.chunkName = chunkName;
        this.areaName = areaName;
        this.sectionName = sectionName;
        this.tilesThatAreActuallyTiles = new ArrayList<>();
        this.tilesThatAreNotActuallyTiles = new ArrayList<>();
        this.topLevelTilesInChunk = new ArrayList<>();
    }

    public void setTilesInChunk(ArrayList<Tile> tilesInChunk) {
        this.tilesInChunk = tilesInChunk;
        for (Tile tile : tilesInChunk) {
            setTileGrid(tile);
        }
        setOtherObjectsInChunk(tilesThatAreNotActuallyTiles);
        Tile[][] topTileLayer = setTopTileLayer();
        setTileGrid(topTileLayer);
    }

    public Tile getClosestTile(float x, float z) {

        HashMap<String, Float> distanceMap = new HashMap<>();

        for (Tile tile : topLevelTilesInChunk) {
            float dx = tile.getTileCoordinates().getX() - x;
            float dz = tile.getTileCoordinates().getZ() - z;
            float distance = (float) Math.sqrt(dx * dx + dz * dz);
            distanceMap.put(tile.getTileName(), distance);
        }

        Float minDistance = distanceMap.values().stream().min(Float::compare).orElse(Float.MAX_VALUE);

        String closestTileName = distanceMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(minDistance))
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse(null);

        
        return topLevelTilesInChunk.stream()
                .filter(tile -> tile.getTileName().equals(closestTileName))
                .findFirst()
                .orElse(null);
    }

    





    private void setTileGrid(Tile[][] topTileLayer) {
        this.tileGrid = topTileLayer;
    }

    public Tile[][] getTopTileLayerTileGrid() {
        return this.tileGrid;
    }

    public void placeChunkAtCoordinates(Float translateXVal, Float translateYVal, Float translateZVal) {
        this.translateXVal = translateXVal;
        this.translateYVal = translateYVal;
        this.translateZVal = translateZVal;
    }

    private Tile[][] setTopTileLayer() {
        //method to set top tile layer
        //this will help in rendering and managing chunk contents
        for (Tile tile : tilesThatAreActuallyTiles) {
            
            //now, query to see if there is a tile with a duplicate x and z coordinate but higher y coordinate
            if (checkIfTileIsInTopLayer(tile) == true) {
                topLevelTilesInChunk.add(tile);
            }

            //determine if tile is in top layer
            //if so, add to topLevelTilesInChunk array
            //this will help in rendering and managing chunk contents
            
        }
        Tile[][] tileGrid = mapTileCoordinatesToGameCoordinatesInChunk(topLevelTilesInChunk);
        return tileGrid;
    }

    private boolean checkIfTileIsInTopLayer(Tile tile) {

        ArrayList<Tile> currentTopTileAtTilePosition = topLevelTilesInChunk.stream().filter(d -> d.getTileCoordinates().getX() == tile.getTileCoordinates().getX() &&
                                                     d.getTileCoordinates().getZ() == tile.getTileCoordinates().getZ()).collect(Collectors.toCollection(ArrayList::new));
        
        if (currentTopTileAtTilePosition.size() == 0) {
            return true;
        }
        else {
        float y = currentTopTileAtTilePosition.get(0).getTileCoordinates().getY();
        if (tile.getTileCoordinates().getY() >= y) {
            topLevelTilesInChunk.remove(currentTopTileAtTilePosition.get(0));
            return true;
        }
    }

        //method to check if tile is in top layer
        //this will help in rendering and managing chunk contents
        return false;
    }



    private void setTileGrid(Tile tile) {
        

        if (checkIfTileIsATile(tile) == true) {
            tilesThatAreActuallyTiles.add(tile);
            //method to set tile grid based on tiles in chunk
            //this will help in rendering and managing chunk contents
        }
        else {
            tilesThatAreNotActuallyTiles.add(tile);
        }
    }

    private void setOtherObjectsInChunk(ArrayList<Tile> tilesThatAreNotActuallyTiles) {
        //method to set other objects in chunk
        //this will help in rendering and managing chunk contents
        //this method will convert tiles that are not actually tiles into other objects in chunk
        //this method will create ObjectInTile instances for each tile that is not actually a tile
        //this method will feature extensive use of if statements to determine what type of object the tile is
        //then it will add each to the otherObjectsInChunk array for use via the stream API
    }

    private boolean  checkIfTileIsATile(Tile node) {
        String tileName = node.getTileName(); 
        if (tileName.contains("Hill_2x2x2_Color2") ) {
            //currently this only covers one type of tile
            //I can expand this to cover more types of tiles
            //this will help in rendering and managing chunk contents
            //I will need to make classes for different types of tiles later on
            
            return true;
        } else {
            return false;
        }
    }


    public Tile[][] mapTileCoordinatesToGameCoordinatesInChunk(ArrayList<Tile> topLevelTilesInChunk) {
        Tile [][] tileGrid = new Tile[16][18];
        int currentrow = 0;
        int currentcol = 0;
        ArrayList<Float> xValues = new ArrayList<>();
        ArrayList<Float> yValues = new ArrayList<>();
        for (Tile tile : topLevelTilesInChunk) {
            xValues.add(tile.getTileCoordinates().getX());
            yValues.add(tile.getTileCoordinates().getY());
        }
        while (currentrow < 16) {
           float thing = xValues.stream().min(Float::compare).get();
            //get min x or z value from row
           

            while (currentcol < 18) {
                //this is for sorting the tiles within a row
                float thing2 = yValues.stream().min(Float::compare).get();
                Tile tileAtPosition = topLevelTilesInChunk.stream().filter(d -> d.getTileCoordinates().getX() >= thing + 5 && d.getTileCoordinates().getX() <= thing - 5 && d.getTileCoordinates().getY() <= thing2 + 5 && d.getTileCoordinates().getY() >= thing2 - 5).findFirst().orElse(null);
                tileGrid[currentrow][currentcol] = tileAtPosition;
                yValues.remove(thing2);
                currentcol++;
        }        
            currentrow++;
    }

        //1) first I need to take the min x or z value -> which should return an array of tiles with the lowest x or z value
               //for practical purposes, I will take the min and then round and then grab tiles that are within that range

        //2) I will then assign positions within Tile[][] based on their x and z coordinates
            //I will need to use a sorting algorithm to sort the tiles based on their x and z coordinates
            //a) I will take the min of the second value and remove it from the list, then assign it to the next position in the array
            //b) I will repeat until I have filled the first row/column of the array
        
        //3) Then I can repeat for each x or z row/column until the entire grid is filled


        //method to map tile coordinates to world coordinates
        //this will help in rendering and managing chunk contents
        //the easiest solution I can think of is to use the streaming API to get the closest tile and then assign based on a couple of if statements
            //I need to get a better handle on grids and how to map them to world coordinates
            //this will help with the math later on and when I need to do pathfinding and other grid based calculations
            //I might also need to enum out the x and z coordinates for easier reference later on
        return tileGrid;
    }

    public void setChunkName(String chunkName) {
        this.chunkName = chunkName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }


    public String getChunkName() {
        return chunkName;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public Float getTranslateXVal() {
        return translateXVal;
    }

    public Float getTranslateYVal() {
        return translateYVal;
    }

    public Float getTranslateZVal() {
        return translateZVal;
    }

    public void setTranslateXVal(Float translateXVal) {
        this.translateXVal = translateXVal;
    }

    public void setTranslateYVal(Float translateYVal) {
        this.translateYVal = translateYVal;
    }

    public void setTranslateZVal(Float translateZVal) {
        this.translateZVal = translateZVal;
    }

    void setTranslationValues(float[] get) {
        this.translateXVal = get[0];
        this.translateYVal = get[1];
        this.translateZVal = get[2];
    }

    public void setChunkPositionInArea(ChunkPositionInArea chunkPositionInArea) {
        this.chunkPositionInArea = chunkPositionInArea;
    }

    public ChunkPositionInArea getChunkPositionInArea() {
        return chunkPositionInArea;
    }

    public void setTileTranslations() {
        float xTranslation = this.translateXVal;
        float yTranslation = this.translateYVal;
        float zTranslation = this.translateZVal;
        for (Tile tile : tilesInChunk) {
            tile.applyTransformToWorldCoordinates(new Vector3(xTranslation, yTranslation, zTranslation));
        }
    }







}
