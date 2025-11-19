package first.client.playercharacter;

import java.util.List;

import first.client.playercharacter.CharacterClasses.ActiveClass;
import first.client.playercharacter.CharacterClasses.CharacterClassesAvailable;
public class CharacterController {

    


    
    ActiveClass activeClass;
    int methodCount = activeClass.getClass().getDeclaredMethods().length;
    
    public CharacterController(ActiveClass activeClass) {
        this.activeClass = activeClass;
    }

    public ActiveClass getActiveClass() {
        //this is for interacting with frontend so it can display available methods for the active class
        return activeClass;
    }

    public void setActiveClass(ActiveClass activeClass) {
        //this is for changing the active class
        this.activeClass = activeClass;
    }

    public String displayAvailableActions(){
        //this is for interacting with frontend so it can display available methods for the active class
        return activeClass.displayAvailableActions();
    }
    
    public void invokeCharacterAction(String methodName){
        //this is for interacting with frontend so it can invoke methods for the active class
        //this will cite an enum constant for the specific animations to be played
        //based on the method name passed in
        //and the class will respond based on the value their associated enum holds for it
       activeClass.invokeCharacterAction(methodName);
    }

    
    public int getMethodCount() {
        //this is for interacting with frontend so it can display available methods for the active class
        return methodCount;
    }
    
    public void takeOnNewClass(String className, String choice){
        List<String> availableClasses = CharacterClassesAvailable.getClassesAvailable();
        if(!availableClasses.contains(className)){
            System.out.println("Class not available");
            return;
        }
        if (availableClasses.contains(className) && choice.equals("switch")){}
            
        //create a new character
        //provide choice as to whether to switch to new class or keep current class
        //if switch, set active class to new class
        //if keep, just add class attribute to CharacterController for later use
        //a list will be an attribute of CharacterController to store all classes the character has
        //this will be a way to produce records in a clean way
    }

    public void saveCharacter(){
        activeClass.saveActiveClassState();
        //save character data to file or database
    }


    public List<String> getAvailableClasses(){
        return CharacterClassesAvailable.getClassesAvailable();
        //return a list of available classes for the character to choose from
    }




}