package Game;

import java.util.List;
import java.util.ArrayList;


public class Command extends CommandParser {
    private final Game GAME;
    private List<String> possible_cmd = null;

    public Command(Game g) {
        this.GAME = g;
        this.possible_cmd = new ArrayList<String>();
        this.possible_cmd.add("HELP");
        this.possible_cmd.add("GO");
        this.possible_cmd.add("QUIT");
        this.possible_cmd.add("ATTACK");

    }

    public boolean exec() {
        
        if(this.getCmd() != null) {
            System.out.println("\nExecuting command '" + this.getCmd() + "' with args : " + this.getArgs());

            // clear list between commands
            this.getArgs().clear();

            switch(this.getCmd()) {
                case "HELP": 
                    this.help();
                    break;
                default:
                    System.out.println("Command not found");
            }


            return true;
        }

        return false;
    }

    public void add_cmd(String name) {
        possible_cmd.add(name);
    }

    public void help() {
        System.out.println("Commands availables : ");
        for(String command : possible_cmd) {
            System.out.println(command);
        }
    }

    public void go_location() {
        
    }
}
