package me.gfuil.bmap.lite.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.gfuil.bmap.lite.R;
import me.gfuil.bmap.lite.base.BaseListAdapter;

/**
 * @author gfuil
 */

public class SearchKeywordAdapter extends BaseListAdapter<String> {
    private  OnSearchHistoryDeleteListener onSearchHistoryDeleteListener;

    public void setOnSearchHistoryDeleteListener(OnSearchHistoryDeleteListener onSearchHistoryDeleteListener) {
        this.onSearchHistoryDeleteListener = onSearchHistoryDeleteListener;
    }

    public SearchKeywordAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = getInflater().inflate(R.layout.item_search_history, parent, false);
        }
        TextView textKeyword = ViewHolder.get(convertView, R.id.text_keyword);
        ImageView imageClose = ViewHolder.get(convertView, R.id.btn_close);
        textKeyword.setText(getList().get(position));
        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onSearchHistoryDeleteListener){
                    onSearchHistoryDeleteListener.onSearchHistoryDelete(getList().get(position));
                }
            }
        });
        return convertView;
    }

    public interface OnSearchHistoryDeleteListener {
        void onSearchHistoryDelete(String keyword);
    }
}
