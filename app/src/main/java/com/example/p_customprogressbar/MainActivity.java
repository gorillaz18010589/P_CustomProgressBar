package com.example.p_customprogressbar;
//https://blog.csdn.net/hjpdyxhjd/article/details/50365723

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;

import com.example.progressutils.CustomProgressBar;

public class MainActivity extends AppCompatActivity {
    private CustomProgressBar prbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setProgressSmooth(ProgressBar progressBar, int progress)
    }

        /**
         * 设置ProgressBar的进度（平滑的增长）
         * @param progressBar progressBar
         * @param progress 取值0-100
         */
        public static void setProgressSmooth(ProgressBar progressBar, int progress) {

            ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", progress);
            // 1 second
            animation.setDuration(1000);
            //先加速在减速
            animation.setInterpolator(new AccelerateDecelerateInterpolator());

        }
}