package Location;


public class Painting extends DecorObjet{
	public Painting() {
		super();
	}
	
    @Override
    public boolean isMe(String s){
    	switch(s) {
    	case "Painting": 
    		return true;
    	default : 
    		return false;
    	}
    }
    public String getDescription() {
    	return "A luxurious painting, a masterpiece on canvas, boasted a rich tapestry of colors.";
    }
    public String toString() {
    	return "Painting";
    }
}
