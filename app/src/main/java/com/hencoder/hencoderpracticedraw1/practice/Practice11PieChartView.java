package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.Data;

import java.util.ArrayList;

public class Practice11PieChartView extends View {

    private Paint paint;
    private float density;
    private float scaledDensity;
    private ArrayList<Data> datas;
    private float mTotal;
    private RectF rectF;
    private float radius;
    private float startAngle;
    private static String NAME = "饼图";

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        density = getResources().getDisplayMetrics().density;
        scaledDensity = getResources().getDisplayMetrics().scaledDensity;

        datas = new ArrayList<>();
        datas.add(new Data("Froyao", 5, Color.WHITE));
        datas.add(new Data("GB", 10, Color.MAGENTA));
        datas.add(new Data("ICS", 12, Color.GRAY));
        datas.add(new Data("JB", 33, Color.GREEN));
        datas.add(new Data("KitKat", 70, Color.BLUE));
        datas.add(new Data("L", 85, Color.RED));
        datas.add(new Data("M", 45, Color.YELLOW));
        mTotal = 260;//所有number 的和

        rectF = new RectF();
        rectF.left = - 84 * density;
        rectF.top = - 84 * density;
        rectF.right =  84 * density;
        rectF.bottom = 84 * density;
        radius = 84 * density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.translate(width/2, height/2);//将canvas坐标原点（0，0）平移到view的中心
        startAngle = 0f;
        Rect rect = new Rect();
        for (Data data : datas){
            //计算旋转的角度
            float sweepAngle = data.getNumber() / mTotal * 360f;
            paint.setColor(data.getColor());
            paint.setStyle(Paint.Style.FILL);

            //画 弧形
            if (data.getNumber() == 85){
                canvas.save();//将 canvas保存起来  一般和canvas.restore();
                canvas.translate(-4 * density, -4 * density);
                canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);
            }else {
                canvas.drawArc(rectF, startAngle, sweepAngle - 2, true, paint);
            }

            //画折线
            float lineAngle = startAngle + sweepAngle /2;
            Log.d("xxxxxxxx", "lineAngle-->" + lineAngle);
            float lineStartX = (float) (radius * Math.cos(lineAngle / 360 * (2 * Math.PI)));
            float lineStartY = (float) (radius * Math.sin(lineAngle / 360 * (2 * Math.PI)));
            float lineEndX = (float) ((radius + 10 * density) * Math.cos(lineAngle / 360 * (2 * Math.PI)));
            float lineEndY = (float) ((radius + 10 * density) * Math.sin(lineAngle / 360 * (2 * Math.PI)));

            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.WHITE);
            paint.setStrokeWidth(density);
            paint.setTextSize(10 * scaledDensity);
            canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, paint);
            if (lineAngle >= 90 && lineAngle <= 270){
                float lineEndXTwo = lineEndX - 30 * density;
                canvas.drawLine(lineEndX, lineEndY, lineEndXTwo, lineEndY, paint);
                paint.setStyle(Paint.Style.FILL);
                paint.getTextBounds(data.getName(), 0, data.getName().length(), rect);
                canvas.drawText(data.getName(), lineEndXTwo - paint.measureText(data.getName()) - 2 * density, lineEndY + rect.height()/2, paint);
            }else {
                float lineEndXTwo = lineEndX + 30 * density;
                canvas.drawLine(lineEndX, lineEndY, lineEndXTwo, lineEndY, paint);
                paint.setStyle(Paint.Style.FILL);
                paint.getTextBounds(data.getName(), 0, data.getName().length(), rect);
                canvas.drawText(data.getName(), lineEndXTwo + 2 * density, lineEndY + rect.height()/2, paint);
            }


            if (data.getNumber() == 85){
                canvas.restore();//canvas 恢复到之前的一个状态  如果canvas没做过任何几何变换 那么canvas不变
            }
            startAngle += sweepAngle;
        }


        //canvas.translate(-width/2, -height/2);
        paint.setTextSize(12 * scaledDensity);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(NAME, -paint.measureText(NAME)/2, 106 * density, paint);
    }
}
