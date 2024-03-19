package model.character.other;

import java.util.ArrayList;
import java.util.List;

import model.character.WhoFight;
import model.item.Item;
import model.item.KnightShield;

public class Knight extends WhoFight {
    public final static int DEFAULT_HP = 600;
    public final static int DEFAULT_ARMOR = 150;
    public final static int DEFAULT_DAMAGE = 150;

    public Knight(int x, int y){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE,3,1,createItem(), x, y);
    }
    private static List<Item> createItem(){
    	List<Item> lst = new ArrayList<Item>();
    	lst.add((Item)new KnightShield());
    	return lst;
    }
    @Override
    public String getDescription() {
    	return "A mythical knight, with a sword at his side and a shield bearing his family crest.";
    }
    @Override
    public String toString() {
    	return "Knight";
    }
}
