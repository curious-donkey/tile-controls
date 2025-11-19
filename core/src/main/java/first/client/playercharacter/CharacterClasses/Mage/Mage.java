package first.client.playercharacter.CharacterClasses.Mage;

import java.util.ArrayList;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

import first.client.playercharacter.CharacterClasses.CharacterClass;
import first.client.playercharacter.CharacterClasses.Knight.FirstClassChoice;
public class Mage implements CharacterClass, FirstClassChoice {

    private ModelInstance mageInstance;

    
    @Override
    public ModelInstance getModelInstance() {
            mageInstance.transform.scale(100f, 100f, 100f); // Very large scale
        return mageInstance;
    }

    public Vector3 initialPosition;



    public Mage(Model modelPath) {
        // Load the mage model here
        // For example, using an AssetManager or directly loading a model file
        // This is a placeholder implementation
        mageInstance = new ModelInstance(modelPath);
    }










    @Override
    public String getClassName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassName'");
    }

    @Override
    public String getClassDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassDescription'");
    }

   

    @Override
    public void invokeAction(String actionName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'invokeAction'");
    }

    @Override
    public ArrayList<String> getAvailableActions(String className) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvailableActions'");
    }
    
    
    public static ArrayList<String> getDefaultActions() {
        // TODO Auto-generated method stub
        return DEFAULT_ACTIONS;
    }


    @Override
    public void chooseClass() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chooseClass'");
    }

    @Override
    public void setFirstPosition(Vector3 position) {
        this.initialPosition = position;
        mageInstance.transform.setToTranslation(position);
    }

    @Override
    public void unselectClass() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unselectClass'");
    }

    @Override
    public String examineClass() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'examineClass'");
    }

    

}
