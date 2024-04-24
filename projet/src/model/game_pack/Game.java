package model.game_pack;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import apps.setting.JsonSetting;
import model.character.Character;
import model.character.Direction;
import model.character.WhoFight;
import model.character.hero.Hero;
import model.character.monster.Spawner;
import model.location.Location;
import model.location.LocationName;
import model.location.decorObject.Spawn;

public class Game {
    public final static Game GAME = new Game(15,8, 1);
    public int NB_HERO;
    public final List<Hero> HEROS;
    private Location location;
    //private final Command cmd;
    public final int SIZE_MAP_X;
    public final int SIZE_MAP_y;
    public boolean defaultHero;
    private Game(int sizeMapX, int sizeMapY, int nbHero){
        this.NB_HERO = nbHero;
        this.HEROS = new ArrayList<>(nbHero);
        this.SIZE_MAP_X = sizeMapX;
        this.SIZE_MAP_y = sizeMapY;
        defaultHero = true;
        reset();
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
    public Hero getTheClosestHero(Lookable other){
        int distanceMin = Integer.MAX_VALUE;
        Hero closestHero = null;
        for (Hero hero : this.HEROS){
            if (hero.getDistance(other) < distanceMin){
                distanceMin = (int) hero.getDistance(other);
                closestHero = hero;
            }
        }
        return closestHero;
    }
    /**
     * all the characters fight againt the HERO or move. The HERO don't attacks himself
     */
    public void attackHero(){
        for (Character character : this.getMainHero().getLocation().getCharacters()){
            Hero hero = getTheClosestHero(character);
            if (character instanceof WhoFight && !(character instanceof Hero)){
                if (!((WhoFight) character).fight(hero) && !(character instanceof Spawner)){
                    character.direction = Direction.values()[new Random().nextInt(4)];
                    hero.getLocation().move(character);
                }
            }
        }
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
    public void reset(){
        this.HEROS.clear();

        this.location = createLocation(LocationName.GARDEN, this.SIZE_MAP_X, this.SIZE_MAP_y);
        //ajout des heros
        for (int i = 0; i< this.NB_HERO; i++){
            int spawnX = this.location.SPAWNS.get(i).getPosX();
            int spawnY = this.location.SPAWNS.get(i).getPosY();
            Hero hero =  new Hero(this.location,JsonSetting.getSetting(0),spawnX,spawnY);

            this.HEROS.add(hero);
            this.location.addCharacter(hero);
        }
    }
    public void addHero(Hero h){
        if(this.NB_HERO == 1 && this.defaultHero){
            this.defaultHero = false;
            this.location.removeCharacter(this.HEROS.getFirst());
            this.HEROS.removeFirst();
            this.NB_HERO--;
            this.location = h.getLocation();
        }
        this.NB_HERO++;
        this.HEROS.add(h);
        this.location.addCharacter(h);
    }
}
