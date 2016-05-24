package com.tripint.intersight.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.tripint.intersight.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edit_tel)
    EditText editTel;//手机号
    @BindView(R.id.btn_yzm)
    Button btn_yzm;//发送验证码按钮
    @BindView(R.id.edit_yzm)
    EditText editYzm;//验证码
    @BindView(R.id.edit_password)
    EditText editPassword;//密码
    @BindView(R.id.btn_next)
    Button btn_next;//下一步按钮
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.textView)
    TextView textView;

    private Intent intent;
    private RequestParams requestParams;
    private String phoneNumber;
    private String smsType = "1";
    private int time = 60;
    private HttpUtils httpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_yzm, R.id.btn_next, R.id.rel_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_yzm:
                phoneNumber = editTel.getText().toString();
//                requestParams.addBodyParameter("secKey", MyApp.getSecKey());
//                requestParams.addBodyParameter("terminal", MyApp.getTerminal());
//                requestParams.addBodyParameter("deviceId", MyApp.getDeviceId());
                requestParams.addBodyParameter("lng", "121.483363");
                requestParams.addBodyParameter("lat", "31.314555");
                requestParams.addBodyParameter("token", "");
                requestParams.addBodyParameter("phone", phoneNumber);
                requestParams.addBodyParameter("smsType", smsType);

//                httpUtils.send(HttpRequest.HttpMethod.POST, "www.baidu.com", requestParams, new RequestCallBack<String>() {
//                    @Override
//                    public void onSuccess(ResponseInfo<String> responseInfo) {
//                        Log.e("result", responseInfo.result);
//                    }
//
//                    @Override
//                    public void onFailure(HttpException e, String s) {
//                        Toast.makeText(RegisterActivity.this, "网络异常，请检查手机网络", Toast.LENGTH_SHORT).show();
//                    }
//                });
                btn_yzm.setText("重新获取(" + time + ")");
                btn_yzm.setClickable(false);
                handler.sendEmptyMessageDelayed(100, 1000);
                break;
            case R.id.btn_next:
                String phone = editTel.getText().toString();
                String smsCode = editYzm.getText().toString();
                String password = editPassword.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                } else if (phone.length() != 11) {
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(smsCode)) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6 || password.length() > 16) {
                    Toast.makeText(this, "请输入6~16位的字符或者数字作为密码", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(this, Register2Activity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("phone", phone);
//                    bundle.putString("smsCode", smsCode);
//                    bundle.putString("password", password);
//                    intent.putExtras(bundle);
                    startActivityForResult(intent, 1);
                }
                break;
            case R.id.rel_back:
                RegisterActivity.this.finish();
                break;
        }
    }


    //    public void startCount() {
//        timer = new Timer();
//        timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                if (count > 0) btn_yzm.setText(""+count+"秒");
//                else btn_yzm.setText("重新获取");
//                count --;
//
//            }
//        };
//        timer.schedule(timerTask, 0, 1000);
//    }
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    if (time == 0) {
                        time = 60;
                        btn_yzm.setClickable(true);
                        btn_yzm.setText("获取验证码");
                    } else {
                        btn_yzm.setText("重新获取(" + (--time) + ")");
                        handler.sendEmptyMessageDelayed(100, 1000);
                    }
                    break;
            }
        }
    };
}
