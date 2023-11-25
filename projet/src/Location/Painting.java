package Location;


public class Painting extends DecorObjet{
	public Painting() {
		super();
	}
	
    public void look(){
        System.out.println("i'm a painting");
    }
    @Override
    public boolean itMe(String s){
    	switch(s) {
    	case "Painting": 
    		return true;
    	default : 
    		return false;
    	}
    }
}
