package com.tripint.intersight.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tripint.intersight.R;
import com.tripint.intersight.utils.ClearFileUtil;
import com.tripint.intersight.utils.UpdateAppManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.Setting_tvCacheSize)
    TextView SettingTvCacheSize;
    @BindView(R.id.Setting_clear)
    RelativeLayout SettingClear;
    @BindView(R.id.txt_update)
    TextView txtUpdate;

    private UpdateAppManager updateManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        SettingClear = ((RelativeLayout) findViewById(R.id.Setting_clear));
        SettingClear.setOnClickListener(this);
        txtUpdate = ((TextView) findViewById(R.id.txt_update));
        txtUpdate.setOnClickListener(this);
        SettingTvCacheSize = ((TextView) findViewById(R.id.Setting_tvCacheSize));
        //打开设置页面时，显示已经占用的缓存大小
        String cacheSize = ClearFileUtil.getTotalCacheSize(this);
        SettingTvCacheSize.setText("已用缓存:" + cacheSize);
    }


    @OnClick({R.id.Setting_clear,R.id.txt_update})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Setting_clear:
                ClearFileUtil.clearAllCache(this);
                SettingTvCacheSize.setText("缓存清除成功");
                break;
            case R.id.txt_update:
                //弹出对话框提示更新应用
                updateManager = new UpdateAppManager(SettingActivity.this);
                updateManager.checkUpdateInfo();
                break;
        }
    }

}
