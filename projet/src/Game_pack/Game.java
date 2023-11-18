package Game_pack;
import java.util.ArrayList;
import java.util.List;

import Character.Character;
import Character.Hero;
import Character.Dragon;
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

        Location l = game.locations.get(0);
        Location l_out = game.creatLocation(LocationName.ROOM_WITH_TREASURE);
        l.addNeighbor(l_out, new Exit(l_out));
        Character Drag = new Dragon();
        l.addCharacter(Drag);
        
        System.out.println(game.HERO.getLocation());

        game.HERO.goLocation(l_out);

    }
}
