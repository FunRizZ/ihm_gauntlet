package Location;

public enum LocationName{
    GARDEN,
    SITING_ROOM,
    BEDROOM,
    RECPTION_ROOM,
    ARMORY,
    SECRET_PASSAGE,
    KITCHEN,
    PRISON,
    HALLWAY,
    WC,
    ROOM_WITH_TREASURE,
    CHAPEL,
    GUARD_ROOM,
    TOWER;
    
    public static LocationName stringToLocationName(String str) throws NullPointerException{
        switch(str) {
    		case "GARDEN" :
    			return GARDEN;
    		default:
                Location loc = null;
                return loc.NAME;
        }
    }
}