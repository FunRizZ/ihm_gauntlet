package model.Item;

public class DoranShield extends Shield{
	public final static int DEFAULT_PROTECTION = 40;
	public DoranShield() {
		super(DEFAULT_PROTECTION);
	}
	@Override
	public String toString() {
		return "Doran_Shield";
	}
}
