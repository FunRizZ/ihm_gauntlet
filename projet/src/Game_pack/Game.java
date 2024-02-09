package Game_pack;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import Character.Character;
import Item.Item;
import Character.*;
import Location.*;

public class Game {
    public final Hero HERO;
    private List<Location> locations;
    private final Command cmd;

    public Game(){
        this.HERO = new Hero(locations.get(0),0,0);
        this.cmd = new Command(this);
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
