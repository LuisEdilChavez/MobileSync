package com.Luis.mobilesync;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class MotionSensor implements SensorEventListener {

    private final SensorManager sensorManager;
    private final Sensor accelerometer;
    private boolean isMoving = false;

    public MotionSensor(Context context) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        double magnitude = Math.sqrt(x*x + y*y + z*z);
        isMoving = magnitude > 1.5; // threshold, tweak as needed
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    public String getMotionState(){

        return isMoving ? "moving" : "stationary";
    }
}