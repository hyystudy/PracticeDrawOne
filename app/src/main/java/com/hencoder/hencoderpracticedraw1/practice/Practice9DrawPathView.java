package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint paint;
    private float density;
    private Path path;

    public Practice9DrawPathView(Context context) {
        super(context);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        density = getResources().getDisplayMetrics().density;
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        paint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF();
        rectF.left = width/2 - 48 * density;
        rectF.top =  height/2 - 48 *density;
        rectF.right = width/2;
        rectF.bottom = height/2;
        path.addArc(rectF, -225, 225);
        rectF.left += 48 * density;
        rectF.right += 48 * density;
        path.arcTo(rectF, -180, 225, false);
        path.lineTo(width/2, height/2 + 48 * density);
        path.close();
        canvas.drawPath(path, paint);
    }
}
