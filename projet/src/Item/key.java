package Item;

import Character.Hero;

public class key extends Item{
	@Override
	public String toString() {
		return "key";
	}
	@Override
	public void use(Hero h) {
		System.out.println("key used in "+ h.getLocation().NAME + "\n");
	}
}
