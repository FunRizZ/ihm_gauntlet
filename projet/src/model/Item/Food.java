package model.Item;

import model.Character.Hero;

public class Food extends Item{
    public static final int HEAL = 200;

    @Override
    public String toString() {
        return "Food";
    }
    @Override
    public void use(Hero h) {
        System.out.println("Food used in "+ h.getLocation().NAME + "\n");
        h.addHp(HEAL);
    }
}
