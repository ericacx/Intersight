package com.tripint.intersight.fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tripint.intersight.R;
import com.tripint.intersight.activity.SettingActivity;
import com.tripint.intersight.utils.TakePhotoUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.head)
    ImageView imageView;
    @BindView(R.id.txt_setting)
    TextView txt_setting;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        imageView = ((ImageView) view.findViewById(R.id.head));
        imageView.setOnClickListener(this);
        txt_setting = ((TextView) view.findViewById(R.id.txt_setting));
        txt_setting.setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = TakePhotoUtil.dealActivityResult(this, requestCode, resultCode, data, true);
        imageView.setImageBitmap(bitmap);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick({R.id.head, R.id.txt_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head:
                TakePhotoUtil.showDialog(this);
                break;
            case R.id.txt_setting:
                Intent intent = new Intent();
                intent.setClass(getContext(), SettingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
