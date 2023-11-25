package Location;

public class Table extends DecorObjet{
	
    public void look(){
        System.out.println("i'm a table");
    }
    @Override
    public boolean itMe(String s){
    	switch(s) {
    	case "Table": 
    		return true;
    	default : 
    		return false;
    	}
    }
}
