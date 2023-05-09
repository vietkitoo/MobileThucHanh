package com.example.ex1_lession3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GraphicView extends View {
    public GraphicView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect r = new Rect(90, 90, 300, 100);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        canvas.drawRect(r, paint);
        invalidate();
    }
}