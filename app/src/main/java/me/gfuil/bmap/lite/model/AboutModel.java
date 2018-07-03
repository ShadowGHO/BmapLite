package me.gfuil.bmap.lite.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author gfuil
 */

public class AboutModel implements Parcelable{
    private String name;
    private String info;

    public AboutModel(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.info);
    }

    public AboutModel() {
    }

    protected AboutModel(Parcel in) {
        this.name = in.readString();
        this.info = in.readString();
    }

    public static final Creator<AboutModel> CREATOR = new Creator<AboutModel>() {
        @Override
        public AboutModel createFromParcel(Parcel source) {
            return new AboutModel(source);
        }

        @Override
        public AboutModel[] newArray(int size) {
            return new AboutModel[size];
        }
    };
}
