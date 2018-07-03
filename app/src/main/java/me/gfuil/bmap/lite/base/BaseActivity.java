package me.gfuil.bmap.lite.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import me.gfuil.bmap.lite.BApp;


/**
 * activity基类
 *
 * @author gfuil
 */
public class BaseActivity extends AppCompatActivity implements OnBaseListener {
    private static ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BApp.addActivity(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        BApp.removeActivity(this);
    }

    @Override
    public void onMessage(String msg) {
        hideProgress();
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResult(int code, String msg) {
        onMessage(msg);
    }

    @Override
    public void onNoData(String type) {
        hideProgress();
    }

    @Override
    public void onShowData(String type) {
        hideProgress();
    }

    @Override
    public void close() {
        finish();
    }

    /**
     * 跳转到activity, 不结束本Activity
     *
     * @param clazz
     */
    protected void openActivity(Class<?> clazz) {
        openActivity(clazz, null, false);
    }

    /**
     * 跳转到activity，是否结束本activity
     *
     * @param clazz
     * @param isFinish 是否finish掉本Activity
     */
    protected void openActivity(Class<?> clazz, boolean isFinish) {
        openActivity(clazz, null, isFinish);
    }

    /**
     * 跳转到activity，附带bundle，是否结束本activity
     *
     * @param clazz
     * @param extras   附带Bundle
     * @param isFinish 是否finish掉本Activity
     */
    protected void openActivity(Class<?> clazz, Bundle extras, boolean isFinish) {
        Intent intent = new Intent(this, clazz);
        if (extras != null) {
            intent.putExtras(extras);
        }
        startActivity(intent);
        if (isFinish)
            finish();
    }

    /**
     * 获取上个Activity附带的Bubdle
     *
     * @return bundle
     */
    public Bundle getExtras() {
        Bundle bundle = null;
        if (getIntent() != null) {
            bundle = getIntent().getExtras();
        }
        return bundle;
    }

    /**
     * 显示加载时进度条
     */
    public void showProgress() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("请稍候...");
        if (!mProgressDialog.isShowing())
            mProgressDialog.show();
    }

    /**
     * 隐藏进度条
     */
    public void hideProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    protected void showAlertDialog(String title, String msg, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        if (okListener != null) {
            builder.setPositiveButton("确定", okListener);
        }
        if (cancelListener != null) {
            builder.setNegativeButton("取消", cancelListener);
        }

        builder.create().show();
    }

    /**
     * 省略findViewById
     *
     * @param resId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int resId) {
        return (T) findViewById(resId);
    }

    /**
     * 省略findViewById
     *
     * @param view
     * @param resId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(View view, int resId) {
        return (T) view.findViewById(resId);
    }

    protected void initView(int layoutID) {
        if (layoutID != 0) {
            setContentView(layoutID);
        }
    }
}
