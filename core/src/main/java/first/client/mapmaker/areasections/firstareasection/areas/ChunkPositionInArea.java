package first.client.mapmaker.areasections.firstareasection.areas;

public record ChunkPositionInArea(float xPosition, float yPosition, float zPosition) {

    public Float getXPosition() {
        return xPosition;
    }
    public Float getYPosition() {
        return yPosition;
    }

    public Float getZPosition() {
        return zPosition;
    }


}
