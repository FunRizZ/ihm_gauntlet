package Item;

import Character.Hero;

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
		System.out.println("the hero equip " + this + "\n");
		h.setShield(this);
		h.remove(this);
	}
}
