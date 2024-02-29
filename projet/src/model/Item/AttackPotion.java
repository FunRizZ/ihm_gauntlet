package model.Item;

import model.Character.hero.Hero;

public class AttackPotion extends Item{
    public static final double ATTACK = 1.2;
    
    @Override
	public String toString() {
		return "Attack_Potion";
	}
	@Override
	public void use(Hero h) {
		System.out.println("Potion used in "+ h.getLocation().NAME + "\n");
        h.addAttack(ATTACK);
	}
}
