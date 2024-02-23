package model.Item;

import model.Character.Hero;

public class HealPotion extends Item{
    public static final int HEAL = 500;
    
    @Override
	public String toString() {
		return "Potion";
	}
	@Override
	public void use(Hero h) {
		System.out.println("Potion used in "+ h.getLocation().NAME + "\n");
        h.addHp(HEAL);
	}
}
