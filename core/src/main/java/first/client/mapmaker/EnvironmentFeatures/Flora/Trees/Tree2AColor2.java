package first.client.mapmaker.EnvironmentFeatures.Flora.Trees;

import java.util.ArrayList;

import first.client.mapmaker.areasections.firstareasection.areas.Tile;

public class Tree2AColor2 implements Trees {

    private final String objectName;

    private static final String classID = "Tree_2_A_Color2";


    private static final String objectType = "Block Tree";


    private static final String objectDescription = "A tall leafy tree with a thick trunk and vibrant green blocky foliage.";

    private static final String chopDown = "Chop";

    private static final String trim = "Trim";

    private static final String getExamineInfo = "Examine";

    private String currentTile;
        //this might be changed to a type of record later

    private ArrayList<String> objectActions = new ArrayList<>();

    




    public Tree2AColor2(String objectName) {
        this.objectName = objectName;
    }






    @Override
    public ArrayList<String> getObjectInfo() {
        objectActions.add(chopDown);
        objectActions.add(trim);
        objectActions.add(getExamineInfo);

       
        return objectActions;
    }

    @Override
    public void removeObjectFromTile() {
        // TODO Auto-generated method stub
        //this is just going to be for removing the tree from the tile when chopped down
        //It will just change the rendered model to a stump
        //after some some the stump will turn back into a tree
        
        throw new UnsupportedOperationException("Unimplemented method 'removeObjectFromTile'");
    }

    @Override
    public void addObjectToTile(String tileName) {
        this .currentTile = tileName;
    }

    @Override
    public void interactWithObject(String action) {
        if (action.equals(chopDown)) {
            chopDownObject();
        } else if (action.equals(trim)) {
            trimObject();
        } else if (action.equals(getExamineInfo)) {
            //provide examine info
            System.out.println(objectDescription);
        } else {
            System.out.println("Action not recognized.");
        }
    }

    @Override
    public void setCurrentTile(Tile tile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCurrentTile'");
    }

    @Override
    public String getObjectName() {
       return objectName;
    }

    @Override
    public String chopDownObject() {
        // TODO Auto-generated method stub

        //initiates the process of chopping down the tree

        //to be implemented when I get the item drop system working

        return "Chopping down the tree...";
    }

    @Override
    public void trimObject() {


        //this will produce sticks from branches
        //no change in tree appearance planned


        throw new UnsupportedOperationException("Unimplemented method 'trimObject'");
    }

}
