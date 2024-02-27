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
import model.Location.Spawn;

public class Game {
    public final static Game GAME = new Game(100,10, 1);
    public final int NB_HERO;
    public final List<Hero> HEROS;
    private Location location;
    //private final Command cmd;
    public final int SIZE_MAP_X;
    public final int SIZE_MAP_y;
    private Game(int sizeMapX, int sizeMapY, int nbHero){
        this.NB_HERO = nbHero;
        this.HEROS = new ArrayList<>(nbHero);

        try {
            this.location = new Location("./save/locations/GARDEN.json a");

        }catch (Exception error){
            System.out.println("file not found");

            Spawn spawn1 = new Spawn(2,2);
            List<Spawn> sp = new ArrayList<>(2);
            sp.add(spawn1);

            this.location = this.createLocation(LocationName.GARDEN,sizeMapX,sizeMapY);

            Location l2 = new Location(sizeMapX, sizeMapY, LocationName.HALLWAY,sp);
            Exit e = new Exit(l2,10,9);
            this.location.addNeighbor(e);

        }
        //ajout des heros
        for (int i = 0; i< nbHero; i++){
            this.HEROS.add( new Hero(this.location,JsonSetting.getSetting(0),0,0));
            this.location.addCharacter(this.HEROS.get(i));
        }

        this.SIZE_MAP_X = sizeMapX;
        this.SIZE_MAP_y = sizeMapY;
    }

    public Location createLocation(LocationName locationName,int sizeX, int sizeY){
        Spawn spawn1 = new Spawn(1,1);
        Spawn spawn2 = new Spawn(2,2);
        Spawn spawn3 = new Spawn(3,1);
        Spawn spawn4 = new Spawn(4,2);
        List<Spawn> sp = new ArrayList<>(2);
        sp.add(spawn1);
        sp.add(spawn2);
        sp.add(spawn3);
        sp.add(spawn4);
        Location location = new Location(sizeX,sizeY,locationName,sp);
        return location;
    }

    public Hero getMainHero(){
        return this.HEROS.getFirst();
    }

    /**
     * all the characters fight againt the HERO. The HERO don't attacks himself
     */
    public void attackHero(){
    }

    public boolean Load(String path){
        try {
            this.location = new Location(path);
        }catch (Exception e){
            return false;
        }
        for (Hero hero : this.HEROS) {
            hero.setLocation(this.location);
            hero.setPosX(this.location.SPAWNS.getFirst().getPosX());
            hero.setPosY(this.location.SPAWNS.getFirst().getPosY());
        }
        return true;
    }
}
