package com.tripint.intersight.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tripint.intersight.R;
import com.tripint.intersight.recyclerview.MyAdapter;
import com.tripint.intersight.recyclerview.Product;
import com.tripint.intersight.recyclerview.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private MyAdapter myAdapter;
    private List<Product> productList = null;

    public AllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        initView(view);
        ButterKnife.bind(this, view);
        return view;
    }

    private void initView(View view) {
        recyclerView = ((RecyclerView) view.findViewById(R.id.recyclerview));
        //设置 layoutmanager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        initData();
        //设置 adapter
        myAdapter = new MyAdapter(productList);
        recyclerView.setAdapter(myAdapter);
        //设置 item 之间的间隔
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(12);
        recyclerView.addItemDecoration(spacesItemDecoration);
    }

    private void initData() {
        productList = new ArrayList<Product>();
        Product p1 = new Product(R.mipmap.a1, "我是照片1");
        productList.add(p1);
        Product p2 = new Product(R.mipmap.a2, "我是照片2");
        productList.add(p2);
        Product p3 = new Product(R.mipmap.a3, "我是照片3");
        productList.add(p3);
        Product p4 = new Product(R.mipmap.a4, "我是照片4");
        productList.add(p4);
        Product p5 = new Product(R.mipmap.a5, "我是照片5");
        productList.add(p5);
        Product p6 = new Product(R.mipmap.a6, "我是照片6");
        productList.add(p6);
        Product p7 = new Product(R.mipmap.a2, "我是照片7");
        productList.add(p7);
        Product p8 = new Product(R.mipmap.a1, "我是照片8");
        productList.add(p8);
        Product p9 = new Product(R.mipmap.a4, "我是照片9");
        productList.add(p9);
        Product p10 = new Product(R.mipmap.a6, "我是照片10");
        productList.add(p10);
        Product p11 = new Product(R.mipmap.a3, "我是照片11");
        productList.add(p11);
    }

}
