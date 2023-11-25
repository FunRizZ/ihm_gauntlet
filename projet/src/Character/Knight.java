package Character;

import Game_pack.OwnException;

public class Knight extends WhoFight{
    public final static int DEFAULT_HP = 100;
    public final static int DEFAULT_ARMOR = 10;
    public final static int DEFAULT_DAMAGE = 200;

    public Knight(){
        super(DEFAULT_HP, DEFAULT_DAMAGE, DEFAULT_ARMOR);
    }
    
    @Override
    public void fight(WhoFight enemy){
        enemy.reduceHp(this.getDamage());
    }
    @Override
    public WhoFight itMe(String st) throws OwnException{
    	switch(st) {
    	case "Knight": 
    		return (WhoFight)this;
    	default : 
    		throw new OwnException("itMe",st +" not reconized, class Knight");
    	}
    }

}
