package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint paint;
    private float density;

    public Practice8DrawArcView(Context context) {
        super(context);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        RectF rectF = new RectF();
        rectF.left = canvas.getWidth()/2 - 72 * density;
        rectF.top = canvas.getHeight()/2 - 72 * density;
        rectF.right = canvas.getWidth()/2;
        rectF.bottom = canvas.getHeight()/2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(.5f * density);
        canvas.drawArc(rectF, -180f, 90f, false, paint);

        paint.setStyle(Paint.Style.FILL);
        rectF.right = canvas.getWidth()/2 + 55 * density;
        rectF.top = canvas.getHeight()/2 - 72 * density;
        rectF.left = canvas.getWidth()/2 - 55 * density;
        rectF.bottom = canvas.getHeight()/2;

        canvas.drawArc(rectF, -108f, 102f, true, paint);

        paint.setStyle(Paint.Style.FILL);
        rectF.right = canvas.getWidth()/2 + 55 * density;
        rectF.top = canvas.getHeight()/2 - 64 * density;
        rectF.left = canvas.getWidth()/2 - 72 * density;
        rectF.bottom = canvas.getHeight()/2;
        canvas.drawArc(rectF, 0f, 180f, true, paint);
    }
}
