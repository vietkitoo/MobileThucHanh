package com.example.ex4_lession3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class GraphicView extends View {
    Bitmap[] frames = new Bitmap[16]; // 16 frames
    int i = 0;
    long last_tick = 0;
    long period=200;
    Context ctext;
    MediaPlayer mediaPlayer;

    public GraphicView(Context context) {
        super(context);
        ctext=context;

        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.img1);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.img2);
        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.img3);
        frames[3] = BitmapFactory.decodeResource(getResources(), R.drawable.img4);
        frames[4] = BitmapFactory.decodeResource(getResources(), R.drawable.img5);
        frames[5] = BitmapFactory.decodeResource(getResources(), R.drawable.img6);
        frames[6] = BitmapFactory.decodeResource(getResources(), R.drawable.img7);
        frames[7] = BitmapFactory.decodeResource(getResources(), R.drawable.img8);
        frames[8] = BitmapFactory.decodeResource(getResources(), R.drawable.img9);
        frames[9] = BitmapFactory.decodeResource(getResources(), R.drawable.img10);
        frames[10] = BitmapFactory.decodeResource(getResources(), R.drawable.img11);
        frames[11] = BitmapFactory.decodeResource(getResources(), R.drawable.img12);
        frames[12] = BitmapFactory.decodeResource(getResources(), R.drawable.img13);
        frames[13] = BitmapFactory.decodeResource(getResources(), R.drawable.img14);
        frames[14] = BitmapFactory.decodeResource(getResources(), R.drawable.img15);
        frames[15] = BitmapFactory.decodeResource(getResources(), R.drawable.img16);

        mediaPlayer = MediaPlayer.create(context, R.raw.buontaynhaura);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (i < 16)
        {
            long time = (System.currentTimeMillis() - last_tick);
            if (time >= period)
            {
                last_tick = System.currentTimeMillis();
                canvas.drawBitmap(frames[i], 40, 40, new Paint());
                i ++;
                postInvalidate();
            }
            else
            {
                canvas.drawBitmap(frames[i],40,40, new Paint());
                postInvalidate();
            }
        }
        else {
            i=0;
            postInvalidate();
        }
    }}
