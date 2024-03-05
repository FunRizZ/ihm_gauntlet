package model.item;

public class NoctaflameSword extends Weapon{
    public final static int DEFAULT_DAMAGE = 200;
    public NoctaflameSword() {
    	super(DEFAULT_DAMAGE);
    }
    @Override
    public String toString() {
    	return "Noctaflame_Sword";
    }
}
