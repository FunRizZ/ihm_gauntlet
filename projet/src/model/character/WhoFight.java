package model.character;

import java.util.List;

import model.item.Armor;
import model.item.Item;
import model.item.Shield;
import model.item.Weapon;

public abstract class WhoFight extends Character {
    private static final int MAX_HP = 15000;
    private int hp;
    /**
     * some of shield, armor and start_armor
     */
    private int armor_total;
    private int damage;

    private Weapon weapon;
    private Armor armor;
    private Shield shield;

    private int range;
    private int level;

    public WhoFight(int hp, int armor_start, int damage_start, Weapon weapon, Armor armor, Shield shield, int range, int level, List<Item> items, int x, int y){
        super(items, x, y);
        this.hp = hp;
        this.armor_total = armor_start;
        this.damage = damage_start;
        this.weapon = weapon;
        this.armor = armor;
        this.shield = shield;
        this.range = range;
        this.level = level;
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
    public WhoFight(int hp, int armor_start, int damage_start, int range, int difficulty, int x, int y){
        this(hp, armor_start, damage_start, null, null, null,range,difficulty,null, x, y);
    }
    public WhoFight(int hp, int armor_start, int damage_start, int range, int difficulty,List<Item> items, int x, int y){
        this(hp, armor_start, damage_start, null, null, null,range,difficulty,items, x, y);
    }


    /**
     * @return if the character is dead or not
     */
    public boolean isDead(){
        return this.hp <= 0;
    }
    /**
     * reduces the hp of the enemy in function of the damage
     * @param enemy
     */
    public void fight(WhoFight enemy) {
    	enemy.reduceHp(this.getDamage());
    }

    /**
     * this will reduces hp by damage - enemy.armor_total
     * @param damage is the damage of the character who attack
     */
    public void reduceHp(int damage){
        this.hp +=  -damage + this.armor_total;
    }
    public int getDamage() {
        return this.damage;
    }

    public int getRange(){
        return this.range;
    }

    public void addRange(int range){
        this.range += range;
    }

     public int getHp() {
        return this.hp;
    }
    public int getArmor() {
        return this.armor_total;
    }
    public void setArmor(Armor armor) {
        try{this.armor_total -= this.armor.getArmor();}
        catch(NullPointerException e){}
    	this.armor_total += armor.getArmor();
    	this.armor = armor;
    }
    public void setShield(Shield shield) {
        try{this.armor_total -= this.shield.getProtection();}
        catch(NullPointerException e){}
    	this.armor_total += shield.getProtection();
    	this.shield = shield;
    }
    public void setWeapon(Weapon weapon) {
        try{this.damage -= this.weapon.getDamage();}
        catch(NullPointerException e){}
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
    /**
     * increases hp from WhoFight by i up to MAX_HP
     * @param i number of hp restores
     */
    public void addHp(int i){
        this.hp += i;
        if (this.hp > WhoFight.MAX_HP){this.hp = WhoFight.MAX_HP;}
    }
    /**
     * increases armor from WhoFight by i
     * @param i number of armor raise
     */
    public void addDefense(int i){
        this.armor_total += i;
    }
    /**
     * increases Dammage from WhoFight by his damage * i
     * @param i multiplier of damage
     */
    public void addAttack(double i){
        this.damage = (int) (this.damage * i);
    }

}
