package me.gfuil.bmap.lite.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.gfuil.bmap.lite.R;
import me.gfuil.bmap.lite.base.BaseListAdapter;
import me.gfuil.bmap.lite.model.RouteHistoryModel;

/**
 * @author gfuil
 */

public class RouteHistoryAdapter extends BaseListAdapter<RouteHistoryModel> {
    private OnRouteHistoryDeleteListener onRouteHistoryDeleteListener;

    public void setOnRouteHistoryDeleteListener(OnRouteHistoryDeleteListener onRouteHistoryDeleteListener) {
        this.onRouteHistoryDeleteListener = onRouteHistoryDeleteListener;
    }

    public RouteHistoryAdapter(Context context, List<RouteHistoryModel> list) {
        super(context, list);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = getInflater().inflate(R.layout.item_search_history, parent, false);
        }
        TextView textKeyword = ViewHolder.get(convertView, R.id.text_keyword);
        ImageView imageClose = ViewHolder.get(convertView, R.id.btn_close);
        textKeyword.setText(getList().get(position).getNameStart() + " >> " + getList().get(position).getNameEnd());
        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onRouteHistoryDeleteListener){
                    onRouteHistoryDeleteListener.onRouteHistoryDelete(getList().get(position));
                }
            }
        });
        return convertView;
    }

    public interface OnRouteHistoryDeleteListener{
        void onRouteHistoryDelete(RouteHistoryModel history);
    }
}
