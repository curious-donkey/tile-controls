package first.client.mapmaker.areasections.firstareasection.areas;

public record TileToWorldCoordinates(float x, float y, float z) {
    //this is for holding the world coordinates of a tile
    //after they have been converted from tile coordinates to world coordinates

    

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
