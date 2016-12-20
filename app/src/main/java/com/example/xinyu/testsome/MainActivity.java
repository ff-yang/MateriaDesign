package com.example.xinyu.testsome;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.xinyu.testsome.fragment.DemoFragment;
import com.example.xinyu.testsome.fragment.TabFragment;
import com.example.xinyu.testsome.fragment.WidgetFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar mToolbar;
    private long exitTime;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setHeadImage();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.tool);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置导航栏图标
//        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        mToolbar.setTitle("标题");//设置主标题
//        toolbar.setSubtitle("子标题");//设置子标题
        setSupportActionBar(mToolbar);
//        mToolbar.inflateMenu(R.menu.toolbar_menu);//设置右上角的填充菜
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mNavigationView.setNavigationItemSelectedListener(this);
    }


    /**
     *
     */
    private void setHeadImage() {
       View head= mNavigationView.inflateHeaderView(R.layout.navigation_head);
        head.findViewById(R.id.navigation_header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"user icon clicked!",Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_demo:
                getSupportFragmentManager().beginTransaction().replace(R.id.content,new DemoFragment() ).commit();
                mToolbar.setTitle("Demo");
                break;
            case R.id.navigation_tab:
                getSupportFragmentManager().beginTransaction().replace(R.id.content,new TabFragment()).commit();
                mToolbar.setTitle("Tab Example");
                break;
            case R.id.navigation_widget:
                getSupportFragmentManager().beginTransaction().replace(R.id.content,new WidgetFragment()).commit();
                mToolbar.setTitle("Widget");
                break;


        }
        item.setChecked(true);
        mDrawerLayout.closeDrawer(mNavigationView);
        return false;
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(mNavigationView)) {
            mDrawerLayout.closeDrawer(mNavigationView);
        }else{
            exitApp();
        }
    }

    private void exitApp() {
        Log.e("ff", "back pressed");
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Log.e("ff", exitTime + "");
            Toast.makeText(MainActivity.this, "press back again to exit", Toast.LENGTH_SHORT).show();
            exitTime=System.currentTimeMillis();
        } else {
            MainActivity.this.finish();
        }
    }

}
