package com.feng.essaymito_master.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.feng.essaymito_master.R;
import com.feng.essaymito_master.bean.SystemBarTintManager;

/**
 * author：feng
 * createTime: 2015/12/3
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

//        //手机系统大于5.0时启用通知栏沉浸
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////
////            //透明状态栏（WiFi等状态信息）
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////            //透明导航栏(三个导航按钮)
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            getWindow().setStatusBarColor(getResources().getColor(R.color.tab_bg_color));
//        }

//        //4.4-5.0
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            //透明状态栏（WiFi等状态信息）
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏(三个导航按钮)
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintColor(getResources().getColor(R.color.toolbar_background));
//            tintManager.setStatusBarTintEnabled(true);
//        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setNavigationBarTintEnabled(true);
//            tintManager.setStatusBarTintColor(getResources().getColor(R.color.toolbar_background));
//        }

        findViewById();
        initView();
    }


    protected void openActivity(Class<?> cls) {
        openActivity(cls, null);
    }

    /**
     * 启动Activity，带有bundle参数
     *
     * @param cls
     * @param mBundle
     */
    protected void openActivity(Class<?> cls, Bundle mBundle) {
        Intent intent = new Intent(this, cls);
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
    protected void displaySToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示toast信息(时间较短)
     *
     * @param content
     */
    protected void displayLToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
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

    //获取布局文件Id
    protected abstract int getContentView();
}
