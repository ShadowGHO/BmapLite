package me.gfuil.bmap.lite.listener;

import java.util.List;

import me.gfuil.bmap.lite.base.OnBaseListener;


/**
 * @author gfuil
 */

public interface OnSearchTipsListener extends OnBaseListener {
    void setSearchTipsAdatper(List<String> list);
}
