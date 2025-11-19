package first.client.mapmaker.areasections.firstareasection.areas;

import com.badlogic.gdx.graphics.g3d.model.Node;

public record TileCoordinatesInChunk(float x, float y, float z) {

    public TileCoordinatesInChunk(Node node) {
        this(node.translation.x, node.translation.y, node.translation.z);
    }

    //had to swap y and z because of how libgdx handles 3d coordinates compared to blender

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }



}
