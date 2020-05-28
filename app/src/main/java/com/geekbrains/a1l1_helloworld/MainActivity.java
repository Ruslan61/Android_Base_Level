package com.geekbrains.a1l1_helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";
    private Button chooseACity;
    private TextView textTemperature;
    private final String actualTemperatureKey = "actualTemperatureKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setOnOpenCityActivity();


    }


    private void setOnOpenCityActivity() {
        chooseACity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "method onStart started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "method onStop started");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        String text = textTemperature.getText().toString();
        outState.putString(actualTemperatureKey, text);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String text = savedInstanceState.getString(actualTemperatureKey);
        textTemperature.setText(text);
    }

    private void initViews() {
        chooseACity = findViewById(R.id.chooseACityButton);
        textTemperature = findViewById(R.id.actualTemperature);
    }
}
