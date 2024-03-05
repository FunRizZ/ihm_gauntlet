package model.item;

import model.character.hero.Hero;

public abstract class Shield extends Item{
	private final int PROTECTION;
    
    public Shield(int armor) {
    	this.PROTECTION = armor;
    }
    public int getProtection() {
    	return this.PROTECTION;
    }
	@Override
	public void use(Hero h) {
		System.out.println("The hero equips " + this + "\n");
		h.setShield(this);
		h.remove(this);
	}
}
