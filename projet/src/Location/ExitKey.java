package Location;

import Character.Hero;
import Item.Item;
import Item.key;

public class ExitKey extends Exit{
    public final Hero HERO;

    public ExitKey(Location exit, Hero h, int x, int y){
        super(exit, x, y);
        this.HERO = h;
    }

    /**
     * @param location : destination
     * @return a boolean which says if it's possible or not
     */
    public boolean go(Location location){
        Item k;
        try{
            k = this.HERO.getItem("key");
        }catch(NullPointerException e){return false;}
        return location == EXIT_LOCATION && (k instanceof key);
    }
}
