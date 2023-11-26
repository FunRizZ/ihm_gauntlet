package Character;

import java.util.List;

import Item.Armor;
import Item.Item;
import Item.Shield;
import Item.Weapon;

public abstract class WhoFight extends Character{
    private int hp;
    /**
     * somme of shield and armor
     */
    private int armor_total;
    private int damage;

    private Weapon weapon;
    private Armor armor;
    private Shield shield;

    public WhoFight(int hp, int armor_start, int damage_start, Weapon weapon, Armor armor, Shield shield, List<Item> items){
        super(items);
        this.hp = hp;
        this.armor_total = armor_start;
        this.damage = damage_start;
        this.weapon = weapon;
        this.armor = armor;
        this.shield = shield;
        if(this.armor != null){
            this.armor_total += this.armor.ARMOR;
        }
        if(this.shield != null){
            this.armor_total += this.shield.ARMOR;
        }
        if(this.weapon != null){
            this.damage += this.weapon.DAMAGE;
        }
    }
    public WhoFight(int hp, int armor_start, int damage_start){
        this(hp, armor_start, damage_start, null, null, null,null);
    }
    public WhoFight(int hp, int armor_start, int damage_start,List<Item> items){
        this(hp, armor_start, damage_start, null, null, null,items);
    }


    public boolean isDead(){
        return this.hp <= 0;
    }
    public void fight(WhoFight enemy) {
    	enemy.reduceHp(this.getDamage());
    }

    /**
     * this will reduce hp by damage - enemy.armor_total
     * @param damage is the damage of the character who attack
     */
    public void reduceHp(int damage){
        this.hp +=  -damage + this.armor_total;
    }
    public int getDamage() {
        return this.damage;
    }

     public int getHp() {
        return this.hp;
    }

    public int getArmor() {
        return this.armor_total;
    }
    @Override
    public void look() {
    	String dest = this.getDescription()+"\n\t";
    	dest += "hp : " + this.getHp() + "\n\t";
    	dest += "armor : " + this.getArmor() + "\n\t";
    	dest += "damage : " + this.getDamage() + "\n\t";
    	System.out.println(dest);
    	this.afficheItems();
    	
    }

}
