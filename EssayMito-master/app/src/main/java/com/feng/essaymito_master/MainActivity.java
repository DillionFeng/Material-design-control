package com.feng.essaymito_master;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.feng.essaymito_master.activity.BaseActivity;
import com.feng.essaymito_master.activity.DetailActivity;
import com.feng.essaymito_master.adapter.TabAdapter;
import com.feng.essaymito_master.fragment.TabFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener
        , NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViewById() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);
    }

    @Override
    protected void initView() {
        initToolbar();
        initTabLayout();
        findViewById(R.id.fab).setOnClickListener(this);
        ((NavigationView) findViewById(R.id.navigationView)).setNavigationItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                final Snackbar snackbar = Snackbar.make(v, "暂无新消息", Snackbar.LENGTH_SHORT);
                snackbar.setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                displaySToast("查询");
                break;
            case R.id.action_share:
                displaySToast("分享");
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_youhui:
//                displaySToast("优惠");
                openActivity(DetailActivity.class);
                break;
            case R.id.nav_col:
                displaySToast("收藏");
                break;
            case R.id.nav_about:
                displaySToast("关于");
                break;
            case R.id.sub_exit:
                finish();
                break;
            case R.id.sub_switch:
                displaySToast("切换主题");
                break;
        }
        item.setChecked(true);
        drawerLayout.closeDrawers();
        return true;
    }

    //初始化toolbar
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//若不设置，则setTitle无效
        toolbar.setTitle("Design风格");
//        toolbar.setSubtitle("小小魔导师");
//        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setNavigationIcon(R.mipmap.ic_toolbar_home);
        toolbar.setOnMenuItemClickListener(this);
    }

    //初始化tablayout
    private void initTabLayout() {
        List<String> tabs = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
//                tabLayout.addTab(tabLayout.newTab().setText("tab" + i));
            tabs.add("tab" + i);
        }
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Fragment fragment = new TabFragment();
            fragmentList.add(fragment);
        }


        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), fragmentList, tabs);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
