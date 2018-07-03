package me.gfuil.bmap.lite.model;

/**
 * @author gfuil
 */

public enum TypeMap {
    TYPE_BAIDU(0),
    TYPE_AMAP(1),
    TYPE_GOOGLE(2),
    TYPE_GPS(3);

    private int type;

    TypeMap(int type) {
        this.type = type;
    }

    public int getInt() {
        return this.type;
    }

    public static TypeMap fromInt(int type) {
        switch(type) {
            case 0:
                return TYPE_BAIDU;
            case 1:
                return TYPE_AMAP;
            case 2:
                return TYPE_GOOGLE;
            case 3:
                return TYPE_GPS;
            default:
                return null;
        }
    }
}
