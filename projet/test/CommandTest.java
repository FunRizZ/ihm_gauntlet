
import org.junit.Test;

import Character.Dragon;
import Character.Knight;

import static org.junit.Assert.*;


public class CommandTest {
    
    @Test
    public void testAttack() {
        Knight k = new Knight();
        Dragon d = new Dragon();

        k.fight(d);

        assertEquals(d.getHp(), (Dragon.DEFAULT_HP + d.getArmor()) - k.getDamage());
    }

    @Test
    public void testGoLocation() {


}
