package com.feng.essaymito_master.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * author：feng
 * createTime: 2015/12/3
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    Context mContext;
    View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(getContentView(), container, false);
        findViewById();
        initView();

        return view;
    }

    protected void openActivity(Context context, Class<?> cls) {
        openActivity(context, cls, null);
    }

    /**
     * 启动Activity，带有bundle参数
     *
     * @param cls
     * @param mBundle
     */
    protected void openActivity(Context context, Class<?> cls, Bundle mBundle) {
        Intent intent = new Intent(context, cls);
        if (mBundle != null) {
            intent.putExtras(mBundle);
        }
        startActivity(intent);
    }

    /**
     * 显示toast信息(时间较长)
     *
     * @param content
     */
    protected void displaySToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示toast信息(时间较短)
     *
     * @param content
     */
    protected void displayLToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param tv  textView
     * @param str content
     */
    protected void setText(TextView tv, String str) {
        if (str == null || tv == null) {
            return;
        }
        tv.setText(str);
    }

    protected abstract void initView();

    protected abstract void findViewById();

    protected abstract int getContentView();
}
