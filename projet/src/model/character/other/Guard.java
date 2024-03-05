package model.character.other;

import java.util.ArrayList;
import java.util.List;

import model.character.WhoFight;
import model.item.Item;
import model.item.RisingSunAx;

public class Guard extends WhoFight {
    public final static int DEFAULT_HP = 500;
    public final static int DEFAULT_ARMOR = 100;
    public final static int DEFAULT_DAMAGE = 100;

    public Guard(int x, int y){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE,createItem(), x, y);
    }
    private static List<Item> createItem(){
    	List<Item> lst = new ArrayList<Item>();
    	lst.add((Item)new RisingSunAx());
    	return lst;
    }
    @Override
    public String getDescription() {
    	return "A guard, clad in gleaming armor and standing sentinel with unwavering determination.";
    }
    @Override
    public String toString() {
    	return "Guard";
    }
   
}
