package model.Location;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item.Item;
import model.Item.Treasure;

public class TreasureView extends DecorObjet{
	public TreasureView(int x, int y) {
		super((Item)new Treasure(), x, y);
	}
	
    public String getDescription() {
    	return "A luxurious painting, a masterpiece on canvas, boasted a rich tapestry of colors.";
    }
    public String toString() {
    	return "Painting";
    }
}

