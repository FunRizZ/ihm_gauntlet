package model.Location;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item.Food;
import model.Item.Item;
import model.Item.HealPotion;

public class FoodView extends DecorObjet{
    public FoodView(int x, int y) {
        super((Item)new Food(), x, y);
    }

    public String getDescription() {
        return "A meal.";
    }
    public String toString() {
        return "Food";
    }

    @Override
    public ImageView getSpray(){
        Image spray = (new Image(Wall.class.getResource("/sprites/food.png").toExternalForm()));
        ImageView view = new ImageView(spray);
        view.setViewport(new Rectangle2D(0, 0, 80, 80));
        return view;
    }
}

