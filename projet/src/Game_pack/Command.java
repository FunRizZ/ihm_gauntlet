package Game_pack;

import java.util.Scanner;
import Location.LocationName;

public class Command {
	public final Game GAME;
	
	public Command(Game game){
		this.GAME = game;
	}
   
	public void read() throws NullPointerException{

        try ( Scanner scanner = new Scanner( System.in ) ) {
            
            System.out.print( " put your command: " );
            String command = scanner.next("GO|HELP|LOOK|ATTACK|TAKE|USE|QUIT|");
            
            switch(command) {
            	case "GO" :
            		String arg = scanner.next();
            		LocationName location = LocationName.stringToLocationName(arg); 
					this.go(location);   
				default:
					this.help();
			}
        }
        
    }
	
	public void go(LocationName location) {
		System.out.println("Command go ok to " + location);
	}
	public void help() {
		System.out.println("Command :\n\tGO location\n\tLOOK");
	}
}
