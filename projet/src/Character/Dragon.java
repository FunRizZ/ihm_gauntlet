package Character;

import java.util.ArrayList;
import java.util.List;

import Item.Item;
import Item.Treasure;

public class Dragon extends WhoFight{
    public final static int DEFAULT_HP = 500;
    public final static int DEFAULT_ARMOR = 150;
    public final static int DEFAULT_DAMAGE = 200;

    public Dragon(){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE,creatItem());
    }
    private static List<Item> creatItem(){
    	List<Item> lst = new ArrayList<Item>();
    	lst.add((Item)new Treasure());
    	return lst;
    }
    @Override
    public String getDescription() {
    	return "A dragon, with scales of molten gold and eyes gleaming with ancient wisdom.";
    }
    public String toString() {
    	return "Dragon";
    }

}
