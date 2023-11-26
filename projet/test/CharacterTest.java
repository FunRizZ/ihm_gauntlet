
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Character.*;

import Location.LocationName;
import Location.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;


public class CharacterTest {
    private static List<WhoFight> characters;
    private static final LocationName DEFAULT_LOC = LocationName.GARDEN;
    private static Hero h;

    // Initializing variables before all tests
    @BeforeClass
    public static void setup() {
        System.out.println("Setup before tests");
        
        Location l = new Location(DEFAULT_LOC);
        
        h = new Hero(l);
        characters = new ArrayList<WhoFight>();
        characters.add(new Knight());
        characters.add(new Dragon());
        characters.add(new Gargolyle());
        characters.add(new Guard());

    }

    
    @Before
    public void shuffleList() {
        System.out.println("Shuffle list...");
        // before each test, we shuffle the list to be sure that each test work with all WhoFight characters
        Collections.shuffle(characters); 
    }

    @Test
    public void testAttack() {
        WhoFight c1 = characters.get(0);
        
        c1.fight(h);

        assertEquals(h.getHp(), (Hero.DEFAULT_HP + h.getArmor()) - c1.getDamage());
    }
}
