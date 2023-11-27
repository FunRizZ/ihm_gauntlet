package Item;

import Character.Hero;

public class Treasure extends Item{
	@Override
	public String toString() {
		return "Treasure";
	}
	@Override
	public void use(Hero h) {
		System.out.println("you look the beautiful treasure");
	}
}
