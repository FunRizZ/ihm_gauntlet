import java.util.ArrayList;
import java.util.List;

import Character.*;
import Location.*;

public class Game {
    private final Hero HERO;
    private List<Location> locations;

    public Game(){
        this.HERO = new Hero();
        this.locations = new ArrayList<Location>();

        Location start = new Location(LocationName.GARDEN);
        this.locations.add(start);
    }
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        System.out.println(game.locations);

        Location l = game.locations.get(0);
        Location l_out = new Location(LocationName.ROOM_WITH_TREASURE);
        l.addExit(new Exit(l, l_out));

        System.out.println(game.locations);
    }
}
