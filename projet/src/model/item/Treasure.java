package model.item;

import model.character.hero.Hero;

public class Treasure extends Item{
	@Override
	public String toString() {
		return "Treasure";
	}
	@Override
	public void use(Hero h) {
		System.out.println("You look a beautiful treasure and take it.");
	}
}