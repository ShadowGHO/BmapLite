package me.gfuil.bmap.lite.tools;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by gfuil on 2017/4/23.
 */

public class ADFilterTools {
    public static String getClearAdDivByIdJs(String[] adDivs) {
        String js = "javascript:";
        for (int i = 0; i < adDivs.length; i++) {
            js += "var adDiv" + i + "= document.getElementById('" + adDivs[i] + "');if(adDiv" + i + " != null)adDiv" + i + ".parentNode.removeChild(adDiv" + i + ");";
        }
        return js;
    }

    public static String getClearAdDivByClassJs(String[] adDivs) {
        String js = "javascript:";
        for (int i = 0; i < adDivs.length; i++) {
            js += "var adDiv" + i + "= document.getElementsByClassName('" + adDivs[i] + "');if(adDiv" + i + " != null) { for(var j =0; j< adDiv" + i+".length; j++){adDiv" + i + "[j].parentNode.removeChild(adDiv" + i + "[j]);}}";
        }
        return js;
    }
}
