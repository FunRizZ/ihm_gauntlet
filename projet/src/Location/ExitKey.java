package Location;

import Character.Hero;
import Item.Item;
import Item.key;

public class ExitKey extends Exit{
    public final Hero HERO;

    public ExitKey(Location exit, Hero h){
        super(exit);
        this.HERO = h;
    }

    /**
     * @param location : destination
     * @return a boolean wich said if it possible or not
     */
    public boolean go(Location location){
        return location == EXIT_LOCATION && this.HERO.getItem("key").equals((Item)new key());
    }
}
