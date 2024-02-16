package model.Location;


import javafx.geometry.Rectangle2D;
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

	@Override
	public ImageView getSpray(){
		Image spray = (new Image(Wall.class.getResource("/sprites/treasure.png").toExternalForm()));
		ImageView view = new ImageView(spray);
		view.setViewport(new Rectangle2D(0, 0, 80, 80));
		return view;
	}
}

