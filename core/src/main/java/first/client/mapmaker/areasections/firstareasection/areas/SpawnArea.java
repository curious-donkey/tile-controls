package first.client.mapmaker.areasections.firstareasection.areas;

import first.client.mapmaker.areasections.firstareasection.AreaEnum;

//this enum is for defining different areas in the game world
//this enum is for the start area
//so, next step is to create files for two more areas

public enum SpawnArea implements AreaEnum{

    SPAWN_POINT,
    FIRST_LEVEL,
    SECOND_LEVEL,
    THIRD_LEVEL,
    FOURTH_LEVEL,
    FIFTH_LEVEL,
    SIXTH_LEVEL,
    SEVENTH_LEVEL,
    EIGHTH_LEVEL;



   public static String getBlockAssets(SpawnArea area) {
       return switch (area) {
           case SPAWN_POINT -> "maps/planesBiome.g3dj";
           case FIRST_LEVEL -> "maps/hillBiome.g3dj";
           case SECOND_LEVEL -> "maps/scrubLandBiome.g3dj";
           case THIRD_LEVEL -> "maps/forestedBiome.g3dj";
           case FOURTH_LEVEL -> "maps/deadTreesBiome.g3dj";
           case FIFTH_LEVEL -> "maps/forested1Biome.g3dj";
           case SIXTH_LEVEL -> "maps/forestedMineBiome.g3dj";
           case SEVENTH_LEVEL -> "maps/forestedPineBiome.g3dj";
           case EIGHTH_LEVEL -> "maps/planesBiome.g3dj";
           default -> throw new IllegalArgumentException("Unexpected value: " + area);
       };
   }

   private String areaName = "Spawn Area";
   
   public String getAreaName() {
       return areaName;
   }
   
   






   public static SpawnArea[][] getChunkGrid() {


   return new SpawnArea[][]{
            {SPAWN_POINT, FIRST_LEVEL, SECOND_LEVEL},
            {THIRD_LEVEL, FOURTH_LEVEL, FIFTH_LEVEL},
            {SIXTH_LEVEL, SEVENTH_LEVEL, EIGHTH_LEVEL}
    };    
   }

   public static int[][] getChunkGridRelativePositions() {
       return new int[][]{
           {0, 0}, {0, 1}, {0, 2},
           {1, 0}, {1, 1}, {1, 2},
           {2, 0}, {2, 1}, {2, 2}
       };
   }
  
   public static float[] getChunkDimensions() {
       return new float[]{100f, 100f};
   }


   public static float[][] getChunkPositions() {
       return new float[][]{
           {0f, 0f, 0f},        // SPAWN_POINT
           {100f, 0f, 0f},     // FIRST_LEVEL
           {200f, 0f, 0f},     // SECOND_LEVEL
           {0f, 100f, 0f},     // THIRD_LEVEL
           {100f, 100f, 0f},   // FOURTH_LEVEL
           {200f, 100f, 0f},   // FIFTH_LEVEL
           {0f, 200f, 0f},     // SIXTH_LEVEL
           {100f, 200f, 0f},   // SEVENTH_LEVEL
           {200f, 200f, 0f}    // EIGHTH_LEVEL
       };
   }



}
