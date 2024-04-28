package model.location.decorObject;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.character.hero.Hero;
import model.game_pack.Useable;
import model.item.Treasure;

public class TreasureView extends DecorObjet implements Useable {
	public TreasureView(int x, int y) {
		super(new Treasure(), x, y);
	}
	
    public String getDescription() {
    	return "The treasure gleams with an otherworldly allure, its brilliance rivaling the sun's radiance.";
    }
    public String toString() {
    	return "Treasure";
    }

	@Override
	public ImageView getSpray(){
		Image spray = (new Image(Wall.class.getResource("/sprites/treasure.png").toExternalForm()));
		ImageView view = new ImageView(spray);
		view.setViewport(new Rectangle2D(0, 0, 80, 80));
		return view;
	}
	@Override
	public void use(Hero h) {
		this.item.use(h);
		h.getLocation().removeDecorObjet(this);
	}
}

