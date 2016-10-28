package pl.edu.pwr.s210428.lab4;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Ball ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ball = (Ball) findViewById(R.id.ball);
        Thread t = new Thread(new BallThread(new Handler(), ball));
        t.start();

    }
}
