package Game_pack;

import java.util.Scanner;
import Location.LocationName;

public class Command {
	public final Game GAME;
	
	public Command(Game game){
		this.GAME = game;
	}
   
	public void Scanner() {

        try ( Scanner scanner = new Scanner( System.in ) ) {
            
            System.out.print( " put your command: " );
            String function = scanner.next("GO|HELP|LOOK|ATTACK|TAKE|USE|QUIT|");
            
            switch(function) {
            	case "GO" :
            		String fuction = scanner.next(LocationNume);
            
            }
            
        }
        
    }
}
