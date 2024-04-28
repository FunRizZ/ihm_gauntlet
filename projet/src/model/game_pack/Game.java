package model.game_pack;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import apps.setting.JsonSetting;
import model.character.Character;
import model.character.Direction;
import model.character.WhoFight;
import model.character.hero.Hero;
import model.character.hero.Warrior;
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
        return this.HEROS.get(0);
    }

    /**
     * @param other the piece who you want to compare
     * @return the closest hero alive or null
     */
    public Hero getTheClosestHero(Lookable other){
        double distanceMin = Double.MAX_VALUE;
        Hero closestHero = null;
        for (Hero hero : this.HEROS){
            if (hero.getDistance(other) < distanceMin && !hero.isDead()){
                distanceMin =  hero.getDistance(other);
                closestHero = hero;
            }
        }
        return closestHero;
    }
    /**
     * @param other the piece who you want to compare
     * @return the closest alive and not a hero or null
     */
    public WhoFight getTheClosest(List<Character> list, Lookable other){
        double distanceMin = Double.MAX_VALUE;
        WhoFight closest = null;
        for (Character character : list) {
            if (character instanceof WhoFight && !(character instanceof Hero)) {
                if (character.getDistance(other) < distanceMin && !((WhoFight) character).isDead()) {
                    distanceMin = character.getDistance(other);
                    closest = (WhoFight) character;
                }
            }
        }
        return closest;
    }
    /**
     * @param other the piece who you want to compare
     * @return the closest alive and not a hero or null
     */
    public Useable getTheClosestUsable(List<Lookable> list, Lookable other){
        double distanceMin = Double.MAX_VALUE;
        Useable closest = null;
        for (Lookable useable : list) {
            if (useable instanceof Useable) {
                if (useable.getDistance(other) < distanceMin) {
                    distanceMin = useable.getDistance(other);
                    closest = (Useable) useable;
                }
            }
        }
        return closest;
    }
    /**
     * all the characters fight againt the HERO or move. The HERO don't attack himself
     * @return true if some hero are alive else false
     */
    public boolean attackHero(){
        for (Character character : this.getMainHero().getLocation().getCharacters()){
            Hero hero = getTheClosestHero(character);

            if (hero == null){ return false;}
            if (character instanceof WhoFight && !(character instanceof Hero)){
                if (!((WhoFight) character).fight(hero) && !(character instanceof Spawner)){
                    character.direction = Direction.values()[new Random().nextInt(4)];
                    hero.getLocation().move(character);
                    ((WhoFight)character).reset_attack_speed();
                }
            }
        }
        return true;
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
            changeLocation(this.location);
        }catch (Exception e){
            System.err.println(e.getMessage());
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
            Hero hero =  new Warrior(this.location,JsonSetting.getSetting(0),spawnX,spawnY);

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
        h.setLocation(this.location);
    }
}
