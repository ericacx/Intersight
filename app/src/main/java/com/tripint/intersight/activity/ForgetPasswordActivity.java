package com.tripint.intersight.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tripint.intersight.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ForgetPasswordActivity extends AppCompatActivity {

    @BindView(R.id.edit_tels)
    EditText editTels;
    @BindView(R.id.edit_duanxin)
    EditText editDuanxin;
    @BindView(R.id.btn_yzm)
    Button btnYzm;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.edit_pwd2)
    EditText editPwd2;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_yzm, R.id.btn_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_yzm:
                break;
            case R.id.btn_submit:
                break;
        }
    }
}
