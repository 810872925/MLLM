package com.m.ml.mllm;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Activity activity;
    private boolean isDrawer;
    private DrawerLayout drawerLayout;
    private CoordinatorLayout home;
    private RelativeLayout drawerLeft;
    private RelativeLayout drawerRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
            }
        }

        context = this;
        activity = this;

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlaout);
        home = (CoordinatorLayout) findViewById(R.id.home);
        drawerLeft = (RelativeLayout) findViewById(R.id.drawerlaout_left);
        drawerRight = (RelativeLayout) findViewById(R.id.drawerlaout_right);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                isDrawer = true;

                WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
                DisplayMetrics dm = new DisplayMetrics();
                wm.getDefaultDisplay().getMetrics(dm);

                int scrW = dm.widthPixels;
                int scrH = dm.heightPixels;

                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                switch (drawerView.getId()) {
                    case R.id.drawerlaout_left:
                        home.layout(drawerLeft.getRight(), 0, drawerLeft.getRight() + scrW, scrH);
                        break;
                    case R.id.drawerlaout_right:
                        //home.layout(drawerRight.getLeft()-scrW,0,home.getWidth()+drawerRight.getLeft()-scrW,scrH);
                        break;
                }


            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                isDrawer = false;
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

}
