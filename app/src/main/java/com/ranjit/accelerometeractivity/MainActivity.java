package com.ranjit.accelerometeractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private TextView tvShowAxis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Accelerometer sensor");

        tvShowAxis=findViewById(R.id.tvShowAxis);


        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sel=new SensorEventListener() {

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values=event.values;
                String xAxis="x:"+ values[0];
                String yAxis="y:"+ values[1];
                String zAxis="z:"+ values[2];
                tvShowAxis.setText(xAxis+""+yAxis +""+zAxis);


            }
        };

        if(sensor!=null){
            sensorManager.registerListener(sel, sensor, sensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(this,"No sensor found", Toast.LENGTH_LONG).show();
        }

    }
}
