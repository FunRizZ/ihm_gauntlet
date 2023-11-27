package Item;

public class DeadraHammer extends Weapon{
    public final static int DEFAULT_DAMAGE = 250;
    public DeadraHammer() {
    	super(DEFAULT_DAMAGE);
    }
    @Override
    public String toString() {
    	return "Deadra_Hammer";
    }
}
