package me.gfuil.bmap.lite.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import me.gfuil.bmap.lite.R;
import me.gfuil.bmap.lite.adapter.RegionExpandAdapter;
import me.gfuil.bmap.lite.base.BaseActivity;
import me.gfuil.bmap.lite.interacter.CacheInteracter;
import me.gfuil.bmap.lite.model.MyRegionModel;
import me.gfuil.bmap.lite.utils.FileUtils;

/**
 * 切换城市
 *
 * @author gfuil
 */

public class ChangeCityActivity extends BaseActivity implements ExpandableListView.OnChildClickListener {
    private ExpandableListView mExpandListCity;
    private RegionExpandAdapter mRegionExpandAdapter;
    private List<MyRegionModel> regionModelList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView(R.layout.activity_change_city);
        getData();
    }

    private void getData() {
        String regionString = FileUtils.readFileFromAsset(this, "region.json");
        try {
            JSONArray jsonArray = new JSONArray(regionString);

            for (int i = 0; i < jsonArray.length(); i++) {
                MyRegionModel region = new MyRegionModel();
                region.fromJSON(jsonArray.optJSONObject(i));
                regionModelList.add(region);
            }

            mRegionExpandAdapter = new RegionExpandAdapter(this, regionModelList);
            mExpandListCity.setAdapter(mRegionExpandAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void initView(int layoutID) {
        super.initView(layoutID);

        Toolbar toolbar = getView(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mExpandListCity = getView(R.id.expand_list_city);
        mExpandListCity.setOnChildClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (android.R.id.home == id) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        final String cityName = (String) mRegionExpandAdapter.getChild(groupPosition, childPosition);

        showAlertDialog("温馨提示", "是否设置为搜索默认城市，否则临时切换城市", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                (new CacheInteracter(ChangeCityActivity.this)).setCity2(cityName);
                setCity(cityName);
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setCity(cityName);
            }
        });

        return true;
    }

    private void setCity(String city) {
        Bundle bundle = new Bundle();
        bundle.putString("city", city);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(SearchActivity.REQUEST_CITY_CODE, intent);
        finish();

    }

}
