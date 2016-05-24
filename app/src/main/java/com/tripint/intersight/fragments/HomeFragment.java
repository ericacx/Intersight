package com.tripint.intersight.fragments;


import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tripint.intersight.R;
import com.tripint.intersight.adapters.MyTabPagerAdapter;
import com.tripint.intersight.adapters.TabLayoutAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> fragmentList;
    private TabLayout.Tab tab1;
    private TabLayout.Tab tab2;
    private TabLayout.Tab tab3;
    private TabLayout.Tab tab4;
    private TabLayout.Tab tab5;
    private TabLayout.Tab tab6;
    private TabLayout.Tab tab7;

    private AllFragment allFragment;
    private InternetFragment internetFragment;
    private FinancialFragment financialFragment;
    private SourceFragment sourceFragment;
    private TechFragment techFragment;
    private EnvironmentFragment environmentFragment;
    private ArchitectureFragment architectureFragment;

    private List<String> stringLists;
    private MyTabPagerAdapter myTabPagerAdapter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        //初始化控件
        initView(view);

        return view;
    }

    private void initView(View view) {
        tabLayout = ((TabLayout) view.findViewById(R.id.tabLayout));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = ((ViewPager) view.findViewById(R.id.viewPager));

        stringLists = new ArrayList<String>();
        stringLists.add("全部");
        stringLists.add("互联网");
        stringLists.add("金融");
        stringLists.add("能源");
        stringLists.add("科技");
        stringLists.add("环保");
        stringLists.add("建筑");

        fragmentList = new LinkedList<Fragment>();
        allFragment = new AllFragment();
        internetFragment = new InternetFragment();
        financialFragment = new FinancialFragment();
        sourceFragment = new SourceFragment();
        techFragment = new TechFragment();
        environmentFragment = new EnvironmentFragment();
        architectureFragment = new ArchitectureFragment();

        fragmentList.add(allFragment);
        fragmentList.add(internetFragment);
        fragmentList.add(financialFragment);
        fragmentList.add(sourceFragment);
        fragmentList.add(techFragment);
        fragmentList.add(environmentFragment);
        fragmentList.add(architectureFragment);

        tab1 = tabLayout.newTab();
        tab2 = tabLayout.newTab();
        tab3 = tabLayout.newTab();
        tab4 = tabLayout.newTab();
        tab5 = tabLayout.newTab();
        tab6 = tabLayout.newTab();
        tab7 = tabLayout.newTab();

        tab1.setText(stringLists.get(0));
        tab2.setText(stringLists.get(1));
        tab3.setText(stringLists.get(2));
        tab4.setText(stringLists.get(3));
        tab5.setText(stringLists.get(4));
        tab6.setText(stringLists.get(5));
        tab7.setText(stringLists.get(6));


        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
        tabLayout.addTab(tab4);
        tabLayout.addTab(tab5);
        tabLayout.addTab(tab6);
        tabLayout.addTab(tab7);

        myTabPagerAdapter = new MyTabPagerAdapter(getChildFragmentManager(),stringLists,fragmentList);
        viewPager.setAdapter(myTabPagerAdapter);

//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(myTabPagerAdapter);
//        tabLayout.setOnTabSelectedListener(new TabLayoutAdapter());
    }

}
