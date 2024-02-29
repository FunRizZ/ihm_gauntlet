package model.Item;

import model.Character.hero.Hero;

public class PoisonPotion extends Item{
    public static final int DAMAGE = 200;

    @Override
    public String toString() {
        return "Poison";
    }
    @Override
    public void use(Hero h) {
        System.out.println("Poison used in "+ h.getLocation().NAME + "\n");
        h.reduceHp(DAMAGE);
    }
}
