package model.Item;

import model.Character.hero.Hero;

public class DefensePotion extends Item{
    public static final int Defense = 100;
    
    @Override
	public String toString() {
		return "Defense_Potion";
	}
	@Override
	public void use(Hero h) {
		System.out.println("Potion used in "+ h.getLocation().NAME + "\n");
        h.addDefense(Defense);
	}
}
