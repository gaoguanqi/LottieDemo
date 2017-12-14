package com.maple.smaple.lottiedemo.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.maple.smaple.lottiedemo.R;
import com.maple.smaple.lottiedemo.widget.view.CircleProgressBarView;
import com.maple.smaple.lottiedemo.widget.view.LoadingButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaogu on 2017/12/14.
 */

public class MyViewActivity extends AppCompatActivity {


    @BindView(R.id.loading_btn)
    LoadingButton mLoadingBtn;

    @BindView(R.id.circleView)
    CircleProgressBarView  mCircleView;

    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
        ButterKnife.bind(this);


        mLoadingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoadingBtn.startLoading();
            }
        });



        mCircleView.setProgressWithAnimation(33.8f);
        mCircleView.setProgressListener(new CircleProgressBarView.ProgressListener() {
            @Override
            public void currentProgressListener(float currentProgress) {
                textView.setText("当前进度：" + currentProgress);
            }
        });
        mCircleView.startProgressAnimation();
    }
}
