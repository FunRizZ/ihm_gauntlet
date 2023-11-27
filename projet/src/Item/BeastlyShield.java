package Item;

public class BeastlyShield extends Shield{
	public final static int DEFAULT_PROTECTION = 50;
	public BeastlyShield() {
		super(DEFAULT_PROTECTION);
	}
	@Override
	public String toString() {
		return "Beastly_Shield";
	}
}
