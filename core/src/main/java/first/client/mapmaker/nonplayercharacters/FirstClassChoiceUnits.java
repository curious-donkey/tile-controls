package first.client.mapmaker.nonplayercharacters;

import java.util.ArrayList;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.Vector3;

import first.client.playercharacter.CharacterClasses.Knight.FirstClassChoice;
import first.client.playercharacter.CharacterClasses.Knight.Knight;
import first.client.playercharacter.CharacterClasses.Mage.Mage;

public class FirstClassChoiceUnits  {

   

    private final AssetManager assets;

    private Knight playerCharacter;
    private Mage mageInstance;

    ArrayList<FirstClassChoice> initialClassChoices = new ArrayList<>();


    public FirstClassChoiceUnits(AssetManager assets) {
        this.assets = assets;
        playerCharacter = new Knight(assets.get("units/Knight.g3dj", Model.class));
        mageInstance = new Mage(assets.get("units/Mage.g3dj", Model.class));
    }


    public Knight getPlayerCharacterUnit() {
        return playerCharacter;
    }

    public ArrayList<FirstClassChoice> getInitialClassChoices() {
        setStartingPositions();
        initialClassChoices.add(playerCharacter);
        initialClassChoices.add(mageInstance);
        // Add other class instances here
        return initialClassChoices;
    }


    public void setStartingPositions() {
        float [][][] druidPosition = {{{-246.942f, 190, -200 * 5}}};
        float [][][] roguePosition = {{{-246.942f, 190, -200 * 2}}};
        float [][][] rogueHoodedPosition = {{{-246.942f, 190, -200 * 17}}};
        float [][][] engineerPosition = {{{-246.942f, 190, -200 * 11}}};
        float [][][] barbarianPosition = {{{-246.942f, 190, -200 * 14}}};

        playerCharacter.setFirstPosition(new Vector3(200, 190, 200 * 12));
        
        mageInstance.setFirstPosition(new Vector3(-246.942f * 5f, 190, -200 * 8));
       
    }

    


    

    

    public AssetManager getAssets() {
        return assets;
    }







}
