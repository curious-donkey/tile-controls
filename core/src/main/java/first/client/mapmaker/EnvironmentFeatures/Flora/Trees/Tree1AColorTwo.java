package first.client.mapmaker.EnvironmentFeatures.Flora.Trees;

import java.util.ArrayList;

import first.client.mapmaker.areasections.firstareasection.areas.Tile;

public class Tree1AColorTwo implements Trees {
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

  


    public Tree1AColorTwo(String objectName) {
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
        throw new UnsupportedOperationException("Unimplemented method 'removeObjectFromTile'");
    }

    @Override
    public void addObjectToTile(String tileName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addObjectToTile'");
    }

    @Override
    public void interactWithObject(String action) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interactWithObject'");
    }

    @Override
    public void setCurrentTile(Tile tile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCurrentTile'");
    }

    @Override
    public String getObjectName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getObjectName'");
    }

    @Override
    public String chopDownObject() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chopDownObject'");
    }

    @Override
    public void trimObject() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'trimObject'");
    }

}
