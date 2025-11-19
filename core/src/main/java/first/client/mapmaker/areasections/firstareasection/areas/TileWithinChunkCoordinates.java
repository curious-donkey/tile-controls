package first.client.mapmaker.areasections.firstareasection.areas;

public record TileWithinChunkCoordinates(float x, float y, float z) {
//this is for simplifying the storage of tile coordinates within a chunk
//these are the coordinates relative to the chunk origin point
//not the world coordinates
//each chunk has its own origin point at (0,0,0)
//and each chunk is 16x18 in terms of tiles

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
