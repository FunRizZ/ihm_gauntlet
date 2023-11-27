import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Character.Character;
import Character.Dragon;
import Character.Guard;
import Character.Knight;
import Location.LocationName;
import Location.Table;
import Location.Location;
import Location.Book;
import Location.DecorObjet;
import Location.Exit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.Assert.*;


public class LocationTest {
    private static LocationName ln;
    private static Location l;
    private static Location l2;
    private static Map<Location,Exit> neighbor;
    private static List<Character> characters;
    private static List<DecorObjet> decorObjets;


    @BeforeClass
    public static void setup() {
        ln = LocationName.BEDROOM;
        l2 = new Location(ln);

        characters = new ArrayList<Character>();
        characters.add(new Knight());
        characters.add(new Dragon());

        decorObjets = new ArrayList<DecorObjet>();
        decorObjets.add(new Table());
        decorObjets.add(new Book());

        Location exit1 = new Location(LocationName.ARMORY);
        Location exit2 = new Location(LocationName.KITCHEN);

        neighbor = new HashMap<Location,Exit>();
        neighbor.put(l, new Exit(exit1));
        neighbor.put(l, new Exit(exit2));

        l = new Location(neighbor, characters, decorObjets, LocationName.GARDEN);


    }
    /* 
    @Test
    public void testaddNeighbor(){
        Location exit = new Location(LocationName.GUARD_ROOM);
        int nb_exit = neighbor.size();
    }
    */

    /* 
    @Test
    public void testgetExits(){
    }
    */

    @Test
    public void testgetCharacters(){
        List<Character> ch = l.getCharacters();
        assertEquals(ch, characters);
    }

    @Test
    public void testAddCharacter(){
        int size_before_add = l.getCharacters().size();
        l.addCharacter(new Guard());
        assertEquals(size_before_add + 1, l.getCharacters().size());
    }

    @Test
    public void testRemoveCharacter(){
        int size_before_add = l.getCharacters().size();
        l.removeCharacter(characters.get(0));
        assertEquals(size_before_add-1, l.getCharacters().size());
    }

    
    

    @Test
    public void testDecorObjects() {

    }
    
}
