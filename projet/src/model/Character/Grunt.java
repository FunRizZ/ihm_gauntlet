package model.Character;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item.Item;
import model.Item.Potion;
import model.Location.Wall;

public class Grunt extends WhoFight{
    public final static int DEFAULT_HP = 250;
    public final static int DEFAULT_ARMOR = 10;
    public final static int DEFAULT_DAMAGE = 200;

    public Grunt(int x, int y){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE,createItem(), x, y);
    }
    private static List<Item> createItem(){
    	List<Item> lst = new ArrayList<Item>();
    	lst.add((Item)new Potion());
    	return lst;
    }
    @Override
    public String getDescription() {
    	return "A grunt.";
    }
    @Override
    public String toString() {
    	return "Grunt";
    }
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/grunt.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(320, 0, 80, 80));
        return view;
    }

}