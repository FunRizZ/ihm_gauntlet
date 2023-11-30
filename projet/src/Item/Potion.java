package Item;

import Character.Hero;

public class Potion extends Item{
    public static final int HEAL = 200;
    
    @Override
	public String toString() {
		return "Potion";
	}
	@Override
	public void use(Hero h) {
		System.out.println("potion used in "+ h.getLocation().NAME + "\n");
        h.addHp(HEAL);
	}
}
