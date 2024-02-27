package model.Location;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import model.Character.Character;
import model.Game_pack.Lookable;

public class Location {
    public final Lookable[][] BOARD;
    /**
     * number of columns
     */
    private final int SIZE_X;
    /**
     * number of rows
     */
    private final int SIZE_Y;
    public final LocationName NAME;

    public Location(String path) throws FileNotFoundException {
        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(new FileReader(path));
        JsonObject jsonObject = (JsonObject) JsonParser.parseReader(jsonReader);

        String name = path.split("/")[path.split("/").length -1].split(".json")[0];
        System.out.println(name);
        this.NAME = LocationName.valueOf(name);

        this.SIZE_X = gson.fromJson(jsonObject.get("sizeX"),Integer.class);
        this.SIZE_Y = gson.fromJson(jsonObject.get("sizeY"),Integer.class);
        this.BOARD = new Lookable[this.SIZE_X][this.SIZE_Y];

        JsonArray decorObjects = jsonObject.getAsJsonArray("decorObject");
        for(int i = 0; i< decorObjects.size(); i++){
            JsonObject jsonObjectDecorObject = decorObjects.get(i).getAsJsonObject();
            try {
                Class objClass = Class.forName("",gson.fromJson(jsonObjectDecorObject.get("name"), String.class));
                DecorObjet obj = (DecorObjet) gson.fromJson(jsonObjectDecorObject.get("elt"), objClass);
                this.addLookable(obj);
            }catch (Exception e){
                System.err.println(e);
            }
        }

    }
    public Location(Lookable[][] board, LocationName name) {
        this.BOARD = board;
        this.SIZE_X = board.length;
        this.SIZE_Y = board[0].length;
        this.NAME = name;
    }
    /**
     * creates a Location with empty board
     *
     * @param sizeX number of columns
     * @param sizeY number of rows
     */
    public Location(int sizeX, int sizeY, LocationName name) {
        this.BOARD = new Lookable[sizeX][sizeY];
        this.SIZE_X = sizeX;
        this.SIZE_Y = sizeY;
        this.NAME = name;
        this.resetBoard();
    }

    public void resetBoard() {
        for (int x = 0; x < this.SIZE_X; x++) {
            for (int y = 0; y < this.SIZE_Y; y++) {
                this.BOARD[x][y] = null;
            }
        }
    }

    public List<Location> getNeighbor() {
        List<Location> locations = new ArrayList<>();
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                if (this.BOARD[x][y] instanceof Exit) {
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
        for (Location loc : locations) {
            if (loc.NAME == location) {
                return loc;
            }
        }
        return null;
    }


    public List<Exit> getExits() {
        List<Exit> exits = new ArrayList<>();
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                if (this.BOARD[x][y] instanceof Exit) {
                    exits.add((Exit) this.BOARD[x][y]);
                }
            }
        }
        return exits;
    }

    public List<Character> getCharacters() {
        List<Character> characters = new ArrayList<>();
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                if (this.BOARD[x][y] instanceof Character) {
                    characters.add((Character) this.BOARD[x][y]);
                }
            }
        }
        return characters;
    }

    public List<DecorObjet> getDecorObjects() {
        List<DecorObjet> decorObjects = new ArrayList<>();
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                if (this.BOARD[x][y] instanceof DecorObjet) {
                    decorObjects.add((DecorObjet) this.BOARD[x][y]);
                }
            }
        }
        return decorObjects;
    }

    /**
     * @param location to go to
     * @return null if no exit found else exit found
     */
    public Exit getExit(LocationName location) {
        List<Exit> exits = getExits();
        for (Exit exit : exits) {
            if (exit.EXIT_LOCATION.NAME == location) {
                return exit;
            }
        }
        return null;
    }

    /**
     * @param location to go to
     * @return null if no exit found else exit found
     */
    public Exit getExit(Location location) {
        List<Exit> exits = getExits();
        for (Exit exit : exits) {
            if (exit.EXIT_LOCATION == location) {
                return exit;
            }
        }
        return null;
    }

    /**
     * @param obj objet to add if there are no object in the position
     * @return true if the obj has been added
     */
    public boolean addLookable(Lookable obj) {
        int posX = obj.getPosX();
        int posY = obj.getPosY();
        if (this.BOARD[posX][posY] == null) {
            this.BOARD[posX][posY] = obj;
            return true;
        } else {
            return false;
        }
    }

    public boolean addCharacter(Character character) {
        return addLookable(character);
    }

    public boolean addDecorObjet(DecorObjet obj) {
        return addLookable( obj);
    }

    public boolean addNeighbor(Exit exit) {
        return addLookable( exit);
    }

    /**
     * @param obj objet to delete
     * @return true if the obj has been deleted
     */
    public boolean removeLookable(Lookable obj) {
        int posX = obj.getPosX();
        int posY = obj.getPosY();
        if (this.BOARD[posX][posY] == obj) {
            this.BOARD[posX][posY] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeCharacter(Character character) {
        return this.removeLookable( character);
    }

    public boolean removeDecorObjet(DecorObjet obj) {
        return this.removeLookable( obj);
    }

    @Override
    public String toString() {
        String description = "You are in the " + this.NAME + " \n\n";
        String strExits = "They have no issue";
        List<Exit> exits = this.getExits();
        if (exits != null) {
            strExits = "In this room you have those exits :\n";
            for (Exit exit : exits) {
                strExits += "\t" + exit + "\n";
            }
        }
        String strCharacters = "";
        List<Character> characters = this.getCharacters();
        if (characters != null) {
            strCharacters = "In this room you have :\n";
            for (Character character : characters) {
                strCharacters += "\t" + character + "\n";
            }
        }
        String strDecorObjets = "";
        List<DecorObjet> decorObjets = this.getDecorObjects();
        if (decorObjets != null) {
            strDecorObjets = "In this room you can see:\n";
            for (DecorObjet decorObjet : decorObjets) {
                strDecorObjets += "\t" + decorObjet + "\n";
            }
        }

        return description + strExits + strCharacters + strDecorObjets;
    }


    /**
     * @return the path of the location save
     */
    public String toFile(){
        Gson gson = new Gson();
        //path of the file
        String path = "./save/locations/"+this.NAME.name()+".json";

        List<DecorObjet> decorObjects = getDecorObjects();
        List<Character> characters = getCharacters();
        List<Exit> exits = getExits();

        System.out.println("decorObjets : "+decorObjects);
        System.out.println("Characters : "+characters);
        System.out.println("Exit : "+exits);

        try (JsonWriter writer = new JsonWriter(new FileWriter(path))) {
            writer.beginObject();
            writer.name("sizeX").value(this.SIZE_X);
            writer.name("sizeY").value(this.SIZE_Y);

            writer.name("decorObject").beginArray();
            for (DecorObjet obj: decorObjects){
                writer.beginObject();
                writer.name("name").value(obj.getClass().getSimpleName());
                writer.name("elt").value(gson.toJson(obj));
                writer.endObject();
            }
            writer.endArray();

            writer.name("character").beginArray();
            for (Character chr: characters){
                writer.beginObject();
                writer.name("name").value(chr.getClass().getSimpleName());
                writer.name("x").value(chr.getPosX());
                writer.name("y").value(chr.getPosY());
                writer.endObject();
            }
            writer.endArray();

            writer.name("exit").beginArray();
            for (Exit ext: exits){
                writer.beginObject();
                writer.name("name").value(ext.getClass().getSimpleName());
                writer.name("x").value(ext.getPosX());
                writer.name("y").value(ext.getPosY());
                writer.name("exit_location").value(ext.EXIT_LOCATION.toFile());
                writer.endObject();
            }
            writer.endArray();

            writer.endObject();
        } catch (IOException e) {
            e.getCause();
            System.err.println(e.getMessage());
        }
        return path;
    }
}
