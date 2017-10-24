package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {

    private Paint paint;
    private float density;

    public Practice7DrawRoundRectView(Context context) {
        super(context);
        init();
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        RectF rectF = new RectF();
        rectF.left = canvas.getWidth()/2 - 64 * density;
        rectF.top = canvas.getHeight()/2 - 32 * density;
        rectF.right = canvas.getWidth()/2 + 64 * density;
        rectF.bottom = canvas.getHeight()/2 + 32 * density;
        canvas.drawRoundRect(rectF, 10 * density, 10 * density, paint);
    }
}
