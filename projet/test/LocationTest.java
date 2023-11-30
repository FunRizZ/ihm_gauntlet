import org.junit.BeforeClass;
import org.junit.Test;

import Character.Character;
import Character.Dragon;
import Character.Guard;
import Character.Hero;
import Character.Knight;
import Item.Item;
import Item.key;
import Location.LocationName;
import Location.Painting;
import Location.Table;
import Location.Location;
import Location.Book;
import Location.DecorObjet;
import Location.Exit;
import Location.ExitKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.Assert.*;


public class LocationTest {
    private static Location l;
    private static Map<Location,Exit> neighbor;
    private static List<Character> characters;
    private static List<DecorObjet> decorObjets;


    @BeforeClass
    public static void setup() {
        // create a location with characters, objects and exits
        characters = new ArrayList<Character>();
        characters.add(new Knight());
        characters.add(new Dragon());

        decorObjets = new ArrayList<DecorObjet>();
        decorObjets.add(new Table());
        decorObjets.add(new Book());

        Location exit1 = new Location(LocationName.ARMORY);
        Location exit2 = new Location(LocationName.KITCHEN);

        neighbor = new HashMap<Location,Exit>();
        neighbor.put(exit1, new Exit(exit1));
        neighbor.put(exit2, new Exit(exit2));

        l = new Location(neighbor, characters, decorObjets, LocationName.GARDEN);
    }

     //test exits
    @Test
    public void testGoExit(){
        // creates an exit
        Location guard_room = new Location(LocationName.GUARD_ROOM);
        Exit exit_to_guard_room = new Exit(guard_room);

        assertTrue(exit_to_guard_room.go(guard_room));
    }
    
    @Test
    public void testGoKeyExit(){
        // creates an exit
        Location guard_room = new Location(LocationName.GUARD_ROOM);
        Hero h = new Hero(guard_room);
        Exit exit_to_guard_room = new ExitKey(guard_room,h);

        assertFalse(exit_to_guard_room.go(guard_room));

        h.addItem((Item) new key());
        assertTrue(exit_to_guard_room.go(guard_room));
    }
    

     
    @Test
    public void testgetExits(){
        // compares exits with exist created in setup
        int i = 0;
        for(Map.Entry<Location, Exit> exit : neighbor.entrySet()) {
            assertEquals(exit.getValue(), l.getExits().get(i));
            i++;
        }
    }
    

    @Test
    public void testgetCharacters(){
        List<Character> ch = l.getCharacters();
        assertEquals(ch, characters);
    }

    @Test
    public void testAddCharacter(){
        // creates a character
        Character c = new Guard();

        // compares size 
        int size_before_add = l.getCharacters().size();
        l.addCharacter(c);
        int size_after_add = l.getCharacters().size();
        assertEquals(size_before_add + 1, size_after_add);

        // compares character 
        Character last_character = l.getCharacters().get(size_after_add-1);
        assertEquals(last_character, c);

    }

    @Test
    public void testRemoveCharacter(){
        int size_before_remove= l.getCharacters().size();
        Character character_to_delete = l.getCharacters().get(size_before_remove-1);

        // compares size
        l.removeCharacter(character_to_delete);
        int size_after_remove = l.getCharacters().size();
        assertEquals(size_before_remove-1, size_after_remove);

        // verify that last_char isn't in the list anymore
        assertFalse(l.getCharacters().contains(character_to_delete));
    }

    
    

    @Test
    public void testDecorObject(){
        List<DecorObjet> obj = l.getDecorObject();
        assertEquals(obj, decorObjets);
    }

    @Test
    public void testAddDecorObject() {
        Painting painting = new Painting();

        // compares size
        int size_before_add = l.getDecorObject().size();
        l.addDecorObjet(painting);
        int size_after_add = l.getDecorObject().size();
        assertEquals(size_before_add+1, size_after_add);

        // compares character 
        DecorObjet last_obj = l.getDecorObject().get(size_after_add-1);
        assertEquals(last_obj, painting);

    }

    @Test
    public void testRemoveDecorObject() {
        int size_before_remove = l.getDecorObject().size();
        DecorObjet obj_delete = l.getDecorObject().get(size_before_remove-1);

        // compares size
        l.removeDecorObjet(obj_delete);
        int size_after_remove = l.getDecorObject().size();
        assertEquals(size_before_remove-1, size_after_remove);

        // verify that last_char isn't in the list anymore
        assertFalse(l.getDecorObject().contains(obj_delete));
    }
    
}
