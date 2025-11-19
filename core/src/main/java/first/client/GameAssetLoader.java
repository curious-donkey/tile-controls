package first.client;

import com.badlogic.gdx.assets.AssetManager;


public class GameAssetLoader {
    //this is for loading all game assets

    



    public static AssetManager loadAssets(AssetManager assetManager) {
        // Load models
        assetManager.load("maps/hillBiome.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);  
        assetManager.load("maps/planesBiome.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("maps/scrubLandBiome.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        
        assetManager.load("units/Knight.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("units/Mage.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("units/Rogue.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("units/RogueHooded.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("units/Engineer.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("units/Barbarian.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("units/Druid.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);


        assetManager.load("maps/deadTreesBiome.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("maps/forested1Biome.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("maps/forestedMineBiome.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("maps/forestedPineBiome.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);
        assetManager.load("maps/forestedBiome.g3dj", com.badlogic.gdx.graphics.g3d.Model.class);

        return assetManager;
    }

   

    

}


       
    




   







   



