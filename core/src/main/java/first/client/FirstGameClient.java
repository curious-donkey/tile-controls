package first.client;


import static first.client.mapmaker.areasections.firstareasection.FirstAreasInGame.SPAWN_AREA;

import java.util.HashMap;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.kotcrab.vis.ui.widget.file.FileChooser;

import first.client.mapmaker.areasections.firstareasection.FirstAreasInGame;
import first.client.mapmaker.nonplayercharacters.SceneUnitsHandler;
import net.mgsx.gltf.scene3d.scene.Scene;
import first.client.mapmaker.areasections.firstareasection.areas.ChunkPositionInArea;
import first.client.mapmaker.areasections.firstareasection.areas.SpawnArea;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.EIGHTH_LEVEL;

import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.FIFTH_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.FIRST_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.FOURTH_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.SECOND_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.SEVENTH_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.SIXTH_LEVEL;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.SPAWN_POINT;
import static first.client.mapmaker.areasections.firstareasection.areas.SpawnArea.THIRD_LEVEL;

public class FirstGameClient implements ApplicationListener {
	//I need to setup control of how the player model spawns and moves
	//I also need to setup the camera to orbit around the player model

	//I will need to setup multiple input processors
	//So I will need to create an interface for input processors
	//Then do input chaining/multiplexing
	
	//I've also got to figure out how to make the player model move


	//and do conditional rendering based on camera position
	//and make different blocks of terrain load in based on camera position

	ModelBatch modelBatch;
	Environment environment;
	OrthographicCamera cam;
	NathanInPutProcessor inputProcessor;
	AssetManager assets;
	boolean loading;
	Model model;
	ModelInstance instance;
	ModelInstance chunk2;
	Model model2;
	ModelInstance playerCharacter;
	GameMap gameMap;
	Model model3;
	ModelInstance chunk3;


	Model model4;
	ModelInstance chunk4;
	
	
	Model model5;
	ModelInstance chunk5;

	Model model6;
	ModelInstance chunk6;

	Model model7;
	ModelInstance chunk7;

	Model model8;
	ModelInstance chunk8;

	Model model9;
	ModelInstance chunk9;









	Array<ModelInstance> instances = new Array<ModelInstance>();
	Viewport viewport;
	// Orbital camera variables
	Vector3 target = new Vector3(0, 0, 0);
	float distance = 1000f;
	float angleY = 45f;
	float angleX = 45f;
	float rotationSpeed = 100f; // Degrees per second
	float zoomSpeed = 100f; // Units per second
	Vector3 temp = new Vector3();
	
	private void setInstance(ModelInstance instance) {
		this.instance = instance;
	}



	@Override
	public void create() {
		// TODO Auto-generated method stub
		modelBatch = new ModelBatch();
		environment = new Environment();
		
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(100f, 100f, 100f);
		cam.lookAt(100f, 100f, 100f);
		cam.near = -10000f;
		cam.far = 10000f;
		cam.update();
		
		this.gameMap = new GameMap(SPAWN_AREA);
			//I need to work on the FirstAreasInGame enum next



		
			//I need to properly initialize the game map now
			//otherwise I'll get null pointer exceptions when trying to reference tiles
			//and I can't use a constructor to do it because of how the game assets are structured
			//so I need to do so with setter methods

		
		
		assets = new AssetManager();

		
		assets = GameAssetLoader.loadAssets(assets);

		

										//I will need to abstract the parameters for this object method call later
	
				//I've temporarily hardcoded the area enum and area name here
				//this is necessary to properly initialize the game map
				//but another MAJOR issue is that the assets are not loaded yet when this method is called
				//I will need to relocated this method call to after the assets are loaded


		//now that I have the nodes for each block
		//I can use them to get location data for each individual tile

		inputProcessor = new NathanInPutProcessor(cam, target, distance, angleY, angleX, rotationSpeed, zoomSpeed, temp, gameMap);
		
		Gdx.input.setInputProcessor(inputProcessor);


		loading = true;

		

	}

	private void snapModelToGrid(ModelInstance instance, float gridSize) {
		// Snap the model's position to the nearest grid point
		for (Node node : instance.nodes){

			Vector3 translation = node.translation;

			translation.x = Math.round(translation.x / gridSize) * gridSize;
			translation.y = Math.round(translation.y / gridSize) * gridSize;
			translation.z = Math.round(translation.z / gridSize) * gridSize;
			node.calculateTransforms(true);
		}
	}






	@Override
	public void resize(int width, int height) {
		cam.viewportWidth = width;
		cam.viewportHeight = height;
		cam.update();
	}
	@Override
	public void render() {
	
		if (loading && assets.update()) {
			doneLoading();
		}
		inputProcessor.update();
		
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		modelBatch.begin(cam);

		

		modelBatch.render(instances, environment);
		modelBatch.end();
		if (assets.isFinished()) {
			model = assets.get(SpawnArea.getBlockAssets(SPAWN_POINT), Model.class);
			model2 = assets.get(SpawnArea.getBlockAssets(FIRST_LEVEL), Model.class);
			model3 = assets.get(SpawnArea.getBlockAssets(SECOND_LEVEL), Model.class);
			model4 = assets.get(SpawnArea.getBlockAssets(THIRD_LEVEL), Model.class);
			model5 = assets.get(SpawnArea.getBlockAssets(FOURTH_LEVEL), Model.class);
			model6 = assets.get(SpawnArea.getBlockAssets(FIFTH_LEVEL), Model.class);
			model7 = assets.get(SpawnArea.getBlockAssets(SIXTH_LEVEL), Model.class);
			model8 = assets.get(SpawnArea.getBlockAssets(SEVENTH_LEVEL), Model.class);
			model9 = assets.get(SpawnArea.getBlockAssets(EIGHTH_LEVEL), Model.class);

			instance = new ModelInstance(model);
			chunk2 = new ModelInstance(model2);
			chunk3 = new ModelInstance(model3);
			chunk4 = new ModelInstance(model4);
			chunk5 = new ModelInstance(model5);
			chunk6 = new ModelInstance(model6);
			chunk7 = new ModelInstance(model7);
			setInstance(instance);
			inputProcessor.setInstance(instance);
			snapModelToGrid(instance, 10f);
		}

		


	}
	
		
			
	private void doneLoading() {
		SceneUnitsHandler unitLoader = new SceneUnitsHandler(assets, instances);
		

		unitLoader.addToInstances(instances);

		
		//I need to set it so individual character classes reference their own model instances
		//right now they are null
		//the current goal is to now render the different models outside the game client class
		//that way I can render different models based on which scene is loaded


		//my next task is to implement the game map
		//so I can position chunks automatically rather than through defining a ton of constants

		//but first I need to get the player character working
		//so that the program can run again without crashing
		
		inputProcessor.gameMap.initalizeAreaSectionValue(assets, "Spawn Area", "Spawn Area");
		inputProcessor.setPlayerCharacter(unitLoader.getFirstSceneUnits().getPlayerCharacterUnit().getModelInstance());


		cam.lookAt(SceneUnitsHandler.playerStartingPosition());
		gameMap.updateMap(cam.position.x, cam.position.y, cam.position.z);
		//I need to make it so that the map loads based on player position
		//so that the player is always on solid ground
		//and so that the map loads in chunks based on player position
		instance = new ModelInstance(unitLoader.getAssets().get(SpawnArea.getBlockAssets(SPAWN_POINT), Model.class));
		chunk2 = new ModelInstance(unitLoader.getAssets().get(SpawnArea.getBlockAssets(FIRST_LEVEL), Model.class));
		chunk3 = new ModelInstance(unitLoader.getAssets().get(SpawnArea.getBlockAssets(SECOND_LEVEL), Model.class));
		chunk4 = new ModelInstance(unitLoader.getAssets().get(SpawnArea.getBlockAssets(THIRD_LEVEL), Model.class));
		chunk5 = new ModelInstance(unitLoader.getAssets().get(SpawnArea.getBlockAssets(FOURTH_LEVEL), Model.class));
		chunk6 = new ModelInstance(unitLoader.getAssets().get(SpawnArea.getBlockAssets(FIFTH_LEVEL), Model.class));
		chunk7 = new ModelInstance(unitLoader.getAssets().get(SpawnArea.getBlockAssets(SIXTH_LEVEL), Model.class));
		chunk8 = new ModelInstance(unitLoader.getAssets().get(SpawnArea.getBlockAssets(SEVENTH_LEVEL), Model.class));
		chunk9 = new ModelInstance(unitLoader.getAssets().get(SpawnArea.getBlockAssets(EIGHTH_LEVEL), Model.class));

		
		HashMap<String, float[]> translationVals = new HashMap<>();
		//this is just the standard positioning for chunks in any given area


		instance.transform.translate(0, 0, 0);
		translationVals.put("chunk1", new float[] {0, 0, 0});
		chunk2.transform.translate(-200 * 16f, 0, -200 * 16f); // Position next to the first chunk
		translationVals.put("chunk2", new float[] {-200 * 16f, 0, -200 * 16f});
		chunk3.transform.translate(200 * 16f, 0, -200 * 16f); // Position next to the first chunk
		translationVals.put("chunk3", new float[] {200 * 16f, 0, -200 * 16f});
		chunk4.transform.translate(0, 0, -200 * 16f); // Position next to the first chunk
		translationVals.put("chunk4", new float[] {0, 0, -200 * 16f});
		chunk5.transform.translate(-200 * 16f, 0, 0); // Position next to the first chunk
		translationVals.put("chunk5", new float[] {-200 * 16f, 0, 0});
		chunk6.transform.translate(200 * 16f, 0, 0); // Position next to the first chunk
		translationVals.put("chunk6", new float[] {200 * 16f, 0, 0});
		chunk7.transform.translate(0, 0, 200 * 16f); // Position next to the first chunk
		translationVals.put("chunk7", new float[] {0, 0, 200 * 16f});
		chunk8.transform.translate(200 * 16f, 0, 200 * 16f); // Position next to the first chunk
		translationVals.put("chunk8", new float[] {200 * 16f, 0, 200 * 16f});
		chunk9.transform.translate(-200 * 16f, 0, 200 * 16f); // Position next to the first chunk
		translationVals.put("chunk9", new float[] {-200 * 16f, 0, 200 * 16f});





		


		inputProcessor.gameMap.currentAreaSection.currentArea.setTranslationValsForChunks(translationVals);
			// each tile is 200 by 200 units
			// each chunk is 16 by 16 tiles
				//revised each chunk to be 16 by 16 to make using streams with it easier
				//no need to overcomplicate things
			


		instances.add(instance);
		instances.add(chunk2);
		instances.add(chunk3);
		instances.add(chunk4);
		instances.add(chunk5);
		instances.add(chunk6);
		instances.add(chunk7);
		instances.add(chunk8);
		instances.add(chunk9);

		


		loading = false;
	}

	



	@Override
	public void pause() {
		//
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'resume'");
	}
	@Override
	public void dispose() {
		modelBatch.dispose();
		instances.clear();
		model.dispose();
	} 


}