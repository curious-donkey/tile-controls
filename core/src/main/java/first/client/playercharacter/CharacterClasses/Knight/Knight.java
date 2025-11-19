package first.client.playercharacter.CharacterClasses.Knight;




import java.util.ArrayList;
import java.util.Vector;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.kotcrab.vis.ui.widget.file.FileChooser;


import first.client.playercharacter.CharacterClasses.CharacterClass;
public class Knight implements CharacterClass, FirstClassChoice {

    ModelInstance knightInstance;
    public Vector3 initialPosition;
    


    String className = "Knight";
    

   
    String classDescription = "A brave warrior skilled in melee combat and defense.";

    public Knight(Model modelPath) {
        // Load the knight model here
        // For example, using an AssetManager or directly loading a model file
        // This is a placeholder implementation
        knightInstance = new ModelInstance(modelPath);
    }

    @Override
   public ModelInstance getModelInstance() {
       knightInstance.transform.scale(10f, 10f, 10f); // Very large scale
        return knightInstance;
    }
    
    

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public String getClassDescription() {
        return classDescription;
    }

    
    public void invokeAction(String actionMethod) {
        // Implementation to invoke the animation based on the animationName
        System.out.println("Invoking animations: " + actionMethod);
    }

    
    @Override
    public ArrayList<String> getAvailableActions(String className){

        //this method will access an enum of action methods
        //the enum will reference character data to determine what actions are available
        //the enum ActionMethods will have a method to return a list of available actions
        return AVAILABLE_ACTIONS;
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
        knightInstance.transform.setToTranslation(position);
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
