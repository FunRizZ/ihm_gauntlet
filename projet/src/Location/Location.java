package Location;

import java.util.List;

public class Location {
    private LocationName NAME;
    private List<Location> neighbor;
    private List<Exit> exits;

    public Location(List<Location> neighbor, List<Exit> exits, LocationName name){}
}
