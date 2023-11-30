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

    public Location createLocation(LocationName locationName){
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

        //Creation of locations rooms
        Location sitting_room = this.createLocation(LocationName.SITING_ROOM);
        Location kitchen = this.createLocation(LocationName.KITCHEN);
        Location reception_room = this.createLocation(LocationName.RECPTION_ROOM);
        Location hallway = this.createLocation(LocationName.HALLWAY);
        Location bedroom = this.createLocation(LocationName.BEDROOM);
        Location office = this.createLocation(LocationName.OFFICE);
        Location secret_passage = this.createLocation(LocationName.SECRET_PASSAGE);
        Location wc = this.createLocation(LocationName.WC);
        Location chapel = this.createLocation(LocationName.CHAPEL);
        Location guard_room = this.createLocation(LocationName.GUARD_ROOM);
        Location prison = this.createLocation(LocationName.PRISON);
        Location armory = this.createLocation(LocationName.ARMORY);
        Location tower = this.createLocation(LocationName.TOWER);
        Location room_treasure = this.createLocation(LocationName.ROOM_WITH_TREASURE);

        //Creation of Exits
        start.addNeighbor(sitting_room, new Exit(sitting_room));
        start.addNeighbor(kitchen, new Exit(kitchen));

        sitting_room.addNeighbor(kitchen, new Exit(kitchen));
        sitting_room.addNeighbor(reception_room, new Exit(reception_room));
        sitting_room.addNeighbor(hallway, new Exit(hallway));

        kitchen.addNeighbor(sitting_room, new Exit(sitting_room));
        
        reception_room.addNeighbor(sitting_room, new Exit(sitting_room));
        reception_room.addNeighbor(hallway, new Exit(hallway));
        
        hallway.addNeighbor(sitting_room, new Exit(sitting_room));
        hallway.addNeighbor(reception_room, new Exit(reception_room));
        hallway.addNeighbor(bedroom, new Exit(bedroom));
        hallway.addNeighbor(wc, new Exit(wc));
        hallway.addNeighbor(chapel, new Exit(chapel));
        hallway.addNeighbor(tower, new Exit(tower));
        hallway.addNeighbor(prison, new Exit(prison));
        hallway.addNeighbor(guard_room, new Exit(guard_room));
        
        bedroom.addNeighbor(office, new Exit(office));
        bedroom.addNeighbor(hallway, new Exit(hallway));
        
        office.addNeighbor(hallway, new Exit(hallway));
        
        secret_passage.addNeighbor(office, (Exit)new ExitKey(office,this.HERO));  //Special exit
        
        wc.addNeighbor(secret_passage, new Exit(secret_passage));
        wc.addNeighbor(hallway, new Exit(hallway));
        
        chapel.addNeighbor(hallway, new Exit(hallway));
        
        guard_room.addNeighbor(armory, new Exit(armory));
        guard_room.addNeighbor(prison, new Exit(prison));
        guard_room.addNeighbor(hallway, new Exit(hallway));
        
        prison.addNeighbor(guard_room, new Exit(guard_room));
        
        armory.addNeighbor(guard_room, new Exit(guard_room));
        
        tower.addNeighbor(hallway, new Exit(hallway));
        tower.addNeighbor(room_treasure, (Exit)new ExitKey(room_treasure,this.HERO)); //Special exit
        
        
        // -----------------Add items and characters in each room-------------------------
                
        // In this game, there is two keys : one for the secret passage and one for access to the room with treasure
        // You can use one of this keys to the secret passage or for access to the room with treasure
        // But if you use it, the key will be destroy
        
        // Garden
        start.addCharacter((Character)new Guard());
        
        // Kitchen
        kitchen.addCharacter((Character)new Chef());
        
        // Reception room
        reception_room.addCharacter((Character)new Lord());
        
        // Hallway
        hallway.addCharacter((Character)new Gargolyle());
        hallway.addCharacter((Character)new HouseKeeper());
        
        // Bedroom (with a key)
        bedroom.addCharacter((Character)new Gargolyle());
        bedroom.addDecorObjet((DecorObjet)new Cupboard());
        
        // Office
        office.addCharacter((Character)new Knight());
        
        // Secret passage
        secret_passage.addDecorObjet((DecorObjet)new Vase());
        
        // WC
        wc.addDecorObjet((DecorObjet)new WC());
        
        // Chapel (with a key)
        chapel.addDecorObjet((DecorObjet)new Cupboard());
        
        // Guard_room
        guard_room.addCharacter((Character)new Executioner());
        guard_room.addCharacter((Character)new Guard());
        guard_room.addCharacter((Character)new Guard());
        
        // Prison
        prison.addCharacter((Character)new Prisoner());
        
        // Armory
        armory.addCharacter((Character)new Knight());
        armory.addDecorObjet((DecorObjet)new Table());
        
        // Room with treasure
        room_treasure.addCharacter((Character)new Dragon());
                
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
        System.out.println("You are the hero who lived in a small town and you heared that a abandoned castel was found.\nA old man in the town said to you \n``If you get the treasure, i can give you my daughter``\nOn his word the hero go to find the treasure");
        System.out.println(game.HERO.getLocation());
		
        Scanner scanner = new Scanner( System.in ); 
        boolean res = true;
        while(res && !game.HERO.isDead() && !game.treasureIsGet()) {
            res = game.cmd.read(scanner);
            game.attackHero();
            System.out.println("Hero have "+ game.HERO.getHp() + " hp");
        }
        scanner.close();
        if(game.HERO.isDead()){ System.out.println("Game over, try again !");}
        else if(game.treasureIsGet()){System.out.println("You show the treasure to the old man,\n after that the hero and his wife live happily.");}
        
    }
}
