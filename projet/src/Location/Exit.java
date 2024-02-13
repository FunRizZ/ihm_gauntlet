package Location;

import Game_pack.Lookable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Exit extends Lookable {
    public final Location EXIT_LOCATION;

    public Exit(Location exit, int x, int y){
        super(x, y);
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

    @Override
    public void look() {}

    @Override
    public ImageView getSpray() {
        Image spray = new Image(Exit.class.getResource("/sprites/exit.png").toExternalForm());
        return new ImageView(spray);
    }
}
