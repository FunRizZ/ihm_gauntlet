package Game;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandParser {
    private List<String> args = new ArrayList<String>();
    private String cmd;

    public abstract boolean exec();

    public List<String> getArgs(){
        return args;
    }

    public String getCmd() {
        return cmd;
    }

    public void parse(String input) {
        String s[] = input.trim().split(" ");
        this.cmd = s[0];
        for(int i = 1; i < s.length; i++) {
            this.args.add(s[i]);
        }
    }
}
