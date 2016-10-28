package pl.edu.pwr.s210428.lab4;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by android on 28.10.16.
 */

public class ReadSensor implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor;
    private float ax;
    private float ay;
    private float az;



    public ReadSensor(Context context) {
        init(context);

    }

    private void init(Context context) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor,sensorManager.SENSOR_DELAY_NORMAL);

    }


    public float readAX()
    {
        return this.ax;
    }
    public float readAY()
    {
        return this.ay;
    }
    public float readAZ()
    {
        return this.az;
    }

    private void setAx(float ax)
    {
        this.ax = ax;
    }

    private void setAy(float ay)
    {
        this.ay = ay;
    }

    private void setAz(float az)
    {
        this.az = az;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        setAx(event.values[0]);
        setAy(event.values[1]);
        setAz(event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
