package first.client.mapmaker.nonplayercharacters;

import java.util.ArrayList;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import first.client.mapmaker.AreasSectionEnum;
import first.client.playercharacter.CharacterClasses.Knight.FirstClassChoice;

public class SceneUnitsHandler {

    private Array<SceneUnit> sceneUnits;
    private Array<String> sceneUnitNames;
    private String sceneName;
    private AssetManager assets;
    private Array<ModelInstance> instances;
    private FirstClassChoiceUnits classChoices;




    public static Vector3 playerStartingPosition() {
        return new Vector3(0, 0, 0); // Default position
    }

    public SceneUnitsHandler(AssetManager assets, Array<ModelInstance> instances){
        this.assets = assets;
        this.instances = instances;
    }

    public void setSceneUnits(Array<String> sceneUnitNames) {
        this.sceneUnitNames = sceneUnitNames;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getSceneName() {
        return sceneName;
    }

    public FirstClassChoiceUnits addToInstances(Array<ModelInstance> instances) {
        this.classChoices = new FirstClassChoiceUnits(assets);
        ArrayList<FirstClassChoice> initialClassChoices = classChoices.getInitialClassChoices();
        int classChoiceCount = 0;
        int initChoicesCount = initialClassChoices.size();
        while (classChoiceCount < initChoicesCount) {
            instances.add(initialClassChoices.get(classChoiceCount).getModelInstance());
            classChoiceCount++;
        }
        
       return classChoices;
    }

    

    public FirstClassChoiceUnits getFirstSceneUnits(){
        return classChoices;
    }
    

    public void createSceneUnit(String name, int[][] chunkPosition, int[][] tilePosition, ModelInstance modelInstance){
        SceneUnit newUnit = new SceneUnit(name, chunkPosition, tilePosition, modelInstance);
        sceneUnits.add(newUnit);
    }

    public AreasSectionEnum getSceneEnum(String name){
        return AreasSectionEnum.valueOf(name);
    }

    public Array<ModelInstance> getInstances() {
        return instances;
    }

    public AssetManager getAssets() {
        return assets;
    }

}
