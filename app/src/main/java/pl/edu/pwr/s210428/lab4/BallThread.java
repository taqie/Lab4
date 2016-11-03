package pl.edu.pwr.s210428.lab4;

import android.os.Handler;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by android on 21.10.16.
 */

public class BallThread implements Runnable{
    private final TextView tv2;
    private final TextView tv;
    private final TextView tv3;
    private Board board;
    private Handler handler;
    private Ball ball;


    public BallThread(Handler handler, Ball ball, Board board, TextView tv, TextView tv2, TextView tv3)
    {
        this.board = board;
        this.handler = handler;
        this.ball = ball;

        this.tv = tv;
        this.tv2 = tv2;
        this.tv3 = tv3;

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
//
                        board.checkWall(ball);
                        ball.changeXY(20);
                        ball.postInvalidate();

                        tv.setText("Liczba scian = "+board.numberWalls);
                        tv2.setText("Ilość dotknieć sciany = "+board.counter);
                        tv3.setText("Przyspiesznie = "+ball.g);
                        ball.checkWall(board);
//                        ball.checkWall();
//                         line.invalidate();
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
