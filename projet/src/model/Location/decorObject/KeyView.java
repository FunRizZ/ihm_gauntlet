package model.Location.decorObject;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item.key;

public class KeyView extends DecorObjet {
	public KeyView(int x, int y) {
		super(new key(), x, y);
	}
	
    public String getDescription() {
    	return "Key";
    }
    public String toString() {
    	return "Key";
    }

	@Override
	public ImageView getSpray(){
		Image spray = (new Image(Wall.class.getResource("/sprites/key.png").toExternalForm()));
		ImageView view = new ImageView(spray);
		view.setViewport(new Rectangle2D(0, 0, 80, 80));
		return view;
	}
}

