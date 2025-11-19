package first.client.mapmaker.nonplayercharacters;

import java.util.HashMap;

public class NpcController {
    //this is for controlling npc behavior
    //such as movement, attacking, etc.
    //each object of this class will be tied to a specific npc
    HashMap<String, SceneUnit> npcModelMap;

    public SceneUnit getNpcByName(String name){
        return npcModelMap.get(name);
    }

    public void moveNpc(String name, int[][] newChunkPosition, int[][] newTilePosition){
        SceneUnit npc = npcModelMap.get(name);
        if(npc == null){
            System.out.println("No npc found with name: " + name);
            return;
        }
        
        //update the npc's position
        //npc.setChunkPosition(newChunkPosition);
        //npc.setTilePosition(newTilePosition);
    }





}
