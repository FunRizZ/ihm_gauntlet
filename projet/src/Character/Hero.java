package Character;

import Location.Location;

public class Hero extends WhoFight{
    public final static int DEFAULT_HP = 100;
    public final static int DEFAULT_ARMOR = 10;
    public final static int DEFAULT_DAMAGE = 200;

    private Location location;

    public Hero(Location location){
        super(DEFAULT_HP, DEFAULT_DAMAGE, DEFAULT_ARMOR);
        this.location = location;
    }

    @Override
    public void fight(WhoFight enemy){
        enemy.reduceHp(this.getDamage());
    } 

}
