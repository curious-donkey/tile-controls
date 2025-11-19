package first.client.mapmaker;

public record LocationRecord(String sectionName, String areaName, String chunkName, String topNodeName) {
//this record is for storing location data
//it will be used for storing location data in the game world
//I will need to have a set of name attributes for each location in a chunk
//that way I can query them without headache
    
//this is for usage with the stream api
    





    public String getSectionName() {
        return sectionName;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getChunkName() {
        return chunkName;
    }

    public String getTopNodeName() {
        return topNodeName;
    }

}
