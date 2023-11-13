package Location;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public final LocationName NAME;
    private List<Location> neighbor;
    private List<Exit> exits;
    private List<Character> characters;
    private List<DecorObjet> decorObjets;

    public Location(List<Location> neighbor, List<Exit> exits, List<Character> characters, List<DecorObjet> decorObjets, LocationName name){
        this.NAME = name;
        this.neighbor = neighbor;
        this.exits = exits;
        this.characters = characters;
        this.decorObjets = decorObjets;
    }

    /**
     * creat a empty Location with name : name
     */
    public Location(LocationName name){
        this(null,null,null,null,name);
    }

    public List<Location> getNeighbor() {
        return this.neighbor;
    }

    public void addCharacter(Character character){
        if (this.characters == null){
            this.characters = new ArrayList<Character>();
        }
        this.characters.add(character);
    }
    public void addNeighbor(Location location){
        if (this.neighbor == null){
            this.neighbor = new ArrayList<Location>();
        }
        this.neighbor.add(location);
    }
    public void addExit(Exit exit){
        if (this.exits == null){
            this.exits = new ArrayList<Exit>();
        }
        this.exits.add(exit);
        this.addNeighbor(exit.EXIT_LOCATION);
    }

    @Override
    public String toString(){
        String description = "you are in the "+ this.NAME +" \n\n";
        String strExits = "They have no issue";
        if (this.exits != null){
            strExits  = "In this room you have those exits :\n";
            for(Exit exit : this.exits){
                strExits += "\t" + exit + "\n";
            }
        }
        String strCharacters = "";
        if (this.characters != null){
            strCharacters  = "in this room you have :\n";
            for(Exit exit : this.exits){
                strCharacters += "\t" + exit + "\n";
            }
        }
        String strDecorObjets = "";
        if (this.decorObjets != null){
            strCharacters  = "in this room you can see:\n";
            for(Exit exit : this.exits){
                strCharacters += "\t" + exit + "\n";
            }
        }

        return description + strExits + strCharacters + strDecorObjets;
    }

}
