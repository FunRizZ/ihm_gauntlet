package model.Location;

import model.Game_pack.OwnException;

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
    TOWER,
    OFFICE;
    
    public static LocationName stringToLocationName(String str) throws OwnException{
        switch(str) {
    		case "GARDEN" :
    			return GARDEN;
            case "SITING_ROOM" :
                return SITING_ROOM;
            case "BEDROOM" :
                return BEDROOM;
            case "RECPTION_ROOM":
                return RECPTION_ROOM;
            case "ARMORY":
                return ARMORY;
            case "SECRET_PASSAGE":
                return SECRET_PASSAGE;
            case "KITCHEN":
                return KITCHEN;
            case "PRISON":
                return PRISON;
            case "HALLWAY":
                return HALLWAY;
            case "WC":
                return WC;
            case "ROOM_WITH_TREASURE":
                return ROOM_WITH_TREASURE;
            case "CHAPEL":
                return CHAPEL;
            case "GUARD_ROOM":
                return GUARD_ROOM;
            case "TOWER":
                return TOWER;
            case "OFFICE":
                return OFFICE;
    		default:
                throw new OwnException("stringToLocationName","String not reconized");
        }
    }
}