package me.gfuil.bmap.lite.listener;

import com.amap.api.services.core.SuggestionCity;

import java.util.List;

import me.gfuil.bmap.lite.base.OnBaseListener;
import me.gfuil.bmap.lite.model.MyPoiModel;

/**
 * @author gfuil
 */

public interface OnSearchResultListener extends OnBaseListener {
    void setSearchResult(List<MyPoiModel> list);
    void setSuggestCityList(List<SuggestionCity> cities);
}
