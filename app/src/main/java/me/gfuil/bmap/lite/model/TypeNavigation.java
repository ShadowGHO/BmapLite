package me.gfuil.bmap.lite.model;

/**
 * @author gfuil
 */

public enum TypeNavigation {
    HISTORY(0),
    WALK(1),
    BIKE(2),
    DRIVE(3),
    BUS(4);


    private int type;

    TypeNavigation(int type) {
        this.type = type;
    }

    public int getInt() {
        return this.type;
    }

    public static TypeNavigation fromInt(int type) {
        switch(type) {
            case 0:
                return HISTORY;
            case 1:
                return WALK;
            case 2:
                return BIKE;
            case 3:
                return DRIVE;
            case 4:
                return BUS;
            default:
                return null;
        }
    }
}
