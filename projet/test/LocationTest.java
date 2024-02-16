import model.Game_pack.Lookable;
import model.Location.*;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Character.Character;
import model.Character.Dragon;
import model.Character.Guard;
import model.Character.Hero;
import model.Character.Knight;
import model.Item.Item;
import model.Item.key;
import model.Location.Painting;


import static org.junit.Assert.*;


public class LocationTest {
    private static Location l;
    private static int sizeX = 50;
    private static int sizeY = 50;
    @BeforeClass
    public static void setup() {
        // create a location with characters, objects and exits
        Lookable[][] board = new Lookable[sizeX][sizeY];
        board[9][9] = new Knight(9,9);
        board[7][10] = new Dragon(7,10);

        board[1][1] = new Table(1,1);
        board[2][2] = new Book(2, 2);

        Location exit1 = new Location(sizeX, sizeY, LocationName.ARMORY);
        Location exit2 = new Location(sizeX, sizeY, LocationName.KITCHEN);

        board[1][5] = new Exit(exit1,1,5);
        board[5][1] = new Exit(exit2,5,1);
        l = new Location(board, LocationName.GARDEN);
    }

     //test exits
    @Test
    public void testGoExit(){
        // creates an exit
        Location guard_room = new Location(sizeX, sizeY, LocationName.GUARD_ROOM);
        Exit exit_to_guard_room = new Exit(guard_room,1,3);

        assertTrue(exit_to_guard_room.go(guard_room));
    }
    
    @Test
    public void testGoKeyExit(){
        // creates an exit
        Location guard_room = new Location(sizeX, sizeY,LocationName.GUARD_ROOM);
        Hero h = new Hero(guard_room,0 ,0 );
        Exit exit_to_guard_room = new ExitKey(guard_room,h,20,20);

        assertFalse(exit_to_guard_room.go(guard_room));

        h.addItem((Item) new key());
        assertTrue(exit_to_guard_room.go(guard_room));
    }
    

     
    @Test
    public void testgetExits(){
        // compares lenght of exits with the number of exit add
        assertEquals(2, l.getExits().size());
    }
    

    @Test
    public void testgetCharacters(){
        assertEquals(2, l.getCharacters().size());
    }

    @Test
    public void testAddCharacter(){
        // creates a character
        Character c = new Guard(32,32);

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
        // compares lenght of getDecorObject with the number of exit add
        assertEquals(2, l.getDecorObjects().size());
    }

    @Test
    public void testAddDecorObject() {
        Wall Wall = new Wall(42,42);

        // compares size
        int size_before_add = l.getDecorObjects().size();
        l.addDecorObjet(Wall);
        int size_after_add = l.getDecorObjects().size();
        assertEquals(size_before_add+1, size_after_add);

        // compares character 
        DecorObjet last_obj = l.getDecorObjects().get(size_after_add-1);
        assertEquals(last_obj, Wall);

    }

    @Test
    public void testRemoveDecorObject() {
        int size_before_remove = l.getDecorObjects().size();
        DecorObjet obj_delete = l.getDecorObjects().get(size_before_remove-1);

        // compares size
        l.removeDecorObjet(obj_delete);
        int size_after_remove = l.getDecorObjects().size();
        assertEquals(size_before_remove-1, size_after_remove);

        // verify that last_char isn't in the list anymore
        assertFalse(l.getDecorObjects().contains(obj_delete));
    }
    
}
