package model.item;

import model.character.hero.Hero;
import model.character.hero.Valkyrie;
import model.character.hero.Wizard;

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
