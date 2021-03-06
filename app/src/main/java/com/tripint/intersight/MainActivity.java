package com.tripint.intersight;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tripint.intersight.fragments.DiscoverFragment;
import com.tripint.intersight.fragments.HomeFragment;
import com.tripint.intersight.fragments.MineFragment;
import com.tripint.intersight.fragments.MoreFragment;
import com.tripint.intersight.helper.ChangeFragmentHelper;
import com.tripint.intersight.popwindow.MoreWindow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment fragment;
    private Toast toast;
    private TextView main_tvTitle;
    private boolean currentBackState;
    private ImageView imageView;
    private MoreWindow moreWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //初始界面显示关系管理
        Fragment fragment = new HomeFragment();

        ChangeFragmentHelper helper = new ChangeFragmentHelper();
        helper.setTargetFragment(fragment);
        helper.setIsClearStackBack(true);

        changeFragment(helper);

        initView();
    }

    private void initView() {

        //初始化 ImageView
        imageView = (ImageView) findViewById(R.id.imageView_plus);
        imageView.setOnClickListener(this);
        toast = Toast.makeText(this,"再按一次回退键退出程序",Toast.LENGTH_SHORT);
        //盛放Fragment的容器
        FrameLayout main_container = ((FrameLayout) findViewById(R.id.main_container));

        RadioGroup main_tabBar = ((RadioGroup) findViewById(R.id.main_tabBar));

        main_tabBar.check(R.id.main_relation);

        fragment = null;

        main_tabBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_relation:
//                        main_tvTitle.setText("首页");
                        fragment = new HomeFragment();
                        break;
                    case R.id.main_discover:
                        fragment = new DiscoverFragment();
                        break;
                    case R.id.main_mine:
                        fragment = new MineFragment();
                        break;
                    case R.id.main_more:
                        fragment = new MoreFragment();
                        break;
                }

                ChangeFragmentHelper helper = new ChangeFragmentHelper();

                helper.setTargetFragment(fragment);

                helper.setIsClearStackBack(true);

                changeFragment(helper);
            }
        });

    }

    public void changeFragment(ChangeFragmentHelper helper) {

        //获取需要跳转的Fragment
        Fragment targetFragment = helper.getTargetFragment();

        //获取是否清空回退栈
        boolean clearStackBack = helper.isClearStackBack();

        //获取是否加入回退栈
        String targetFragmentTag = helper.getTargetFragmentTag();

        //获取Bundle
        Bundle bundle = helper.getBundle();
        //是否给Fragment传值
        if (bundle != null) {
            targetFragment.setArguments(bundle);
        }

        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        if (targetFragment != null) {
            fragmentTransaction.replace(R.id.main_container,targetFragment);
        }

        //是否添加到回退栈
        if (targetFragmentTag != null) {
            fragmentTransaction.addToBackStack(targetFragmentTag);
        }

        //是否清空回退栈
        if(clearStackBack){
            manager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        fragmentTransaction.commit();
    }

    //提示按回退键退出程序
    @Override
    public void onBackPressed() {
        if(currentBackState){
            super.onBackPressed();
        }

        currentBackState = true;
        if(!isFinishing()){
            toast.show();
        }else {
            toast.cancel();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    currentBackState = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView_plus:
                showMoreWindow(v);
                break;
        }
    }

    private void showMoreWindow(View view) {
        if (null == moreWindow) {
            moreWindow = new MoreWindow(this);
            moreWindow.init();
        }

        moreWindow.showMoreWindow(view,100);
    }
}
