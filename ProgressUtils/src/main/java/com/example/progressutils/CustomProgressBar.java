package com.example.progressutils;

import android.content.Context;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class CustomProgressBar extends ProgressBar {
    public CustomProgressBar(Context context) {
        super(context);
        getDrawableShape();
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
        getDrawableShape();
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        super(context, attrs, defStyle);
        getDrawableShape();
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec,
                                          int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getDrawableShape();
    }

    public final int roundCorners = 200;//就是改變這個值，就可以改變自定義progressbar左右兩端的圓角大小了，使用於自定義圖片的情況，

    Shape getDrawableShape() {
        final float[] roundedCorners = new float[]{0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < roundedCorners.length; i++) {
            roundedCorners[i] = dip2px(getContext(), roundCorners);
        }
        return new RoundRectShape(roundedCorners, null, null);
    }

    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
