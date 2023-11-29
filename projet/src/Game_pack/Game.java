package Game_pack;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import Character.Character;
import Item.Item;
import Character.*;
import Location.*;

public class Game {
    public final Hero HERO;
    private List<Location> locations;
    private final Command cmd;

    public Game(){
        generateMap();
        this.HERO = new Hero(locations.get(0));
        this.cmd = new Command(this);
    }

    public Location creatLocation(LocationName locationName){
        Location location = new Location(locationName);
        this.locations.add(location);
        return location;
    }

    /**
     * genere the map, store in this.locations. The first Location is GARDEN
     */
    public void generateMap(){
        this.locations = new ArrayList<Location>();

        Location start = new Location(LocationName.GARDEN);
        this.locations.add(start);
        
        Location l_out = this.creatLocation(LocationName.ROOM_WITH_TREASURE);
        start.addNeighbor(l_out, new Exit(l_out));
        Location l_out2 = this.creatLocation(LocationName.KITCHEN);
    //    l_out.addNeighbor(l_out2, new Exit(l_out2));
        Character Drag = new Dragon();
        start.addCharacter(Drag);
        Character knight = new Knight();
        start.addCharacter(knight);
        DecorObjet vase = new Vase();
        start.addDecorObjet(vase);
        DecorObjet book = new Book();
        start.addDecorObjet(book);
    }

    /**
     * all the character fight againt the HERO. the HERO don't attack him self
     */
    public void attackHero(){
        Location locationH = this.HERO.getLocation();
        try{
            for (Character c : locationH.getCharacters()) {
                if (c instanceof WhoFight){
                    ((WhoFight)c).fight(this.HERO);
                    System.out.println(c + " hit the hero");
                }
            }
        }catch(NullPointerException e){}
    }
    /**
     * @return true if the hero have the treasure else false
     */
    public boolean treasureIsGet(){
        boolean res = false;
        try{
            for (Item i : this.HERO.getItems()) {
                if(i.isMe("Treasure")){res = true;}
            }
        }catch(NullPointerException e){}
        return res;
    }


    public static void main(String[] args) throws Exception {
        Game game = new Game();
        System.out.println("You are the hero who live in a small town and you heared that a abandoned castel was found.\nA old man in the town said to you 'if you get the treasure, i can give you my daughter'\nIn this word the hero go to find the treasure");
        System.out.println(game.HERO.getLocation());
		
        Scanner scanner = new Scanner( System.in ); 
        boolean res = true;
        while(res && !game.HERO.isDead() && !game.treasureIsGet()) {
            res = game.cmd.read(scanner);
            game.attackHero();
            System.out.println("Hero have "+ game.HERO.getHp() + " hp");
        }
        scanner.close();
        System.out.println("You quit the game");
    }
}
