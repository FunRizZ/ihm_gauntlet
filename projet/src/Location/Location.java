package Location;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Character.Character;

public class Location {
    public final LocationName NAME;
    private Map<Location,Exit> neighbor;
    private List<Character> characters;
    private List<DecorObjet> decorObjets;

    public Location(Map<Location,Exit> neighbor, List<Character> characters, List<DecorObjet> decorObjets, LocationName name){
        this.NAME = name;
        this.neighbor = neighbor;
        this.characters = characters;
        this.decorObjets = decorObjets;
    }

    /**
     * creat a empty Location with name : name
     */
    public Location(LocationName name){
        this(null,null,null,name);
    }

    public List<Location> getNeighbor() {
        List<Location> locations = new ArrayList<Location>();
        Set<Location> keys = this.neighbor.keySet();
        Object[] tab = keys.toArray();
        for(int i = 0; i< tab.length; i++){
            locations.add((Location)tab[i]);
        }
        return locations;
    }

    public List<Exit> getExits() {
    	if (this.neighbor == null) {return null;}
        List<Exit> exits = new ArrayList<Exit>();
        Collection<Exit> val = this.neighbor.values();
        Object[] tab = val.toArray();
        for(int i = 0; i< tab.length; i++){
            exits.add((Exit)tab[i]);
        }
        return exits;
    }
    /**
     * @param location to go to
     * @return null if no exit found else exit found
     */
    public Exit getExit(Location location){
        if (this.neighbor == null) return null;
        else return this.neighbor.get(location);
    }

    public void addCharacter(Character character){
        if (this.characters == null){
            this.characters = new ArrayList<Character>();
        }
        this.characters.add(character);
    }
    public void addNeighbor(Location location,Exit exit){
        if (this.neighbor == null){
            this.neighbor = new HashMap<Location,Exit>();
        }
        this.neighbor.put(location,exit);
    }

    @Override
    public String toString(){
        String description = "you are in the "+ this.NAME +" \n\n";
        String strExits = "They have no issue";
        List<Exit> exits = this.getExits();
        if ( exits!= null){
            strExits  = "In this room you have those exits :\n";
            for(Exit exit : exits){
                strExits += "\t" + exit + "\n";
            }
        }
        String strCharacters = "";
        if (this.characters != null){
            strCharacters  = "in this room you have :\n";
            for(Character character : this.characters){
                strCharacters += "\t" + character + "\n";
            }
        }
        String strDecorObjets = "";
        if (this.decorObjets != null){
            strDecorObjets  = "in this room you can see:\n";
            for(DecorObjet decorObjet : this.decorObjets){
                strCharacters += "\t" + decorObjet + "\n";
            }
        }

        return description + strExits + strCharacters + strDecorObjets;
    }

}
