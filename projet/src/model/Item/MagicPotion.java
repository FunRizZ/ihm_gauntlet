package model.Item;

import model.Character.hero.Hero;
import model.Character.hero.Valkyrie;
import model.Character.hero.Wizard;

public class MagicPotion extends Item{
    public static final double ATTACK = 1.2;
    
    @Override
	public String toString() {
		return "Attack_Potion";
	}
	@Override
	public void use(Hero h) {
		System.out.println("Potion used in "+ h.getLocation().NAME + "\n");
		if( h instanceof Wizard || h instanceof Valkyrie){
			h.addAttack(ATTACK);
		}
	}
}
