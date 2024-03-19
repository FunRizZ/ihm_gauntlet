package model.character.monster;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.character.WhoFight;
import model.item.Item;
import model.item.Treasure;
import model.location.decorObject.Wall;

public class Daemon extends WhoFight {
    public final static int DEFAULT_HP = 500;
    public final static int DEFAULT_ARMOR = 150;
    public final static int DEFAULT_DAMAGE = 200;

    public Daemon(int x, int y){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE,3,1,createItem(), x, y);
    }
    private static List<Item> createItem(){
    	List<Item> lst = new ArrayList<Item>();
    	lst.add((Item)new Treasure());
    	return lst;
    }
    @Override
    public String getDescription() {
    	return "A daemon from Hell.";
    }
    @Override
    public String toString() {
    	return "Daemon";
    }
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/daemon.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(320, 0, 80, 80));
        return view;
    }

}
