package Location;

public class Table extends DecorObjet{
	public Table() {
		super();
	}
    @Override
    public boolean isMe(String s){
    	switch(s) {
    	case "Table": 
    		return true;
    	default : 
    		return false;
    	}
    }
    public String getDescription() {
    	return "An Table in a wondeful oak wood probably dated about four hundred years ago.";
    }
    public String toString() {
    	return "Table";
    }
}
