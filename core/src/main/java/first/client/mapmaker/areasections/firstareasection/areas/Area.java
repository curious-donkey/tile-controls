package first.client.mapmaker.areasections.firstareasection.areas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Area {

    
    @SuppressWarnings("unused")
    private final String areaName;
    @SuppressWarnings("unused")
    private final String sectionName;
    private final ArrayList<Chunk> chunks;
    private final Chunk chunk1;
    private final Chunk chunk2;
    private final Chunk chunk3;
    private final Chunk chunk4;
    private final Chunk chunk5;
    private final Chunk chunk6;
    private final Chunk chunk7;
    private final Chunk chunk8;
    private final Chunk chunk9;
    private AreaPositionInSection areaPositionInSection;
    private Chunk[][] chunkGrid;    

    private HashMap<String, Object> nonTileAssetsInArea;

    private HashMap<Integer, HashMap<String, Integer>> areaCoordinates;


    public Area(String areaName, String sectionName, Chunk chunk1, Chunk chunk2, Chunk chunk3,
                Chunk chunk4, Chunk chunk5, Chunk chunk6,
                Chunk chunk7, Chunk chunk8, Chunk chunk9) {
        this.areaName = areaName;
        this.sectionName = sectionName;
        this.chunk1 = chunk1;
        this.chunk2 = chunk2;
        this.chunk3 = chunk3;
        this.chunk4 = chunk4;
        this.chunk5 = chunk5;
        this.chunk6 = chunk6;
        this.chunk7 = chunk7;
        this.chunk8 = chunk8;
        this.chunk9 = chunk9;
        this.chunks = new ArrayList<>();
        chunks.add(chunk1);
        chunks.add(chunk2);
        chunks.add(chunk3);
        chunks.add(chunk4);
        chunks.add(chunk5);
        chunks.add(chunk6);
        chunks.add(chunk7);
        chunks.add(chunk8);
        chunks.add(chunk9);
    }

    public String getAreaName() {
        return areaName;
    }


    public static Chunk generateChunks(String chunkName, String areaName, String sectionName) {
        return new Chunk(chunkName, areaName, sectionName);
    }

    
    //removed method as it was deemed unnecessary and a poor solution for chunk grid management
    //might be used for conditional chunk grid setups in the future
    //public void setChunkGrid() {

        //Chunk[][] chunkGrid = {
            //{chunk1, chunk2, chunk3},
            //{chunk4, chunk5, chunk6},
            //{chunk7, chunk8, chunk9}
        //};
    //}

    //public Chunk[][] getChunkGrid() {
        //return chunkGrid;
    //}


    public void generateAreaCoordinates(String sectionName, String areaName) {
        //this is NOT translation values
        //these are the coordinates of the area in the section

        this.areaCoordinates = new HashMap<>();
        






    }



    

    public HashMap<Integer, HashMap<String, Integer>> getAreaCoordinates() {
        return areaCoordinates;
    }



    public Chunk getClosestChunk(float x, float z) {
            Map<Integer, Float> distances = new HashMap<>();
            int a = 0;
            for (Chunk chunk : chunks) {
                float distance = (float) Math.sqrt(Math.pow(x - chunk.getTranslateXVal(), 2) + Math.pow(z - chunk.getTranslateZVal(), 2));
                distances.put(a, distance);
                a++;
            }

            int closestChunkIndex = distances.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);

                if (closestChunkIndex != -1) {
                    return chunks.get(closestChunkIndex);
                }

                return null;
               
    }

    public void setTranslationValsForChunks(HashMap<String, float[]> chunkPositions) {
        chunk1.setTranslationValues(chunkPositions.get(chunk1.getChunkName()));
        chunk2.setTranslationValues(chunkPositions.get(chunk2.getChunkName()));
        chunk3.setTranslationValues(chunkPositions.get(chunk3.getChunkName()));
        chunk4.setTranslationValues(chunkPositions.get(chunk4.getChunkName()));
        chunk5.setTranslationValues(chunkPositions.get(chunk5.getChunkName()));
        chunk6.setTranslationValues(chunkPositions.get(chunk6.getChunkName()));
        chunk7.setTranslationValues(chunkPositions.get(chunk7.getChunkName()));
        chunk8.setTranslationValues(chunkPositions.get(chunk8.getChunkName()));
        chunk9.setTranslationValues(chunkPositions.get(chunk9.getChunkName()));
    }
   
    public ArrayList<Chunk> getChunks(){
        return chunks;
    }




}


