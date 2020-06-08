package com.geekbrains.a1l1_helloworld.ui.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.geekbrains.a1l1_helloworld.R;

public class MainActivity extends AppCompatActivity {
    private Button chooseACity;
    private TextView displayedCity;
    private final String actualDisplayedCity = "actualDisplayedCity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_layout);
        initViews();
        setOnOpenCityActivity();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int requestCodeToOpenCityActivity = 11;
        if (requestCode == requestCodeToOpenCityActivity) {
            assert data != null;
            displayedCity.setText(data.getExtras().getString(CityActivity.cityActivityDataKey));
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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        String text = displayedCity.getText().toString();
        outState.putString(actualDisplayedCity, text);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String text = savedInstanceState.getString(actualDisplayedCity);
        displayedCity.setText(text);
    }

    private void initViews() {
        chooseACity = findViewById(R.id.chooseACityButton);
        displayedCity = findViewById(R.id.displayedCity);
    }
}
