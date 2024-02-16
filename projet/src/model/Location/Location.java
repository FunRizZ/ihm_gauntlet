package model.Location;

import java.util.ArrayList;
import java.util.List;

import model.Character.Character;
import model.Game_pack.Lookable;

public class Location{
    public final Lookable[][] BOARD;
    private final int SIZE_X;
    private final int SIZE_Y;
    public final LocationName NAME;

    public Location(Lookable[][] board,LocationName name){
        this.BOARD = board;
        this.SIZE_X = board.length;
        this.SIZE_Y = board[0].length;
        this.NAME = name;
    }

    /**
     * creates a Location with empty board
     * @param sizeX size x of the board
     * @param sizeY size y of the board
     */
    public Location(int sizeX, int sizeY, LocationName name){
        this.BOARD = new Lookable[sizeX][sizeY];
        this.SIZE_X = sizeX;
        this.SIZE_Y = sizeY;
        this.NAME = name;
        this.resetBoard();
    }
    public void resetBoard(){
        for(int x = 0; x < this.SIZE_X; x++){
            for (int y = 0; y < this.SIZE_Y; y++){
                this.BOARD[x][y] = null;
            }
        }
    }
    public List<Location> getNeighbor() {
        List<Location> locations = new ArrayList<Location>();
        for(int x = 0; x< SIZE_X; x++){
            for(int y = 0; y< SIZE_Y; y++){
                if(this.BOARD[x][y] instanceof Exit){
                    locations.add(((Exit) this.BOARD[x][y]).EXIT_LOCATION);
                }
            }
        }
        return locations;
    }
        /**
     * @param location the name of the location we want
     * @return null if no neighbor found else neighbor
     */
    public Location getNeighbor(LocationName location) {
        List<Location> locations = getNeighbor();
        for (Location loc : locations){
            if(loc.NAME == location){return loc;}
        }
        return null;
    }

 
    public List<Exit> getExits() {
        List<Exit> exits = new ArrayList<Exit>();
        for(int x = 0; x< SIZE_X; x++){
            for(int y = 0; y< SIZE_Y; y++){
                if(this.BOARD[x][y] instanceof Exit){
                    exits.add((Exit)this.BOARD[x][y]);
                }
            }
        }
        return exits;
    }
    public List<Character> getCharacters() {
        List<Character> characters = new ArrayList<Character>();
        for(int x = 0; x< SIZE_X; x++){
            for(int y = 0; y< SIZE_Y; y++){
                if(this.BOARD[x][y] instanceof Character){
                    characters.add((Character)this.BOARD[x][y]);
                }
            }
        }
        return characters;
    }
    public List<DecorObjet> getDecorObjects() {
        List<DecorObjet> decorObjects = new ArrayList<DecorObjet>();
        for(int x = 0; x< SIZE_X; x++){
            for(int y = 0; y< SIZE_Y; y++){
                if(this.BOARD[x][y] instanceof DecorObjet){
                    decorObjects.add((DecorObjet)this.BOARD[x][y]);
                }
            }
        }
        return decorObjects;
    }
    /**
     * @param location to go to
     * @return null if no exit found else exit found
     */
    public Exit getExit(LocationName location){
        List<Exit> exits = getExits();
        for (Exit exit : exits){
            if(exit.EXIT_LOCATION.NAME == location){return exit;}
        }
        return null;
    }

    /**
     * @param location to go to
     * @return null if no exit found else exit found
     */
    public Exit getExit(Location location){
        List<Exit> exits = getExits();
        for (Exit exit : exits){
            if(exit.EXIT_LOCATION == location){return exit;}
        }
        return null;
    }

    /**
     * @param obj objet to add if there are no object in the position
     * @return true if the obj has been added
     */
    public boolean addLookable(Lookable obj){
        int posX = obj.getPosX();
        int posY = obj.getPosY();
        if (this.BOARD[posX][posY] == null){
            this.BOARD[posX][posY] = obj;
            return true;
        }
        else {return false;}
    }
    public boolean addCharacter(Character character){
        return addLookable((Lookable) character);
    }
    public boolean addDecorObjet(DecorObjet obj){
        return addLookable((Lookable) obj);
    }
    public boolean addNeighbor(Exit exit){
        return addLookable((Lookable) exit);
    }
    /**
     * @param obj objet to delete
     * @return true if the obj has been deleted
     */
    public boolean removeLookable(Lookable obj){
        int posX = obj.getPosX();
        int posY = obj.getPosY();
        if (this.BOARD[posX][posY] == obj){
            this.BOARD[posX][posY] = null;
            return true;
        }
        else {return false;}
    }
    public boolean removeCharacter(Character character){
        return this.removeLookable((Lookable) character);
    }
    public boolean removeDecorObjet(DecorObjet obj){
        return this.removeLookable((Lookable) obj);
    }
    @Override
    public String toString(){
        String description = "You are in the "+ this.NAME +" \n\n";
        String strExits = "They have no issue";
        List<Exit> exits = this.getExits();
        if ( exits != null){
            strExits  = "In this room you have those exits :\n";
            for(Exit exit : exits){
                strExits += "\t" + exit + "\n";
            }
        }
        String strCharacters = "";
        List<Character> characters = this.getCharacters();
        if (characters != null){
            strCharacters  = "In this room you have :\n";
            for(Character character : characters){
                strCharacters += "\t" + character + "\n";
            }
        }
        String strDecorObjets = "";
        List<DecorObjet> decorObjets = this.getDecorObjects();
        if (decorObjets != null){
            strDecorObjets  = "In this room you can see:\n";
            for(DecorObjet decorObjet : decorObjets){
            	strDecorObjets += "\t" + decorObjet + "\n";
            }
        }

        return description + strExits + strCharacters + strDecorObjets;
    }
}
