package Character;

import Location.Exit;
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

    public Location getLocation() {
        return location;
    }

    @Override
    public void fight(WhoFight enemy){
        enemy.reduceHp(this.getDamage());
    }

    public boolean goLocation(Location location) {
        Exit exit = this.location.getExit(location);
        if( exit != null && exit.go(location)){
            System.out.println(location);
            this.location = location;
            return true;
        }
        return false;
    }

}
