package model.character.hero;


import model.character.WhoFight;
import model.item.key;
import model.location.Exit;
import model.location.Location;

import java.util.ArrayList;
import java.util.List;

import apps.setting.SettingPersonnage;
import model.item.Item;
import model.location.decorObject.Carcass;
import model.location.decorObject.DecorObjet;
import javafx.scene.input.KeyCode;

public abstract class Hero extends WhoFight {
    public final static int DEFAULT_HP = 1000;
    public final static int DEFAULT_ARMOR = 50;
    public final static int DEFAULT_DAMAGE = 200;
    public final static int level = 0;
    public final static int DEFAULT_RANGE = 10;
    public final static int DEFAULT_ATTACK_SPEED = 100;
    public static int attack_speed = DEFAULT_ATTACK_SPEED;

    private Location location;
    private SettingPersonnage setting;

    public Hero(Location location, SettingPersonnage setting, int x, int y){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE,level,DEFAULT_RANGE, x, y);
        this.location = location;
        this.setting = setting;
    }

    public Hero(Location location, SettingPersonnage setting, int x, int y, int hp, int armor, int damage, int range){
        super(hp, armor, damage,range,level, x, y);
        this.location = location;
        this.setting = setting;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;

    }

    @Override
    public boolean fight(WhoFight enemy){
        if (attack_speed <= 0){
            if(this.getDistance(enemy) < this.getRange()) {
                attack_speed = DEFAULT_ATTACK_SPEED;
                System.out.println("HERO hit with " + this.getDamage() + " damage");
                enemy.reduceHp(this.getDamage());
                System.out.println("HERO hit the " + enemy);
                System.out.println(enemy + " have : " + enemy.getHp() + " hp");
                if (enemy.isDead()) {
                    System.out.println("HERO kill the " + enemy);
                    this.location.removeCharacter(enemy);
                    List<Item> items = enemy.getItems();
                    if (items != null) {
                        DecorObjet obj = new Carcass(items.get(0), enemy.getPosX(), enemy.getPosY());
                        this.location.addDecorObjet(obj);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean goLocation(Location location) {
        // exit recovery
        Exit exit = this.location.getExit(location);

        if( exit != null){
            if (exit.go(location)){
                System.out.println("You go in " + location.NAME + "\n");
                System.out.println(location);
                this.location = location;
                return true;
            }
        }
        System.out.println("You stay in the room \n");
        return false;
    }
    @Override
    public String getDescription() {
    	return "The Hero is in "+ this.location.NAME + ". He is in travel to found the long-lost treasure hidden in this castel.";
    }
    public String toString() {
    	return "HERO";
    }
    public int getNbKeys(){
        int nbKeys = 0;
        if (this.getItems() == null){ return 0;}
        for ( Item item: this.getItems()){
            if (item instanceof key){
                nbKeys++;
            }
        }
        return nbKeys;
    }
    public List<Item> getKeys(){
        List<Item> keys = new ArrayList<>();
        if (this.getItems() == null){ return null;}
        for ( Item item: this.getItems()){
            if (item instanceof key){
                keys.add(item);
            }
        }
        return keys;
    }
    public String getKeyString(KeyCode Key) {
        return setting.getKeyString(Key);
    }

    public void changeAttackSpeed(){
        if (attack_speed > 0){
            attack_speed -= 100;
        }
    }
}