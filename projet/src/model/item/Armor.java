package model.item;

import model.character.hero.Hero;

public abstract class Armor extends Item{
    private final int ARMOR;
    
    public Armor(int armor) {
    	this.ARMOR = armor;
    }
    public int getArmor() {
    	return this.ARMOR;
    }
	@Override
	public void use(Hero h) {
		System.out.println("The hero equips " + this + "\n");
		h.setArmor(this);
		h.removeItem(this);
	}		
}
