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
			for(Location l : locationH.getNeighbor()) {
				if (l != null) {
					dest += "after "+ l.NAME.toString() +", you have\n\t";
					if(l.getNeighbor() != null){
						for(Location l2 : l.getNeighbor()) { //location in 2 degree
							dest += l2.NAME.toString()+ "\n\t";
						}
						dest +="\n";
					}else {
					dest += "after "+ l.NAME.toString() +", you don't have room\n";
					}
				}
			}
		}
		finally {
			System.out.println(dest);
			System.out.println("map used\n");
		}
	}
}
