package pl.edu.pwr.s210428.lab4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by android on 28.10.16.
 */

public class Ball extends View {

    private Paint ball;
    private float vx;
    private float vy;
    private ReadSensor sensor;
    private int h;
    private int w;



    public Ball(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        ball = new Paint(Paint.ANTI_ALIAS_FLAG);
        ball.setColor(Color.BLACK);
        initSensor(context);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.h = h;
        this.w = w;
        init();
    }

    private void init()
    {
        this.vx = this.w/2;
        this.vy = this.h/2;

    }
    private void initSensor(Context context)
    {
        this.sensor = new ReadSensor(context);
    }

    public void changeXY(float dt)
    {
        this.vx = this.vx-(this.sensor.readAX()*10) / dt;
        this.vy = this.vy+(this.sensor.readAY()*10) / dt;

    }

    private void checkXY(float vx,float vy)
    {
        Log.d("Vy",""+vy);
        Log.d("Vx",""+vx);
//        Log.d("this x",""+this.w);
        if((vx+10) >= this.w)
        {

            this.vx = this.w-10;
        }
        else if((vx-10) <= 0)
        {
            this.vx = 10;
        }
        else if((vy-10)<=0)
        {
            this.vy = 10;
        }
        else  if((vy+10) >= this.h){
            this.vy = this.h-10;
        }
    }

    private void initdraw(Canvas canvas){

        checkXY(this.vx, this.vy);
        canvas.drawCircle(this.vx,this.vy,10,ball);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initdraw(canvas);
    }
}

