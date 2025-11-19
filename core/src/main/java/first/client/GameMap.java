package first.client;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.badlogic.gdx.assets.AssetManager;

import first.client.mapmaker.areasections.firstareasection.FirstAreasInGame;
import first.client.mapmaker.areasections.firstareasection.areas.AreaSection;
import first.client.mapmaker.areasections.firstareasection.areas.Chunk;
import first.client.mapmaker.areasections.firstareasection.areas.Tile;
import first.client.menus.GameContextMenu;
import first.client.menus.PlainWalkMenu;

public class GameMap {
    //this class will handle the game map   
    //it will manage the backend for the tiles, entities, and other elements on the map
    private static String chunkOne = "chunk1";
    private static String chunkTwo = "chunk2";
    private static String chunkThree = "chunk3";
    private static String chunkFour = "chunk4";
    private static String chunkFive = "chunk5";
    private static String chunkSix = "chunk6";
    private static String chunkSeven = "chunk7";  
    private static String chunkEight = "chunk8";
    private static String chunkNine = "chunk9";
    private  String areaOne = "area1";
    private  String areaTwo = "area2";
    private  String areaThree = "area3";
    private  String areaFour = "area4";
    private  String areaFive = "area5";
    private  String areaSix = "area6";
    private  String areaSeven = "area7";
    private  String areaEight = "area8";
    private  String areaNine = "area9";


   
    AreaSection currentAreaSection;
    
   
    private String currentAreaSectionName;
    private HashMap<String, AreaSection> loadedAreaSections;
    
    
   
    private PlainWalkMenu walkMenu;
    
    
    
    



    public GameMap() {
        // Constructor logic here
        //for first loading the map when a character is created
        //after that, the map will be updated based on player position
        
    }

    public GameMap(FirstAreasInGame areaSectionName) {
        //for loading the map from a file or generating it
        //this will be used for loading a character that already exists

        //next goal is to properly initialize the game map from the game client class

        //now that the getTile method is implemented, I need to properly initialize the game map or I will get null pointer exceptions


        //It looks like I need to properly implement the FirstAreasInGame enum to manage area sections

        //there only really needs to be a couple objects of AreaSection in the game client at any time

        this.currentAreaSectionName = FirstAreasInGame.getAreaSection(areaSectionName);
        this.loadedAreaSections = new HashMap<>();
        this.walkMenu = new PlainWalkMenu();
    }

   

    public static List<String> getAllChunkNames() {
        return List.of(chunkOne, chunkTwo, chunkThree, chunkFour, chunkFive,
                       chunkSix, chunkSeven, chunkEight, chunkNine);
    }

    public void setCurrentAreaSectionName(FirstAreasInGame areaSectionName) {
        this.currentAreaSectionName = FirstAreasInGame.getAreaSection(areaSectionName);
    }

    public void changeCurrentAreaSection(FirstAreasInGame newAreaSectionName, AssetManager assets, String areaEnum, String areaName) {
        setCurrentAreaSectionName(newAreaSectionName);
        initalizeAreaSectionValue(assets, areaEnum, areaName);
    }




    public void initalizeAreaSectionValue(AssetManager assets, String areaEnum, String areaSectionName) {
        //for loading area sections of the map
        //this will help in managing large maps by breaking them into sections
        //this is where an object of that "library" is initialized





            //this chain of initializations is necessary to properly set up the area section

        this.currentAreaSection = new AreaSection(areaSectionName);
        currentAreaSection.determineAreaAssets(areaEnum);
            //it specifically needs the area enum to properly set up the area assets
            //setAreaOne is not working because the enum is not properly working yet

        
        //I just need to iterate through these method calls to properly set up the area section
        //and bug fix it
        List<String> chunkNames = getAllChunkNames();
        currentAreaSection.setAreaOne(chunkNames, areaOne, currentAreaSectionName, assets);
        
            //the other areas will be set up similarly later on
            //but they are not actually created yet
        currentAreaSection.setCurrentArea(currentAreaSection.getAreaOne());
        loadedAreaSections.put(this.currentAreaSectionName, currentAreaSection);
    }




    public void updateMap(float playerX, float playerY, float playerZ) {
        //for updating the visible map area based on player position
        //and for loading/unloading map sections as needed
        //for data handling


    }

    public void activateContextMenuOption() {
        //for interacting with map elements
        //e.g., picking up items, interacting with NPCs, etc.
        //also for moving
    }


    private void getMovementPath() {
        //pathfinding logic will go here
    }




    public ArrayList<String> getHoverContextMenuAt(float x, float y, float z) {
        Tile closestTile = getClosestTileRecord(x, z);

        walkMenu.setTileRecord(closestTile);
        ArrayList<String> contextMenuOptions = walkMenu.getTileRecord();
        System.out.println("Tile Record: " + contextMenuOptions);
        //I now need to update the context menu options based on the objects in the tile
        //this will involve checking the objects and adding relevant options to the menu
        //for example, if there is an NPC, add "Talk to NPC"
        //if there is an item, add "Pick up item"
        //if the tile is walkable, add "Walk here"




        //this method is in progress,
        //it will eventually handle more complex interactions and context menu options
        //so it is better to design it well the first time around

        return contextMenuOptions;
    }

    public GameContextMenu getRightClickContextMenuAt(float x, float y, float z) {
        //this method will return the appropriate context menu based on the tile the player clicked on
        return null; // Placeholder return value
    }

    private Tile getClosestTileRecord(float x, float z) {

        Chunk closestChunk = getClosestChunk(x, z);
        Tile targetTile = closestChunk.getClosestTile(x, z);
                                    //this method will call a stream
        
        //this is where I need to logic through getting the closest tile to the given coordinates
        //I will finally make use of the "tiles" library I made and the data structures it provides
        //this will output what the player will see of that outside graphics



        //this is a placeholder method

        //I still need to do the math on loading and rendering tiles based on camera position
        //also on reading the json files for the tiles

        //this method will tap into records that store tile information


        //this method will return the record of the tile closest to the mouse cursor
        //it will use screen coordinates to determine which tile is closest
        //and return the appropriate tile record
        return targetTile;
    }

    private Chunk getClosestChunk(float x, float z) {
        //this method is the next to be worked upon
        
                                        //this method will call a stream
    
        //this method will return the closest chunk to the given coordinates
        //it will use screen coordinates to determine which chunk is closest
        //and return the appropriate chunk
        return currentAreaSection.getCurrentArea().getClosestChunk(x, z);
    }





}
