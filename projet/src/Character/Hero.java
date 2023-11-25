package Character;

import Game_pack.OwnException;
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
        System.out.println("HERO hit the " + enemy);
    }

    public boolean goLocation(Location location) {
        //recupération de l'exit
        Exit exit = this.location.getExit(location);

        if( exit != null){
            if (exit.go(location)){
                System.out.println("you go in " + location.NAME + "\n");
                System.out.println(location);
                this.location = location;
                return true;
            }
        }
        System.out.println("you stay in the room \n");
        return false;
    }
    @Override
    public WhoFight itMe(String st) throws OwnException{
    	switch(st) {
    	case "Hero": 
    		return (WhoFight)this;
    	default : 
    		throw new OwnException("itMe",st +" not reconized, class Hero");
    	}
    }


}
