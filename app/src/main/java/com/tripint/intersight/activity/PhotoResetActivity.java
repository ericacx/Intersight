package com.tripint.intersight.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.tripint.intersight.R;
import com.tripint.intersight.utils.PicUtil;
import com.tripint.intersight.utils.SetPhotoUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoResetActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.head)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_reset);
        ButterKnife.bind(this);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = SetPhotoUtil.dealActivityResult(PhotoResetActivity.this, requestCode, resultCode, data, true);
        Bitmap bp = PicUtil.getRoundedCornerBitmap(bitmap, 2);
        imageView.setImageBitmap(bp);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.head)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.head:
                SetPhotoUtil.showDialog(this);
                break;
        }
    }
}
