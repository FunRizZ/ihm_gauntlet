package Character;

import java.util.ArrayList;
import java.util.List;

import Game_pack.OwnException;
import Item.Item;

public abstract class Character {
    private List<Item> items;
    
    /**
     * creat a character with items
     */
    public Character(List<Item> items){
        this.items = items;
    }
    /**
     * creat a character with no item
     */
    public Character(){
        this(null);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        if (this.items == null){
            this.items = new ArrayList<Item>();
        }
        this.items.add(item);
    }

    public void afficheItems(){
        String description = "the "+ getClass().getSimpleName() +" have : \n";
        if (this.items == null){
            description += "\tno item";
        }
        else{
            for(Item item : this.items){
                description += "\t"+item;
            }
        }
        System.out.println(description);
    }
    public abstract boolean itMe(String st);
}
