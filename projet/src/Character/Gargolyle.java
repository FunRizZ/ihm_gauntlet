package Character;

public class Gargolyle extends WhoFight{
    public final static int DEFAULT_HP = 250;
    public final static int DEFAULT_ARMOR = 10;
    public final static int DEFAULT_DAMAGE = 200;

    public Gargolyle(){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE);
    }
    @Override
    public String getDescription() {
    	return "A gargoyle, stoically perched, exudes an ominous presence with its chiseled features and eternal watchfulness.";
    }
    @Override
    public String toString() {
    	return "Gargoyle";
    }

}
