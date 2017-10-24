package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    private Paint paint;
    private float density;

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        density = getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        paint.setColor(Color.BLACK);
        canvas.drawCircle(canvas.getWidth() / 2 - 80 * density, 80 * density, 64 * density, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2 * density);
        canvas.drawCircle(canvas.getWidth() / 2 + 80 * density, 80 * density, 64 * density, paint);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(canvas.getWidth() / 2 - 80 * density, 214 * density, 64 * density, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10 * density);
        canvas.drawCircle(canvas.getWidth() / 2 + 80 * density, 214 * density, 56 * density, paint);

    }
}
