package model.Game_pack;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;

import apps.setting.JsonSetting;
import model.Item.Item;
import model.Character.Hero;
import model.Character.Character;
import model.Location.Exit;
import model.Location.Location;
import model.Character.WhoFight;
import model.Location.LocationName;

public class Game {
    public final static Game GAME = new Game(100,10);
    public final Hero HERO;
    private List<Location> locations;
    //private final Command cmd;
    public final int SIZE_MAP_X;
    public final int SIZE_MAP_y;
    private Game(int sizeMapX, int sizeMapY){
        locations = new ArrayList<Location>();
        try {
            locations.addFirst(new Location("a"));
        }catch (FileNotFoundException e){
            System.out.println("file not found");
            locations.addFirst(this.createLocation(LocationName.GARDEN,sizeMapX,sizeMapY));
        }
        this.HERO = new Hero(locations.getFirst(),JsonSetting.getSetting(0),0,0);

        Location l = locations.getFirst();
        Location l2 = new Location(sizeMapX, sizeMapY, LocationName.HALLWAY);
        Exit e = new Exit(l2,10,9);
        l.addNeighbor(e);
        l.addCharacter((Character) this.HERO);
        this.SIZE_MAP_X = sizeMapX;
        this.SIZE_MAP_y = sizeMapY;
    }

    public Location createLocation(LocationName locationName,int sizeX, int sizeY){
        Location location = new Location(sizeX,sizeY,locationName);
        this.locations.add(location);
        return location;
    }

    /**
     * all the characters fight againt the HERO. The HERO don't attacks himself
     */
    public void attackHero(){
        Location locationH = this.HERO.getLocation();
        try{
            for (Character c : locationH.getCharacters()) {
                if (c instanceof WhoFight){
                    ((WhoFight)c).fight(this.HERO);
                    System.out.println(c + " hit the hero");
                }
            }
        }catch(NullPointerException e){}
    }
    /**
     * @return true if the hero has the treasure else false
     */
    public boolean treasureIsGet(){
        boolean res = false;
        try{
            for (Item i : this.HERO.getItems()) {
                if(i.isMe("Treasure")){res = true;}
            }
        }catch(NullPointerException e){}
        return res;
    }
}
