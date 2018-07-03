package me.gfuil.bmap.lite.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import me.gfuil.bmap.lite.utils.StringUtils;

/**
 * @author gfuil
 */

public class MyRegionModel implements Parcelable {
    private String name;
    private List<String> child;

    public void fromJSON(JSONObject object) {
        this.name = object.optString("a");
        this.child = Arrays.asList(StringUtils.convertStrToArray(object.optString("b"), ","));
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject object = new JSONObject();
        object.put("a", name);
        object.put("b", StringUtils.converToString(child, ","));
        return object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChild() {
        return child;
    }

    public void setChild(List<String> child) {
        this.child = child;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeStringList(this.child);
    }

    public MyRegionModel() {
    }

    protected MyRegionModel(Parcel in) {
        this.name = in.readString();
        this.child = in.createStringArrayList();
    }

    public static final Creator<MyRegionModel> CREATOR = new Creator<MyRegionModel>() {
        @Override
        public MyRegionModel createFromParcel(Parcel source) {
            return new MyRegionModel(source);
        }

        @Override
        public MyRegionModel[] newArray(int size) {
            return new MyRegionModel[size];
        }
    };
}
