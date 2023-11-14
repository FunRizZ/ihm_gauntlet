package Character;

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
    
}
