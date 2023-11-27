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
            this.armor_total += this.armor.getArmor();
        }
        if(this.shield != null){
            this.armor_total += this.shield.getProtection();
        }
        if(this.weapon != null){
            this.damage += this.weapon.getDamage();
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
    public void setArmor(Armor armor) {
    	this.armor_total -= this.armor.getArmor();
    	this.armor_total += armor.getArmor();
    	this.armor = armor;
    }
    public void setShield(Shield shield) {
    	this.armor_total -= this.shield.getProtection();
    	this.armor_total += shield.getProtection();
    	this.shield = shield;
    }
    public void setWeapon(Weapon weapon) {
    	this.damage -= this.weapon.getDamage();
    	this.damage += weapon.getDamage();
    	this.weapon = weapon;
    }
    @Override
    public void look() {
    	String dest = this.getDescription()+"\n\t";
    	dest += "hp : " + this.getHp() + "\n\t";
    	dest += "armor : " + this.getArmor() + "\n\t";
    	dest += "damage : " + this.getDamage() + "\n";
    	dest += "the "+ this.toString() + " have equip :\n\t";
    	if (this.armor != null) {
    		dest += this.armor + "\n\t";
    	}
    	if (this.shield != null) {
    		dest += this.shield + "\n\t";
    	}
    	if (this.weapon != null) {
    		dest += this.weapon + "\n\t";
    	}
    	System.out.println(dest);
    	this.printItems();
    	
    }

}
