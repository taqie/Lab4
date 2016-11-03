package pl.edu.pwr.s210428.lab4;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Ball ball;
    private Board board;
    private TextView textv2;
    private TextView textv;
    private TextView textv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = (Board) findViewById(R.id.board);
        ball = (Ball) findViewById(R.id.ball);
        textv = (TextView) findViewById(R.id.textView);
        textv2 = (TextView) findViewById(R.id.textView2);
        textv3 = (TextView) findViewById(R.id.textView3);
        Thread t = new Thread(new BallThread(new Handler(), ball, board,textv,textv2,textv3));
        t.start();

    }
}
