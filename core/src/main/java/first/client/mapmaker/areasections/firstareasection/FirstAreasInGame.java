
package first.client.mapmaker.areasections.firstareasection;

public enum FirstAreasInGame  implements AreaEnum {

    SPAWN_AREA,
    NEWBIE_TOWN,
    TUTORIAL_GROVE,
    FOREST_EDGE,
    DARK_WOODS,
    MYSTIC_RIVER,
    ANCIENT_CAVE,
    PROTOTYPICAL_CASTLE,
    ABANDONED_VILLAGE;

    
    public static String getAreaSection(AreaEnum areaEnum) {
         return switch (areaEnum) {
              case SPAWN_AREA -> "Spawn Area";
              case NEWBIE_TOWN ->"Newbie Town";
              case TUTORIAL_GROVE ->"Tutorial Grove";
          default -> throw new IllegalArgumentException("Unexpected value: " + areaEnum);
         };
}


    
    

    





}
