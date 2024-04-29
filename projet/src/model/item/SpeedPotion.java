package model.item;

import model.character.hero.Hero;

public class SpeedPotion extends Item{
    public static final int RANGE = 20;

    @Override
    public String toString() {
        return "Speed";
    }
    @Override
    public void use(Hero h) {
        System.out.println("Speed used in "+ h.getLocation().NAME + "\n");
        h.changeAttackSpeed();
    }
}
