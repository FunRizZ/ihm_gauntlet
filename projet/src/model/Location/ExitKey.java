package model.Location;

import model.Game_pack.Game;
import model.Item.Item;
import model.Item.key;

public class ExitKey extends Exit{
    public final Game GAME;

    public ExitKey(Location exit, Game game, int x, int y){
        super(exit, x, y);
        this.GAME = game;
    }

    /**
     * @param location : destination
     * @return a boolean which says if it's possible or not
     */
    public boolean go(Location location){
        Item k;
        try{
            k = this.GAME.getMainHero().getItem("key");
        }catch(NullPointerException e){return false;}
        return location == EXIT_LOCATION && (k instanceof key);
    }
}
