package Character;


public class Guard extends WhoFight{
    public final static int DEFAULT_HP = 500;
    public final static int DEFAULT_ARMOR = 100;
    public final static int DEFAULT_DAMAGE = 100;

    public Guard(){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE);
    }
    @Override
    public String getDescription() {
    	return "A guard, clad in gleaming armor and standing sentinel with unwavering determination.";
    }
    public String toString() {
    	return "Guard";
    }
   
}
