import java.util.ArrayList;
import java.util.List;

import Character.*;
import Location.*;

public class Game {
    private final Hero HERO;
    private List<Location> locations;

    public Game(){
        this.locations = new ArrayList<Location>();

        Location start = new Location(LocationName.GARDEN);
        this.locations.add(start);
        this.HERO = new Hero(locations.get(0));
    }

    public Location creatLocation(LocationName locationName){
        Location location = new Location(locationName);
        this.locations.add(location);
        return location;
    }
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        System.out.println(game.HERO.getLocation());

        Location l = game.locations.get(0);
        Location l_out = game.creatLocation(LocationName.ROOM_WITH_TREASURE);
        l.addExit(new Exit(l, l_out));

        game.HERO.goLocation(l_out);

    }
}
