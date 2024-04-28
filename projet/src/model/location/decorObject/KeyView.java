package model.location.decorObject;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.character.hero.Hero;
import model.game_pack.Useable;
import model.item.key;

public class KeyView extends DecorObjet implements Useable {
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
	@Override
	public void use(Hero h) {
		h.addItem(item);
		item = null;
		h.getLocation().removeDecorObjet(this);
	}
}

