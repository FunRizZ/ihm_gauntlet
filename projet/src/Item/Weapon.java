package Item;

public abstract class Weapon extends Item{
    public final int DAMAGE;
    public Weapon(int dmg) {
    	this.DAMAGE = dmg;
    }
    @Override
    public abstract String toString();
}
