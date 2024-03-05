package model.game_pack;
import java.util.ArrayList;

import java.util.List;

import apps.setting.JsonSetting;
import model.character.hero.Hero;
import model.location.Location;
import model.location.LocationName;
import model.location.decorObject.Spawn;

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

        this.location = createLocation(LocationName.GARDEN, sizeMapX, sizeMapY);
        //ajout des heros
        for (int i = 0; i< nbHero; i++){
            int spawnX = this.location.SPAWNS.get(i).getPosX();
            int spawnY = this.location.SPAWNS.get(i).getPosY();
            Hero hero =  new Hero(this.location,JsonSetting.getSetting(0),spawnX,spawnY);

            this.HEROS.add(hero);
            this.location.addCharacter(hero);
        }

        this.SIZE_MAP_X = sizeMapX;
        this.SIZE_MAP_y = sizeMapY;
    }

    public Location createLocation(LocationName locationName,int sizeX, int sizeY){
        List<Spawn> sp = new ArrayList<>(4);
        Spawn spawn1 = new Spawn(1,1);
        Spawn spawn2 = new Spawn(2,1);
        Spawn spawn3 = new Spawn(3,1);
        Spawn spawn4 = new Spawn(4,1);
        sp.add(spawn1);
        sp.add(spawn2);
        sp.add(spawn3);
        sp.add(spawn4);
        Location location = new Location(sizeX,sizeY,locationName,sp);
        location.resetBoard();
        location.spawn();
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
    public void changeLocation(Location location){
        this.location = location;
        for (int i =  0 ; i < this.NB_HERO; i++) {
            Hero hero = this.HEROS.get(i);
            hero.setLocation(this.location);
            hero.setPosX(this.location.SPAWNS.get(i).getPosX());
            hero.setPosY(this.location.SPAWNS.get(i).getPosY());
            this.location.addCharacter(hero);
        }
    }
    public boolean Load(String path){
        try {
            this.location = new Location(path);
            location.loadJson(path);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        changeLocation(this.location);
        return true;
    }
}
