package Location;

public class Exit {
    public final Location START_LOCATION;
    public final Location EXIT_LOCATION;

    public Exit(Location start, Location exit){
        this.START_LOCATION = start;
        this.EXIT_LOCATION = exit;
    }

    public boolean go(Location location){
        return location == EXIT_LOCATION;
    }
    
    @Override
    public String toString(){
        String description = "this exit leads to "+ EXIT_LOCATION.NAME +"\n";
        return description;
    }
}
