package me.gfuil.bmap.lite.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.baidu.mapapi.search.route.MassTransitRouteLine;

/**
 * @author gfuil
 */

public class BusRouteModel implements Parcelable{
    private int duration;
    private int distance;
    private double price;
    private String name;
    private boolean isTexi;
    private boolean isSameCity;
    private MassTransitRouteLine line;
    private String destinationCity;
    private String originCity;

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTexi() {
        return isTexi;
    }

    public void setTexi(boolean texi) {
        isTexi = texi;
    }

    public boolean isSameCity() {
        return isSameCity;
    }

    public void setSameCity(boolean sameCity) {
        isSameCity = sameCity;
    }

    public MassTransitRouteLine getLine() {
        return line;
    }

    public void setLine(MassTransitRouteLine line) {
        this.line = line;
    }

    public BusRouteModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.duration);
        dest.writeInt(this.distance);
        dest.writeDouble(this.price);
        dest.writeString(this.name);
        dest.writeByte(this.isTexi ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isSameCity ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.line, flags);
        dest.writeString(this.destinationCity);
        dest.writeString(this.originCity);
    }

    protected BusRouteModel(Parcel in) {
        this.duration = in.readInt();
        this.distance = in.readInt();
        this.price = in.readDouble();
        this.name = in.readString();
        this.isTexi = in.readByte() != 0;
        this.isSameCity = in.readByte() != 0;
        this.line = in.readParcelable(MassTransitRouteLine.class.getClassLoader());
        this.destinationCity = in.readString();
        this.originCity = in.readString();
    }

    public static final Creator<BusRouteModel> CREATOR = new Creator<BusRouteModel>() {
        @Override
        public BusRouteModel createFromParcel(Parcel source) {
            return new BusRouteModel(source);
        }

        @Override
        public BusRouteModel[] newArray(int size) {
            return new BusRouteModel[size];
        }
    };
}
