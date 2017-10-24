package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice6DrawLineView extends View {

    private Paint paint;
    private float density;

    public Practice6DrawLineView(Context context) {
        super(context);
        init();
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        练习内容：使用 canvas.drawLine() 方法画直线
        paint.setStrokeWidth(4 * density);
        paint.setStrokeCap(Paint.Cap.ROUND);
        float startX = canvas.getWidth()/2 - 64 * density;
        float startY = canvas.getHeight()/2 - 32 * density;
        float endX = canvas.getWidth()/2 + 64 * density;
        float endY = canvas.getHeight()/2 + 32 * density;
        canvas.drawLine(startX, startY, endX, endY, paint);
    }
}
