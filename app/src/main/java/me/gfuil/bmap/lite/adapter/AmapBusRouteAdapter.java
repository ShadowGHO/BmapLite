package me.gfuil.bmap.lite.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.services.route.BusPath;

import java.util.List;

import me.gfuil.bmap.lite.R;
import me.gfuil.bmap.lite.base.BaseListAdapter;
import com.amap.mapapi.overlay.AMapUtil;

/**
 * @author gfuil
 */

public class AmapBusRouteAdapter extends BaseListAdapter<BusPath> {
    public AmapBusRouteAdapter(Context context, List<BusPath> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = getInflater().inflate(R.layout.item_bus_route, parent, false);
        }
        TextView textInfo = ViewHolder.get(convertView, R.id.text_info);
        TextView textRoute = ViewHolder.get(convertView, R.id.text_route);

        if (getList().get(position).getSteps() != null ) {
            textInfo.setText(AMapUtil.getBusPathTitle(getList().get(position)));
            textRoute.setText(AMapUtil.getBusPathDes(getList().get(position)));
        }else {
            textInfo.setText("实时公交");
            textRoute.setVisibility(View.GONE);
        }

        return convertView;
    }
}
