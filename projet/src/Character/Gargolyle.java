package Character;

import java.util.ArrayList;
import java.util.List;

import Item.Item;
import Item.Potion;

public class Gargolyle extends WhoFight{
    public final static int DEFAULT_HP = 250;
    public final static int DEFAULT_ARMOR = 10;
    public final static int DEFAULT_DAMAGE = 200;

    public Gargolyle(int x, int y){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE,createItem(), x, y);
    }
    private static List<Item> createItem(){
    	List<Item> lst = new ArrayList<Item>();
    	lst.add((Item)new Potion());
    	return lst;
    }
    @Override
    public String getDescription() {
    	return "A gargoyle, stoically perched, exudes an ominous presence with its chiseled features and eternal watchfulness.";
    }
    @Override
    public String toString() {
    	return "Gargoyle";
    }

}
