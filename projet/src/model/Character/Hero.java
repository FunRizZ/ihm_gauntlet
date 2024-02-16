package model.Character;


import model.Location.Exit;
import model.Location.Location;

import java.util.List;

import model.Item.Item;
import model.Location.Carcass;
import model.Location.DecorObjet;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero extends WhoFight{
    public final static int DEFAULT_HP = 1000;
    public final static int DEFAULT_ARMOR = 50;
    public final static int DEFAULT_DAMAGE = 200;

    private Location location;

    public Hero(Location location, int x, int y){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE, x, y);
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void fight(WhoFight enemy){
    	System.out.println("HERO hit with " + this.getDamage() + " damage");
        enemy.reduceHp(this.getDamage());
        System.out.println("HERO hit the " + enemy);
        System.out.println(enemy + " have : "+ enemy.getHp() +" hp");
        if (enemy.isDead()) {
        	System.out.println("HERO kill the "+ enemy);
        	List<Item> items = enemy.getItems();
        	if (items != null) {
        		DecorObjet obj = new Carcass(items.get(0), enemy.getPosX(), enemy.getPosY());
        		this.location.addDecorObjet(obj);
        	}
        	else {
        		DecorObjet obj = new Carcass(enemy.getPosX(), enemy.getPosY());
        		this.location.addDecorObjet(obj);
        	}
        this.location.removeCharacter(enemy);	
        }
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

    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Hero.class.getResource("/sprites/elf.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(0, 0, 80, 80));
        return view;
    }
}
