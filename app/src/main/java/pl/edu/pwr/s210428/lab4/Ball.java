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
    public float vx;
    public float vy;
    private ReadSensor sensor;
    private int h;
    private int w;
    protected int g;





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
        init(20);
    }

    public void newGame(int g){
        init(g);
    }

    private void init(int g)
    {
        this.vx = 50;
        this.vy = 50;
        this.g = this.g+g;

    }
    private void initSensor(Context context)
    {
        this.sensor = new ReadSensor(context);
    }

    public void changeXY(float dt)
    {
        this.vx = this.vx-(this.sensor.readAX()*this.g) / dt;
        this.vy = this.vy+(this.sensor.readAY()*this.g) / dt;

    }

    private void checkXY(float vx,float vy)
    {
        if((vx+13) >= this.w)
        {

            this.vx = this.w-13;
        }
        else if((vx) <=13)
        {
            this.vx = 13;
        }
        if((vy)<=13)
        {
            this.vy = 13;
        }
        else  if((vy+13) >= this.h){
            this.vy = this.h-13;
        }
    }
    public void checkWall(Board board)
    {

//        int[] myX = new int[board.getMyX().length];
//        int[] myY1 = new int[board.getMyY1().length];
//        int[] myY2 = new int[board.getMyY2().length];

//        int[] myX = board.getMyX();
//        int[] myY1 = board.getMyY1();
//        int[] myY2 = board.getMyY2();

//        Log.d("aasd",""+board.x[0]);
//
//        for(int i=0;i<myX.length;i++)
//        {
//            if(this.vx >= (myX[i]) && this.vx <= (myX[i]) ) {
//                Log.d("Sciana", "Y1 = " + myY1[i] + " Y2 = " + myY2[i] +" X = "+ myX[i]);
//            }
//            else{
////                Log.d("Brak sciany","brak");
//            }
//            Log.d("X","X"+myX[i]);
//        }
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

