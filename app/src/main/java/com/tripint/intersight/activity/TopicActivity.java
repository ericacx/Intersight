package com.tripint.intersight.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.tripint.intersight.R;
import com.tripint.intersight.adapters.MyTabPagerAdapter;
import com.tripint.intersight.fragments.HotTopicFragment;
import com.tripint.intersight.fragments.MyConcernedTopicFragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopicActivity extends AppCompatActivity {

    @BindView(R.id.topic_tabLayout)
    TabLayout topic_tabLayout;
    @BindView(R.id.topic_viewPager)
    ViewPager topic_viewPager;


    private List<Fragment> list;
    private MyTabPagerAdapter myTabPagerAdapter;

    private List<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        strings = new ArrayList<String>();
        strings.add("我关注的话题");
        strings.add("热门话题");

        list = new LinkedList<>();
        list.add(new MyConcernedTopicFragment());
        list.add(new HotTopicFragment());

        TabLayout.Tab tab1 = topic_tabLayout.newTab();
        TabLayout.Tab tab2 = topic_tabLayout.newTab();

        tab1.setText(strings.get(0));
        tab2.setText(strings.get(1));

        topic_tabLayout.addTab(tab1);
        topic_tabLayout.addTab(tab2);

        myTabPagerAdapter = new MyTabPagerAdapter(getSupportFragmentManager(), strings, list);
        topic_viewPager.setAdapter(myTabPagerAdapter);

        topic_tabLayout.setupWithViewPager(topic_viewPager);
        topic_tabLayout.setTabsFromPagerAdapter(myTabPagerAdapter);
    }
}
