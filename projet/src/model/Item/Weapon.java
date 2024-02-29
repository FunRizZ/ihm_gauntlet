package model.Item;

import model.Character.hero.Hero;

public abstract class Weapon extends Item{
	private final int DAMAGE;
    
    public Weapon(int dmg) {
    	this.DAMAGE = dmg;
    }
    public int getDamage() {
    	return this.DAMAGE;
    }
	@Override
	public void use(Hero h) {
		System.out.println("The hero equips " + this + "\n");
		h.setWeapon(this);
		h.remove(this);
	}
}
