package com.example.myproyectpocketsave.Sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import com.example.myproyectpocketsave.R;

public class Gyroscope extends AppCompatActivity {
    private static final String TAG = "Ejemplo Sensor";
    private SensorManager sensorManager;
    private Sensor gyroscopeSensor;
    private SensorEventListener gyroscopeSensorListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        //Inicialización del manager del sensor
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        //USAR EL SENSOR DE GIROSCOPIO
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (gyroscopeSensor == null) {
            Log.e(TAG, "El sensor de giroscopio no se encuentra disponible");
            finish();
        }
        gyroscopeSensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[2] > 0.5f) { //sentido antihorario.
                    getWindow().getDecorView().setBackgroundColor(Color.CYAN);
                } else if (sensorEvent.values[2] < -0.5f) { //sentido horario.
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(gyroscopeSensorListener, gyroscopeSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(gyroscopeSensorListener);
    }
}