package Location;

public class Exit {
    public final Location EXIT_LOCATION;

    public Exit(Location exit){
        this.EXIT_LOCATION = exit;
    }

    /**
     * @param location : destination
     * @return a boolean wich said if it possible or not
     */
    public boolean go(Location location){
        return location == EXIT_LOCATION;
    }
    
    @Override
    public String toString(){
        String description = "This exit leads to "+ EXIT_LOCATION.NAME +"\n";
        return description;
    }
}
