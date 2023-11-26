package Character;


public class Knight extends WhoFight{
    public final static int DEFAULT_HP = 600;
    public final static int DEFAULT_ARMOR = 150;
    public final static int DEFAULT_DAMAGE = 150;

    public Knight(){
        super(DEFAULT_HP, DEFAULT_ARMOR, DEFAULT_DAMAGE);
    }
    
    @Override
    public boolean isMe(String st){
    	switch(st) {
    	case "Knight": 
    		return true;
    	default : 
    		return false;
    	}
    }
    @Override
    public String getDescription() {
    	return "A mythical knight, with a sword at his side and a shield bearing his family crest.";
    }
    public String toString() {
    	return "Knight";
    }
}
