package com.geekbrains.a1l1_helloworld.ui.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.geekbrains.a1l1_helloworld.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";
    private Button chooseACity;
    private TextView textTemperature;
    private final String actualTemperatureKey = "actualTemperatureKey";
    private TextView changedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_layout);
        initViews();
        setOnOpenCityActivity();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int requestCodeToOpenCityActivity = 11;
        if (requestCode == requestCodeToOpenCityActivity) {
            changedCity.setText(data.getExtras().getString(CityActivity.cityActivityDataKey));
        }
    }

    public void setOnOpenCityActivity() {
        chooseACity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                startActivityForResult(intent, 11);
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
        changedCity = findViewById(R.id.displayedCity);
    }
}
