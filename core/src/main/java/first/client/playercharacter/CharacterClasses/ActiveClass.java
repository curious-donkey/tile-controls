package first.client.playercharacter.CharacterClasses;

public class ActiveClass {


    CharacterClass characterClass;
    String currentClass;

    public ActiveClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
        this.currentClass = characterClass.getClassName();
    }


    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        // Logic to set the active class
        this.characterClass = characterClass;
    }

    public void saveActiveClassState() {
        //Logic to save the state of the active class
        //mostly to save to a record
    }

    public void invokeCharacterAction(String actionName) {
        characterClass.invokeAction(actionName);
    }

     

    public String displayAvailableActions(){
        characterClass.getAvailableActions(currentClass);
        return "placeholder";
    }



}
