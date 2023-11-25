package Game_pack;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import Character.Character;
import Character.*;
import Location.*;

public class Game {
    public final Hero HERO;
    private List<Location> locations;
    private final Command cmd;

    public Game(){
        generateMap();
        this.HERO = new Hero(locations.get(0));
        this.cmd = new Command(this);
    }

    public Location creatLocation(LocationName locationName){
        Location location = new Location(locationName);
        this.locations.add(location);
        return location;
    }

    /**
     * genere the map, store in this.locations. The first Location is GARDEN
     */
    public void generateMap(){
        this.locations = new ArrayList<Location>();

        Location start = new Location(LocationName.GARDEN);
        this.locations.add(start);
        
        Location l_out = this.creatLocation(LocationName.ROOM_WITH_TREASURE);
        start.addNeighbor(l_out, new Exit(l_out));
        Character Drag = new Dragon();
        start.addCharacter(Drag);
        Character knight = new Knight();
        start.addCharacter(knight);
    }


    public static void main(String[] args) throws Exception {
        Game game = new Game();
        
        System.out.println(game.HERO.getLocation());
		
        Scanner scanner = new Scanner( System.in ); 
        boolean res = true;
        while(res) {
            res = game.cmd.read(scanner);
        }
        scanner.close();
    }
}
