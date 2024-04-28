package model.location.decorObject;

import model.character.hero.Hero;
import model.game_pack.Useable;
import model.item.Item;

public class Carcass extends DecorObjet implements Useable {
	public Carcass(Item i, int x, int y) {
		super(i, x, y);
	}
	@Override
    public String getDescription() {
    	return "A carcass, lying in stark stillness, bores the weight of mortality.";
    }
	@Override
    public String toString() {
    	return "Carcass";
    }
	@Override
	public void use(Hero h) {
		this.item.use(h);
		h.getLocation().removeDecorObjet(this);

	}
}
