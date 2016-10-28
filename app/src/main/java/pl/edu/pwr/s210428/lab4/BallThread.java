package pl.edu.pwr.s210428.lab4;

import android.os.Handler;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by android on 21.10.16.
 */

public class BallThread implements Runnable{
    private Handler handler;
    private Ball ball;


    public BallThread(Handler handler, Ball ball)
    {
        this.handler = handler;
        this.ball = ball;

    }



    @Override
    public void run() {
        while (true)
        {
            try {
                Thread.sleep(20);

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        ball.changeXY(20);
                        ball.postInvalidate();
////                        line.invalidate();
//                        line.postInvalidate();
//                        cir.postInvalidate();
                    }
                });

            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
