package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.Data;

import java.util.ArrayList;

public class Practice10HistogramView extends View {

    private Paint paint;
    private float density;
    private ArrayList<Data> datas;
    private static float MAX = 100;
    private static String NAME = "直方图";
    private float scaledDensity;
    private float space;

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        density = getResources().getDisplayMetrics().density;
        scaledDensity = getResources().getDisplayMetrics().scaledDensity;
        space = 8 * density;

        datas = new ArrayList<>();
        datas.add(new Data("Froyao", 5, Color.GREEN));
        datas.add(new Data("GB", 10, Color.GREEN));
        datas.add(new Data("ICS", 12, Color.GREEN));
        datas.add(new Data("JB", 33, Color.GREEN));
        datas.add(new Data("KitKat", 70, Color.GREEN));
        datas.add(new Data("L", 85, Color.GREEN));
        datas.add(new Data("M", 45, Color.GREEN));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        RectF rectF = new RectF();
        //获取view 宽高
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        //设定直方图饿边界
        rectF.left = width * 0.1f;
        rectF.top = height * 0.05f;
        rectF.right = width * 0.9f;
        rectF.bottom = height * 0.8f;
        //计算 每个直方条的宽度以及直方条的最大高度
        float itemWidth = (rectF.width() - 10 * density) / datas.size() - space;
        float maxHeight = rectF.height();

        float left = rectF.left;
        float bottom = rectF.bottom ;
        //设置直方条下面文字的大小
        paint.setTextSize(8 * scaledDensity);

        //获取直方条下面文字的高度
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for (Data data : datas){
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(data.getColor());
            float percent = data.getNumber() / MAX;
            canvas.drawRect(left + space, bottom - maxHeight * percent, left + space + itemWidth, bottom, paint);
            paint.setColor(Color.WHITE);
            float startX = left + space + (itemWidth - paint.measureText(data.getName()))/2;
            float startY = bottom + fontHeight;
            canvas.drawText(data.getName(), startX, startY, paint);
            left += (itemWidth + space);
        }

        //画直方图下面的title
        paint.setTextSize(16 * scaledDensity);
        paint.setColor(Color.WHITE);
        //float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        canvas.drawText(NAME, (width - paint.measureText(NAME))/2, height - 10 * density, paint);

        //画 横竖轴线
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(density);
        canvas.drawLine(rectF.left, rectF.top, rectF.left, rectF.bottom, paint);
        canvas.drawLine(rectF.left, rectF.bottom, rectF.right, rectF.bottom, paint);
    }
}
