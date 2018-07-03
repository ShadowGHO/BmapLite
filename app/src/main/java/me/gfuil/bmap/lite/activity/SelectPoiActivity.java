package me.gfuil.bmap.lite.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import me.gfuil.bmap.lite.BApp;
import me.gfuil.bmap.lite.R;
import me.gfuil.bmap.lite.base.BaseActivity;
import me.gfuil.bmap.lite.fragment.AmapSelectPoiFragment;
import me.gfuil.bmap.lite.fragment.BaiduMapSelectPoiFragment;
import me.gfuil.bmap.lite.model.MyPoiModel;
import me.gfuil.bmap.lite.model.TypeMap;

/**
 * 选择地点
 *
 * @author gfuil
 */

public class SelectPoiActivity extends BaseActivity {
    private BaiduMapSelectPoiFragment mBaiduMapFragment;
    private AmapSelectPoiFragment mAmapFragment;
    private TextView mTextPoiName;
    private MyPoiModel mPoi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(R.layout.activity_select_poi);

        getData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.select_poi, menu);
        return true;
    }

    private void getData() {
    }

    @Override
    protected void initView(int layoutID) {
        super.initView(layoutID);

        Toolbar toolbar = getView(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mTextPoiName = getView(R.id.text_poi_name);

        if (BApp.TYPE_MAP == TypeMap.TYPE_BAIDU) {
            mBaiduMapFragment = BaiduMapSelectPoiFragment.newInstance();
            getFragmentManager().beginTransaction().replace(R.id.lay_content, mBaiduMapFragment).commit();
        } else if (BApp.TYPE_MAP == TypeMap.TYPE_AMAP) {
            mAmapFragment = AmapSelectPoiFragment.newInstance();
            getFragmentManager().beginTransaction().replace(R.id.lay_content, mAmapFragment).commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (android.R.id.home == id) {
            finish();
            return true;
        }else if (R.id.action_ok == id){
            Bundle bundle = new Bundle();
            bundle.putParcelable("poi", mPoi);

            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(MainActivity.REQUEST_SEARCH, intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void setPoi(MyPoiModel myPoiModel) {
        mPoi = myPoiModel;
        mTextPoiName.setText(myPoiModel.getName());
    }
}
