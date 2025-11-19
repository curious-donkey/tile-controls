package first.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class NathanInPutProcessor extends CameraInputController  {
    //this class will handle input for the orbital camera
    //and for the player character movement
    //it will be used in the FirstGameClient class
    //and for mouse input

    float rotationSpeed; // Slower, smoother rotation
    float zoomSpeed; // Slower, smoother zoom
    
	Vector3 temp;

    Vector3 target;
	float distance;
	float angleY;
	float angleX;
    GameMap gameMap;
    ModelInstance instance;
    OrthographicCamera cam;
    ModelInstance playerCharacter;
    Vector3 gridPos;
  
    public void setInstance(ModelInstance instance) {
        this.instance = instance;
    }



    public NathanInPutProcessor(OrthographicCamera cam, Vector3 target, float distance, float angleY, float angleX,
            float rotationSpeed, float zoomSpeed, Vector3 temp, GameMap gameMap) {
        super(cam); // Call the superclass constructor with the camera
        this.cam = cam;
        this.target = target;
        this.distance = distance;
        this.angleY = angleY;
        this.angleX = angleX;
        this.rotationSpeed = rotationSpeed;
        this.zoomSpeed = zoomSpeed;
        this.temp = temp;
        this.gameMap = gameMap;
    }

    public void setPlayerCharacter(ModelInstance playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
    
 


    // Simplified keyDown - let continuous polling handle the actual rotation
    @Override
    public boolean keyDown(int keycode) {
        //this will be used for bringing up menus
        //and for interacting with objects in the game world
        //and using item abilities while not in a menu
              //so basically for using item/ability hotkeys
        // Just return true for handled keys to prevent other processors from handling them
        //a different set of controls will be used for interacting with menus
            //so a different class will be made to do menu controls
        return keycode == Input.Keys.W || keycode == Input.Keys.A || 
               keycode == Input.Keys.S || keycode == Input.Keys.D;
    }
    public Vector3 screenToGroundPosition(int screenX, int screenY) {
    // Get both near and far points of the click ray
    Vector3 near = new Vector3(screenX, screenY, 0f);
    Vector3 far = new Vector3(screenX, screenY, 1f);
    
    cam.unproject(near);
    cam.unproject(far);
    
    // Calculate where the line intersects your ground level (Y = 190)
    float groundY = 190f;
    float t = (groundY - near.y) / (far.y - near.y);
    
    // Interpolate to find the exact ground intersection
    Vector3 groundPoint = new Vector3();
    groundPoint.x = near.x + t * (far.x - near.x);
    groundPoint.y = groundY;
    groundPoint.z = near.z + t * (far.z - near.z);
    
    return groundPoint;
}


   
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //this will be used for clicking on objects in the game world  
        //e.g., selecting a unit or interacting with an object
        //or for moving the player character to a specific location
        //this is for movement and interacting with objects
        Vector3 gridPos = screenToGroundPosition(screenX, screenY);
        //context menu will be a class attribute of FirstGameClient
        //it is to be generated on a mouse hover so that there is a context menu ready to go at all times
        //the context menu will be generated based on what the mouse is hovering over

        //I will need to create multiple classes to handle context menus

            if (button == Input.Buttons.LEFT)
            {
                System.out.println("Left click at: " + screenX + ", " + screenY);
                
                
                
                
                
                playerCharacter.transform.setTranslation(gridPos.x, 190f, gridPos.z);

                System.out.println("Moving player character to: " + gridPos);

                //I need to do the math to convert the screen coordinates to world coordinates
                //and then convert those world coordinates to grid coordinates
                //and then finally set the player character to the new grid coordinates
                //I also need to make sure the player character is at the correct height
                //so that it is not floating above the ground or sinking into the ground

                
                // Option 2: Extract from transform matrix
                //for (Node node : instance.nodes) {

                    //if (node.id.equals("Camera")) {
                        //skip camera node
                        //continue;
                    //}
                    //else {
                        // Handle other nodes
                        //Vector3 pos = node.translation;
                    
                    // Round to your grid (same as in GameWorldLoader)
                    //float gridX = Math.round(pos.x / 10f) * 10f;
                    //float gridY = Math.round(pos.y / 10f) * 10f;
                    //float gridZ = Math.round(pos.z / 10f) * 10f;

                    //System.out.println("Tile: " + node.id +
                    //    " Grid: (" + gridX + ", " + gridY + ", " + gridZ + ")");
                    //}
                    
                    
                    //}
                }

                //lets make the character move to the clicked location
                    //I'm able to get the coordinates of the clicked tile
                    //and I'm also able to control which tiles are counted when nodes are read
                    //which means I can control communication between the client and the server
                    //as It means I can control which tiles are rendered
                    //and which tiles are not rendered
                    //via communication in json files
                //for (Node node : instance.nodes) {
                //if (node.parts.size > 0) {
                    //BoundingBox bounds = new BoundingBox();
                    //node.parts.first().meshPart.mesh.calculateBoundingBox(bounds);
                    
                    //float width = bounds.getWidth() * node.scale.x;
                    //float depth = bounds.getDepth() * node.scale.z;
                    
                    //System.out.println("Node: " + node.id + 
                        //" Actual size: " + width + " x " + depth);
               

                if (button == Input.Buttons.RIGHT) {
               
                
                
                //left mouse button click
                //this one is for movement and interacting with objects immediately
                //also for selecting options in the context menus brought up with right click
                gameMap.getRightClickContextMenuAt(gridPos.x, 190f, gridPos.z);
                
                }
                //if outside a context menu, left click will cause the first action in the context menu to be executed
                //if inside a context menu, left click will select the option clicked on
            
            
                //right mouse button click
                //this will be used for bringing up context menus
          
        return false;
    }
    public Vector3 screenToGrid(float screenX, float screenY) {
    // Create a screen coordinate vector
    Vector3 screenCoords = new Vector3(screenX, screenY, 0);
    
    // Unproject to world coordinates
    Vector3 worldCoords = new Vector3();
    cam.unproject(worldCoords.set(screenCoords));
    
    // Round to nearest grid position
    float gridX = Math.round(worldCoords.x / 10f) * 10f;
    float gridY = 0;
    float gridZ = Math.round(worldCoords.z / 10f) * 10f; // Assuming a flat grid at z=0
    
    return new Vector3(gridX, gridY, gridZ);
}
   
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //I will use this for moving items in inventory
        //basically for drag and drop functionality

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Vector3 gridPos = screenToGroundPosition(screenX, screenY);
        gameMap.getHoverContextMenuAt(gridPos.x, 190f, gridPos.z);
        //this method will be used for highlighting tiles
        //when the mouse is over them
        

        //this method can be used for making a custom cursor
        //and for displaying where the user will click
        //e.g., a way to know where the user is aiming
        //or where the user is pointing
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        float delta = Gdx.graphics.getDeltaTime();
        
        //this will be used for zooming in and out

        cam.zoom += amountY * 0.1f; // Zoom in/out
        cam.zoom = MathUtils.clamp(cam.zoom, 0.1f, 5f);

        updateCameraPosition();
        
        return true;
    }
//this class wil be responsible for handling inputs
//that is all
    @Override
    public void update() {
        // Get delta time for smooth, frame-rate independent movement
        float delta = Gdx.graphics.getDeltaTime();
        boolean cameraChanged = false;
        
        // Continuous input polling - check if keys are currently pressed
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            angleY += rotationSpeed * delta; // Orbit left around center
            cameraChanged = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            angleY -= rotationSpeed * delta; // Orbit right around center
            cameraChanged = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            angleX += rotationSpeed * delta; // Change viewing angle up
            cameraChanged = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            angleX -= rotationSpeed * delta; // Change viewing angle down
            cameraChanged = true;
        }
        
        // Only update camera position if input was detected or this is the first call
        if (cameraChanged || cam.position.isZero()) {
            updateCameraPosition();
        }
    }
    
    private void updateCameraPosition() {
        // Update camera position based on current angles and distance
        float radY = angleY * MathUtils.degreesToRadians;
        float radX = angleX * MathUtils.degreesToRadians;
        float x = target.x + distance * MathUtils.cos(radY) * MathUtils.cos(radX);
        float z = target.z + distance * MathUtils.sin(radY) * MathUtils.cos(radX);
        float y = target.y + distance * MathUtils.sin(radX);
        gameMap.updateMap(x, y, z);
        cam.position.set(x, y, z);
        
        cam.lookAt(target);
        cam.up.set(Vector3.Y); // Ensure camera 'up' is always world up
        cam.update();
    }

    public Vector3 getGridPos() {
        return gridPos;
    }

    public void setGridPos(Vector3 gridPos) {
        this.gridPos = gridPos;
    }

}