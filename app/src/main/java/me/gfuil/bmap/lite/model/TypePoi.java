package me.gfuil.bmap.lite.model;


/**
 * @author gfuil
 */

public enum TypePoi {
    POINT(0),
    BUS_STATION(1),
    BUS_LINE(2),
    SUBWAY_STATION(3),
    SUBWAY_LINE(4);

    private int type;

    TypePoi(int type) {
        this.type = type;
    }

    public int getInt() {
        return this.type;
    }

    public static TypePoi fromInt(int type) {
        switch(type) {
            case 0:
                return POINT;
            case 1:
                return BUS_STATION;
            case 2:
                return BUS_LINE;
            case 3:
                return SUBWAY_STATION;
            case 4:
                return SUBWAY_LINE;
            default:
                return null;
        }
    }
}
