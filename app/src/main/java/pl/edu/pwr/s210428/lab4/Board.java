package pl.edu.pwr.s210428.lab4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * Created by taqie on 03.11.16.
 */

public class Board extends View {
    private int h;
    private int w;
    private Paint board;
    protected int[] x;
    private int[] y1;
    private int[] y2;
    private Random random;
    protected int numberWalls;
    protected int counter;


    public Board(Context context, AttributeSet attrs) {
        super(context, attrs);
        board = new Paint(Paint.ANTI_ALIAS_FLAG);
        board.setColor(Color.BLACK);
        board.setStyle(Paint.Style.STROKE);
        board.setStrokeWidth(5);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        createBoard(canvas);
        rysLine(canvas);
    }

    private void rysLine(Canvas canvas) {
        for(int i=0;i<this.numberWalls;i++){
            canvas.drawLine(x[i],y1[i],x[i],y2[i],board);
        }

    }

    private void createBoard(Canvas canvas) {
        canvas.drawLine(0,0,this.w,0,this.board);
        canvas.drawLine(0,0,0,this.h,this.board);
        canvas.drawLine(this.w,0,this.w,this.h,board);
        canvas.drawLine(0,this.h,this.w,this.h,board);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        this.h = h;
        init(20,0);

    }

    private void init(int numberWalls, int counter) {
        this.numberWalls = this.numberWalls+numberWalls;
        this.counter = counter;
        this.random = new Random();
        this.x = new int[this.numberWalls];
        this.y1 = new int[this.numberWalls];
        this.y2 = new int[this.numberWalls];
        randomX();
        randomY1();
        randomY2();


    }


    private void randomY2() {
        int los=0;
        for(int i=0;i<this.numberWalls;i++)
        {
            los = this.random.nextInt((1000-200));
            if(los > (y1[i]+20))
            {
                y2[i]=los;

            }
            else
            {
                int los2 = this.random.nextInt((1000-200));
                int sum = los+los2;
                if(sum <= this.h)
                {
                    y2[i]=sum;
                }
                else {
                    y2[i]=1000-200;
                }

            }
        }

    }

    private void randomY1() {
        for(int i=0;i<this.numberWalls;i++)
        {
            this.y1[i] = this.random.nextInt((1000/2));
        }

    }

    private void randomX() {
        this.x[0]= this.random.nextInt(50);
        for(int i=1;i<this.numberWalls;i++)
        {

                this.x[i] = this.random.nextInt(600);

        }

    }

    public void checkWall(Ball ball) {
        for(int i=0;i<this.numberWalls;i++) {
            if(ball.vx >= (x[i]-14) && ball.vx <= (x[i]+14) && ball.vy >=y1[i] && ball.vy <= y2[i]){
                ball.vx = 50;
                ball.vy = 50;
                this.counter++;
            }

        }
        if(ball.vy >= (this.h-20) && ball.vx >= (this.w-20))
        {
            init(1,this.counter);
            ball.newGame(1);
            this.postInvalidate();
            Log.d("wlaczasie","daadas");
        }
    }
}
