package model.Location.decorObject;

import model.Game_pack.IsMe;
import model.Game_pack.Lookable;
import model.Item.Item;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class DecorObjet extends Lookable implements IsMe{
    public Item item;
    
    public DecorObjet(Item item, int x, int y) {
    	super(x, y);
        this.item = item;
    }
    public DecorObjet(int x, int y) {
    	this(null, x, y);
    }
    public Item take() {
    	Item i = this.item;
    	this.item = null;
    	return i;
    }
    public void look(){
        String dest = this.getDescription() + "\n\t";
        if (this.item != null) {dest += "with "+ this.item;}
        System.out.println(dest);
    }
    public abstract String toString();
    public abstract String getDescription();

    @Override
    public ImageView getSpray() {
        Image spray = new Image(DecorObjet.class.getResource("/sprites/food.png").toExternalForm());
        return new ImageView(spray);
    }
}
