package com.tripint.intersight.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.tripint.intersight.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ResetPassWordActivity extends AppCompatActivity {

    @BindView(R.id.edit_yzm)
    EditText editYzm;
    @BindView(R.id.edit_new_pwd)
    EditText editNewPwd;
    @BindView(R.id.edit_new_pwd2)
    EditText editNewPwd2;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass_word);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_submit)
    public void onClick() {

    }
}
