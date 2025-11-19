package first.client.playercharacter.CharacterClasses.Knight;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

public interface FirstClassChoice {

    public void setFirstPosition(Vector3 position);
    public void chooseClass();
    public void unselectClass();
    public String examineClass();
    public ModelInstance getModelInstance();


}
