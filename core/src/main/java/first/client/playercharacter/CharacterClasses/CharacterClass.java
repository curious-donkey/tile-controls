package first.client.playercharacter.CharacterClasses;

import java.util.List;



public interface CharacterClass {

     

    public String getClassName();
    public String getClassDescription();
    public void invokeAction(String actionName);
        //generic method as different classes will have different actions
        //basically to enable different classes to have different actions
        //but still be able to use the same method name
        //and have the same method signature
        //this will be a way to produce records in a clean way
        //and this will allow for different character classes to have different move sets
        //e.g., Knight will have different actions than Mage
        //this method is for generalizing the action invocation process
        //so that the frontend can call this method regardless of the active class
                  //which reduces the amount of code needed in the frontend
                  //and makes it easier to add new classes in the future
    public List<String> getAvailableActions(String className);

    





}
