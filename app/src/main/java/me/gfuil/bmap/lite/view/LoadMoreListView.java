package me.gfuil.bmap.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import me.gfuil.bmap.lite.R;


/**
 * 自动加载更多listview
 *
 * @author gfuil
 */
public class LoadMoreListView extends ListView implements AbsListView.OnScrollListener {
    private boolean isLastItem = false; //是否滑动到最后一个item
    private boolean isLoading = false; //是否加载标示
    private boolean canLoad = false;
    private View footerView;
    private OnLoadMoreListener loadMoreListener;

    public LoadMoreListView(Context context) {
        super(context);
        addFootView();
    }

    public LoadMoreListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addFootView();
    }

    public LoadMoreListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addFootView();
    }

    private void addFootView() {
        footerView = LayoutInflater.from(getContext()).inflate(R.layout.view_load_more_footer, null);
        this.addFooterView(footerView, null, false);
        this.setOnScrollListener(this);
    }

    public void setOnLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE && isLastItem && loadMoreListener != null && !isLoading && canLoad) {
            isLoading = true;
            footerView.setVisibility(VISIBLE);
            loadMoreListener.onLoadMore();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        isLastItem = ((firstVisibleItem + visibleItemCount) == totalItemCount);
    }

    /**
     * 数据加载完成
     */
    public void loadComplete() {
        footerView.setVisibility(View.GONE);
        isLoading = false;
        this.invalidate();
    }

    public void setCanLoad(boolean canLoad) {
        this.canLoad = canLoad;
        if (canLoad && getFooterViewsCount() == 0) {
            addFooterView(footerView);
        } else if (!canLoad && getFooterViewsCount() == 1) {
            removeFooterView(footerView);
        }
        isLoading = false;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public interface OnLoadMoreListener {
        public void onLoadMore();
    }
}
