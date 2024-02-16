package model.Character;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item.Item;
import model.Item.Treasure;
import model.Location.Wall;

public class Death extends WhoFight{
    public final static int DEFAULT_HP = 1000;
    public final static int DEFAULT_ARMOR = 150;
    public final static int DEFAULT_DAMAGE = 200;

    public Death(int x, int y){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE,createItem(), x, y);
    }
    private static List<Item> createItem(){
        List<Item> lst = new ArrayList<Item>();
        lst.add((Item)new Treasure());
        return lst;
    }
    @Override
    public String getDescription() {
        return "Death is angry.";
    }
    @Override
    public String toString() {
        return "Death";
    }
    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/death.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(0, 0, 80, 80));
        return view;
    }

}
