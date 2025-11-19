package first.client.playercharacter.CharacterClasses;

import java.util.ArrayList;
import java.util.List;

import first.client.playercharacter.CharacterClasses.Knight.Knight;
import first.client.playercharacter.CharacterClasses.Mage.Mage;


public enum CharacterClassesAvailable {

    KNIGHT,
    MAGE;




public static ArrayList<String> getClassesAvailable() {
   //for usage by frontend to display available classes
    List<String> classes = new ArrayList<>();
     for (CharacterClassesAvailable characterClass : CharacterClassesAvailable.values()) {
         classes.add(characterClass.name());
     }
     return (ArrayList<String>) classes;
}




public static String getCharacterClassPath(String className) {
    switch (className.toString()) {
        case "KNIGHT":
            return Knight.getCharacterClassPath();
        case "MAGE":
            return Mage.getCharacterClassPath();
        default:
            return null;
    }




}

}
