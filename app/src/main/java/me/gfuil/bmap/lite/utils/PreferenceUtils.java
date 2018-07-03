package me.gfuil.bmap.lite.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 读写SharedPreferences
 *
 * @author gfuil
 */
public class PreferenceUtils {
    private String file = "default";
    private SharedPreferences preference;

    public PreferenceUtils(Context context) {
        this(context, null);
    }

    public PreferenceUtils(Context context, String preferenceFile) {
        if (preferenceFile != null)
            file = preferenceFile;
        preference = context.getApplicationContext().getSharedPreferences(file, 0);
    }

    public String getPreferenceFile() {
        return file;
    }

    public void clear(){
        Editor ed = preference.edit();
        ed.clear();
        ed.apply();
    }

    public void setStringPreference(String key, String value) {
        Editor ed = preference.edit();
        ed.putString(key, value);
        ed.apply();
    }

    public String getStringPreference(String key, String defaultValue) {
        String str = defaultValue;
        if (preference.contains(key)) {
            str = preference.getString(key, defaultValue);
        }
        return str;
    }

    public void setIntPreference(String key, int value) {
        Editor ed = preference.edit();
        ed.putInt(key, value);
        ed.apply();

    }

    public int getIntPreference(String key, int defaultValue) {
        int num = defaultValue;
        if (preference.contains(key)) {
            num = preference.getInt(key, defaultValue);
        }
        return num;
    }

    public void setBooleanPreference(String key, boolean value) {
        Editor ed = preference.edit();
        ed.putBoolean(key, value);
        ed.apply();

    }

    public boolean getBooleanPreference(String key, boolean defaultValue) {
        boolean is = defaultValue;
        if (preference.contains(key)) {
            is = preference.getBoolean(key, defaultValue);
        }
        return is;
    }

    public void setFloatPreference(String key, float value) {
        Editor ed = preference.edit();
        ed.putFloat(key, value);
        ed.apply();

    }

    public float getFloatPreference(String key, float defaultValue) {
        float val = defaultValue;
        if (preference.contains(key)) {
            val = preference.getFloat(key, defaultValue);
        }
        return val;
    }

    public void setLongPreference(String key, long value) {
        Editor ed = preference.edit();
        ed.putLong(key, value);
        ed.apply();
    }

    public long getLongPreference(String key, long defaultValue) {
        long val = defaultValue;
        if (preference.contains(key)) {
            val = preference.getLong(key, defaultValue);
        }

        return val;
    }

}
