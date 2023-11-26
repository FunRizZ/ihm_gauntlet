package Character;

import java.util.ArrayList;
import java.util.List;

import Game_pack.Lookable;
import Item.Item;

public abstract class Character implements Lookable{
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
        String description = "the "+ this +" have : \n";
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
    public abstract boolean isMe(String st);
    public abstract String toString();
    public abstract String getDescription();
}
