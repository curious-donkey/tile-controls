package first.client.mapmaker.areasections.firstareasection.areas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.EIGHTH_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.FIFTH_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.FIRST_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.FOURTH_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.SECOND_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.SEVENTH_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.SIXTH_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.SPAWN_POINT;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.THIRD_LEVEL;

public class AreaSection {

    private final String sectionName;
    @SuppressWarnings("FieldMayBeFinal")
    private Array<Area> areasInSection;

    private Area areaOne;
    private Area areaTwo;
    private Area areaThree;
    private Area areaFour;
    private Area areaFive;
    private Area areaSix;
    private Area areaSeven;
    private Area areaEight;
    private Area areaNine;

    private String chunkOnePath;
    private String chunkTwoPath;
    private String chunkThreePath;
    private String chunkFourPath; 
    private String chunkFivePath;
    private String chunkSixPath;
    private String chunkSevenPath;
    private String chunkEightPath;
    private String chunkNinePath;
    private String areaEnum;

    public Area currentArea;

    private Vector3 position;
    
    private HashMap<String, Object> nonTileAssetsInAreaSection;




    public AreaSection(String sectionName) {
        this.sectionName = sectionName;
    }

    public Area getCurrentArea() {
        return currentArea;
    }
    public void setCurrentArea(Area currentArea) {
        this.currentArea = currentArea;
    }

    public String getSectionName() {
        return sectionName;
    }

   
    public Array<Area> getAreasInSection() {
        return areasInSection;
    }
    public void setPosition(Vector3 position) {
        //method to set position of area section
        //this will help in positioning the entire section in the game world
    }

    public Vector3 getPosition() {
        return position;
    }

    private static ArrayList<Tile> getMapNodes(FileHandle file, AssetManager assetManager) {
       //method to get map nodes from loaded assets
       //this will help in positioning and rendering map chunks
       ArrayList<Tile> mapNodes = new ArrayList<>();

       // Get the loaded model from the asset manager
       Model model = assetManager.get(file.path(), Model.class);
       if (model != null) {
           // Iterate through the nodes of the model and add them to the mapNodes array
           for (Node node : model.nodes) {
                Tile nodeData = new Tile(node.id, node, file.nameWithoutExtension());
               mapNodes.add(nodeData);
           }
       }

       return mapNodes;
    }

    public void determineAreaAssets(String areaEnum) {
        //method to determine area assets
        //this will help in loading the correct assets for each area
        this.areaEnum = areaEnum;
        switch (areaEnum) {
            case "Spawn Area" -> {
                this.chunkOnePath = SpawnArea.getBlockAssets(SPAWN_POINT);
                this.chunkTwoPath = SpawnArea.getBlockAssets(FIRST_LEVEL);
                this.chunkThreePath = SpawnArea.getBlockAssets(SECOND_LEVEL);
                this.chunkFourPath = SpawnArea.getBlockAssets(THIRD_LEVEL);
                this.chunkFivePath = SpawnArea.getBlockAssets(FOURTH_LEVEL);
                this.chunkSixPath = SpawnArea.getBlockAssets(FIFTH_LEVEL);
                this.chunkSevenPath = SpawnArea.getBlockAssets(SIXTH_LEVEL);
                this.chunkEightPath = SpawnArea.getBlockAssets(SEVENTH_LEVEL);
                this.chunkNinePath = SpawnArea.getBlockAssets(EIGHTH_LEVEL);
            }
            default -> {
                this.chunkOnePath = "";
                this.chunkTwoPath = "";
                this.chunkThreePath = "";
                this.chunkFourPath = "";
                this.chunkFivePath = "";
                this.chunkSixPath = "";
                this.chunkSevenPath = "";
                this.chunkEightPath = "";
                this.chunkNinePath = "";
            }
        }
        // Add cases for other areas as needed
        // Default paths or error handling
    }



    public ArrayList<ArrayList<Tile>> getAllMapNodes(AssetManager assets) {
        ArrayList<ArrayList<Tile>> allMapNodes = new ArrayList<>();
        //render activation of this method abstract so I can utilize my enums as this will save a lot of work later on
        //this is for forming a group of chunks and tiles which make up an area
        determineAreaAssets(areaEnum);

        ArrayList<Tile> blockOneNodes = getMapNodes(Gdx.files.internal(chunkOnePath), assets);
		ArrayList<Tile> blockTwoNodes = getMapNodes(Gdx.files.internal(chunkTwoPath), assets);
		ArrayList<Tile> blockThreeNodes = getMapNodes(Gdx.files.internal(chunkThreePath), assets);
		ArrayList<Tile> blockFourNodes = getMapNodes(Gdx.files.internal(chunkFourPath), assets);
		ArrayList<Tile> blockFiveNodes = getMapNodes(Gdx.files.internal(chunkFivePath), assets);
		ArrayList<Tile> blockSixNodes = getMapNodes(Gdx.files.internal(chunkSixPath), assets);
		ArrayList<Tile> blockSevenNodes = getMapNodes(Gdx.files.internal(chunkSevenPath), assets);
		ArrayList<Tile> blockEightNodes = getMapNodes(Gdx.files.internal(chunkEightPath), assets);
		ArrayList<Tile> blockNineNodes = getMapNodes(Gdx.files.internal(chunkNinePath), assets);

        allMapNodes.add(blockOneNodes);
        allMapNodes.add(blockTwoNodes);
        allMapNodes.add(blockThreeNodes);
        allMapNodes.add(blockFourNodes);
        allMapNodes.add(blockFiveNodes);
        allMapNodes.add(blockSixNodes);
        allMapNodes.add(blockSevenNodes);
        allMapNodes.add(blockEightNodes);
        allMapNodes.add(blockNineNodes);


        return allMapNodes;    
    }

    public static Area getArea(List<String> chunkNames, String areaName, String sectionName, ArrayList<ArrayList<Tile>> allMapNodes) {
        //method to get area by name
        //this will help in loading specific areas in the game
        Chunk chunk1 = Area.generateChunks(chunkNames.get(0), areaName, sectionName);
        chunk1.setTilesInChunk(allMapNodes.get(0));
        Chunk chunk2 = Area.generateChunks(chunkNames.get(1), areaName, sectionName);
        chunk2.setTilesInChunk(allMapNodes.get(1));
        Chunk chunk3 = Area.generateChunks(chunkNames.get(2), areaName, sectionName);
        chunk3.setTilesInChunk(allMapNodes.get(2));
        Chunk chunk4 = Area.generateChunks(chunkNames.get(3), areaName, sectionName);
        chunk4.setTilesInChunk(allMapNodes.get(3));
        Chunk chunk5 = Area.generateChunks(chunkNames.get(4), areaName, sectionName);
        chunk5.setTilesInChunk(allMapNodes.get(4));
        Chunk chunk6 = Area.generateChunks(chunkNames.get(5), areaName, sectionName);
        chunk6.setTilesInChunk(allMapNodes.get(5));
        Chunk chunk7 = Area.generateChunks(chunkNames.get(6), areaName, sectionName);
        chunk7.setTilesInChunk(allMapNodes.get(6));
        Chunk chunk8 = Area.generateChunks(chunkNames.get(7), areaName, sectionName);
        chunk8.setTilesInChunk(allMapNodes.get(7));
        Chunk chunk9 = Area.generateChunks(chunkNames.get(8), areaName, sectionName);
        chunk9.setTilesInChunk(allMapNodes.get(8));

        return new Area(areaName, sectionName, chunk1, chunk2, chunk3,
                             chunk4, chunk5, chunk6,
                             chunk7, chunk8, chunk9);
    }



    public void setAreaOne(List<String> chunkNames, String areaName, String sectionName, AssetManager assets) {
        this.areaOne = getArea(chunkNames, areaName, sectionName, getAllMapNodes(assets));
    }
    public void setAreaTwo(List<String> chunkNames, String areaName, String sectionName, AssetManager assets) {
        this.areaTwo = getArea(chunkNames, areaName, sectionName, getAllMapNodes(assets));
    }
    public void setAreaThree(List<String> chunkNames, String areaName, String sectionName, AssetManager assets) {
        this.areaThree = getArea(chunkNames, areaName, sectionName, getAllMapNodes(assets));
    }
    public void setAreaFour(List<String> chunkNames, String areaName, String sectionName, AssetManager assets) {
        this.areaFour = getArea(chunkNames, areaName, sectionName, getAllMapNodes(assets));
    }
    public void setAreaFive(List<String> chunkNames, String areaName, String sectionName, AssetManager assets) {
        this.areaFive = getArea(chunkNames, areaName, sectionName, getAllMapNodes(assets));
    }
    public void setAreaSix(List<String> chunkNames, String areaName, String sectionName, AssetManager assets) {
        this.areaSix = getArea(chunkNames, areaName, sectionName, getAllMapNodes(assets));
    }
    public void setAreaSeven(List<String> chunkNames, String areaName, String sectionName, AssetManager assets) {
        this.areaSeven = getArea(chunkNames, areaName, sectionName, getAllMapNodes(assets));
    }
    public void setAreaEight(List<String> chunkNames, String areaName, String sectionName, AssetManager assets) {
        this.areaEight = getArea(chunkNames, areaName, sectionName, getAllMapNodes(assets));
    }
    public void setAreaNine(List<String> chunkNames, String areaName, String sectionName, AssetManager assets) {
        this.areaNine = getArea(chunkNames, areaName, sectionName, getAllMapNodes(assets));
    }

    public void setCoordinatesForWithinAreaSection() {
        //method to set coordinates for within area
        //this will help in positioning the area within the section
        //this is specifically for setting coordinates that the server uses to track player position within areas

        areaOne.generateAreaCoordinates(sectionName, areaOne.getAreaName());
        HashMap<Integer, HashMap<String, Integer>> areaCoordinates = areaOne.getAreaCoordinates();



            //the other areas will have their coordinates set when they are created
            //I still need to do some work in blender for those areas






    }







    public HashMap<String, Area> getAllAreasInSection() {
        HashMap<String, Area> areasMap = new HashMap<>();
        areasMap.put(areaOne.getAreaName(), areaOne);
        areasMap.put(areaTwo.getAreaName(), areaTwo);
        areasMap.put(areaThree.getAreaName(), areaThree);
        areasMap.put(areaFour.getAreaName(), areaFour);
        areasMap.put(areaFive.getAreaName(), areaFive);
        areasMap.put(areaSix.getAreaName(), areaSix);
        areasMap.put(areaSeven.getAreaName(), areaSeven);
        areasMap.put(areaEight.getAreaName(), areaEight);
        areasMap.put(areaNine.getAreaName(), areaNine);
        return areasMap;
    }

    public Area getAreaOne() {
        return areaOne;
    }
    public Area getAreaTwo() {
        return areaTwo;
    }
    public Area getAreaThree() {
        return areaThree;
    }
    public Area getAreaFour() {
        return areaFour;
    }
    public Area getAreaFive() {
        return areaFive;
    }
    public Area getAreaSix() {
        return areaSix;
    }
    public Area getAreaSeven() {
        return areaSeven;
    }
    public Area getAreaEight() {
        return areaEight;
    }
    public Area getAreaNine() {
        return areaNine;
    }

    public void setAreaArrays() {
        //method to set area arrays
        //this will help in managing areas within the section
        areasInSection.add(areaNine);
        areasInSection.add(areaEight);
        areasInSection.add(areaSeven);
        areasInSection.add(areaSix);
        areasInSection.add(areaFive);
        areasInSection.add(areaFour);
        areasInSection.add(areaThree);
        areasInSection.add(areaTwo);
        areasInSection.add(areaOne);
    }

    


}
