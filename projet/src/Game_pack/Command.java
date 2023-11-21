package Game_pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Location.Location;
import Location.LocationName;

public class Command {
	public final Game GAME;
	
	public Command(Game game){
		this.GAME = game;
	}
   
	public void read(){
		String command;
		List<String> argv = new ArrayList<String>();

        try ( Scanner scanner = new Scanner( System.in ) ) {
            
            System.out.print( "put your command: " );
            command = scanner.next("GO|HELP|LOOK|ATTACK|TAKE|USE|QUIT|");
            
            switch(command) {
            	case "GO" :
					if(scanner.hasNext()){argv.add(scanner.next());}
            		LocationName location = LocationName.stringToLocationName(argv.get(1)); 
					this.go(location);
					return;
				case "HELP":
					this.help();
					return;
				case "LOOK":
					if(scanner.hasNext()){argv.add(scanner.next());}
					this.look(argv.get(1));
					return;
				case "ATTACK":
					return;
				case "TAKE":
					return;
				case "USE":
					return;
				case "QUIT":
					return;
			}
        }catch(Exception e){
			System.out.println("List of command\n");
			this.help();
		}
        
    }
	
	public void go(LocationName location) {
		Location locationH = this.GAME.HERO.getLocation();
		Location lOut = locationH.getNeighbor(location);
		this.GAME.HERO.goLocation(lOut);
	}

	public void help() {
		System.out.println("Command :\n\tGO location\n\tLOOK \n\tATTACK  \n\tTAKE  \n\tUSE  \n\tQUIT");
	}
	public void look(String s){}
}
