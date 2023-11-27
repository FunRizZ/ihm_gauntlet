package Item;

public class KnightShield extends Shield{
	public final static int DEFAULT_PROTECTION = 30;
	public KnightShield() {
		super(DEFAULT_PROTECTION);
	}
	@Override
	public String toString() {
		return "Knight_Shield";
	}
}
