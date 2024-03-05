package model.item;

public class HolyGrenade extends Weapon{
    public final static int DEFAULT_DAMAGE = 500;
    public HolyGrenade() {
        super(DEFAULT_DAMAGE);
    }
    @Override
    public String toString() {
        return "Holy_Grenade";
    }

}