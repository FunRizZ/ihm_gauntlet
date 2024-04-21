
import model.character.hero.Hero;
import model.character.monster.Daemon;
import model.character.monster.Grunt;
import model.character.other.Guard;
import model.character.other.Knight;
import model.location.decorObject.Spawn;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import apps.setting.SettingPersonnage;
import model.character.*;

import model.location.LocationName;
import model.location.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import model.item.*;


public class CharacterTest {
    private static List<WhoFight> characters;
    private static Hero h;

    // Initializing variables before all tests
    @BeforeClass
    public static void setup() {
        int sizeY = 50;
        int sizeX = 50;
        Spawn spawn1 = new Spawn(2,2);
        List<Spawn> sp = new ArrayList<>(2);
        sp.add(spawn1);
        Location l = new Location(sizeX, sizeY, LocationName.GARDEN,sp);
        l.resetBoard();
        SettingPersonnage setting = new SettingPersonnage(null, null, null, null, null, null, null);

        h = new Hero(l,setting,5,5);
        characters = new ArrayList<WhoFight>();
        characters.add(new Knight(1,1));
        //characters.add(new Daemon(2,2));
        //characters.add(new Grunt(3,3));
        characters.add(new Guard(4,4));
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

    @Test
    public void testAddItem() {
        Treasure t = new Treasure();
        WhoFight c1 = characters.get(0);
        
        int size_before_add = c1.getItems().size();
        c1.addItem(t);
        int size_after_add = c1.getItems().size();

        assertEquals(size_before_add+1, size_after_add);
        assertTrue(c1.getItems().contains(t));

    }

    @Test
    public void testRemoveItem() {
        Treasure t = new Treasure();
        WhoFight c1 = characters.get(0);
        c1.addItem(t);
        
        int size_before_remove = c1.getItems().size();
        c1.remove(t);
        int size_after_remove = c1.getItems().size();

        assertEquals(size_before_remove-1, size_after_remove);
        assertFalse(c1.getItems().contains(t));
    }

    @Test
    public void testHaveItem() {
        Treasure t = new Treasure();
        WhoFight c1 = characters.get(0);
        c1.addItem(t);

        assertTrue(c1.haveItem(t));
    }

}
