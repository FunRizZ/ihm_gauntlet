package model.item;

import model.character.hero.Hero;

public class HealPotion extends Item{
    public static final int HEAL = 500;
    
    @Override
	public String toString() {
		return "Heal_Potion";
	}
	@Override
	public void use(Hero h) {
		System.out.println("Potion used in "+ h.getLocation().NAME + "\n");
        h.addHp(HEAL);
	}
}
