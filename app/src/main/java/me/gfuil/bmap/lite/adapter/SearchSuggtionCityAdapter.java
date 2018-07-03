package me.gfuil.bmap.lite.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.services.core.SuggestionCity;

import java.util.List;

import me.gfuil.bmap.lite.R;

/**
 * @author gfuil
 */

public class SearchSuggtionCityAdapter extends RecyclerView.Adapter<SearchSuggtionCityAdapter.SearchSuggionCityViewHolder> {
    private Context context;
    private List<SuggestionCity> list;
    private OnClickCityListener onClickCityListener;


    public OnClickCityListener getOnClickCityListener() {
        return onClickCityListener;
    }

    public void setOnClickCityListener(OnClickCityListener onClickCityListener) {
        this.onClickCityListener = onClickCityListener;
    }

    public List<SuggestionCity> getList() {
        return list;
    }

    public void setList(List<SuggestionCity> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.clear();
            if (null != list) {
                this.list.addAll(list);
            }
        }
    }

    public SearchSuggtionCityAdapter(Context context, List<SuggestionCity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SearchSuggionCityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_suggion_city, parent, false);
        return new SearchSuggionCityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchSuggionCityViewHolder holder, final int position) {
        holder.textCity.setText(Html.fromHtml(list.get(position).getCityName() + "(" + list.get(position).getSuggestionNum() + ")"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onClickCityListener){
                    onClickCityListener.onClickCity(list.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class SearchSuggionCityViewHolder extends RecyclerView.ViewHolder {
        TextView textCity;

        public SearchSuggionCityViewHolder(View itemView) {
            super(itemView);
            textCity = (TextView) itemView.findViewById(R.id.text_city);
        }
    }

    public interface OnClickCityListener {
        void onClickCity(SuggestionCity city);
    }
}
