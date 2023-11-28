package Item;

import Character.Hero;
import Location.Location;

public class Map extends Item{
	@Override
	public String toString() {
		return "Map";
	}
	@Override
	public void use(Hero h) {
		Location locationH = h.getLocation();
		String dest = "you are in "+ locationH.NAME.toString() + "\n";
		try {
			for(Location l : locationH.getNeighbor()) { // location 1 degree
				if( !l.getNeighbor().isEmpty()){ //location 2 degree
					dest += "after "+ l.NAME.toString() +", you have\n\t";
					for(Location l2 : l.getNeighbor()) { 
						dest += l2.NAME.toString()+ "\n\t";
					}
				}else {
					dest += "after "+ l.NAME.toString() +", you don't have other room\n";
				}
			}
		}
		finally {
			System.out.println(dest);
			System.out.println("map used\n");
		}
	}
}
